# CS 3308 Mission 03 -- Queues

## Due: Sunday February 03, 2019 @ 2300

## Purpose
* Build a Queue Implementation using a Wrapped LinkedList
* Implement some useful Queue methods
* Implement an application to scan a Stack without destroying it

## Problem Statement
You are going to implement a Queue using a LinkedList. Once you have constructed the Queue you will need to solve the following problem.

suppose you have a stack S and a queue Q that is initially empty. You will implement a method that uses Q to scan S to see if it contains a certain element X, with the additional constraint that your algorithm must return the elements back to S in their original order. You may only use S, Q, and a constant number of other primitive variables.

## Assignment
1. Fork this repository
2. Use your LinkedLists from prior assignments.
3. Review the Queue ADT in package `edu.isu.cs.cs3308.structures`. **Review this interface in order to understand methods which must be implemented, their signatures, and their documentation.**
4. Using this ADT implement the class `LinkedQueue` (which implements the `Queue` ADT) in the package `edu.isu.cs.cs3308.structures.impl`
5. `static <E> boolean scanStack(Stack<E> stack, E element)` in class `StackScan`, which scans a stack to determine if it contains the provided element. **Note: the stack must contain the same elements in the same order after the method is complete**

## Submission
When you have completed the assignment (all tests pass) or it is reaching midnight of the due date, make sure you have completed the following:
1. Committed all changes to your repo
2. Pushed your changes to GitHub
3. Tagged your repo as "COMPLETE"
4. Pushed the "COMPLETE" tag to GitHub
5. Submitted your repository URL to Moodle in the Mission 01 submission section.

## Grading -- 50 Points
* StackScan -- 10 Points
* LinkedQueue -- 22 Points
* Program by contract -- 8
* Style and Documentation -- 10

## Hints
* The merge, transfer, and reverse methods should be quite similar to those implemented for Stack, but keep in mind the FIFO operation of a Queue.
* The StackScan method will need some planning, keeping in mind the four steps to successful planning. It will help to draw out how this algorithm works on paper first.
