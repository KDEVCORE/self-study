import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken()); // 1 <= start <= end <= 1000000
        int[] a = new int[end+1];
        for(int i=2; i<=end; i++) {
            a[i] = i;
        }
        for(int i=2; i<Math.sqrt(end); i++) {
            if(a[i] == 0) continue;
            for(int j=i+i; j<=end; j+=i) {
                a[j] = 0;
            }
        }
        for(int i=start; i<=end; i++) {
            if(a[i] != 0) System.out.println(a[i]);
        }
    }
}
