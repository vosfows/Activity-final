import classes.*;
import org.junit.Test;
import static org.junit.Assert.*;

/*
 * Fraction Test
 *
 * Version 2.1
 *
 * 19/12/2020
 *
 * Copyright notice
 */





/**
 * JUnit tests for {@link Fraction}.
 * <p>
 * Testing cases for proper and improper fractions using the methods for basic
 * arithmetic operations, accessor and mutator, convert to mixed fraction, and
 * reduce fraction.
 *
 * @author  Adriel Hans M. Gaviola
 *
 */
public class FractionTest {
    //Starting variables with assigned values
    Fraction properFraction = new Fraction(12, 52);
    Fraction improperFraction = new Fraction(61, 52);

    /**
     * This test method tests the getter methods of the fraction class.
     */
    @Test
    public void accessors() {
        assertEquals(12, properFraction.getNumerator());
        assertEquals(52, properFraction.getDenominator());
        assertEquals(61, improperFraction.getNumerator());
        assertEquals(52, improperFraction.getDenominator());
    }

    /**
     * This test method tests setter methods of the fraction class.
     */
    @Test
    public void mutators() {
        properFraction.setNumerator(34);
        properFraction.setDenominator(12);
        improperFraction.setNumerator(17);
        improperFraction.setDenominator(42);
        assertEquals(34, properFraction.getNumerator());
        assertEquals(12, properFraction.getDenominator());
        assertEquals(17, improperFraction.getNumerator());
        assertEquals(42, improperFraction.getDenominator());
    }

    /**
     * This test method tests the convert improper and proper fractions into a mixed fraction.
     */
    @Test
    public void convertFraction() {
        assertEquals("3/13", properFraction.toMixedFraction().toString());
        assertEquals("1 9/52", improperFraction.toMixedFraction().toString());
    }

    /**
     * This test method reduces the value of the fractions.
     */
    @Test
    public void reduce() {
        properFraction.reduce();
        improperFraction.reduce();
        assertEquals("3/13", properFraction.toString());
        assertEquals("61/52", improperFraction.toString());
    }

    /**
     * This test method adds the value of proper and improper fraction using add() method
     * in the fraction class.
     */
    @Test
    public void add() {
        assertEquals("6/13", properFraction.add(properFraction).toString());
        assertEquals("73/52", properFraction.add(improperFraction).toString());
        assertEquals("61/26", improperFraction.add(improperFraction).toString());
        assertEquals("73/52", improperFraction.add(properFraction).toString());
    }

    @Test
    /**
     * This test method subtract the value of proper and improper fraction using subtract() method
     * in the fraction class.
     */
    public void subtract() {
        assertEquals("0/1", properFraction.subtract(properFraction).toString());
        assertEquals("-49/52", properFraction.subtract(improperFraction).toString());
        assertEquals("0/1", improperFraction.subtract(improperFraction).toString());
        assertEquals("49/52", improperFraction.subtract(properFraction).toString());
    }


    /**
     * This test method multiplies the value of proper and improper fraction using multiplyBy() method
     * in the fraction class.
     */
    @Test
    public void multiply() {
        assertEquals("9/169", properFraction.multiplyBy(properFraction).toString());
        assertEquals("183/676", properFraction.multiplyBy(improperFraction).toString());
        assertEquals("3721/2704", improperFraction.multiplyBy(improperFraction).toString());
        assertEquals("183/676", improperFraction.multiplyBy(properFraction).toString());
    }


    /**
     * This test method divides the value of proper and improper fraction using divideBy() method
     * in the fraction class.
     */
    @Test
    public void divide() {
        assertEquals("1/1", properFraction.divideBy(properFraction).toString());
        assertEquals("12/61", properFraction.divideBy(improperFraction).toString());
        assertEquals("1/1", improperFraction.divideBy(improperFraction).toString());
        assertEquals("61/12", improperFraction.divideBy(properFraction).toString());
    }
}