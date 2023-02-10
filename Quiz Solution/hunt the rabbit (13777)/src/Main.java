import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int target = Integer.parseInt(st.nextToken());
        int[] cards = new int[51];
        for(int i=1; i<=50; i++) cards[i] = i;
        while(target != 0) {
            bs(cards, target);
            st = new StringTokenizer(br.readLine());
            target = Integer.parseInt(st.nextToken());
        }
        System.out.print(sb);
    }
    public static void bs(int[] array, int target) {
        int start = 1;
        int end = array.length-1;
        while(start <= end) {
            int mid = (start + end) / 2;
            sb.append(mid + " ");
            if(target > array[mid]) {
                start = mid + 1;
            } else if(target < array[mid]) {
                end = mid - 1;
            } else {
                sb.append("\n");
                break;
            }
        }
    }
}
