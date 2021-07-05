package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        //Arrays.sort()


        // Bubble sort
//        int[] numbers = {4, 2, 8, 3, 9, 5};

//        for (int i = 0; i < numbers.length; i++) {
//            for (int j = 0; j < numbers.length -1 -i; j++) {
//                if (numbers[j] > numbers[j + 1]) {
//                    //temporary variable to hold the value of the current value at index j
//                    int temp = numbers[j];
//
//                    // swap the numbers
//                    numbers[j] = numbers[j + 1];
//                    numbers[j + 1] = temp;
//                }
//            }
//        }
//        System.out.println(Arrays.toString(numbers));


//        for (int i = 1; i < numbers.length; i++) {
//            int valueToSort = numbers[i];
//            int j;
//            for (j = i; j > 0 && numbers[j - 1] > valueToSort; j--) {
//                numbers[j] = numbers[j - 1];
//            }
//            numbers[j] = valueToSort;
//        }
//        System.out.println(Arrays.toString(numbers));


        // Selection sort
//        for (int i = 0; i < numbers.length - 1; i++) {
//            int index = i; // current index of the number
//            for (int j = i + 1; j < numbers.length; j++) {
//                if (numbers[j] < numbers[index]) {
//                    index = j; // swap if number at position j less than number at position index
//                }
//            }
//            int smallerNumber = numbers[index];
//            numbers[index] = numbers[i];
//            numbers[i] = smallerNumber;
//        }
//        System.out.println(Arrays.toString(numbers));


        int[] values = {3, 8, 2, 5, 9};
        mergeSort(0, values.length - 1, values );// Call the mergeSort method to sort the array
        System.out.println(Arrays.toString(values));
    }

    public static void mergeSort(int start, int end, int[] numbers) {

        // Recursive method
        int mid = (start + end) / 2;

        if (start < end) {
            // sort left half
            mergeSort(start, mid, numbers);

            //sort right half
            mergeSort(mid + 1, end, numbers);

            // merge
            merge(start, mid, end, numbers);
        }
    }


    public static void merge(int start, int mid, int end, int[] numbers) {
        // initialize the temp array and index
        int[] tempArray = new int[numbers.length]; // create a temp array
        int tmpArrayIndex = start; // create a temp index

        // initialize start index and mid index to be used as counters
        int startIndex = start;
        int midIndex = mid + 1;

        //iterate until the smaller array reaches the end
        while (startIndex <= mid && midIndex <= end) {
            if (numbers[startIndex] < numbers[midIndex]) {
                tempArray[tmpArrayIndex++] = numbers[startIndex++];
            } else {
                tempArray[tmpArrayIndex++] = numbers[midIndex++];
            }
        }

        //copy the remaining elements into the array
        while (startIndex <= mid) {
            tempArray[tmpArrayIndex++] = numbers[startIndex++];
        }
        while (midIndex <= end) {
            tempArray[tmpArrayIndex++] = numbers[midIndex++];
        }

        //copy temporary array to the actual array after sorting
        if (end + 1 - start >= 0) {
            // java method array method for copying arrays
            System.arraycopy(tempArray, start, numbers, start, end + 1 - start);
        }
    }
}

