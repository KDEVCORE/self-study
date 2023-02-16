import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int contest = Integer.parseInt(st.nextToken());
        int divide = Integer.parseInt(st.nextToken());
        int result = 1;
        for(int i = 0, temp; i < contest; i++) {
            temp = Integer.parseInt(br.readLine());
            result = (result * (temp == 0 ? 1 : temp)) % divide;
        }
        System.out.println(result % divide);
    }
}
