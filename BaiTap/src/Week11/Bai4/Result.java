package Week11.Bai4;

import java.util.*;

class Result {

    private static final int TABLE_SIZE = 200003;

    private static void insert(int[] hashTable, int key) {
        int index = key % TABLE_SIZE;
        while (hashTable[index] != 0) {
            index = (index + 1) % TABLE_SIZE;
        }
        hashTable[index] = key;
    }

    private static boolean contains(int[] hashTable, int target) {
        int index = target % TABLE_SIZE;
        while (hashTable[index] != 0) {
            if (hashTable[index] == target) {
                return true;
            }
            index = (index + 1) % TABLE_SIZE;
        }
        return false;
    }

    public static int pairs(int k, List<Integer> arr) {
        int[] hashTable = new int[TABLE_SIZE];

        for (int x : arr) {
            insert(hashTable, x);
        }

        int pairCount = 0;
        for (int x : arr) {
            int target = x - k;
            if (target > 0 && contains(hashTable, target)) {
                pairCount++;
            }
        }

        return pairCount;

    }
}