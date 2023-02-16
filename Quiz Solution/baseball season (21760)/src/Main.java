import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int leagues, teams, k, limit;
        for(int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            leagues = Integer.parseInt(st.nextToken());
            teams = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            limit = Integer.parseInt(st.nextToken());
            int result = 0;
            while(result <= limit) {
                int gameB = (teams - 1) * teams;
                int gameA = k * gameB;
                result = Math.max(result, gameA + gameB);
                teams++;
            }
            System.out.println(result);
        }
    }
}
