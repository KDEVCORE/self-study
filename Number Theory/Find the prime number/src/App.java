import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken()); // 1 <= start <= end <= 1000000
        boolean[] primeNumber = new boolean[end+1];
        for(int i=2; i<=end; i++) {
            primeNumber[i] = true;
        }
        for(int i=2; i<Math.sqrt(end); i++) {
            if(!primeNumber[i]) continue;
            for(int j=i+i; j<=end; j+=i) {
                primeNumber[j] = false;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=start; i<=end; i++) {
            if(primeNumber[i]) sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}
