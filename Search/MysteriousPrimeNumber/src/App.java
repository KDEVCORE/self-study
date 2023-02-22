import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App {
    public static int n;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 1 ≤ n ≤ 8
        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);
        System.out.println(sb);
    }

    public static void dfs(int number, int digit) {
        if(digit == n) {
            if(validPrimeNumber(number)) sb.append(number).append("\n");
            return;
        }
        for(int i=1; i<10; i++) {
            if(i%2 == 0) continue; // 짝수라면 더 이상 탐색할 필요 없음
            if(validPrimeNumber(number*10+i)) dfs(number*10+i, digit+1); // 소수라면 재귀함수로 자릿수를 늘림
        }
    }

    public static boolean validPrimeNumber(int v) {
        // 소수인가
        for(int i=2; i<=v/2; i++) {
            if(v%i == 0) return false;
        }
        return true;
    }
}
