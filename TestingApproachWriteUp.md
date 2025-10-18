# SE320 Homework 1

Name: Samii Shabuse

Course: SE320 - Software Verification and Validation

Assignment: Homework 1 

# Overview

For this assignment I had implemented a generic binary search in java. The function returns the index of a found elemnet or throws
the necessary exception based on elementing or invalid input.

The assignment required validating this method through two types of testing:
    - Closed-Box Testing (requirements testing with no code visibility)
    - Open-Box Testing (code-coverage, branch-coverage, and with code visibility)
Both were using JUnit testing


# Closed-Box Testing

For closed-box testing, I designed test cases based on the assignments requirements WITHOUT looking at the source code. So based on this I used equivalence partitioning to identify categories of valid and invalid inputs and boundary value analysis to select represenetative edge cases. 

The valid input parittions included arrays where the target elment was present, arrays where it was absent, arrays with duplicate elements, and single-element arrays. 

The invalid input partitions included a null array, an empty array, and a null target element. So each each test case was written to verify that the binary search method will either return the correct index or throw correct exception type with an informative error message.

For valid test cases, I foucsed on testing for finding elements in the beginning, middle, and end of an array, and as well for finding in an single-element arary an dwithin an array that also has duplicates. 

For invalid inputs, I also tested null arrays, empty arrays, and null target elements to ensure that the function raised an IllegalArgumentException in each case. I also tested a scenario where the element was not found in a valid array, which woudl throw a NoSuchElementException. 

In addition, I also made sure the binary search would not modify the input, so I have a test to see the beginning and after the search input.

I also added two not ofund boundary cases where the search element was smaller than the smallest element and larger than the largest element in the array. 

Finally, to show the binary search works for different comparable T types, I added a test for a string array, that it is generic neough to work with non-numeric.

Also following the instructions didn't include any tests for unsorted arrays, since the behaviors for those are not explicitly specificed and not required to be tested for closed box testing. 


# Open-Box Testing 

I started this before in the beginning a little bit just to get more coverage but closed-box testing showed off more problems so I started working on it again after I finished most of closed-box testing. 

I wrote the open-box testing to achieve full code and branch coverage for the binary search implementation. Unlike closed-boxing testing, these tests were focused on the code I wrote. 

The open-box test included cases where the search element was found immediately at the midpoint, found after going left, and found after going right. I also included a test where the search went through every possible indice and correctly threw NoSuchElementException.

For input validation, I included three seperate tests to trigger each IllegalArgumentException branch: null array, empty array, and null target element. A duplicate value test was also included to confirm that return any valid index of a duplicate element was acceptable. The generated report confirmed 100% statement and branch coverage for the binary search implementation.

# Underspecified Behavior

The specification stated that the binary search behavior on an unsorted array is underspecified. So based on that I decieded not to enforce sort or check for it since it would make in O(n) run time instead of O(log n)

# Comparison of Approach

Both closed-box and open-box testing both compliment each other. The closed-box testing focused on the binary search functional correctness according to the problem specification, ensuring that valid and invalid inputs were handled as required. While the open-box tests, ensured complete internal coverage, confirmed every path, condition, and exception in the implementation was execute. Both the sets found bugs in my code. I forgot to cover a lot of my input testing and then I messed up forgetting to include my else statement for my branch. After fixing everything they both gave me confidence that the implementation is correct and tested in-depth. 

# Summary

Overall, I applied equivalence parititoning and boundary value analysis to designa a thorough closed-box testing suite and achieved full coverage through open-box testing. I didn't include sortedness checking based on instructions. 