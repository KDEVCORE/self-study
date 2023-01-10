import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        if(a > b) {
            long temp = a;
            a = b;
            b = temp;
        }
        long result = gcd(a, b);
        while(result > 0) {
            sb.append("1");
            result--;
        }
        System.out.println(sb);
    }

    public static long gcd(long a, long b) {
        if(b == 0) return a;
        else return gcd(b, a%b);
    }
}
