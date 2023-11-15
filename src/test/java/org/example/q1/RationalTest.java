package org.example.q1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RationalTest {
    Rational r1;
    Rational r2;
    Rational r3;
    @BeforeEach
    public void init(){
        r1 = new Rational();
        r2 = new Rational();
        r3 = new Rational();
    }

    @Test
    public void testCheck() {
        r1.check(3, 4);
        assertEquals(3, r1.getNumerator());
        assertEquals(4, r1.getDenominator());

        r2.check(-5, -6);
        assertEquals(5, r2.getNumerator());
        assertEquals(6, r2.getDenominator());


        assertThrows(ArithmeticException.class, () -> {
            r3.check(7, 0);
        });
    }

    @Test
    public void testAdd() {
        r1.check(1, 2);
        r2.check(2, 3);
        Rational r3 = r1.add(r2);
        assertEquals(7, r3.getNumerator());
        assertEquals(6, r3.getDenominator());
    }

    @Test
    public void testSub() {
        r1.check(3, 4);
        r2.check(1, 6);
        Rational r3 = r1.sub(r2);
        assertEquals(7, r3.getNumerator());
        assertEquals(12, r3.getDenominator());
    }

    @Test
    public void testMul() {
        r1.check(2, 5);
        r2.check(3, 7);
        Rational r3 = r1.mul(r2);
        assertEquals(6, r3.getNumerator());
        assertEquals(35, r3.getDenominator());
    }

    @Test
    public void testDiv() {
        r1.check(4, 9);
        r2.check(6, 5);
        Rational r3 = r1.div(r2);
        assertEquals(10, r3.getNumerator());
        assertEquals(27, r3.getDenominator());
    }

    @Test
    public void testToFloatingPoint() {

        r1.check(5, 8);
        double d1 = r1.toFloatingPoint();
        assertEquals(0.625, d1, 0.0001);
    }

}