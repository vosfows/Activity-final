package classes;

/*
 * Fraction
 *
 * Version 2.1
 *
 * 19/12/2020
 *
 * Copyright notice
 */
public class Fraction {
    //object fields
    private int numerator;
    private int denominator;

    /**
     * Our Starting
     */
    public Fraction() {
        numerator = 0;
        denominator = 1;
    }

    /**
     * @param wholeNumVal will be added
     */
    public Fraction(int wholeNumVal) {
        this.numerator = wholeNumVal;
        denominator = 1;
    }

    /**
     * @param numerator   will be added
     * @param denominator will be added
     */
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * @param num will be added
     */
    public void setNumerator(int num) {
        numerator = num;
    }

    /**
     * @return returns the given numerator
     */
    public int getNumerator() {
        return numerator;
    }

    /**
     * @param den is a setter for our denominator
     */
    public void setDenominator(int den) {
        denominator = den;
    }

    /**
     * @return our denominator
     */
    public int getDenominator() {
        return denominator;
    }

    /**
     * modify using math.abs
     */
    public String toString() {
        if (getDenominator() < 0) {
            return ((numerator * -1) + "/" + (Math.abs(denominator)));
        }
        return (numerator + "/" + denominator);
    }

    /**
     * @return double to our numerator and denominator
     */
    public double toDouble() {
        return (double) numerator / denominator;
    }

    /**
     * @return mixedFraction to
     */
    public MixedFraction toMixedFraction() {
        //instantiation of a mixed fraction with the present value converted into mixed fraction
        MixedFraction mixedFraction = new MixedFraction((getNumerator() / getDenominator()),
                (getNumerator() % getDenominator()), getDenominator());
        return mixedFraction;
    }

    /**
     * @param other throws another fraction
     * @return result of the given computation
     */
    public Fraction add(Fraction other) {
        Fraction result = new Fraction();
        int den = denominator * other.getDenominator();
        int num = den / denominator * numerator + den / other.getDenominator() * other.getNumerator();
        result.setNumerator(num);
        result.setDenominator(den);
        result.reduce();
        return result;
    }

    /**
     * @param other throws another fraction
     * @return result of the given computation (subtraction)
     */
    public Fraction subtract(Fraction other) {
        Fraction result = new Fraction();
        int den = denominator * other.getDenominator();
        int num = den / denominator * numerator - den / other.getDenominator()
                * other.getNumerator();
        result.setNumerator(num);
        result.setDenominator(den);
        result.reduce();
        return result;
    }

    /**
     * @param other throws another fraction
     * @return result of the given computation (multiplication)
     */
    public Fraction multiplyBy(Fraction other) {
        Fraction result = new Fraction();
        result.setNumerator(numerator * other.getNumerator());
        result.setDenominator(denominator * other.getDenominator());
        result.reduce();
        return result;
    }

    /**
     * @param other throws another fraction
     * @return result of the given computation (division)
     */
    public Fraction divideBy(Fraction other) {
        Fraction result = new Fraction();
        result.setNumerator(numerator * other.getDenominator());
        result.setDenominator(denominator * other.getNumerator());
        result.reduce();
        return result;
    }

    /**
     * reduce to our fraction
     */
    public void reduce() {
        int gcd = computeGCD(numerator, denominator); // determine the greatest common divisor of numerator and denominator
        int newNumerator = numerator / gcd; //compute newNumerator, the numerator of the simplest form of this fraction
        int newDenominator = denominator / gcd; //compute newDenominator, the denominator of the simplest form of this fraction
        setNumerator(newNumerator); // set the value of the new numerator for this fraction
        setDenominator(newDenominator); // set the value of the new denominator for this fraction
    }

    /**
     * computes for greates common denominator
     */
    private int computeGCD(int numerator, int denominator) {
        if (denominator == 0) {
            return numerator;
        } else {
            return computeGCD(denominator, numerator % denominator);
        }
    }

    /**
     * reads the whole fraction
     *
     * @param fraction gives the fraction as a string
     */
    public void read(String fraction) {
        int end = fraction.indexOf("/"); //returns index where / is
        if (end == -1) {
            numerator = Integer.parseInt(fraction);
            denominator = 1;
        } else {
            numerator = Integer.parseInt(fraction.substring(0, end));
            denominator = Integer.parseInt(fraction.substring(end + 1));
        }
        if (numerator < 0 && denominator < 0 || (numerator > 0 && denominator < 0)) //if denominator has the negative, or both are negative
        {
            numerator *= -1;
            denominator *= -1;
        }
    }
}


