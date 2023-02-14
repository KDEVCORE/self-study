import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int population = Integer.parseInt(st.nextToken());
            int[] residentPower = new int[population];
            for(int j=0; j<population; j++) residentPower[j] = Integer.parseInt(st.nextToken());
            double average = (double) Arrays.stream(residentPower).sum() / residentPower.length;
            int count = 0;
            for(int j=0; j<population; j++) if(residentPower[j] > average) count++;
            double overpower = (double) count / population * 100;
            sb.append(String.format("%.3f", average) + " " + String.format("%.3f", overpower) + "%\n");
        }
        System.out.print(sb);
    }
}
