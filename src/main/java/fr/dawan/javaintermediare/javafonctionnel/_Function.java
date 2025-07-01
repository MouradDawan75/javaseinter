package fr.dawan.javaintermediare.javafonctionnel;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

    public static void main(String[] args) {
        System.out.println(incrementByOne(10));
        System.out.println(incrementByOneFunction.apply(10));

        System.out.println(incrementAndMultiplyByTen.apply(5,10));

    }

    static int incrementByOne(int i){
        return i + 1;
    }

    static Function<Integer,Integer> incrementByOneFunction = x -> x + 1;
    static Function<Integer,Integer> multiplyByTen = x -> x * 10;
    static BiFunction<Integer,Integer,Integer> incrementAndMultiplyByTen= (numberToIncrement, numberToMultiply)
            -> (numberToIncrement + 1) * numberToIncrement;
}
