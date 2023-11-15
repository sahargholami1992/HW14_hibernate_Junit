package org.example.q1;

public class Rational {
    private int numerator;
    private int denominator;

    public void check(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException();
        }
        int gcd = gcd(numerator,denominator);
        this.numerator=numerator/gcd;
        this.denominator=denominator/gcd;
        if (this.denominator<0){
            this.numerator=-this.numerator;
            this.denominator=-this.denominator;
        }
    }

    public Rational() {
        this.numerator = 0;
        this.denominator = 1;
    }
    private int gcd(int a,int b){
        if (b==0){
            return a;
        }
        return gcd(b,a%b);
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }
    public Rational add(Rational num){
        Rational result = new Rational();
        int commonDenominator=this.denominator*num.denominator;
        int newNumerator=this.numerator*num.denominator+num.numerator*this.denominator;
        result.check(newNumerator,commonDenominator);
        return result;
    }
    public Rational sub(Rational num){
        Rational result = new Rational();
        int commonDenominator=this.denominator*num.denominator;
        int newNumerator=this.numerator*num.denominator-num.numerator*this.denominator;
        result.check(newNumerator,commonDenominator);
        return result;
    }
    public Rational mul(Rational num){
        Rational result = new Rational();
        int newNumerator=this.numerator*num.numerator;
        int newDenominator=this.denominator*num.denominator;
        result.check(newNumerator,newDenominator);
        return result;
    }
    public Rational div(Rational num){
        Rational result = new Rational();
        if (num.numerator==0){
            throw new ArithmeticException();
        }
        int newNumerator=this.numerator*num.denominator;
        int newDenominator=this.denominator*num.numerator;
        result.check(newNumerator,newDenominator);
        return result;
    }
    public double toFloatingPoint(){
        return (double) this.numerator/this.denominator;
    }
    public String toString(){
        return this.numerator+"/"+this.denominator;
    }
    public String toMixedNumber(){
        if (this.numerator==0){
            return "0";
        }
        if (Math.abs(this.numerator)<=Math.abs(this.denominator)){
            return this.toString();
        }
        int integerPart = this.numerator/this.denominator;
        int reminder = this.numerator%this.denominator;
        return integerPart + "+" + Math.abs(reminder)+"/"+Math.abs(this.denominator);
    }
}
