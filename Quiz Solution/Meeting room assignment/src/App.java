import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 1 <= n <= 100000
        int[][] a = new int[n][2];
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a[i][0] = Integer.parseInt(st.nextToken()); 
            a[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a, new Comparator<int[]>() {
         @Override
         public int compare(int[] s, int[] e) {
            if(s[1] == e[1]) return s[0] - e[0];
            return s[1] - e[1];
         }   
        });
        int count = 0, end = -1;
        for(int i=0; i<n; i++) {
            if(a[i][0] >= end) {
                end = a[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
