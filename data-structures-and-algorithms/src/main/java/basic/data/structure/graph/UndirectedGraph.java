package basic.data.structure.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 无向图
 * @author wangxin
 * 2020/5/10 18:22
 * @since
 **/
public class UndirectedGraph {
    /** 顶点的个数*/
    private int v;
    /** 邻接表*/
    private LinkedList<Integer>[] adj;

    public UndirectedGraph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }

    /**
     * breadthFirstSearch
     *
     * @param s 搜索起点
     * @param t 搜索终点
     * @return void
     */
    public void bfs(int s, int t) {
        if (s == t) {
            return;
        }
        boolean[] visited = new boolean[v];
        visited[s] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }
        while (queue.size() != 0) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); i++) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    private void print(int[] prev, int source, int target) {
        if (prev[target] != -1 && target != source) {
            print(prev, source, prev[target]);
        }
        System.out.print(target + " ");
    }


    boolean found = false;

    /**
     * 深度优先遍历，只负责找到结果，结果不一定是最优的
     * @param source
     * @param target
     */
    public void dfs(int source, int target) {
        found = false;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }
        recurDfs(source, target, visited, prev);
        print(prev, source, target);
    }

    private void recurDfs(int curIndex, int target, boolean[] visited, int[] prev) {
        if (found) {
            return;
        }
        visited[curIndex] = true;
        if (curIndex == target) {
            found = true;
            return;
        }
        for (int i = 0; i < adj[curIndex].size(); i++) {
            int nextIndex = adj[curIndex].get(i);
            if (!visited[nextIndex]) {
                prev[nextIndex] = curIndex;
                recurDfs(nextIndex, target, visited, prev);
            }
        }
    }

    public static void main(String[] args) {
        UndirectedGraph graph = new UndirectedGraph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(3, 4);
        graph.addEdge(2, 5);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 6);
        graph.addEdge(6, 7);

        graph.bfs(0, 7);
        System.out.println();
        graph.dfs(0, 7);
    }

}
