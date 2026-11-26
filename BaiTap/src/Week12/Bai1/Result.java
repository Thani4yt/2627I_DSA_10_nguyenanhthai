package Week12.Bai1;

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

    /*
     * Complete the 'shortestReach' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY edges
     *  3. INTEGER s
     */

    public static List<Integer> shortestReach(int n, List<List<Integer>> edges, int s) {
        final int INF = 1_000_000_000;

        // ma tran^ nxn voi' gia' tri. vo^ cuc.
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }

        // dua do^` thi. vao` ma tran.
        for (List<Integer> edge : edges) {
            int u = edge.get(0) - 1;
            int v = edge.get(1) - 1;
            int w = edge.get(2);

            if (w < graph[u][v]) {
                graph[u][v] = w;
                graph[v][u] = w;
            }
        }

        // mang? khoang? cach' va` danh' dau' visited
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[s - 1] = 0;

        boolean[] visited = new boolean[n];

        // Dijkstra
        for (int step = 0; step < n; step++) {
            int u = -1;
            int minDist = INF;

            // dinh? chua tham co' khoang? cach' nho? nhat'
            for (int i = 0; i < n; i++) {
                if (!visited[i] && dist[i] < minDist) {
                    minDist = dist[i];
                    u = i;
                }
            }

            // khong^ co' dinh? nao` di toi' duoc thi` dung`
            if (u == -1) {
                break;
            }

            visited[u] = true;

            // cap^ nhat^ khoang? cach'
            for (int v = 0; v < n; v++) {
                if (!visited[v] && graph[u][v] != INF) {
                    if (dist[u] + graph[u][v] < dist[v]) {
                        dist[v] = dist[u] + graph[u][v];
                    }
                }
            }
        }

        // List ket' qua?
        List<Integer> result = new ArrayList<>(n - 1);
        for (int i = 0; i < n; i++) {
            if (i == s - 1) {
                continue;
            }
            result.add(dist[i] == INF ? -1 : dist[i]);
        }

        return result;
    }

}

