# Instructions

For your write-up, you must:
Explain the approach you took to testing your search routine. Tell us if you used equivalence partitions, boundary value analysis, etc., including what order you did these things and what process (if any) you used for each. We are not looking for a particular combination of techniques; we’re interested in your record of how you selected and applied the chosen techniques. Please include in your write-up any intermediate results (e.g, your textual breakdown of equivalence partitions, etc.); any closed-box technique you apply generates intermediate results that are not literally represented as test methods written in Java. If you’re unsure what information to include here, you could of course err on the side of more information, but really you should just ask.
One part of the requirements above were (identified as) underspecified, yet you still had to make a decision regarding the behavior for those under-specified inputs. Which tests are related to that choice of behavior? Are those closed-box, or open-box tests? Why?
Briefly compare your closed-box and open-box tests. Did either approach find bugs in your implementation that the other did not (or would not have)? If not, can you imagine scenarios where it could have? (Hint: closed-box and code-coverage-driven open-box tests are complementary, each is better at finding certain kinds of bugs the other is not as good at finding; see the lecture slides.)
Please submit your write-up as a .txt, .md, or .pdf file.

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

# Open-Box Testing 

