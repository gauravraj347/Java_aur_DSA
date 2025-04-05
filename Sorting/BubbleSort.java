package Sorting;

public class BubbleSort {
    public void bubbleSort(int[] nums){
        int n=nums.length;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<n-i-1;j++){
                if(nums[j]>nums[j+1]){
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
    }
    public void disp(int nums[]){
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
    }
    public static void main(String[] args) {
        int[] nums={6,3,4,8,3};
        BubbleSort obj=new BubbleSort();
        obj.bubbleSort(nums);
        obj.disp(nums);
        
    }
}
