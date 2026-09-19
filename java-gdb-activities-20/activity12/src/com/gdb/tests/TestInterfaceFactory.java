package com.gdb.tests;

import com.gdb.domain.*;
import com.gdb.exceptions.*;

public class TestInterfaceFactory {
    public static void main(String[] args) {
        System.out.println("=== Activity 12: Factory-Driven System Suite ===");

        // NOTE: If you completed Activity 11 successfully, paste your working IAccount.java and AccountFactory.java into src/com/gdb/domain (replacing the provided versions).

        // Test 1: Savings Account Creation & Deposit
        try {
            IAccount savings = AccountFactory.createAccount("SAVINGS", "SAV1001", "Rajesh Sharma", 28, 5000.0, "ACTIVE", "1234");
            savings.deposit(2000.0);
            if (savings.getBalance() == 7000.0) {
                System.out.println("[Test 1] Savings Account Creation & Deposit: [PASS]");
            } else {
                System.out.println("[Test 1] Savings Account Creation & Deposit: [FAIL]");
            }
        } catch (AccountException e) {
            System.out.println("[Test 1] [FAIL]");
        }
        // Test 2: Current Account Overdraft Withdrawal
        try {
            IAccount current = AccountFactory.createAccount("CURRENT", "CUR1001", "Priya Patel", 34, 5000.0, "ACTIVE", "5678");
            current.withdraw(8000.0, "5678");
            if (current.getBalance() == -3000.0) {
                System.out.println("[Test 2] Current Account Overdraft Withdrawal: [PASS]");
            } else {
                System.out.println("[Test 2] Current Account Overdraft Withdrawal: [FAIL]");
            }
        } catch (AccountException e) {
            System.out.println("[Test 2] [FAIL]");
        }
        // Test 3: Fixed Deposit Premature Withdrawal Block
        try {
            IAccount fd = AccountFactory.createAccount("FIXED_DEPOSIT", "FD1001", "Amit Kumar", 45, 50000.0, "ACTIVE", "1111");
            fd.withdraw(5000.0, "1111");
            System.out.println("[Test 3] [FAIL]");
        } catch (AccountException e) {
            System.out.println("[Test 3] Fixed Deposit Premature Withdrawal Block: [PASS]");
        }
        // Test 4: Invalid Type Rejection
        try {
            AccountFactory.createAccount("INVALID_TYPE", "INV001", "Test", 30, 1000.0, "ACTIVE", "0000");
            System.out.println("[Test 4] [FAIL]");
        } catch (IllegalArgumentException e) {
            System.out.println("[Test 4] Invalid Type Rejection: [PASS]");
        }

        System.out.println("=== Complete Activity 12 test suite and run ===");
    }
}
