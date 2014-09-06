package com.company;

import java.util.ArrayList;
import java.util.Random;

/**
 * Class to test TwoTools class.
 */
public class Main {

    static Random rnd = new Random();

    /**
     * Write your tests here.
     *
     * @param args args[0] will be used as upper and lower bounds for first test and args[1] - for second
     */
    public static void main(String[] args) {
        /*int radius = Integer.parseInt(args[0]);
        int radius1 = Integer.parseInt(args[1]);

        Integer[] classArrayTest = new Integer[radius];
        for (int i = 0; i < classArrayTest.length; i++) {
            classArrayTest[i] = rnd.nextInt(radius + 1) - radius / 2;
        }

        System.out.println("Before sort:");
        for (Integer f : classArrayTest) {
            System.out.print(f + " ");
        }
        System.out.println();

        TwoTools.myBubbleSort(classArrayTest);

        System.out.println("After sort:");
        for (Integer f : classArrayTest) {
            System.out.print(f + " ");
        }
        System.out.println();

        ArrayList<Integer> arrListTest = new ArrayList<Integer>();
        for (int i = 0; i < radius1; i++) {
            arrListTest.add(i, rnd.nextInt(radius1 + 1) - radius1 / 2);
        }

        System.out.println("Before sort:");
        for (Integer f : arrListTest) {
            System.out.print(f + " ");
        }
        System.out.println();

        TwoTools.myBubbleSort(arrListTest);

        System.out.println("After sort:");
        for (Integer f : arrListTest) {
            System.out.print(f + " ");
        }
        System.out.println();*/
        MyCollection<Integer> myCollection = new MyCollection<Integer>();
        for (int i = 0; i < 10; i++) {
            myCollection.add(i);
        }

        for (Integer aMyCollection : myCollection) {
            System.out.println(aMyCollection);
        }
    }
}
