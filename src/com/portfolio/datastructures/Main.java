package com.portfolio.datastructures;

import com.portfolio.datastructures.model.Student;
import com.portfolio.datastructures.map.StudentHashMap;
import com.portfolio.datastructures.tree.StudentBST;
import com.portfolio.datastructures.queue.StudentQueue;
import com.portfolio.datastructures.stack.StudentStack;
import com.portfolio.datastructures.list.StudentLinkedList;
import com.portfolio.datastructures.list.StudentDoublyLinkedList;

/**
 * Main driver for testing the custom data structures.
 *
 * @author Abdullah Al Asmy
 * @version 1.0
 */
public class Main
{
    public static void main(String[] args)
    {
        Student s1;
        Student s2;
        Student s3;
        Student s4;
        Student s5;
        Student s6;

        s1 = new Student("Barack Obama", 105, "Computer Science", 3.8);
        s2 = new Student("MrBeast", 102, "Mathematics", 3.5);
        s3 = new Student("Cleopatra", 108, "Physics", 3.9);
        s4 = new Student("Gordon Ramsay", 101, "Engineering", 4.0);
        s5 = new Student("Nikola Tesla", 110, "Computer Science", 3.2);
        s6 = new Student("Serena Williams", 99, "Engineering", 3.7);

        System.out.println("===== Data Structures Test Driver =====");

        testLinkedList(s1, s2, s3, s4, s5, s6);
        testDoublyLinkedList(s1, s2, s3, s4);
        testStack(s1, s2, s3, s4);
        testQueue(s1, s2, s3, s4);
        testBST(s1, s2, s3, s4, s5, s6);
        testHashMap(s1, s2, s3, s4, s5, s6);

        System.out.println("\n===== Execution Complete =====");
    }

    private static void testLinkedList(final Student... students)
    {
        StudentLinkedList list;
        Student foundById;
        Student foundByName;

        System.out.println("\n----- Singly Linked List Test -----");

        list = new StudentLinkedList();

        System.out.println("Adding students using addStudent():");
        for (Student student : students)
        {
            list.addStudent(student);
            System.out.println("Added: " + student.getName());
        }

        System.out.println("\nPrinting the list using printContent():");
        System.out.println("The list should appear sorted by student number.");
        list.printContent();

        System.out.println("\nSearching by ID using findStudent(108):");
        foundById = list.findStudent(108);
        if (foundById != null)
        {
            System.out.println(foundById.toString());
        }

        System.out.println("\nSearching by name using findStudent(\"MrBeast\"):");
        foundByName = list.findStudent("MrBeast");
        if (foundByName != null)
        {
            System.out.println(foundByName.toString());
        }

        System.out.println("\nFinding highest GPA student using findTopOne():");
        list.findTopOne();

        System.out.println("\nGetting Computer Science students using getStudents():");
        list.getStudents("Computer Science");

        System.out.println("\nRemoving student ID 102 using removeStudent():");
        list.removeStudent(102);

        System.out.println("\nPrinting the list after removing ID 102:");
        list.printContent();

        System.out.println("\nTrying to remove missing student ID 999:");
        list.removeStudent(999);
    }

    private static void testDoublyLinkedList(final Student... students)
    {
        StudentDoublyLinkedList list;

        System.out.println("\n----- Doubly Linked List Test -----");

        list = new StudentDoublyLinkedList();

        System.out.println("Adding first student using addFirst():");
        list.addFirst(students[0]);
        System.out.println("Added first: " + students[0].getName());

        System.out.println("\nAdding remaining students using addLast():");
        for (int i = 1; i < students.length; i++)
        {
            list.addLast(students[i]);
            System.out.println("Added last: " + students[i].getName());
        }

        System.out.println("\nCurrent size using getSize(): " + list.getSize());

        System.out.println("\nPrinting forward using printForward():");
        list.printForward();

        System.out.println("\nPrinting backward using printBackward():");
        list.printBackward();

        System.out.println("\nRemoving student ID 108 using removeStudent():");
        list.removeStudent(108);

        System.out.println("\nSize after removing ID 108: " + list.getSize());

        System.out.println("\nForward list after removing ID 108:");
        list.printForward();

        System.out.println("\nBackward list after removing ID 108:");
        list.printBackward();
    }

