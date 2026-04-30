package com.portfolio.datastructures.list;

import com.portfolio.datastructures.model.Student;

/**
 * A custom Doubly Linked List implementation to manage Student records.
 * Allows two-way traversal.
 *
 * @author Abdullah Al Asmy
 * @version 1.0
 */
public class StudentDoublyLinkedList
{
    private DoubleNode head;
    private DoubleNode tail;
    private int size;

    /**
     * Constructs an empty doubly linked list.
     */
    public StudentDoublyLinkedList()
    {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Adds a student to the front of the list.
     *
     * @param student the student to add
     * @throws IllegalArgumentException if the student is null
     */
    public void addFirst(final Student student)
    {
        if (student == null)
        {
            throw new IllegalArgumentException("Cannot add a null student to the list.");
        }

        final DoubleNode newNode = new DoubleNode(student);

        if (head == null)
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
        size++;
    }

    /**
     * Adds a student to the end of the list efficiently using the tail pointer.
     *
     * @param student the student to add
     * @throws IllegalArgumentException if the student is null
     */
    public void addLast(final Student student)
    {
        if (student == null)
        {
            throw new IllegalArgumentException("Cannot add a null student to the list.");
        }

        final DoubleNode newNode = new DoubleNode(student);

        if (tail == null)
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
        size++;
    }

    /**
     * Removes a student from the list based ID number.
     *
     * @param studentNumber the ID number of the student to remove
     */
    public void removeStudent(final int studentNumber)
    {
        if (head == null)
        {
            System.out.println("The list is empty. Nothing to remove.");
            return;
        }

        DoubleNode current = head;

        while (current != null)
        {
            if (current.getElement().getNumber() == studentNumber)
            {
                if (current == head && current == tail)
                {
                    head = null;
                    tail = null;
                }
                else if (current == head)
                {
                    head = head.getNext();
                    head.setPrev(null);
                }
                else if (current == tail)
                {
                    tail = tail.getPrev();
                    tail.setNext(null);
                }
                else
                {
                    current.getPrev().setNext(current.getNext());
                    current.getNext().setPrev(current.getPrev());
                }

                size--;
                System.out.println("Student #" + studentNumber + " successfully removed.");
                return;
            }
            current = current.getNext();
        }

        System.out.println("Student #" + studentNumber + " not found.");
    }

    /**
     * Prints the list forwards (Head to Tail).
     */
    public void printForward()
    {
        DoubleNode current = head;
        System.out.println("--- Forward Traversal ---");
        while (current != null)
        {
            System.out.println(current.getElement().toString());
            current = current.getNext();
        }
    }

    /**
     * Prints the list backwards (Tail to Head).
     */
    public void printBackward()
    {
        DoubleNode current = tail;
        System.out.println("--- Backward Traversal ---");
        while (current != null)
        {
            System.out.println(current.getElement().toString());
            current = current.getPrev();
        }
    }

    /**
     * Returns the current number of students in the list.
     *
     * @return the size of the list
     */
    public int getSize()
    {
        return size;
    }
}