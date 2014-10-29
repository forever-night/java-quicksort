/**
 * Created by anna on 10/28/14.
 */
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        int[] input = generateArray(20);

        System.out.println("input:");
        printArray(input);

        sort(input, 0, input.length - 1);

        System.out.println("\noutput");
        printArray(input);
    }


    public static int[] sort(int[] input, int leftIndex, int rightIndex) {
        int pivotIndex;

        if (rightIndex > leftIndex) {
            pivotIndex = divide(input, leftIndex, rightIndex);

            sort(input, leftIndex, pivotIndex - 1);
            sort(input, pivotIndex, rightIndex);
        }

        return input;
    }


    public static int divide(int[] input, int leftIndex, int rightIndex){
        int left = leftIndex;
        int right = rightIndex;

        // (leftIndex + (rightIndex - leftIndex)) / 2
        int pivot = input[(leftIndex + rightIndex) / 2];

//        System.out.println("\npivot = " + pivot);

        while (left <= right) {
            while (input[left] < pivot)
                left++;
            while (input[right] > pivot)
                right--;
            if (left <= right) {
                // swap values
                int temp = input[left];
                input[left] = input[right];
                input[right] = temp;

                left++;
                right--;

//                System.out.println("\nprocessing:");
//                printArray(input);
            }
        }

        return left;
    }


    public static void printArray(int[] array){
        for (int i : array)
            System.out.print(i + " ");
    }


    public static int[] generateArray(int length){
        int[] array = new int[length];
        Random rand = new Random();


        for (int i = 0; i < array.length; i++)
            array[i] = rand.nextInt(100);

        return array;
    }
}