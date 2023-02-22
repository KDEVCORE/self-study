import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] coinType = new int[Integer.parseInt(st.nextToken())];
        int values = Integer.parseInt(st.nextToken());
        for(int i=0; i<coinType.length; i++) coinType[i] = Integer.parseInt(br.readLine());
        int sum = 0, count = 0;
        for(int i=coinType.length-1; i>=0; i--) {
            if(coinType[i] > values) continue;
            while(values - sum >= coinType[i] && sum < values) {
                sum += coinType[i];
                count++;
            }
        }
        System.out.println(count);
    }
}
