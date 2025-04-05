package Searching;

public class LinearSearch {
    public int linearSearch(int[] nums,int target){
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==target){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int nums[]={3,4, 6,7};
        LinearSearch obj=new LinearSearch();
        int result=obj.linearSearch(nums, 4);
        System.out.println(result);
    }
    
}
