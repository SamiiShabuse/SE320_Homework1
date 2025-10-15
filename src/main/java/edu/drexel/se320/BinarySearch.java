package edu.drexel.se320;

public class BinarySearch {

    // DO NOT MODIFY THIS SIGNATURE
    // This includes the protected modifier; the autograder currently relies
    // on a combination of overloading and visibility hacks to swap out your
    // code at runtime to test your test suite.
    protected static <T extends Comparable<T>> int binarySearchImplementation(T[] array, T elem) {
	// TODO: Implement binary search here. The signature above sets you up to ensure the array elements have a compareTo method
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int compare =  elem.compareTo(array[mid]);

            if  (compare == 0) {
                return mid; // Element was found
            }
            else if (compare < 0) {
                left = mid + 1; // Search the left half
            }
            else if (compare > 0) {
                right = mid - 1; // search the right half
            }

            throw new NoSuchElementException("Element was not in array.");

        }
    }
}
