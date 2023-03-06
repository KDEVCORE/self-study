import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int submission = Integer.parseInt(br.readLine());
        int[] files = new int[submission];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<submission; i++) files[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(files);

        long result = 0;
        for(int i=0; i<submission; i++) result += search(files, i);
        System.out.println(result);
    }
    private static int search(int[] aim, int target) {
        int min = target+1, max = aim.length - 1;
        int result = 0;
        while(min <= max) {
            int mid = (min + max) / 2;
            if(aim[target] >= 0.9 * aim[mid]) {
                result = mid - target;
                min = mid + 1;
            } else max = mid - 1;
        }
        return result;
    }
}