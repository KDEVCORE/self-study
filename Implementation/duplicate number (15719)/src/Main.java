import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] sequence = new boolean[size+1];
        for(int i=1; i<=size; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if(sequence[temp]) {
                System.out.println(temp);
                return;
            }
            else sequence[temp] = true;
        }
    }
}
