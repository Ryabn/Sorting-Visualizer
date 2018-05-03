package tech.ryanqyang;

import java.util.ArrayList;
import java.util.Random;

public class SortingAlgorithms {
    static private String[] supportedSorts = {"Selection Sort", "Insertion Sort", "Quick Sort", "Merge Sort"};

    static private ArrayList<int[]> steps;

    public static String[] getSupportedSorts() {
        return supportedSorts;
    }

    /**
     * Generates and returns an integer array of length made of random integers between 0 and n
     * @param length
     * @param n
     * @return
     */
    public static int[] randomIntArrayGenerator(int length, int n){
        Random generator = new Random();
        int[] generated = new int[length];
        for(int i = 0; i < length; i++){
            generated[i] = generator.nextInt(n);
        }
        return generated;
    }

    /**
     * Given array, print elements in their order
     */
    public static void printArr(int[] arr){
        System.out.print("[ ");
        for(int i = 0; i < arr.length - 1; i++){
            System.out.print(arr[i] + ", ");
        }
        System.out.print( arr[ arr.length-1 ] );
        System.out.println(" ]");
    }

    /**
     * Swap two elements in an array
     * @param i index 1
     * @param j index 2
     */
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void mergeSort(int[] arr){

    }
    public static void mergeSortHelper(int[] arr){

    }

    public static void selectionSort(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            int min = i;
            for(int j = i; j < arr.length; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            //found smallest index
            swap(arr, i, min);
        }
    }

    public static int[] selectionSortWithSteps(int[] arr){
        //i (which location is it replacing at )
        //j (compare for min value)
        //min (highlight which is current min)

        //i means we only look at i and on
        //- 3 i       -2 j    -1 min

        return arr;
    }
    public void recurSelectionSort(int a[], int n, int index){
        // Return when starting and size are same
//        if (index == n)
//            return;
//
//        // calling minimum index function for minimum index
//        //int k = min(a, index, n-1);
//
//        // Swapping when index nd minimum index are not same
//        if (k != index)
//            swap(a[k], a[index]);
//
//        // Recursively calling selection sort function
//        recurSelectionSort(a, n, index + 1);
    }
}
