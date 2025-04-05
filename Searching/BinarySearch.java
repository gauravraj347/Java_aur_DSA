package Searching;
class BinarySearch {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;  // Avoids overflow

            if (nums[mid] == target) {
                return mid;  // Found target
            } else if (nums[mid] > target) {
                high = mid - 1;  // Search in the left half
            } else {
                low = mid + 1;  // Search in the right half
            }
        }
        return low;  // Target not found, return insert position
    }
    public static void main(String[] args) {
        BinarySearch obj=new BinarySearch();
        int[] nums={2,5,8,9}; 
        int result = obj.searchInsert(nums, 8);
        int result1 = obj.searchInsert(nums, 11);
        System.out.println(result);
        System.out.println(result1);
    }
}

