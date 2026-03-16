package dsa_jan_2026.search__sorting;

public class SortingPerfCompare {

    public static void main(String[] args) {


        // Create an array of 10,000 integers
        final int SIZE = 50000;
        int[] arr = new int[SIZE];
        int[] arr2 = new int[SIZE];

        for(int i=0; i<SIZE; i++) {
            arr[i] = (int)(Math.random() * SIZE);
            arr2[i] = arr[i];
        }

        // Just get a sample of the array
        for(int i=0; i<100; i++) {
            System.out.println(arr[i]);
        }

        long begin = System.nanoTime();
        new MergeSort().doMergeSort(arr);
        long end = System.nanoTime();
        System.out.println("Merge Sort Time = " + (end-begin)/1000);

        begin = System.nanoTime();
        new InsertionSort().doInsertionSort(arr2);
        end = System.nanoTime();
        System.out.println("Insertion Sort Time = " + (end-begin)/1000);
    }
}
