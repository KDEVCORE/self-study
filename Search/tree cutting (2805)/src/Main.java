import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int treeCount = Integer.parseInt(st.nextToken());
        int takeAway = Integer.parseInt(st.nextToken());
        int[] trees = new int[treeCount];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<treeCount; i++) trees[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(trees);

        int min = 1, max = trees[treeCount-1];
        int result = Integer.MIN_VALUE;
        while(min <= max) {
            int mid = (min + max) / 2;
            long sum = 0;
            for(int i=0; i<treeCount; i++) sum += trees[i] > mid ? trees[i] - mid : 0;
            if(sum >= takeAway) {
                result = Math.max(result, mid);
                min = mid + 1;
            } else {
                max = mid - 1;
                if(max == 0) result = Math.max(result, max);
            }
        }
        System.out.println(result);
    }
}