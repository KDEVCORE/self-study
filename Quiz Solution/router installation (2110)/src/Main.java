import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int house = Integer.parseInt(st.nextToken());
        int router = Integer.parseInt(st.nextToken());
        int[] location = new int[house];
        for(int i=0; i<house; i++) location[i] = Integer.parseInt(br.readLine());
        Arrays.sort(location);
        int start = 0, end = location[house-1] - location[0], result = Integer.MIN_VALUE;
        while(start <= end) {
            int mid = (start + end) / 2;
            int count = 1;
            int frontHouse = location[0];
            for(int i=1; i<house; i++) {
                if(location[i] - frontHouse >= mid) {
                    count++;
                    frontHouse = location[i];
                }
            }
            if (count >= router) {
                result = Math.max(result, mid);
                start = mid+1;
            } else end = mid-1;
        }
        System.out.println(result);
    }
}
