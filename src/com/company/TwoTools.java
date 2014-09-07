package com.company;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Class with two tools: reverser of sentences and shaker sort for Collections and Arrays
 */
public class TwoTools {
    /**
     * This method reverses all words in sentence excluding non letters and digits.
     *
     * @param str sentence with words to reverse
     * @return new String which represents reverser sentence.
     */
    public static String reverseSentence(String str) {
        String[] words = str.split("[^a-zA-Z0-9]");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i > 0; i--) {
            if (!words[i].isEmpty())
                sb.append(words[i]).append(" ");
        }
        sb.append(words[0]);
        return sb.toString();
    }

    /**
     * this modified bubble sort sorts given Collection.
     *
     * @param c   collection to sort
     * @param <T> comparable type of collection
     */
    public static <T extends Comparable<T>> void myBubbleSort(Collection<T> c) {
        if (c.isEmpty()) return;
        ArrayList<T> tmpArray = new ArrayList<T>(c);
        //T[] tmpArray = (T[]) new Object[c.size()];//Array.newInstance(c.getClass().getComponentType(), c.size());
        //c.toArray(tmpArray);

        int arrSize = tmpArray.size();
        for (int i = 0; i < arrSize / 2; i++) {
            boolean hasSwapped = false;
            for (int j = i; j < arrSize - i - 1; j++) {
                if (tmpArray.get(j).compareTo(tmpArray.get(j + 1)) > 0) {
                    T tmp = tmpArray.get(j);
                    tmpArray.set(j, tmpArray.get(j + 1));
                    tmpArray.set(j + 1, tmp);
                    hasSwapped = true;
                }
            }
            for (int j = arrSize - 2 - i; j > i; j--) {
                if (tmpArray.get(j).compareTo(tmpArray.get(j - 1)) < 0) {
                    T tmp = tmpArray.get(j);
                    tmpArray.set(j, tmpArray.get(j - 1));
                    tmpArray.set(j - 1, tmp);
                    hasSwapped = true;
                }
            }
            if (!hasSwapped) break;
        }

        c.clear();
        for (T aTmpArray : tmpArray) {
            c.add(aTmpArray);
        }
    }

    /**
     * this modified bubble sort sorts given Class Array
     *
     * @param array array of some class to sort
     * @param <T>   comparable type of collection
     */
    public static <T extends Comparable<T>> void myBubbleSort(T[] array) {
        if (array == null || array.length == 0) return;
        for (int i = 0; i < array.length / 2; i++) {
            boolean hasSwapped = false;
            for (int j = i; j < array.length - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T tmp = (array[j]);
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    hasSwapped = true;
                }
            }
            for (int j = array.length - 2 - i; j > i; j--) {
                if (array[j].compareTo(array[j - 1]) < 0) {
                    T tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                    hasSwapped = true;
                }
            }
            if (!hasSwapped) break;
        }
    }

}