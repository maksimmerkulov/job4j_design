package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

/**
 * Tests for the {@link Box} class focusing on primitive type
 * and string assertions.
 *
 * @author Maksim Merkulov
 * @version 1.0
 */
class BoxTest {

    /**
     * Verifies that the object is correctly identified as a Sphere.
     */
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isNotNull()
                .isNotEmpty()
                .isNotBlank()
                .isEqualTo("Sphere")
                .isNotEqualTo("Unknown object")
                .startsWith("Sph")
                .endsWith("ere")
                .contains("phe")
                .doesNotContain("Cube");
    }

    /**
     * Verifies that an invalid vertex count results in an Unknown object.
     */
    @Test
    void isThisUnknown() {
        Box box = new Box(6, 5);
        String name = box.whatsThis();
        assertThat(name).isNotNull()
                .isNotEmpty()
                .isEqualTo("Unknown object")
                .startsWithIgnoringCase("unknown")
                .contains("object")
                .isNotIn("Sphere", "Tetrahedron", "Cube");
    }

    /**
     * Verifies the vertex count for a Tetrahedron.
     */
    @Test
    void checkNumberOfVerticesTetrahedron() {
        Box box = new Box(4, 8);
        int result = box.getNumberOfVertices();
        assertThat(result).isNotZero()
                .isPositive()
                .isEven()
                .isGreaterThan(3)
                .isLessThan(5)
                .isEqualTo(4);
    }

    /**
     * Verifies the vertex count for an invalid configuration.
     */
    @Test
    void checkNumberOfVerticesUnknown() {
        Box box = new Box(-1, 8);
        int result = box.getNumberOfVertices();
        assertThat(result).isNegative()
                .isNotZero()
                .isLessThan(0)
                .isGreaterThan(-2)
                .isEqualTo(-1);
    }

    /**
     * Verifies existence of a valid Cube.
     */
    @Test
    void isExistTrue() {
        Box box = new Box(8, 8);
        boolean result = box.isExist();
        assertThat(result).isTrue()
                .isNotEqualTo(false);
    }

    /**
     * Verifies non-existence of an object with zero edge length.
     */
    @Test
    void isExistFalse() {
        Box box = new Box(8, 0);
        boolean result = box.isExist();
        assertThat(result).isFalse()
                .isNotEqualTo(true);
    }

    /**
     * Verifies the surface area of a Cube.
     */
    @Test
    void checkAreaCube() {
        Box box = new Box(8, 4);
        double result = box.getArea();
        assertThat(result).isNotZero()
                .isPositive()
                .isGreaterThan(95.9d)
                .isLessThan(96.1d)
                .isEqualTo(96.0d, withPrecision(0.01d));
    }

    /**
     * Verifies the surface area of a Tetrahedron.
     */
    @Test
    void checkAreaTetrahedron() {
        Box box = new Box(4, 6);
        double result = box.getArea();
        assertThat(result).isPositive()
                .isNotZero()
                .isGreaterThan(62.0d)
                .isLessThan(63.0d)
                .isCloseTo(62.35d, withPrecision(0.01d));
    }
}
