/**
 * Created by anna on 10/28/14.
 */
//import java.util.Random;


public class Main {
    public static void main(String[] args) {
        int[] input = {5, 6, 22, 64, 23, 13, 9, 0, 34, 7, 4};

        System.out.println("input:");

        for (int i : input)
            System.out.print(i + " ");

        sort(input, 0, input.length - 1);

        System.out.println("\noutput");

        for (int o : input)
            System.out.print(o + " ");

    }


    public static int[] sort(int[] input, int leftIndex, int rightIndex) {
        int pivotIndex = divide(input, leftIndex, rightIndex);


        if (leftIndex < pivotIndex - 1)
            sort(input, leftIndex, pivotIndex);
        if (pivotIndex < rightIndex)
            sort(input, pivotIndex, rightIndex);

        return input;
    }


    public static int divide(int[] input, int leftIndex, int rightIndex){
        int left = leftIndex;
        int right = rightIndex;
        int pivot = input[(leftIndex + rightIndex) / 2];

        System.out.println(
                "\npivot = " + pivot + "\npivotIndex = " + (left + right) / 2
        );


        while (left <= right) {
            while (input[left] < pivot)
                left++;
            while (input[right] > pivot)
                right--;
            if (left <= right) {
                int temp = input[left];
                input[left] = input[right];
                input[right] = temp;
                left++;
                right--;

                System.out.println("\ndivide:");
                for (int i : input)
                    System.out.print(i + " ");
            }
        }

        return left;
    }
}
