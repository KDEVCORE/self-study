import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class App {
    static ArrayList<Integer>[] a;
    static int[] check;
    static boolean visited[], isEven;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine()); // 테스트 케이스 개수, 2 <= k <= 5
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 노드 개수, 1 <= n <= 20000
            int e = Integer.parseInt(st.nextToken()); // 에지 개수, 1 <= e <= 200000
            a = new ArrayList[n];
            visited = new boolean[n];
            check = new int[n];
            isEven = true;
            for(int j=0; j<n; j++) a[j] = new ArrayList<Integer>();
            for(int j=0; j<e; j++) { // 인접 리스트로 그래프 저장하기
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken())-1;
                int end = Integer.parseInt(st.nextToken())-1;
                a[start].add(end);
                a[end].add(start);
            }
            // 주어진 그래프가 1개로 연결돼 있다는 보장이 없으므로 모든 노드에서 수행하기
            for(int j=0; j<n; j++) {
                if(isEven) dfs(j);
                else break;
            }
            if(isEven) sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.print(sb);
    }
    public static void dfs(int node) { // DFS 구현
        visited[node] = true;
        for(int i: a[node]) {
            if(!visited[i]) {
                // 인접한 노드는 같은 집합이 아니므로 이전 노드와 자른 집합으로 처리
                check[i] = (check[node] + 1) % 2;
                dfs(i);
            } else if(check[node] == check[i]) { // 이미 방문한 노드가 현재 내 노드와 같은 집합이면 이분 그래프가 아님
                isEven = false;
            }
        }
    }
}
