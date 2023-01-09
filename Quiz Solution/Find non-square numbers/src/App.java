import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken()); // 1 < min < max
        long max = Long.parseLong(st.nextToken());
        // 최댓값과 최솟값의 차이만큼 배열 선언
        boolean[] check = new boolean[(int) (max-min-1)];
        // 2의 제곱수인 4부터 max보다 작거나 같은 값까지 반복
        for(long i=2; i*i<=max; i++) {
            long pow = i*i; // 제곱 수
            long start_index = min / pow;
            if(min % pow != 0) start_index++; // 나머지가 있으면 1을 더해야 min보다 큰 제곱수에서 시작
            for(long j=start_index; pow*j<=max; j++) check[(int) ((j*pow)-min)] = true; // 제곱 수 true로 변경
        }
        int count = 0;
        for(int i=0; i<=max-min; i++) {
            if(!check[i]) count++;
        }
        System.out.println(count);
    }
}
