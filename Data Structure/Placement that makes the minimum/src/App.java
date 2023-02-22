import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App {
    static int answer = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String eclipse = br.readLine(); // 길이는 50 이하, 0~9, +, - (단, 처음과 마지막 문자는 숫자이고 연산자가 연속되지 않고 5자리 이하 숫자)
        String[] refine = eclipse.split("-");
        for (int i=0; i<refine.length; i++) {
            int temp = sum(refine[i]);
            if(i == 0) answer += temp;
            else answer -= temp;
        }
        
        System.out.println(answer);
    }

    public static int sum(String str) {
        int sum = 0;
        String temp[] = str.split("[+]");
        for(int i=0; i<temp.length; i++) {
            sum += Integer.parseInt(temp[i]);
        }
        return sum;
    }
}
