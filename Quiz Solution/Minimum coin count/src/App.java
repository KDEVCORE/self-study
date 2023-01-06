import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 1 ≤ n ≤ 10
        int k = Integer.parseInt(st.nextToken()); // 1 ≤ k ≤ 100000000
        int[] coins = new int[n];
        for(int i=0; i<n; i++) {
            coins[i] = Integer.parseInt(br.readLine()); // 1 ≤ coins[i] ≤ 1000000, i ≥ 2일 때는 coins[i]는 coins[i-1]의 배수
        }
        int count = 0;
        for(int i=n-1; i>=0; i--) {
            if(k >= coins[i]) {
                count += k/coins[i];
                k = k % coins[i];
            }
        }
        System.out.println(count);
    }
}
