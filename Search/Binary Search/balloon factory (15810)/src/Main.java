import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int staff = Integer.parseInt(st.nextToken());
        int order = Integer.parseInt(st.nextToken());
        int[] stats = new int[staff];
        st = new StringTokenizer(br.readLine());
        long minStat = Long.MAX_VALUE;
        for(int i=0; i<staff; i++) {
            stats[i] = Integer.parseInt(st.nextToken());
            minStat = Math.min(minStat, stats[i]);
        }

        long min = 1, max = minStat * order, result = Long.MAX_VALUE;
        while(min <= max) {
            long count = 0;
            long mid = (min + max) / 2;
            for(int i=0; i<staff; i++) {
                count += mid / stats[i];
            }
            if(order <= count) {
                result = Math.min(result, mid);
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(result);
    }
}