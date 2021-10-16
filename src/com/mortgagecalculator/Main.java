package com.mortgagecalculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final int MONTHS_IN_YEAR = 12;
        final int PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

        System.out.println("This is a mortgage calculator app");
        System.out.println("\nEnter the required values::");

        int principal;

        while (true) {
            System.out.print("Principal ($1K - $1M): ");
            principal = scanner.nextInt();

            if (principal >= 1000 && principal <= 1_000_000)
                break;
            System.out.println("Enter a number between 1,000 and 1,000,000.");
        }

        float rateOfInterest;

        while (true) {
            System.out.print("Annual rate of Interest: ");
            rateOfInterest = scanner.nextFloat();

            if (rateOfInterest >= 1 && rateOfInterest <= 30)
                break;
            System.out.println("Enter a value greater than 0 and less than 30.");
        }
        rateOfInterest /= PERCENT;
        float monthlyROI = rateOfInterest / MONTHS_IN_YEAR;

        int period;

        while (true) {
            System.out.print("Period (Years): ");
            period = scanner.nextInt();

            if (period >= 1 && period <= 30)
                break;
            System.out.println("Enter a value between 1 and 30.");
        }
        int numberOfPayments = period * MONTHS_IN_YEAR;

        double mortgage = principal
                * (monthlyROI * Math.pow(1 + monthlyROI, numberOfPayments)
                / (Math.pow(1 + monthlyROI, numberOfPayments) - 1));

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.print("Mortgage: " + mortgageFormatted);
    }
}
