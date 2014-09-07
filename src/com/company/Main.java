package com.company;

import java.util.*;

/**
 * Class to test TwoTools class.
 */
public class Main {

    static Random rnd = new Random(15623);

    /**
     * Write your tests here.
     */
    public static void main(String[] args) {
        Integer[] rndArray = new Integer[10000];
        for (int i = 0; i < rndArray.length; i++) {
            rndArray[i] = rnd.nextInt(1000) - 500;
        }

        List<Integer> list1 = new LinkedList<Integer>();
        List<Integer> list2 = new LinkedList<Integer>();

        Integer[] arr1 = rndArray.clone();
        Integer[] arr2 = rndArray.clone();

        for (Integer aRndArray : rndArray) {
            list1.add(aRndArray);
            list2.add(aRndArray);
        }

        long mySortTime = System.currentTimeMillis();
        TwoTools.myBubbleSort(list1);
        mySortTime = System.currentTimeMillis() - mySortTime;

        long collectionsSortTime = System.currentTimeMillis();
        Collections.sort(list2);
        collectionsSortTime = System.currentTimeMillis() - collectionsSortTime;

        System.out.println("My sort: " + mySortTime);
        System.out.println("Collections.sort time: " + collectionsSortTime);

        long mySortTime2 = System.currentTimeMillis();
        TwoTools.myBubbleSort(arr1);
        mySortTime2 = System.currentTimeMillis() - mySortTime2;

        long collectionsSortTime2 = System.currentTimeMillis();
        Arrays.sort(arr2);
        collectionsSortTime2 = System.currentTimeMillis() - collectionsSortTime2;

        System.out.println("My sort: " + mySortTime2);
        System.out.println("Arrays.sort time: " + collectionsSortTime2);
    }
}
