
public class Sorting {
    
    // Function to print an array
    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        // Demo array for BubbleSort
        int bubbleArr[] = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array for Bubble Sort:");
        printArray(bubbleArr);
        BubbleSort.bubbleSort(bubbleArr, bubbleArr.length);
        System.out.println("Sorted array using Bubble Sort:");
        printArray(bubbleArr);

        // Demo array for InsertionSort
        int insertionArr[] = {12, 11, 13, 5, 6};
        System.out.println("\nOriginal array for Insertion Sort:");
        printArray(insertionArr);
        InsertionSort ob = new InsertionSort();
        ob.sort(insertionArr);
        System.out.println("Sorted array using Insertion Sort:");
        printArray(insertionArr);

        // Demo array for MergeSort
        int mergeArr[] = {12, 11, 13, 5, 6, 7};
        System.out.println("\nOriginal array for Merge Sort:");
        printArray(mergeArr);
        MergeSort obMerge = new MergeSort();
        obMerge.sort(mergeArr, 0, mergeArr.length - 1);
        System.out.println("Sorted array using Merge Sort:");
        printArray(mergeArr);
    }
}
