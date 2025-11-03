package ru.job4j.assertj;

/**
 * Represents a data model for demonstrating fluent assertions.
 *
 * @author Maksim Merkulov
 * @version 1.0
 */
public class Model {

    /**
     * The top integer value.
     */
    private int top;

    /**
     * The numeric double value.
     */
    private double num;

    /**
     * The string line value.
     */
    private String line;

    /**
     * The boolean condition flag.
     */
    private boolean condition;

    /**
     * Creates a new {@code Model} with the specified values.
     *
     * @param top       the integer value
     * @param num       the double value
     * @param line      the string line
     * @param condition the condition flag
     */
    public Model(int top, double num, String line, boolean condition) {
        this.top = top;
        this.num = num;
        this.line = line;
        this.condition = condition;
    }

    /**
     * Returns the top value.
     *
     * @return the integer value
     */
    public int getTop() {
        return top;
    }

    /**
     * Returns the numeric value.
     *
     * @return the double value
     */
    public double getNum() {
        return num;
    }

    /**
     * Returns the line value.
     *
     * @return the string line
     */
    public String getLine() {
        return line;
    }

    /**
     * Returns the condition flag.
     *
     * @return the boolean condition
     */
    public boolean isCondition() {
        return condition;
    }
}
