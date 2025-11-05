package ru.job4j.generics;

import java.util.Date;
import java.util.Objects;

/**
 * Represents a person with name, age, and birthday.
 *
 * @author Maksim Merkulov
 * @version 1.0
 */
public class Person {

    /**
     * The name of the person.
     */
    private String name;

    /**
     * The age of the person.
     */
    private int age;

    /**
     * The birthday of the person.
     */
    private Date birthday;

    /**
     * Creates a new {@code Person} with the specified attributes.
     *
     * @param name     the person's name
     * @param age      the person's age
     * @param birthday the person's birthday
     */
    public Person(String name, int age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    /**
     * Returns the name of the person.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the person.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the age of the person.
     *
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the person.
     *
     * @param age the new age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Returns the birthday of the person.
     *
     * @return the birthday date
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * Sets the birthday of the person.
     *
     * @param birthday the new birthday date
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param o the reference object with which to compare
     * @return {@code true} if this object is the same as the obj argument
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Person person)) {
            return false;
        }
        return age == person.age
                && Objects.equals(name, person.name)
                && Objects.equals(birthday, person.birthday);
    }

    /**
     * Returns a hash code value for the person.
     *
     * @return a hash code value
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, age, birthday);
    }

    /**
     * Returns a string representation of the person.
     *
     * @return a string representation
     */
    @Override
    public String toString() {
        return "Person{"
                + "name='" + name + '\''
                + ", age=" + age
                + ", birthday=" + birthday
                + '}';
    }
}
