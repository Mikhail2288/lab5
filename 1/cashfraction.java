public class cashfraction implements interfacefraction{
    private fraction fraction;
    private Double cachedValue = null;

    public cashfraction(int numerator, int denominator) {
        this.fraction = new fraction(numerator, denominator);
    }

    @Override
    public double getDecimalValue() {
        if (cachedValue == null) {
            cachedValue = fraction.getDecimalValue();
        }
        return cachedValue;
    }

    @Override
    public void setNumerator(int numerator) {
        fraction.setNumerator(numerator);
        cachedValue = null;
    }

    @Override
    public void setDenominator(int denominator) {
        fraction.setDenominator(denominator);
        cachedValue = null;
    }
    @Override
    public String toString() {
        return fraction.toString();
    }
    @Override
    public boolean equals(Object o){
        return fraction.equals(o);
    }
    @Override
    public int hashCode(){
        return fraction.hashCode();
    }
}
