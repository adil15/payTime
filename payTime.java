/*
 Adil Hassan
991180509
Assignment 3
November 8 , 2016
 */
package paytime;

import java.util.Scanner;
import java.util.Arrays;
import java.text.DecimalFormat;

/**
 *
 * @author adilhassan
 */
public class PayTime {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner k = new Scanner(System.in);
        int empNum[] = {101, 103, 106, 109, 110, 113, 116, 118, 120};
        System.out.println("Enter Y to start program or any other key to exit");
        String s1 = k.next();

        int process = 0;

        while (s1.equalsIgnoreCase("y")) {
            System.out.println("Please enter Employee number");
            process++;
            int eNum = k.nextInt();
            int locate = Arrays.binarySearch(empNum, eNum);
            while (locate < 0) {
                System.out.println("Invalid number, please enter valid employee number");
                eNum = k.nextInt();
            }
            System.out.println("Enter first name");
            String s2 = k.next();
            System.out.println("Enter last name");
            String s3 = k.next();

            System.out.println("Enter hours worked");
            double hrs = k.nextDouble();
            while (hrs < 0) {
                System.out.println("Hours cannot be negative, please enter hours worked");
                hrs = k.nextDouble();
            }
            System.out.println("Please enter wage");
            double wage = k.nextDouble();

            while (wage < 0) {
                System.out.println("Wage cannot be negative, please enter wage");
                wage = k.nextDouble();
            }

            double weeklyPay = hrs * wage;
            double incomeTax = 0;
            if (weeklyPay > 0) {
                incomeTax = 0.10 * weeklyPay;
            } else if (weeklyPay > 300) {
                incomeTax = 0.12 * weeklyPay;
            } else if (weeklyPay > 400) {
                incomeTax = 0.15 * weeklyPay;
            } else {
                incomeTax = 0.15 * weeklyPay;
            }
            double netPay = weeklyPay - incomeTax;
            DecimalFormat d = new DecimalFormat("$##0.00");
            String s8 = d.format(weeklyPay);
            String s9 = d.format(incomeTax);
            String s10 = d.format(netPay);
            System.out.println("Worker " + eNum + " Paycheck Information");
            System.out.println("Name is: " + s2 + " " + s3);
            System.out.println("Weekly pay is: " + s8);
            System.out.println("Income tax is: " + s9);
            System.out.println("NetPay is: " + s10);

            if (hrs > 40) {
                double otPay = (hrs - 40) * (wage * 1.5);
                double otTax = otPay * 0.25;
                double otNetPay = otPay - otTax;
                double TnetPay = netPay + otNetPay;
                String s4 = d.format(otPay);
                String s5 = d.format(otTax);
                String s6 = d.format(otNetPay);
                String s7 = d.format(TnetPay);

                System.out.println("\nWorker " + eNum + " Overtime pay");
                System.out.println("Overtime pay is: " + s4);
                System.out.println("Overtimetax is: " + s5);
                System.out.println("Overtime net pay is: " + s6);
                System.out.println("Total net pay is: " + s7);

            }

            System.out.println("number of employees processed " + process);
            System.out.println("Enter Y to process another employee or any other key to exit");
            s1 = k.next();
        }
    }

}
