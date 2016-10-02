package com.company;

import java.util.Dictionary;
import java.util.Scanner;

public class Main {

    /**
     * Takes 3 parameters; knownAngle1, knownAngle2, and correspondingSideToKnownAngle1, and with
     * Law of Sines will calculate angle C and segments b and c.
     * aasResult[0] = segment b, aasResult[1] = angle C, and
     * aasResult[2] = segment c,
     * @param knownAngle1
     * @param knownAngle2
     * @param correspondingSideToKnownAngle1
     * @return
     */
    public static double[] AAS(double knownAngle1, double knownAngle2, double correspondingSideToKnownAngle1){
        double[] aasResult = new double[3];
        aasResult[0] = ((Math.sin(Math.toRadians(knownAngle2)) * correspondingSideToKnownAngle1)) / (Math.sin(Math.toRadians(knownAngle1)));
        aasResult[1] = 180 - knownAngle1 - knownAngle2;
        aasResult[2] = ((Math.sin(Math.toRadians(aasResult[1])) * correspondingSideToKnownAngle1)) / (Math.sin(Math.toRadians(knownAngle1)));
        return aasResult;
    }
    public static double[] ASS(double knownAngle1, double correspondingSideToKnownAngle1, double correspondingSideToUnKnownAngle2){
        double[] assResult = new double[3];
        double A = (Math.sin(Math.toRadians(knownAngle1)));
        double B = Math.toDegrees(Math.asin((correspondingSideToUnKnownAngle2 * A) / (correspondingSideToKnownAngle1)));
        assResult[0] = Math.toDegrees(Math.asin((correspondingSideToUnKnownAngle2 * (Math.sin(Math.toRadians(knownAngle1)))) / (correspondingSideToKnownAngle1)));
        assResult[1] = 180 - assResult[0] - knownAngle1;
        assResult[2] = ((Math.sin(Math.toRadians(assResult[1])) * correspondingSideToKnownAngle1)) / (Math.sin(Math.toRadians(knownAngle1)));
        return assResult;
    }

//    public static void printAngle(int A, int B, int a){
//        System.out.println("A = " + A  + " B = " + B + " C = " + aasResult[1]);
//        System.out.println("a = " + a  + " b = " + aasResult[0] + " c = " + aasResult[2]);
//    }

    public static void main(String[] args) {
        Double A;
        Double a;
        Double B;
        Double b;
        Double C;
        Double c;
//// TODO: 10/1/16 Create method to take in data and sanitize it.
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter angle A:");
        A = sc.nextDouble();
        System.out.println("Please enter segment a:");
        a = sc.nextDouble();
        System.out.println("Please enter angle B:");
        B = sc.nextDouble();
        System.out.println("Please enter segment b:");
        b = sc.nextDouble();
        System.out.println("Please enter angle C:");
        C = sc.nextDouble();
        System.out.println("Please enter segment c:");
        c = sc.nextDouble();



        if (A > 0 && B > 0 && a > 0){
            double[] aasResult = AAS(A, B, a);
            System.out.println("A = " + A  + " B = " + B + " C = " + aasResult[1]);
            System.out.println("a = " + a  + " b = " + aasResult[0] + " c = " + aasResult[2]);
        } else if (A > 0 && B > 0 && b > 0){
            double[] aasResult = AAS(B, A, b);
            System.out.println("A = " + A  + " B = " + B + " C = " + aasResult[1]);
            System.out.println("a = " + aasResult[0]  + " b = " + b + " c = " + aasResult[2]);
        } else if (A > 0 && C > 0 && a > 0) {
            double[] aasResult = AAS(A, C, a);
            System.out.println("A = " + A + " B = " + aasResult[1] + " C = " + C);
            System.out.println("a = " + a + " b = " + aasResult[2] + " c = " + aasResult[0]);
        } else if (A > 0 && C > 0 && c > 0) {
            double[] aasResult = AAS(C, A, c);
            System.out.println("A = " + A + " B = " + aasResult[1] + " C = " + C);
            System.out.println("a = " + aasResult[0] + " b = " + aasResult[2] + " c = " + c);
        } else if (B > 0 && C > 0 && b > 0) {
            double[] aasResult = AAS(B, C, b);
            System.out.println("A = " + aasResult[1] + " B = " + B + " C = " + C);
            System.out.println("a = " + aasResult[2] + " b = " + b + " c = " + aasResult[0]);
        } else if (B > 0 && C > 0 && c > 0) {
            double[] aasResult = AAS(C, B, c);
            System.out.println("A = " + aasResult[1] + " B = " + B + " C = " + C);
            System.out.println("a = " + aasResult[2] + " b = " + aasResult[0] + " c = " + c);
        } else if (A > 0 && a > 0 && b > 0) {
            double[] assResult = ASS(A, a, b);
            System.out.println("A = " + A + " B = " + assResult[0] + " C = " + assResult[1]);
            System.out.println("a = " + a + " b = " + b + " c = " + assResult[2]);
            if ((180 - assResult[0] + A < 180)){
                double[] aasResult = AAS(A, 180 - assResult[0], a);
                System.out.printf(" -or- \n");
                System.out.println("A = " + A  + " B = " + (180 - assResult[0]) + " C = " + aasResult[1]);
                System.out.println("a = " + a  + " b = " + aasResult[0] + " c = " + aasResult[2]);
            }

            }


    }
}