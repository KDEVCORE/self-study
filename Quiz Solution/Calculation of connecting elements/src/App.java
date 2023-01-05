import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class App {
    public static ArrayList<Integer>[] a; // 인접 리스트
    public static boolean visited[]; // 방문 배열
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // 1 ≤ u, v ≤ n (u ≠ v)
        int n = Integer.parseInt(st.nextToken()); // 1 ≤ n ≤ 1000
        int m = Integer.parseInt(st.nextToken()); // 0 ≤ m ≤ n*(n-1)/2
        a = new ArrayList[n];
        visited = new boolean[n];
        for(int i=0; i<n; i++) {
            a[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            // 방향이 없는(=양방향) 에지이므로 양쪽에 에지를 추가
            a[s].add(e);
            a[e].add(s);
        }
        int count = 0;
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                count++;
                dfs(i);
            }
        }

        System.out.println(count);
    }

    public static void dfs(int v) {
        if(visited[v]) return;
        visited[v] = true;
        for(int i: a[v]) {
            if(!visited[i]) dfs(i);
        }
    }
}
