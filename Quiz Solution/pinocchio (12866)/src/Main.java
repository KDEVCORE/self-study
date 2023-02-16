import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        String baseSequence = br.readLine();
        long a = 0, c = 0, g = 0, t = 0;
        for(char item: baseSequence.toCharArray()) {
            switch(item) {
                case 'A':
                    a++;
                break;
                case 'C':
                    c++;
                break;
                case 'G':
                    g++;
                break;
                case 'T':
                    t++;
                break;
            }
        }
        long div = 1000000007;
        long result = a * c;
        result %= div;
        result *= g;
        result %= div;
        result *= t;
        result %= div;
        System.out.println(result);
    }
}