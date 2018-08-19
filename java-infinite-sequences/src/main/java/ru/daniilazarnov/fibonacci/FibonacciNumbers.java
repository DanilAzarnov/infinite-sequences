package ru.daniilazarnov.fibonacci;

import java.math.BigInteger;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public final class FibonacciNumbers {

    private FibonacciNumbers() {
    }

    public static int recursiveFib(int n) {
        if(n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return recursiveFib(n - 2) + recursiveFib(n - 1);
        }
    }

    public static BigInteger recursiveFibBigNumbers(int n) {
        if(n == 0) {
            return BigInteger.ZERO;
        } else if (n == 1) {
            return BigInteger.ONE;
        } else {
            return recursiveFibBigNumbers(n - 2).add(recursiveFibBigNumbers(n - 1));
        }
    }

    public static int cycleFib(int n) {
        int first = 0;
        int second = 1;

        for (int i = 0; i < n; i++) {
            int next = first + second;
            first = second;
            second = next;
        }

        return first;
    }

    public static BigInteger cycleFibBigNumbers(int n) {
        BigInteger first = BigInteger.ZERO;
        BigInteger second = BigInteger.ONE;

        for (int i = 0; i < n; i++) {
            BigInteger next = first.add(second);
            first = second;
            second = next;
        }

        return first;
    }

    public static int streamFib(int n) {

        Integer[] initialValue = new Integer[] {0, 1};

        UnaryOperator<Integer[]> fibOperator = fib -> new Integer[] {
                fib[1], fib[0] + fib[1]};

        return Stream.iterate(initialValue, fibOperator)
                .map(fib -> fib[0])
                .skip(n)
                .findFirst()
                .orElse(0);
    }

    public static BigInteger streamFibBigNumbers(int n) {

        BigInteger[] initialValue = new BigInteger[] {BigInteger.ZERO, BigInteger.ONE};

        UnaryOperator<BigInteger[]> fibOperator = fib -> new BigInteger[] {
                fib[1], fib[0].add(fib[1])};

        return Stream.iterate(initialValue, fibOperator)
                .map(fib -> fib[0])
                .skip(n)
                .findFirst()
                .orElse(BigInteger.ZERO);
    }

    public static int matrixFib(int n) {
        return n;
    }

    public static BigInteger matrixFibBigNumbers(int n) {
        return BigInteger.valueOf(n);
    }

    public static int binetFib(int n) {
        return n;
    }

    public static BigInteger binetFibBigNumbers(int n) {
        return BigInteger.valueOf(n);
    }

}
