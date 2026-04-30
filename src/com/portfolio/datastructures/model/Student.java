package com.portfolio.datastructures.model;

/**
 * Represents a student with a name, student number, major, and GPA.
 *
 * @author Abdullah Al Asmy
 * @version 1.0
 */
public class Student
{
    private static final int MIN_STUDENT_NUMBER = 1;
    private static final double MIN_GPA = 0.0;

    private final String name;
    private final int number;
    private final String major;
    private final double gpa;

    /**
     * Constructs a Student with validated fields.
     *
     * @param name   the name of the student
     * @param number the student's ID number
     * @param major  the student's major
     * @param gpa    the student's GPA
     *
     * @throws IllegalArgumentException if any argument is invalid
     */
    public Student(final String name,
                   final int number,
                   final String major,
                   final double gpa)
    {
        validateName(name);
        validateNumber(number);
        validateMajor(major);
        validateGpa(gpa);

        this.name = name;
        this.number = number;
        this.major = major;
        this.gpa = gpa;
    }

    /**
     * Validates the student's name.
     *
     * @param inputName the name to validate
     * @throws IllegalArgumentException if the name is null or blank
     */
    private void validateName(final String inputName)
    {
        if (inputName == null || inputName.isBlank())
        {
            throw new IllegalArgumentException("Student name cannot be null or blank.");
        }
    }

    /**
     * Validates the student's ID number.
     *
     * @param inputNumber the number to validate
     * @throws IllegalArgumentException if the number is below the minimum allowed
     */
    private void validateNumber(final int inputNumber)
    {
        if (inputNumber < MIN_STUDENT_NUMBER)
        {
            throw new IllegalArgumentException("Student number must be at least " + MIN_STUDENT_NUMBER + ".");
        }
    }

    /**
     * Validates the student's major.
     *
     * @param inputMajor the major to validate
     * @throws IllegalArgumentException if the major is null or blank
     */
    private void validateMajor(final String inputMajor)
    {
        if (inputMajor == null || inputMajor.isBlank())
        {
            throw new IllegalArgumentException("Major cannot be null or blank.");
        }
    }

    /**
     * Validates the student's GPA.
     *
     * @param inputGpa the GPA to validate
     * @throws IllegalArgumentException if the GPA is below the minimum allowed
     */
    private void validateGpa(final double inputGpa)
    {
        if (inputGpa < MIN_GPA)
        {
            throw new IllegalArgumentException("GPA cannot be less than " + MIN_GPA + ".");
        }
    }

    /**
     * Returns the student's name.
     *
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Returns the student's ID number.
     *
     * @return the ID number
     */
    public int getNumber()
    {
        return number;
    }

    /**
     * Returns the student's major.
     *
     * @return the major
     */
    public String getMajor()
    {
        return major;
    }

    /**
     * Returns the student's GPA.
     *
     * @return the GPA
     */
    public double getGpa()
    {
        return gpa;
    }

    /**
     * Returns a string representation of this student.
     *
     * @return formatted student details
     */
    @Override
    public String toString()
    {
        return "Student{" +
                "Name='" + name + '\'' +
                ", Number=" + number +
                ", Major='" + major + '\'' +
                ", GPA=" + gpa +
                '}';
    }
}