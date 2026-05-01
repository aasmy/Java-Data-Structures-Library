# Java Data Structures Library

This project is a Java data structures library built around a `Student` object. I used it to practice building common data structures manually instead of relying on Java’s built-in collections, with a focus on clean code, clear structure, and readable implementation.
The project includes:

- Singly Linked List
- Doubly Linked List
- Stack
- Queue
- Binary Search Tree
- Hash Map

Each structure stores student records with a name, student number, major, and GPA.

---

## Project Structure

```text
com.portfolio.datastructures
│
├── Main.java
│
├── model
│   └── Student.java
│
├── list
│   ├── Node.java
│   ├── DoubleNode.java
│   ├── StudentLinkedList.java
│   └── StudentDoublyLinkedList.java
│
├── stack
│   └── StudentStack.java
│
├── queue
│   └── StudentQueue.java
│
├── tree
│   ├── TreeNode.java
│   └── StudentBST.java
│
└── map
    ├── MapEntry.java
    └── StudentHashMap.java
```

---

## Student Model

The `Student` class is the object stored inside all of the data structures.

Each student has:

```java
String name;
int number;
String major;
double gpa;
```

Example:

```java
Student s1;

s1 = new Student("Barack Obama", 105, "Computer Science", 3.8);
```

The student number is used as the main identifier for sorting, searching, and hashing.

---

## Singly Linked List

The singly linked list stores students in connected nodes. In this project, `addStudent()` adds a student and keeps the list sorted by student number.

Used methods:

```java
addStudent()
printContent()
findStudent()
findTopOne()
getStudents()
removeStudent()
```

Example from the test output:

```text
Printing the list using printContent():
The list should appear sorted by student number.
Student{Name='Serena Williams', Number=99, Major='Engineering', GPA=3.7}
Student{Name='Gordon Ramsay', Number=101, Major='Engineering', GPA=4.0}
Student{Name='MrBeast', Number=102, Major='Mathematics', GPA=3.5}
Student{Name='Barack Obama', Number=105, Major='Computer Science', GPA=3.8}
Student{Name='Cleopatra', Number=108, Major='Physics', GPA=3.9}
Student{Name='Nikola Tesla', Number=110, Major='Computer Science', GPA=3.2}
```

This shows that the list is not just storing the students. It is also keeping them ordered by student number.

The linked list also searches by ID and name, finds the highest GPA student, filters by major, and removes a student by ID.

---

## Doubly Linked List

The doubly linked list uses nodes with both `next` and `prev` references. This means the list can be printed forward and backward.

Used methods:

```java
addFirst()
addLast()
printForward()
printBackward()
removeStudent()
getSize()
```

Example from the test output:

```text
Printing backward using printBackward():
--- Backward Traversal ---
Student{Name='Gordon Ramsay', Number=101, Major='Engineering', GPA=4.0}
Student{Name='Cleopatra', Number=108, Major='Physics', GPA=3.9}
Student{Name='MrBeast', Number=102, Major='Mathematics', GPA=3.5}
Student{Name='Barack Obama', Number=105, Major='Computer Science', GPA=3.8}
```

After removing student ID `108`, the size changes from `4` to `3`, and Cleopatra no longer appears in the forward or backward traversal.

---

## Stack

The stack follows the LIFO rule: last in, first out.

Used methods:

```java
push()
peek()
pop()
getSize()
```

Example from the test output:

```text
Checking stack before pop:
Top using peek(): Gordon Ramsay
Size using getSize(): 4

Removed using pop(): Gordon Ramsay

Checking stack after pop:
New top using peek(): Cleopatra
New size using getSize(): 3
```

Gordon Ramsay was the last student pushed, so he was the first one removed.

---

## Queue

The queue follows the FIFO rule: first in, first out.

Used methods:

```java
enqueue()
peek()
dequeue()
getSize()
```

Example from the test output:

```text
Checking queue before dequeue:
Front using peek(): Barack Obama
Size using getSize(): 4

Removed using dequeue(): Barack Obama

Checking queue after dequeue:
New front using peek(): MrBeast
New size using getSize(): 3
```

Here, Barack Obama was the first student added, so he was the first one removed.

---

## Binary Search Tree

The binary search tree stores students ordered by student number. Smaller IDs go to the left side of the tree, and larger IDs go to the right side.

Used methods:

```java
insert()
printInOrder()
search()
getSize()
```

Example from the test output:

```text
Printing tree using printInOrder():
This should print students sorted by ID.
--- BST In-Order Traversal (Sorted by ID) ---
Student{Name='Serena Williams', Number=99, Major='Engineering', GPA=3.7}
Student{Name='Gordon Ramsay', Number=101, Major='Engineering', GPA=4.0}
Student{Name='MrBeast', Number=102, Major='Mathematics', GPA=3.5}
Student{Name='Barack Obama', Number=105, Major='Computer Science', GPA=3.8}
Student{Name='Cleopatra', Number=108, Major='Physics', GPA=3.9}
Student{Name='Nikola Tesla', Number=110, Major='Computer Science', GPA=3.2}
```

The main point of the BST: `printInOrder()` prints the students sorted by ID.

The test driver also searches for an existing ID, searches for a missing ID, and checks that duplicate IDs are not added.

---

## Hash Map

The hash map stores students using the student number as the key. The map uses buckets, and each key is placed into a bucket based on the hash function.

Used methods:

```java
put()
get()
remove()
printMap()
getSize()
```

Example from the test output:

```text
Printing buckets using printMap():
--- Hash Map Distribution ---
Bucket 3: [99 -> Serena Williams]
Bucket 5: [101 -> Gordon Ramsay]
Bucket 6: [102 -> MrBeast]
Bucket 9: [105 -> Barack Obama]
Bucket 12: [108 -> Cleopatra]
Bucket 14: [110 -> Nikola Tesla]
```


The test driver also retrieves student ID `102`, removes student ID `105`, and prints the map again to show that the removed student is no longer stored.

---

## Main Test Driver

The `Main` class is a console driver that shows how each structure behaves.

It demonstrates:

- adding students
- printing stored students
- searching by ID or name
- removing students
- checking size changes
- stack LIFO behavior
- queue FIFO behavior
- BST sorted traversal
- hash map bucket distribution

The output is meant to make the behavior visible while running the program.

---


## How to Run

Run the project from `Main.java` in IntelliJ IDEA.

Or from the command line:

```bash
javac com/portfolio/datastructures/Main.java
java com.portfolio.datastructures.Main
```

---


This project was built to practice the internal logic of data structures.
