import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int partition = Integer.parseInt(br.readLine());
        int[][] serverRoom = new int[partition][partition];
        long sum = 0, min = 0, max = Long.MIN_VALUE;
        for(int i=0; i<partition; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<partition; j++) {
                serverRoom[i][j] = Integer.parseInt(st.nextToken());
                sum += serverRoom[i][j];
                max = Math.max(max, serverRoom[i][j]);
            }
        }
        long halfLine = (long) Math.ceil(sum / 2.0), timer = Long.MAX_VALUE;
        while(min <= max) {
            long mid = (min + max) / 2;
            long temp = 0;
            for(int i=0; i<partition; i++) {
                for(int j=0; j<partition; j++) {
                    if(serverRoom[i][j] > mid) temp += mid;
                    else temp += serverRoom[i][j];
                }
            }
            if(temp >= halfLine) {
                timer = Math.min(timer, mid);
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(timer);
    }
}
