/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Wolverine
 */
public class SortingApp {

    public static void printArray(int[] c, int start, int end) {
        int j;
        for (j = start; j <= end; j++) {
            System.out.print(c[j] + ", ");
        }
        System.out.print("\n");
    }

    public static void bubbleSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("Iteration " + i + "==>");
            printArray(arr, 0, arr.length);
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
            System.out.println("Iteration " + i + "==>");
            printArray(arr, 0, arr.length);
        }
    }

    public static void selectionSort1(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int small = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[small]) {
                    small = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[small];
            arr[small] = temp;

            System.out.println("Iteration " + i + "==>");
            printArray(arr, 0, arr.length);
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int curr_index = i;
            int curr_value = arr[i];
            while (curr_index > 0 && curr_value < arr[curr_index - 1]) {
                arr[curr_index] = arr[curr_index - 1];
                curr_index--;
            }
            arr[curr_index] = curr_value;

            System.out.println("Iteration " + i + "==>");
            printArray(arr, 0, arr.length);
        }
    }

    public static int[] mergeSort(int[] array, int leftStart, int rightEnd) {
        System.out.println();
        System.out.print("(" + leftStart + "->" + rightEnd + ") = ");
        for (int i = leftStart; i <= rightEnd; i++) {
            System.out.print(array[i] + " ");
        }

        if (leftStart < rightEnd) { // no single element
            // Finding mid point
            int mid = (leftStart + rightEnd) / 2;
            mergeSort(array, leftStart, mid);
            mergeSort(array, mid + 1, rightEnd);
            array = mergeHalves(array, leftStart, mid, rightEnd);
        }
        return array;
    }

    public static int[] mergeHalves(int[] array, int l, int m, int r) {
        System.out.println("\n\nMerging subarrays");
        System.out.println("L = " + l + ", R = " + r + ", Mid =  " + m);
        for (int i = l; i <= m; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.print("| ");
        for (int i = m + 1; i <= r; i++) {
            System.out.print(array[i] + " ");
        }

        // i(L-Mid), j(Mid-R) -> k(L-R)
        int i = l;
        int j = m + 1;
        int k = l;
        int[] temp = new int[array.length];

        while (i <= m && j <= r) {
            if (array[i] < array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }

        while (i <= m) {
            temp[k++] = array[i++];
        }
        while (j <= r) {
            temp[k++] = array[j++];
        }

        // to copy temp array to main array
        for (int d = l; d < k; d++) {
            array[d] = temp[d];
        }
        return array;
    }

    public static void main(String args[]) {

        int array[] = { -4, 10, 5, 0, 17, 0, -9, 25, 12 };
        int start = 0, end = array.length - 1;
        // System.out.println("Before Sorting Bubble Sort===>");
        // printArray(array, start, end);
        // bubbleSort(array);
        // System.out.println("After Sorting===>");
        // printArray(array, start, end);
        // System.out.println();

        // int array1[] = {-4, 10, 5, 17, 0, -9, 25, 12};
        // System.out.println("Before Sorting Selection Sort===>");
        // printArray(array1, start, end);
        // selectionSort(array1);
        // System.out.println("After Sorting===>");
        // printArray(array1, start, end);
        // System.out.println();
        //
        // int array2[] = {-4, 10, 5, 17, 0, -9, 25, 12};
        // System.out.println("Before Sorting Selection Sort1===>");
        // printArray(array2, start, end);
        // selectionSort1(array2);
        // System.out.println("After Sorting===>");
        // printArray(array2, start, end);
        //
        int array3[] = { -4, 10, 5, 17, 9, 0, -9, 25, 12 };
        System.out.println("Before Sorting Merge Sort===>");
        printArray(array3, start, end);
        array3 = mergeSort(array3, start, end);
        System.out.println("After Sorting===>");
        printArray(array3, start, end);
    }
}
