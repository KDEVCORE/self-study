import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int leagues, teams, k, limit;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            leagues = Integer.parseInt(st.nextToken());
            teams = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            limit = Integer.parseInt(st.nextToken());
            long b = 0;
            while(leagues*teams*b*(k*(teams-1)+teams*(leagues-1)) <= (2*limit)) b++;
            if(b <= 1) {
                sb.append(-1 + "\n");
                continue;
            }
            long a = leagues * teams * (b-1) * (k*(teams-1)+teams*(leagues-1));
            sb.append(a/2 + "\n");
        }
        System.out.print(sb);
    }
}