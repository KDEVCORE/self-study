import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class App {
    public static boolean visited[];
    public static ArrayList<Integer>[] a;
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken())-1;
        a = new ArrayList[n];
        for(int i=0; i<n; i++) {
            a[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            a[s].add(e);
            a[e].add(s);
        }
        // 번호가 작은 것을 먼저 방문하기 위해 정렬하기
        for(int i=0; i<n; i++) {
            Collections.sort(a[i]);
        }
        visited = new boolean[n];
        dfs(start);
        sb.append("\n");
        visited = new boolean[n];
        bfs(start);
        System.out.println(sb);
    }

    // DFS 구현
    public static void dfs(int node) {
        sb.append(node + 1).append(" ");
        visited[node] = true;
        for(int i: a[node]) {
            if(!visited[i]) dfs(i);
        }
    }

    // BFS 구현
    public static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(node);
        visited[node] = true;

        while(!queue.isEmpty()) {
            int nowNode = queue.poll();
            sb.append(nowNode + 1).append(" ");
            for(int i: a[nowNode]) {
                if(!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
