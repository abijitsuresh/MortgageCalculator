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

        System.out.print("Principal: ");
        int principal = scanner.nextInt();

        System.out.print("Annual rate of Interest: ");
        float rateOfInterest = scanner.nextFloat();
        rateOfInterest /= PERCENT;
        float monthlyROI = rateOfInterest / MONTHS_IN_YEAR;

        System.out.print("Period (Years): ");
        int period = scanner.nextInt();
        int numberOfPayments = period * MONTHS_IN_YEAR;

        double mortgage = principal
                * (monthlyROI * Math.pow(1 + monthlyROI, numberOfPayments)
                / (Math.pow(1 + monthlyROI, numberOfPayments) - 1));

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.print("Mortgage: " + mortgageFormatted);
    }
}
