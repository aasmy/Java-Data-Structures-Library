package com.portfolio.datastructures.queue;

import com.portfolio.datastructures.list.Node;
import com.portfolio.datastructures.model.Student;

/**
 * A Queue implementation for Student records.
 *
 * @author Abdullah Al Asmy
 * @version 1.0
 */
public class StudentQueue
{
    private static final int EMPTY_SIZE = 0;

    private Node front;
    private Node rear;
    private int size;

    /**
     * Constructs an empty queue.
     */
    public StudentQueue()
    {
        this.front = null;
        this.rear = null;
        this.size = EMPTY_SIZE;
    }

    /**
     * Adds a student to the back of the queue (Enqueue).
     *
     * @param student the student to add
     * @throws IllegalArgumentException if the student is null
     */
    public void enqueue(final Student student)
    {
        if (student == null)
        {
            throw new IllegalArgumentException("Cannot enqueue a null student.");
        }

        final Node newNode = new Node(student);

        if (isEmpty())
        {
            front = newNode;
            rear = newNode;
        }
        else
        {
            rear.setNext(newNode);
            rear = newNode;
        }
        size++;
    }

    /**
     * Removes and returns the student at the front of the queue (Dequeue).
     *
     * @return the front student, or null if the queue is empty
     */
    public Student dequeue()
    {
        if (isEmpty())
        {
            System.out.println("The queue is empty. Nothing to dequeue.");
            return null;
        }

        final Student frontStudent = front.getElement();
        front = front.getNext();

        if (front == null)
        {
            rear = null;
        }

        size--;
        return frontStudent;
    }

    /**
     * Returns the student at the front of the queue without removing them.
     *
     * @return the front student, or null if the queue is empty
     */
    public Student peek()
    {
        if (isEmpty())
        {
            System.out.println("The queue is empty. Nothing to peek.");
            return null;
        }

        return front.getElement();
    }

    /**
     * Checks if the queue is empty.
     *
     * @return true if empty, false otherwise
     */
    public boolean isEmpty()
    {
        return front == null;
    }

    /**
     * Returns the current number of students in the queue.
     *
     * @return the size of the queue
     */
    public int getSize()
    {
        return size;
    }
}