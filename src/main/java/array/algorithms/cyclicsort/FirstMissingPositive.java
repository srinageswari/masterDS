package array.algorithms.cyclicsort;

public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        int i= 0;
        while(i<nums.length){
            int corrIndex= nums[i]-1;
            if(nums[i]>0 && nums[i]<= nums.length &&nums[i]!=nums[corrIndex]){
                swap(nums, i, corrIndex);
            }
            else{
                i++;
            }

        }
        for(int j =0; j<nums.length; j++){
            if(nums[j]!= j+1){
                return j +1;
            }
        }
        return nums.length+1;
    }

    public static void swap(int[] arr, int i, int j){
        int temp= arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args)
    {
        int[] input1 = {3, 1, 2, 5, 4};
        int[] input2 = {1,2,0};
        System.out.println(firstMissingPositive(input1));
    }


}
