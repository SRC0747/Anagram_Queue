package com.anagramqueue;
import java.util.Arrays;

public class AnagramQueue {
    public static void main(String args[]) {



        String[][] data = {{"army", "mary"}, {"stop", "tops"}, {"soap", "abcd"}};

        System.out.println("======== Testing areAnagrams() method =======");

        for (String[] value : data) {

            String s1 = value[0];

            String s2 = value[1];

            System.out.printf("Are %s and %s are Anagrams? %b%n", s1, s2,
                    areAnagrams(s1, s2));

        }



        System.out.println("======== Testing isAnagaram() method =======");

        for (String[] value : data) {

            String s1 = value[0];

            String s2 = value[1];

            System.out.printf("Does %s and %s are Anagrams? %b%n", s1, s2,
                    isAnagram(s1, s2));

        }



    }



    /*

     * One of the easiest way to check if two Strings are an anagram of each other
     * is to take their character array, sort them and check if they are equal.
     * If sorted character arrays are equal then both String are an anagram of
     * each other.

     */

    public static boolean areAnagrams(String first, String second) {

        char[] fa = first.toCharArray();
        char[] sa = second.toCharArray();

        // sort arrays
        Arrays.sort(fa);
        Arrays.sort(sa);


        // check if arrays are equal
        if (Arrays.equals(fa, sa)) {
            return true;
        }


        return false;

    }



    /*

     * Earlier method was using a couple of library methods, which is not permitted during
     * interviews. This method checks if two Strings are anagram without using any utility
     * method. This solution assumes that both source and target string are ASCII strings.

     */

    public static boolean isAnagram(String source, String target) {

        if ((source == null || target == null) || source.length() != target.length()) {

            return false;

        }



        int[] table = new int[256];



        int numOfUniqueCharInSource = 0;

        int numOfCharProcessedInTarget = 0;



        char[] characters = source.toCharArray();



        // store count of each unique character in source String

        for (char ch : characters) {

            if (table[ch] == 0) {

                ++numOfUniqueCharInSource;

            }

            ++table[ch];

        }



        for (int i = 0; i < target.length(); ++i) {

            int c = target.charAt(i);

            if (table[c] == 0) {

                return false;

            }

            --table[c];

            if (table[c] == 0) {

                ++numOfCharProcessedInTarget;

                if (numOfCharProcessedInTarget == numOfUniqueCharInSource) {

                    // it’s a match if t has been processed completely

                    return i == target.length() - 1;

                }

            }

        }

        return false;

    }
}
