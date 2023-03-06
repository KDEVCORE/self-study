import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int numberN = Integer.parseInt(br.readLine());
        int[] numbers = new int[numberN];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<numberN; i++) numbers[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(numbers);
        int numberM = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<numberM; i++) {
            sb.append(binarySearch(numbers, Integer.parseInt(st.nextToken())) ? "1" : "0").append("\n");
        }
        System.out.print(sb);
    }
    private static boolean binarySearch(int[] aim, int target) {
        int min = 0, max = aim.length-1;
        while(min <= max) {
            int mid = (min + max) / 2;
            if(target == aim[mid]) {
                return true;
            } else {
                if(target < aim[mid]) max = mid - 1;
                else min = mid + 1;
            }
        }
        return false;
    }
}
