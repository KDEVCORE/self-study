import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class App {
    static int visited[];
    static ArrayList<Integer>[] a;
    static int n, m, k, x;
    static List<Integer> answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 도시 개수(노드), 2 <= n <= 300000
        int m = Integer.parseInt(st.nextToken()); // 도로 개수(에지), 1 <= m <= 1000000
        int k = Integer.parseInt(st.nextToken()); // 거리 정보, 1 <= k <= 300000
        int x = Integer.parseInt(st.nextToken()); // 출발 도시 번호, 1 <= x <= n
        a = new ArrayList[n];
        answer = new ArrayList<>();
        for(int i=0; i<n; i++) a[i] = new ArrayList<Integer>();
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()); // 출발 도시
            int e = Integer.parseInt(st.nextToken()); // 도착 도시
            a[s].add(e);
        }
        visited = new int[n]; // 방문 배열 초기화
        for(int i=0; i<n; i++) visited[i] = -1;
        bfs(x);
        for(int i=0; i<n; i++) if(visited[i] == k) answer.add(i);
        if(answer.isEmpty()) System.out.println("-1");
        else {
            Collections.sort(answer);
            for(int item: answer) System.out.println(item+1);
        }
    }
    public static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(node);
        visited[node]++;
        while(!queue.isEmpty()) {
            int now_node = queue.poll();
            for(int i: a[now_node]) {
                if(visited[i-1] == -1) {
                    visited[i-1] = visited[now_node]+1;
                    queue.add(i-1);
                }
            }
        }
    }
}
