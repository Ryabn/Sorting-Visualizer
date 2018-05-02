package tech.ryanqyang;

import java.util.Random;

public class SortingAlgorithms {

    /**
     * Generates and returns an integer array of length made of random integeres between 0 and n
     * @param length
     * @param n
     * @return
     */
    static int[] randomIntArrayGenerator(int length, int n){
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
    static void printArr(int[] arr){
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
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void selectionSort(int[] arr){
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
