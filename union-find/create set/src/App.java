import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class App {
    static int[] set;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken()); // 1 <= node <= 1000000
        set = new int[node + 1];
        for(int i=1; i<=node; i++) set[i] = i;
        int calc= Integer.parseInt(st.nextToken()); // 1 <= calc <= 100000
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=calc; i++) {
            st = new StringTokenizer(br.readLine());
            switch(st.nextToken()) {
                case "0":
                union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                break;
                case "1":
                sb.append(find(Integer.parseInt(st.nextToken())) == find(Integer.parseInt(st.nextToken())) ? "YES" : "NO" + "\n");
                break;
            }
        }
        System.out.println(sb);
    }
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) set[b] = a;
    }
    public static int find(int x) {
        if(x == set[x]) return x;
        else return set[x] = find(set[x]);
    }
}
