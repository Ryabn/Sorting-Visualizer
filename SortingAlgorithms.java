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
     * Generates and returns an integer array of length made of random integeres between 0 and n
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

    public static void selectionSortWithSteps(int[] arr){
        steps.clear();
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
}
