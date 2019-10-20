package com.company;

import java.util.Scanner;

public class p2 {

    public static class SavingsAccount {
        double savingsBalance;

        public double calculateMonthlyInterest(double savingsB, double interestR) {
            double monthlyInterest;

            monthlyInterest = ((savingsB * interestR)/12.0);
            return (savingsB + monthlyInterest);
        }
        public static double modifyInterestRate(double interestRate) {
            Scanner scnr = new Scanner(System.in);

            interestRate = scnr.nextDouble();
            return interestRate;
        }
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        double annualInterestRate;
        int termAcc, i, j;
        SavingsAccount saver1 = new SavingsAccount(), saver2 = new SavingsAccount();

        System.out.println("Please enter account 1 balance: ");
        saver1.savingsBalance = scnr.nextDouble();

        System.out.println("Please enter account 2 balance: ");
        saver2.savingsBalance = scnr.nextDouble();

        for(j = 0; j < 2; j++) {
            System.out.println("What is the current interest rate?");
            annualInterestRate = ((scnr.nextDouble())/100);

            System.out.println("Please enter term of account in months: ");
            termAcc = scnr.nextInt();

            for (i = 0; i < termAcc; i++) {
                saver1.savingsBalance = saver1.calculateMonthlyInterest(saver1.savingsBalance, annualInterestRate);
                saver2.savingsBalance = saver2.calculateMonthlyInterest(saver2.savingsBalance, annualInterestRate);
            }
            System.out.println("Balance of savings account 1 after term: " + saver1.savingsBalance);
            System.out.println("Balance of savings account 2 after term: " + saver2.savingsBalance);

        }
    }
}

