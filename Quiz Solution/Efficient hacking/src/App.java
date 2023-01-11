import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class App {
    static int n, m;
    static boolean visited[];
    static ArrayList<Integer>[] a;
    static int answer[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 컴퓨터 개수(노드), 1 <= n <= 10000
        m = Integer.parseInt(st.nextToken()); // 신뢰 관계 개수(에지), 1 <= m <= 100000
        a = new ArrayList[n];
        answer = new int[n];
        for(int i=0; i<n; i++) a[i] = new ArrayList<>();
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            a[s].add(e);
        }
        for(int i=0; i<n; i++) {
            visited = new boolean[n];
            bfs(i);
        }
        int max = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) max = Math.max(max, answer[i]);
        for(int i=0; i<n; i++) if(answer[i] == max) sb.append(i+1).append(" ");
        System.out.println(sb);
    }
    public static void bfs(int index) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(index);
        visited[index] = true;
        while(!queue.isEmpty()) {
            int nowNode = queue.poll();
            for(int i: a[nowNode]) {
                if(!visited[i]) {
                    visited[i] = true;
                    answer[i]++;
                    queue.add(i);
                }
            }
        }
    }
}
