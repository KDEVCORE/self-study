import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine()); // 1 ≤ n ≤ 100000, 데이터 개수
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        int m = Integer.parseInt(br.readLine()); // 1 ≤ m ≤ 100000, 찾아야 할 숫자 개수
        int[] b = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        for(int item: b) {
            boolean find = false;
            int target = item;
            // 이진 탐색
            int start = 0, end = a.length-1;
            while(start <= end) {
                int midIndex = (start + end) / 2;
                int midValue = a[midIndex];
                if(midValue > target) {
                    end = midIndex - 1;
                } else if(midValue < target) {
                    start = midIndex + 1;
                } else {
                    find = true;
                    break;
                }
            }
            sb.append(find ? 1 : 0).append("\n");
        }
        System.out.println(sb);
    }
}
