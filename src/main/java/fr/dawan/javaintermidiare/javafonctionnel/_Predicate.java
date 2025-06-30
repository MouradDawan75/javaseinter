package fr.dawan.javaintermidiare.javafonctionnel;

import java.util.function.Predicate;

public class _Predicate {

    public static void main(String[] args) {

        System.out.println(isValidePhoneNumber("0606060606"));
        System.out.println(isValidePhoneNumberPredicate.test("0705050505"));

    }

    static boolean isValidePhoneNumber(String phoneNumber){
        return phoneNumber.startsWith("06") && phoneNumber.length() == 10;
    }

    static Predicate<String> isValidePhoneNumberPredicate = phoneNumber -> phoneNumber.startsWith("06") && phoneNumber.length() == 10;
}
