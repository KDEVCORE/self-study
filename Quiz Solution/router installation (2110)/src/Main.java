import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int house = Integer.parseInt(st.nextToken());
        int router = Integer.parseInt(st.nextToken());
        int[] location = new int[house + 1];
        for(int i=1; i<=house; i++) location[i] = Integer.parseInt(br.readLine());
        Arrays.sort(location);

        
    }
}