    private static void testStack(final Student... students)
    {
        StudentStack stack;
        Student removed;

        System.out.println("\n----- Stack Test -----");
        System.out.println("Stack uses LIFO: last in, first out.");

        stack = new StudentStack();

        System.out.println("\nPushing students using push():");
        for (Student student : students)
        {
            stack.push(student);
            System.out.println("Pushed: " + student.getName());
        }

        System.out.println("\nChecking stack before pop:");
        System.out.println("Top using peek(): " + stack.peek().getName());
        System.out.println("Size using getSize(): " + stack.getSize());

        removed = stack.pop();

        System.out.println("\nRemoved using pop(): " + removed.getName());

        System.out.println("\nChecking stack after pop:");
        System.out.println("New top using peek(): " + stack.peek().getName());
        System.out.println("New size using getSize(): " + stack.getSize());
    }

    private static void testQueue(final Student... students)
    {
        StudentQueue queue;
        Student removed;

        System.out.println("\n----- Queue Test -----");
        System.out.println("Queue uses FIFO: first in, first out.");

        queue = new StudentQueue();

        System.out.println("\nAdding students using enqueue():");
        for (Student student : students)
        {
            queue.enqueue(student);
            System.out.println("Enqueued: " + student.getName());
        }

        System.out.println("\nChecking queue before dequeue:");
        System.out.println("Front using peek(): " + queue.peek().getName());
        System.out.println("Size using getSize(): " + queue.getSize());

        removed = queue.dequeue();

        System.out.println("\nRemoved using dequeue(): " + removed.getName());

        System.out.println("\nChecking queue after dequeue:");
        System.out.println("New front using peek(): " + queue.peek().getName());
        System.out.println("New size using getSize(): " + queue.getSize());
    }

    private static void testBST(final Student... students)
    {
        StudentBST bst;
        Student found;

        System.out.println("\n----- Binary Search Tree Test -----");
        System.out.println("BST stores students ordered by student number.");

        bst = new StudentBST();

        System.out.println("\nInserting students using insert():");
        for (Student student : students)
        {
            bst.insert(student);
            System.out.println("Inserted: " + student.getName() + " | ID: " + student.getNumber());
        }

        System.out.println("\nBST size using getSize(): " + bst.getSize());

        System.out.println("\nPrinting tree using printInOrder():");
        System.out.println("This should print students sorted by ID.");
        bst.printInOrder();

        System.out.println("\nSearching existing ID 108 using search():");
        found = bst.search(108);
        if (found != null)
        {
            System.out.println(found.toString());
        }

        System.out.println("\nSearching missing ID 777 using search():");
        found = bst.search(777);
        if (found == null)
        {
            System.out.println("Student ID 777 was not found.");
        }

        System.out.println("\nTrying to insert duplicate ID 108:");
        bst.insert(students[2]);

        System.out.println("BST size after duplicate attempt: " + bst.getSize());
    }

    private static void testHashMap(final Student... students)
    {
        StudentHashMap map;
        Student found;
        Student removed;

        System.out.println("\n----- Hash Map Test -----");
        System.out.println("Hash Map stores students using student number as the key.");

        map = new StudentHashMap();

        System.out.println("\nAdding students using put():");
        for (Student student : students)
        {
            map.put(student);
            System.out.println("Put: " + student.getNumber() + " -> " + student.getName());
        }

        System.out.println("\nHash Map size using getSize(): " + map.getSize());

        System.out.println("\nPrinting buckets using printMap():");
        map.printMap();

        System.out.println("\nGetting student ID 102 using get():");
        found = map.get(102);
        if (found != null)
        {
            System.out.println(found.toString());
        }

        System.out.println("\nRemoving student ID 105 using remove():");
        removed = map.remove(105);
        if (removed != null)
        {
            System.out.println("Removed: " + removed.getName());
        }

        System.out.println("\nHash Map size after remove: " + map.getSize());

        System.out.println("\nPrinting map after removing ID 105:");
        map.printMap();

        System.out.println("\nTrying to get removed ID 105:");
        found = map.get(105);
        if (found == null)
        {
            System.out.println("Student ID 105 was not found because it was removed.");
        }
    }
}