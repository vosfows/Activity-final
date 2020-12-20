package classes;

/*
 * Mixed Fraction
 *
 * Version 2.1
 *
 * 19/12/2020
 *
 * Copyright notice
 */
public class MixedFraction extends Fraction {
    /**
     * private
     */
    private int whole;
    private Fraction fraction = new Fraction
            (getNumerator(), getDenominator());

    /**
     * Solve mixed fraction
     */
    public MixedFraction() {
        super();
        this.whole = 0;
    }

    /**
     * mixture of a whole number a nd fraction
     *
     * @param whole    number
     * @param fraction value
     */
    public MixedFraction(int whole, Fraction fraction) {
        this.whole = whole;
        this.fraction = fraction;
    }

    /**
     * mixture of a whole number a nd fraction
     *
     * @param whole       as integers
     * @param numerator   as integers
     * @param denominator as integers
     */
    public MixedFraction(int whole, int numerator, int denominator) {
        super(numerator, denominator);
        this.whole = whole;
    }

    /**
     * both fraction
     *
     * @param fraction as fraction
     */
    public MixedFraction(Fraction fraction) {
        whole = 0;
        this.fraction = fraction;
    }

    /**
     * setter
     *
     * @param whole as a whole
     */
    public void setWholePart(int whole) {
        this.whole = whole;
    }

    /**
     * setter
     *
     * @param fraction as fraction
     */
    public void setFractionPart(Fraction fraction) {
        this.fraction = fraction;
    }

    /**
     * getter
     *
     * @return whole will return as a whole
     */
    public int getWhole() {
        return whole;
    }

    /**
     * gets the fraction part
     *
     * @return fraction to the cosecutive method
     */
    public Fraction getFractionPart() {
        return this.fraction;
    }

    /**
     * states both fraction
     *
     * @return as a fraction
     */
    public Fraction toFraction() {
        int num = getNumerator();
        int den = getDenominator();
        int whole = getWhole();

        if (whole == 0) {
            Fraction fraction = new Fraction(num, den);
            return fraction;
        } else {
            Fraction fraction = new Fraction(((whole * den) + num), den);
            return fraction;
        }
    }

    /**
     * @return toDouble as double
     */
    public double toDouble() {
        setNumerator(whole * getDenominator() + getNumerator());
        setWholePart(0);

        return super.toDouble();
    }

    /**
     * @return mixedFraction as mixed
     */
    public MixedFraction toMixedFraction() {
        MixedFraction mixedFraction = new MixedFraction((getNumerator() / getDenominator()), (getNumerator() % getDenominator()), getDenominator());

        return mixedFraction;
    }

    /**
     * @param other to signify mixed
     * @return fractionResult
     */
    public MixedFraction add(MixedFraction other) {
        int num = getNumerator();
        int den = getDenominator();
        int whole = getWhole();
        setNumerator((whole * den) + num);
        setWholePart(0);
        Fraction fractionResult = (super.add(other.toFraction()));

        return fractionResult.toMixedFraction();
    }

    /**
     * @param other sinigy mixed
     * @return fractionResult
     */
    public MixedFraction subtract(MixedFraction other) {
        int num = getNumerator();
        int den = getDenominator();
        int whole = getWhole();
        setNumerator((whole * den) + num);
        setWholePart(0);
        Fraction fractionResult = (super.subtract(other.toFraction()));

        return fractionResult.toMixedFraction();
    }

    /**
     * @param other signify mixed
     * @return fractionResult
     */
    public MixedFraction multiplyBy(MixedFraction other) {
        int num = getNumerator();
        int den = getDenominator();
        int whole = getWhole();
        setNumerator((whole * den) + num);
        setWholePart(0);
        Fraction fractionResult = (super.multiplyBy(other.toFraction()));

        return fractionResult.toMixedFraction();
    }

    /**
     * @param other signify mixed
     * @return fractionResult
     */
    public MixedFraction divideBy(MixedFraction other) {
        int num = getNumerator();
        int den = getDenominator();
        int whole = getWhole();
        setNumerator((whole * den) + num);
        setWholePart(0);
        Fraction fractionResult = (super.divideBy(other.toFraction()));

        return fractionResult.toMixedFraction();
    }

    /**
     * reduce
     */
    public void reduce() {
        if (getNumerator() > getDenominator() && whole > 0) {
            whole += getNumerator() / getDenominator();
            setNumerator(getNumerator() % getDenominator());
        } else if (getNumerator() / getDenominator() == 1) {
            whole++;
            setNumerator(0);
            setDenominator(1);
        } else
            super.reduce();
    }

    /**
     * @return toString as string
     */
    public String toString() {
        int numerator = getNumerator();
        int denominator = getDenominator();
        int whole = getWhole();
        Fraction fraction = new Fraction(Math.abs(numerator),
                Math.abs(denominator));

        this.reduce();
        if (whole == 0)
            return "" + super.toString();
        else if (numerator / denominator == 1 || numerator == 0)
            return "" + whole;
        else if (whole < 0)
            return whole + " " + fraction;
        else {
            if (numerator < 0)
                numerator *= -1;
            return whole + " " + super.toString();
        }

    }

    /**
     * @param fraction converts the fraction to string
     */
    public void read(String fraction) {
        int space = fraction.indexOf(" ");
        int end = fraction.indexOf("/");
        if (space == -1 && end == -1) {
            whole = Integer.parseInt(fraction);
            setNumerator(0);
            setDenominator(1);
        } else if (end > -1 && space == -1) {
            super.read(fraction);
            whole = 0;
        } else {
            whole = Integer.parseInt(fraction.substring(0, space));
            super.read(fraction.substring(space + 1));
            if (getNumerator() / getDenominator() == 1) {
                setNumerator(0);
                setDenominator(1);
                whole++;
            }
        }
    }
}

