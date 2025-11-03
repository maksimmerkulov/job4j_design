package ru.job4j.assertj;

/**
 * Represents a geometric box that can be a sphere, tetrahedron, or cube.
 *
 * @author Maksim Merkulov
 * @version 1.0
 */
public class Box {

    /**
     * Constant for unknown objects.
     */
    private static final String UNKNOWN = "Unknown object";

    /**
     * The number of vertices.
     */
    private int vertex;

    /**
     * The length of the edge.
     */
    private final int edge;

    /**
     * The type name of the object.
     */
    private String type = "";

    /**
     * Creates a new {@code Box} with the specified number of vertices
     * and edge length.
     *
     * @param vertex the number of vertices
     * @param edge   the length of the edge
     */
    public Box(int vertex, int edge) {
        this.vertex = vertex;
        this.edge = edge;
        init();
    }

    /**
     * Initializes the object type and validates vertices based on edge length.
     */
    private void init() {
        type = switch (vertex) {
            case 0 -> "Sphere";
            case 4 -> "Tetrahedron";
            case 8 -> "Cube";
            default -> UNKNOWN;
        };
        if (UNKNOWN.equals(type)) {
            vertex = -1;
        }
        if (edge <= 0) {
            vertex = -1;
            type = UNKNOWN;
        }
    }

    /**
     * Returns the type of this geometric object.
     *
     * @return the type name
     */
    public String whatsThis() {
        return this.type;
    }

    /**
     * Returns the number of vertices of this object.
     *
     * @return the vertex count
     */
    public int getNumberOfVertices() {
        return this.vertex;
    }

    /**
     * Checks if the object exists (is a valid geometric shape).
     *
     * @return {@code true} if it exists, {@code false} otherwise
     */
    public boolean isExist() {
        return this.vertex != -1;
    }

    /**
     * Calculates the surface area of the object.
     *
     * @return the surface area
     */
    public double getArea() {
        double a = edge;
        return switch (vertex) {
            case 0 -> 4 * Math.PI * (a * a);
            case 4 -> Math.sqrt(3) * (a * a);
            case 8 -> 6 * (a * a);
            default -> 0;
        };
    }
}
