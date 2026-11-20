package Week11.Bai6;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

class Result {

    static class Node implements Comparable<Node> {
        int val;
        int idx;

        Node(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node other) {
            if (this.val != other.val) {
                return Integer.compare(this.val, other.val);
            }
            return Integer.compare(this.idx, other.idx);
        }
    }

    public static List<Double> runningMedian(List<Integer> a) {
        List<Double> result = new ArrayList<>();
        TreeSet<Node> tree = new TreeSet<>();
        Node mid = null;

        for (int i = 0; i < a.size(); i++) {
            Node current = new Node(a.get(i), i);
            tree.add(current);

            if (i == 0) {
                mid = current;
            } else {
                if (tree.size() % 2 == 0) {
                    if (current.compareTo(mid) < 0) {
                        mid = tree.lower(mid);
                    }
                } else {
                    if (current.compareTo(mid) > 0) {
                        mid = tree.higher(mid);
                    }
                }
            }

            if (tree.size() % 2 == 1) {
                result.add((double) mid.val);
            } else {
                Node rightMid = tree.higher(mid);
                result.add((mid.val + rightMid.val) / 2.0);
            }
        }

        return result;
    }
}