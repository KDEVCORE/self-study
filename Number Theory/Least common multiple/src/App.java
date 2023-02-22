import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 1 <= t <= 1000
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); // 1 <= a,b <= 45000
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(a*b / gcd(a, b)).append("\n");
        }
        System.out.println(sb);
    }
    public static int gcd(int a, int b) {
        if(b==0) return a;
        else return gcd(b, a%b);
    }
}
