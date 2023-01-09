import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = 1000000;
        boolean[] primeNumber = new boolean[max+1];
        for(int i=2; i<=max; i++) {
            primeNumber[i] = true;
        }
        for(int i=2; i<Math.sqrt(max); i++) {
            if(!primeNumber[i]) continue;
            for(int j=i+i; j<=max; j+=i) {
                primeNumber[j] = false;
            }
        }
        int i = n;
        while (true) {
            if(primeNumber[i]) {
                if(isPalindrome(i)) {
                    System.out.println(i);
                    break;
                }
            }
            i++;
        }
    }

    public static boolean isPalindrome(int value) {
        char temp[] = String.valueOf(value).toCharArray();
        int s=0, e=temp.length-1;
        while(s<e) {
            if(temp[s] != temp[e]) return false;
            s++;
            e--;
        }
        return true;
    }
}
