import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken()); // 1 <= start <= end <= 10^14
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
        int count = 0;
        for(int i=start; i<=end; i++) {
            if(primeNumber[i]) {
                int x = 2;
                while(Math.pow(i, x) <= end) {
                    x++;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
