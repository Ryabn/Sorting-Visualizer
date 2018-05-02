package tech.ryanqyang;

public class Main {
    public static void main(String[] args) {
        int[] arr = SortingAlgorithms.randomIntArrayGenerator(20, 100);
        SortingAlgorithms.printArr(arr);
        SortingAlgorithms.selectionSort(arr);
        SortingAlgorithms.printArr(arr);

    }
}
