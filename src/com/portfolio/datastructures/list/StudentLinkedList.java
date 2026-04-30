package com.portfolio.datastructures.list;

import com.portfolio.datastructures.model.Student;

/**
 * A custom Singly Linked List implementation to manage Student records.
 *
 * @author Abdullah Al Asmy
 * @version 1.0
 */
public class StudentLinkedList
{
    private Node head;

    /**
     * Constructs an empty linked list.
     */
    public StudentLinkedList()
    {
        this.head = null;
    }

    /**
     * Adds a student to the list and sorts the list by student number.
     *
     * @param student the student to add
     * @throws IllegalArgumentException if the student is null
     */
    public void addStudent(final Student student)
    {
        if (student == null)
        {
            throw new IllegalArgumentException("Cannot add a null student to the list.");
        }

        final Node newNode = new Node(student);
        newNode.setNext(head);
        head = newNode;
        sortByNumber();
    }

    /**
     * Sorts the linked list iteratively by student number.
     */
    private void sortByNumber()
    {
        Node ptr1 = head;
        Node ptr2;
        Student temp;

        while (ptr1 != null)
        {
            ptr2 = ptr1.getNext();
            while (ptr2 != null)
            {
                if (ptr1.getElement().getNumber() > ptr2.getElement().getNumber())
                {
                    temp = ptr1.getElement();
                    ptr1.setElement(ptr2.getElement());
                    ptr2.setElement(temp);
                }
                ptr2 = ptr2.getNext();
            }
            ptr1 = ptr1.getNext();
        }
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
            System.out.println("No students to remove. The list is empty.");
            return;
        }

        Node current = head;
        Node previous = null;

        while (current != null)
        {
            if (current.getElement().getNumber() == studentNumber)
            {
                break;
            }
            else
            {
                previous = current;
                current = current.getNext();
            }
        }

        if (current != null)
        {
            if (previous == null)
            {
                head = head.getNext();
            }
            else
            {
                previous.setNext(current.getNext());
            }
            System.out.println("Student #" + studentNumber + " removed successfully.");
        }
        else
        {
            System.out.println("No student found with number: " + studentNumber);
        }
    }

    /**
     * Extracts all students from a specific major into an array,
     * sorts them alphabetically by name, and returns the array.
     *
     * @param major the major to filter by
     * @return an array of sorted students in the specified major
     */
    public Student[] getStudents(final String major)
    {
        if (head == null || major == null || major.isBlank())
        {
            System.out.println("Invalid major or empty list.");
            return new Student[0];
        }

        Node ptr = head;
        int counter = 0;

        while (ptr != null)
        {
            if (ptr.getElement().getMajor().equalsIgnoreCase(major))
            {
                counter++;
            }
            ptr = ptr.getNext();
        }

        if (counter > 0)
        {
            final Student[] array = new Student[counter];
            int i = 0;
            ptr = head;

            while (ptr != null)
            {
                if (ptr.getElement().getMajor().equalsIgnoreCase(major))
                {
                    array[i] = ptr.getElement();
                    i++;
                }
                ptr = ptr.getNext();
            }

            Student temp;
            for (int r = 0; r < array.length; r++)
            {
                for (int j = r + 1; j < array.length; j++)
                {
                    if (array[r].getName().compareToIgnoreCase(array[j].getName()) > 0)
                    {
                        temp = array[r];
                        array[r] = array[j];
                        array[j] = temp;
                    }
                }
            }

            System.out.println("This is the list of students whose major is: " + major);
            for (final Student student : array)
            {
                System.out.println(student.toString());
            }

            return array;
        }
        else
        {
            System.out.println("No students found with major: " + major);
            return new Student[0];
        }
    }

    /**
     * Finds and returns a student object based ID number.
     *
     * @param studentNumber the student ID to search for
     * @return the corresponding Student object, or null if not found
     */
    public Student findStudent(final int studentNumber)
    {
        if (head == null)
        {
            System.out.println("The list is empty.");
            return null;
        }

        Node ptr = head;
        while (ptr != null)
        {
            if (ptr.getElement().getNumber() == studentNumber)
            {
                System.out.print("Found pointer for student #" + studentNumber + ": ");
                return ptr.getElement();
            }
            ptr = ptr.getNext();
        }

        System.out.println("Sorry, no student has this number.");
        return null;
    }

    /**
     * Finds and returns a student object based on name.
     *
     * @param studentName the student name to search for
     * @return the corresponding Student object, or null if not found
     */
    public Student findStudent(final String studentName)
    {
        if (head == null || studentName == null || studentName.isBlank())
        {
            System.out.println("Invalid name or empty list.");
            return null;
        }

        Node ptr = head;
        while (ptr != null)
        {
            if (ptr.getElement().getName().equalsIgnoreCase(studentName))
            {
                System.out.print("Found pointer for student named " + studentName + ": ");
                return ptr.getElement();
            }
            ptr = ptr.getNext();
        }

        System.out.println("Sorry, we can't find a student with that name.");
        return null;
    }

    /**
     * Finds and prints the details of the student with the highest GPA.
     */
    public void findTopOne()
    {
        if (head == null)
        {
            System.out.println("The list is empty.");
            return;
        }

        double maxGpa = -1.0;
        Node ptr = head;
        Node topStudentNode = null;

        while (ptr != null)
        {
            if (ptr.getElement().getGpa() > maxGpa)
            {
                maxGpa = ptr.getElement().getGpa();
                topStudentNode = ptr;
            }
            ptr = ptr.getNext();
        }

        if (topStudentNode != null)
        {
            System.out.println(topStudentNode.getElement().toString());
        }
    }

    /**
     * Prints the details of a specific student by ID number.
     *
     * @param studentNumber the ID number of the student to print
     */
    public void print(final int studentNumber)
    {
        if (head == null)
        {
            System.out.println("The list is empty.");
            return;
        }

        Node ptr = head;
        while (ptr != null)
        {
            if (ptr.getElement().getNumber() == studentNumber)
            {
                System.out.println(ptr.getElement().toString());
                return;
            }
            ptr = ptr.getNext();
        }

        System.out.println("Sorry, I can't find the student with that number.");
    }

    /**
     * Prints the entire contents of the linked list.
     */
    public void printContent()
    {
        Node ptr = head;
        while (ptr != null)
        {
            System.out.println(ptr.getElement().toString());
            ptr = ptr.getNext();
        }
    }
}