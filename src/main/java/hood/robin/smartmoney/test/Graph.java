package hood.robin.smartmoney.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    private final Map<Integer, List<Pair<Integer, Double>>> adjList = new HashMap<>();

    public void addEdge(int u, int v, double weight) {
        adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(new Pair<>(v, weight));
    }

    public void addEdge(int u, int v) {
        adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(new Pair<>(v, 1.0));
    }

    public Map<Integer, List<Pair<Integer, Double>>> getAdjList() {
        return adjList;
    }

    public List<Pair<Integer, Double>> getNeighbors(int u) {
        return adjList.getOrDefault(u, new ArrayList<>());
    }
}
