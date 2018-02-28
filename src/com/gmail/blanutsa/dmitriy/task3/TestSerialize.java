package com.gmail.blanutsa.dmitriy.task3;

public class TestSerialize {

    @Save
    private String stringValue;

    @Save
    private Integer integerValue;

    @Save
    private long longValue;

    @Save
    private short shortValue;

    @Save
    private byte byteValue;

    @Save
    private float floatValue;

    @Save
    private double doubleValue;

    @Save
    private char charValue;

    @Save
    private boolean booleanValue;

    public TestSerialize(String stringValue, Integer integerValue, long longValue, short shortValue, byte byteValue, float floatValue, double doubleValue, char charValue, boolean booleanValue) {
        this.stringValue = stringValue;
        this.integerValue = integerValue;
        this.longValue = longValue;
        this.shortValue = shortValue;
        this.byteValue = byteValue;
        this.floatValue = floatValue;
        this.doubleValue = doubleValue;
        this.charValue = charValue;
        this.booleanValue = booleanValue;
    }

    public TestSerialize() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestSerialize)) return false;

        TestSerialize that = (TestSerialize) o;

        if (integerValue != that.integerValue) return false;
        if (longValue != that.longValue) return false;
        if (shortValue != that.shortValue) return false;
        if (byteValue != that.byteValue) return false;
        if (Float.compare(that.floatValue, floatValue) != 0) return false;
        if (Double.compare(that.doubleValue, doubleValue) != 0) return false;
        if (charValue != that.charValue) return false;
        if (booleanValue != that.booleanValue) return false;
        return stringValue != null ? stringValue.equals(that.stringValue) : that.stringValue == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = stringValue != null ? stringValue.hashCode() : 0;
        result = 31 * result + integerValue;
        result = 31 * result + (int) (longValue ^ (longValue >>> 32));
        result = 31 * result + (int) shortValue;
        result = 31 * result + (int) byteValue;
        result = 31 * result + (floatValue != +0.0f ? Float.floatToIntBits(floatValue) : 0);
        temp = Double.doubleToLongBits(doubleValue);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) charValue;
        result = 31 * result + (booleanValue ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TestSerialize{" +
                "stringValue='" + stringValue + '\'' +
                ", integerValue=" + integerValue +
                ", longValue=" + longValue +
                ", shortValue=" + shortValue +
                ", byteValue=" + byteValue +
                ", floatValue=" + floatValue +
                ", doubleValue=" + doubleValue +
                ", charValue=" + charValue +
                ", booleanValue=" + booleanValue +
                '}';
    }
}
