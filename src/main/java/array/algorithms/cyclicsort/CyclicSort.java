package array.algorithms.cyclicsort;

public class CyclicSort {

    public static void main(String[] args) {
        int[] input = {3, 1, 2, 5, 4};
        findMissingNumber(input);
        print(input);
    }

    private static void print(int[] input) {
        for(int i=0; i< input.length; i++)
        {
            System.out.print(input[i]+" ");
        }
    }

    private static void findMissingNumber(int[] input) {
        int i = 0;
        while (i < input.length) {
            int correctIndex = input[i] - 1; //index of the element should be the actual number - 1
            if (input[i] != input[correctIndex]) {
                swap(input,i,correctIndex);
            }
            else
                i++;
        }
    }

    private static void swap(int[] input, int i, int correctIndex) {
        int temp = input[i];
        input[i] = input[correctIndex];
        input[correctIndex] = temp;
    }
}
