package problems;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Karatsuba multiplication of two big integers.
 */
public class Karatsuba {

    public BigInteger multiply(String x, String y) {

        if (x.length() < 2 || y.length() < 2) {
            return new BigInteger(x).multiply(new BigInteger(y));
        }

        int xSize = x.length();
        int ySize = y.length();

        int half = Math.max(xSize, ySize) / 2;
        BigInteger a = new BigInteger(x.substring(0, xSize - half));
        BigInteger b = new BigInteger(x.substring(xSize - half));
        BigInteger c = new BigInteger(y.substring(0, ySize - half));
        BigInteger d = new BigInteger(y.substring(ySize - half));

        BigInteger z = multiply(a.toString(), c.toString());
        BigInteger z1 = multiply(b.toString(), d.toString());
        BigInteger z2 = multiply(a.add(b).toString(), c.add(d).toString());
        BigInteger leftPart = z.multiply(new BigDecimal(Math.pow(10,
                2 * half)).toBigInteger());
        BigInteger righPart = z2.subtract(z1).subtract(z).multiply(new
                BigDecimal(Math.pow(10, half)).toBigInteger());
        return leftPart.add(righPart).add(z1);
    }


    public static void main(String[] args) {
        Karatsuba karatsuba = new Karatsuba();
        BigInteger x = karatsuba.multiply
                ("3141592653589793238462643383279502884197169399375105820974944592",
                        "2718281828459045235360287471352662497757247093699959574966967627");
        System.out.println(x);
    }
}
