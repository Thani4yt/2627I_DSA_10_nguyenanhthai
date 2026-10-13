package Week4.Bai5;

import java.util.*;

import static java.util.stream.Collectors.joining;


class Result {

    /*
     * Complete the 'insertionSort2' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort2(int n, List<Integer> arr) {

        for (int i = 1; i < n; i++) {
            int temp = arr.get(i);
            int j = i - 1;

            while (j >= 0 && arr.get(j) > temp) {
                arr.set(j + 1, arr.get(j));
                j--;
            }
            arr.set(j + 1, temp);

            for (int k = 0; k < n; k++) {
                System.out.print(arr.get(k) + (k == n - 1 ? "" : " "));
            }
            System.out.println();
        }
    }

}