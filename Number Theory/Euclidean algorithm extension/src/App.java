import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        long gcd = gcd(a, b);
        if(c%gcd != 0) System.out.println(-1);
        else {
            int quotient = (int) (c / gcd);
            long[] ret = excute(a, b);
            System.out.println(ret[0] * quotient + " " + ret[1] * quotient);
        }
    }

    public static long[] excute(long a, long b) {
        long[] ret = new long[2];
        if(b == 0) {
            ret[0] = 1; // x=1, y=0으로 설정하고 반환
            ret[1] = 0;
            return ret;
        }
        long q = a / b;
        long[] v = excute(b, a%b); // 재귀 형태로 유클리드 호제법 수행
        ret[0] = v[1]; // 역순으로 x, y 값을 계산
        ret[1] = v[0] - v[1] * q;
        return ret;
    }
    public static long gcd(long a, long b) {
        while(b != 0) {
            long temp = a%b;
            a = b;
            b = temp;
        }
        return Math.abs(a);
    }
}
