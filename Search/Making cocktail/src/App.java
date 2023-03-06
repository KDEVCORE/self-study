import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class App {
    static ArrayList<CNode>[] recipe;
    static long lcm;
    static boolean visited[];
    static long d[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 1 <= n <= 10
        recipe = new ArrayList[n];
        visited = new boolean[n];
        d = new long[n];
        lcm = 1;
        for(int i=0; i<n; i++) recipe[i] = new ArrayList<CNode>();
        for(int i=0; i<n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            recipe[a].add(new CNode(b, p, q));
            recipe[b].add(new CNode(a, q, p));
            lcm *= (p*q / gcd(p, q)); // 최소 공배수는 두 수의 곱을 최대 공약수로 나눈 것
        }
        d[0] = lcm;
        dfs(0);
        long mgcd = d[0];
        for(int i=1; i<n; i++) mgcd = gcd(mgcd, d[i]);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) sb.append(d[i] / mgcd).append(" ");
        System.out.println(sb);
    }
    public static long gcd(long a, long b) { // 최대 공약수 함수
        if(b == 0) return a; // a가 최대 공약수
        else return gcd(b, a%b);
    }
    public static void dfs(int node) { // DFS 함수
        visited[node] = true;
        for(CNode item: recipe[node]) {
            int next = item.getB();
            if(!visited[next]) {
                d[next] = d[node] * item.getQ() / item.getP(); // 주어진 비율로 다음 node값 갱신
                dfs(next);
            }
        }
    }
}
class CNode {
    int b, p, q;
    public CNode(int b, int p, int q) {
        super();
        this.b = b;
        this.p = p;
        this.q = q;
    }
    public int getB() {
        return b;
    }
    public int getP() {
        return p;
    }
    public int getQ() {
        return q;
    }
}