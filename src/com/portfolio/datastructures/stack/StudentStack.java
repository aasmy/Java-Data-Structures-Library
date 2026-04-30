package com.portfolio.datastructures.stack;

import com.portfolio.datastructures.list.Node;
import com.portfolio.datastructures.model.Student;

/**
 * A Stack implementation for Student records.
 *
 * @author Abdullah Al Asmy
 * @version 1.0
 */
public class StudentStack
{
    private static final int EMPTY_SIZE = 0;

    private Node top;
    private int size;

    /**
     * Constructs an empty stack.
     */
    public StudentStack()
    {
        this.top = null;
        this.size = EMPTY_SIZE;
    }

    /**
     * Pushes a student onto the top of the stack.
     *
     * @param student the student to add
     * @throws IllegalArgumentException if the student is null
     */
    public void push(final Student student)
    {
        if (student == null)
        {
            throw new IllegalArgumentException("Cannot push a null student onto the stack.");
        }

        final Node newNode = new Node(student);
        newNode.setNext(top);
        top = newNode;
        size++;
    }

    /**
     * Removes and returns the student at the top of the stack.
     *
     * @return the top student, null if the stack is empty
     */
    public Student pop()
    {
        if (isEmpty())
        {
            System.out.println("The stack is empty. Nothing to pop.");
            return null;
        }

        final Student topStudent = top.getElement();
        top = top.getNext();
        size--;
        return topStudent;
    }

    /**
     * Returns the student at the top of the stack without removing them.
     *
     * @return the top student, or null if the stack is empty
     */
    public Student peek()
    {
        if (isEmpty())
        {
            System.out.println("The stack is empty. Nothing to peek.");
            return null;
        }

        return top.getElement();
    }

    /**
     * Checks if the stack is empty.
     *
     * @return true if empty, false otherwise
     */
    public boolean isEmpty()
    {
        return top == null;
    }

    /**
     * Returns the current number of students in the stack.
     *
     * @return the size of the stack
     */
    public int getSize()
    {
        return size;
    }
}