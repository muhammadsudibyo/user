package com.ecommerce.user.util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class AccountNumberGenerator {
    private static final int LENGTH = 11; // the length of the account number
    private static final Random random = new Random();
    private static final Set<String> usedNumbers = new HashSet<>(); // set of used account numbers

    public static String generate() {
        String accountNumber;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < LENGTH; i++) {
            int digit = random.nextInt(10); // generate a random digit between 0 and 9
            sb.append(digit);
        }
        accountNumber = sb.toString();
        return accountNumber;
    }
}
