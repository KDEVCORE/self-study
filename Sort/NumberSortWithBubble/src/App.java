import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class App {
    public static void main(String[] args) throws Exception {
        // N: 수의 개수(1 ≤ N ≤ 1000)
        // 중복되지 않는 수
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] S = new int[N];
        
        for(int i=0; i<N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        int temp = 0;
        for(int j=0; j<N-1; j++) {
            for(int i=0; i<N-1-j; i++) {
                if(S[i] > S[i+1]) {
                    temp = S[i];
                    S[i] = S[i+1];
                    S[i+1] = temp;
                }
            }
        }

        for(int item: S) {
            System.out.println(item);
        }
    }
}
