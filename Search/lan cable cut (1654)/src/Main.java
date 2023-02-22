import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] haveLAN = new int[k];
        long start = 1, end = Integer.MAX_VALUE;
        for(int i=0; i<k; i++) {
            haveLAN[i] = Integer.parseInt(br.readLine());
            end = Math.max(end, haveLAN[i]);
        }
        Arrays.sort(haveLAN);
        long result = Integer.MIN_VALUE;
        while(start <= end) {
            long mid = (start + end) / 2;
            long count = 0;
            for(int i=0; i<k; i++) {
                count += haveLAN[i] / mid;
            }
            if(count >= n) {
                result = Math.max(result, mid);
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(result);
    }
}
