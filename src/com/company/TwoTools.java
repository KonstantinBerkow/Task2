package com.company;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Collections;

/**
 * Class with two tools: reverser of sentences and shaker sort for Collections and Arrays
 */
@SuppressWarnings("unchecked")
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
        T[] tmpArray = (T[]) Array.newInstance(c.getClass().getComponentType(), c.size());//new Object[c.size()];
        c.toArray(tmpArray);

        for (int i = 0; i < tmpArray.length / 2; i++) {
            boolean hasSwapped = false;
            for (int j = i; j < tmpArray.length - i - 1; j++) {
                if ((tmpArray[j]).compareTo(tmpArray[j + 1]) > 0) {
                    T tmp = ((T) tmpArray[j]);
                    tmpArray[j] = tmpArray[j + 1];
                    tmpArray[j + 1] = tmp;
                    hasSwapped = true;
                }
            }
            for (int j = tmpArray.length - 2 - i; j > i; j--) {
                if ((tmpArray[j]).compareTo(tmpArray[j - 1]) < 0) {
                    T tmp = ((T) tmpArray[j]);
                    tmpArray[j] = tmpArray[j - 1];
                    tmpArray[j - 1] = tmp;
                    hasSwapped = true;
                }
            }
            if (!hasSwapped) break;
        }

        c.clear();
        Collections.addAll(c, tmpArray);
    }

    /**
     * this modified bubble sort sorts given Class Array
     *
     * @param array array of some class to sort
     * @param <T>   comparable type of collection
     */
    public static <T extends Comparable<T>> void myBubbleSort(T[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            boolean hasSwapped = false;
            for (int j = i; j < array.length - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T tmp = ((T) array[j]);
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    hasSwapped = true;
                }
            }
            for (int j = array.length - 2 - i; j > i; j--) {
                if (array[j].compareTo(array[j - 1]) < 0) {
                    T tmp = ((T) array[j]);
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                    hasSwapped = true;
                }
            }
            if (!hasSwapped) break;
        }
    }

}