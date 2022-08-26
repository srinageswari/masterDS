package tree.week1;

import java.util.*;

public class ClosestNodeToPath {
    Map<Integer,List<Integer>> graph = new HashMap<>();

    //query[i] = [starti, endi, nodei]
    //edges[i] = [node1i, node2i] denotes that there is a bidirectional edge connecting node1i and node2i in the tree

    public int[] closestNode(int n, int[][] edges, int[][] query) {
        constructAdjacencyList(edges);
        int[] output = new int[query.length];
        for(int i=0; i<query.length; i++)
        {
            int start = query[i][0];
            int end = query[i][1];
            int target = query[i][2];
            Set<Integer> path = new LinkedHashSet<>();
            findPath(start,end,path);
            output[i] = findClosestNode(n,target, path);
            System.out.println(i+" path "+path+" closest node "+output[i]);
        }
        return output;
    }

    private boolean findPath(int start, int end, Set<Integer> path) {
        path.add(start);
        if(start == end)
        {
            return true;
        }
        for(int neigh : graph.get(start))
        {
            if(!path.contains(neigh)) {
                if (findPath(neigh, end, path)) {
                    return true;
                }
            }
        }
        path.remove(start);
        return false;
    }

    private int findClosestNode(int n,int target, Set<Integer> path) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(target);
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            if(path.contains(curr))
            {
                return curr;
            }
            else {
                for (int neigh : graph.get(curr)) {
                    if (!visited[neigh]) {
                        visited[neigh] = true;
                        queue.add(neigh);
                    }
                }
            }
        }
        return 0;
    }

    private void constructAdjacencyList(int[][] edges) {
        for(int[] edge : edges)
        {
            if(!graph.containsKey(edge[0]))
            {
                graph.put(edge[0],new ArrayList<>());
            }
            if(!graph.containsKey(edge[1]))
            {
                graph.put(edge[1],new ArrayList<>());
            }
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        System.out.println(graph);
    }

    public static void main(String[] args)
    {
        int n = 7;
        int[][] edges = {{0,1},{0,2},{0,3},{1,4},{2,5},{2,6}};
        int[][] query = {{5,3,4},{5,4,6}};
        ClosestNodeToPath cn = new ClosestNodeToPath();
        cn.closestNode(n,edges,query);
    }
}
