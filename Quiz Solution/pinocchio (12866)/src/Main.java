import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static char[] chromosome = {'A', 'C', 'G', 'T'};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        String baseSequence = br.readLine();
        ArrayList<String> valid = new ArrayList<>();
        for(char item: baseSequence.toCharArray()) {
            
        }
    }
    public static long factorial(Long n) {
        if(n == 0) return 1;
        return n * factorial(n-1);
    }
}
