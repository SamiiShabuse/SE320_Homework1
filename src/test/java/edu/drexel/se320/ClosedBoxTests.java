package edu.drexel.se320;

// Hamcrest
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
// Core JUnit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;

public class ClosedBoxTests extends BinarySearchBase {

    /**
     * This is just an example of how to call the generic find method which dispatches to your binary search. 
     * Recall that List<int> is not a permitted Java type, but List<Integer> is, and the
     * Java compiler automatically converts values between int and Integer when needed,
     * but generic types must use Integer (or Char, Double, etc. rather than other primitives).
     * For regular object types (e.g., String) there's nothing special to do, just use the class.
    */
    public void exampleCalls() {
        // Java generics do not treat primitives the same as object types.
        // To pass a primitive type (int, double, etc.) to the find method, you need to actually use the corresponding "boxed" version (Integer, Double, etc.) which is a class-based version of each primitive.
        // For types which are already/always objects, like String, everything will just work.
        // This method is not part of a test, but just a refresher/crash-course for those who may not have tried passing primitives to generic Java methods previously.
        // You should not modify this method; no part of the assignment requires you to do so, and this
        // can simply be deleted.

        Integer[] arr = { 0, 1, 2 };
        find(arr, 1);

        String[] arr2 = { "a", "b", "c", "foo" };
        find(arr2, "c");

    }

    @Test
    @DisplayName("Find element in the middle of a sorted array")
    void findMiddle() {
        Integer[] arr = {1, 3, 5, 7, 9};
        int idx = BinarySearch.binarySearchImplementation(arr, 5);
        assertEquals(5, arr[idx]); // spec: if index returned, arr[idx].equals(target)
    }

    @Test
    @DisplayName("Find first element (boundary at start)")
    void findFirst() {
        Integer[] arr = {10, 20, 30, 40};
        int idx = BinarySearch.binarySearchImplementation(arr, 10);
        assertEquals(10, arr[idx]);
    }

    @Test
    @DisplayName("Find last element (boundary at end)")
    void findLast() {
        Integer[] arr = {10, 20, 30, 40};
        int idx = BinarySearch.binarySearchImplementation(arr, 40);
        assertEquals(40, arr[idx]);
    }

    @Test
    @DisplayName("Find in single-element array")
    void singleElementFound() {
        Integer[] arr = {42};
        int idx = BinarySearch.binarySearchImplementation(arr, 42);
        assertEquals(42, arr[idx]);
    }

    @Test
    @DisplayName("Duplicates: returns any matching index")
    void duplicatesAnyMatchIsValid() {
        Integer[] arr = {2, 4, 4, 4, 8};
        int idx = BinarySearch.binarySearchImplementation(arr, 4);
        assertEquals(4, arr[idx]); // any of indices 1..3 acceptable per spec
    }

    @Test
    @DisplayName("Target not present: NoSuchElementException with informative message")
    void notFoundThrowsNoSuchElement() {
        Integer[] arr = {1, 2, 4, 8, 16};
        NoSuchElementException ex = assertThrows(
            NoSuchElementException.class, () -> BinarySearch.binarySearchImplementation(arr, 3)
        );
        
        String msg = ex.getMessage();
        assertNotNull(msg);
        // Just looking for the word "not" in the message to show it indicates not found.
        assertTrue(msg.toLowerCase().contains("not"), "Message should indicate not found: " + msg);
    }

    @Test
    @DisplayName("Binary search must not modify the input array")
    void arrayNotModified() {
        Integer[] arr = {1, 3, 5, 7, 9};
        Integer[] snapshot = Arrays.copyOf(arr, arr.length);

        // run a few searches and ensure the array stays the same
        assertDoesNotThrow(() -> BinarySearch.binarySearchImplementation(arr, 7));
        assertThrows(NoSuchElementException.class, () -> BinarySearch.binarySearchImplementation(arr, 6));

        assertArrayEquals(snapshot, arr, "Search must not modify the input array");
    }

    @Test
    @DisplayName("Null array: IllegalArgumentException with informative message")
    void nullArray() {
        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            () -> BinarySearch.binarySearchImplementation(null, 1)
        );
        assertTrue(ex.getMessage() != null && !ex.getMessage().isBlank());
    }

    @Test
    @DisplayName("Empty array: IllegalArgumentException with informative message")
    void emptyArray() {
        Integer[] arr = {};
        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            () -> BinarySearch.binarySearchImplementation(arr, 1)
        );
        assertTrue(ex.getMessage() != null && !ex.getMessage().isBlank());
    }

    @Test
    @DisplayName("Null target: IllegalArgumentException with informative message")
    void nullTarget() {
        Integer[] arr = {1, 2, 3};
        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            () -> BinarySearch.binarySearchImplementation(arr, null)
        );
        assertTrue(ex.getMessage() != null && !ex.getMessage().isBlank());
    }
    
    @Test
    @DisplayName("Target not found below minimum")
    void notFoundBelowMin() {
    Integer[] arr = {10, 20, 30};
    assertThrows(NoSuchElementException.class,
        () -> BinarySearch.binarySearchImplementation(arr, 5));
    }

    @Test
    @DisplayName("Target not found above maximum")
    void notFoundAboveMax() {
        Integer[] arr = {10, 20, 30};
        assertThrows(NoSuchElementException.class,
            () -> BinarySearch.binarySearchImplementation(arr, 40));
    }

    @Test
    @DisplayName("Single element not found")
    void singleElementNotFound() {
        Integer[] arr = {42};
        assertThrows(NoSuchElementException.class,
            () -> BinarySearch.binarySearchImplementation(arr, 7));
    }

    @Test
    @DisplayName("Works with String arrays")
    void stringArraySearch() {
        String[] arr = {"a", "b", "c", "foo"};
        int idx = BinarySearch.binarySearchImplementation(arr, "c");
        assertEquals("c", arr[idx]);
    }


    // @Test
    // public void testExceptions() {
	// Exception exception = assertThrows(UnsupportedOperationException.class,
    //     /* The bit between this and the next comment is a 
    //     * *lambda expression*: https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html#syntax
    //     * If you've taken PL, this is Java's lambda.
    //     * If not, this is like special syntax for a function object with one method.
    //     * Notice the form is:
    //     *   _args_ -> { body }
    //     * The body here simply throws an exception so you can see how the exception assertions work, but in general this is where you'd write code you expect to throw an exception when run.
    //     */
    //         () -> { throw new UnsupportedOperationException("Bad jasdf;lkasdjlfk"); }
    //     /* end of lambda expression. The () at the beginning is the (empty)
    //     * argument list of the lambda */
    //     ); // <-- This is closing off the call to assertThrows
    //     // Here you can use any methods on the Exception type to inspect whether the right exception was thrown.
    //  	assertEquals("Bad Operation", exception.getMessage());   
    // }

}

