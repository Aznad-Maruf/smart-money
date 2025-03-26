package hood.robin.smartmoney.test;

import java.util.LinkedList;
import java.util.Queue;

public class P_3243 {

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        Graph graph = new Graph();
        int[] ans = new int[queries.length];

        for (int i = 0; i < n; i++) {
            graph.addEdge(i, i + 1);
        }

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            graph.addEdge(query[0], query[1]);

            ans[i] = findShortestDistance(graph, n);
        }

        return ans;
    }

    private int findShortestDistance(Graph graph, int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int[] distances = new int[n];

        queue.offer(0);
        visited[0] = true;
        distances[0] = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (Pair<Integer, Double> neighbor : graph.getNeighbors(u)) {
                int v = neighbor.getKey();
                if (!visited[v]) {
                    visited[v] = true;
                    distances[v] = distances[u] + 1;
                    queue.offer(v);

                    if (v == n - 1) {
                        return distances[v];
                    }
                }
            }
        }

        return -1;
    }
}
