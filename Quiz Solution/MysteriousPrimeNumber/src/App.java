import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static int n;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 1 ≤ n ≤ 8
        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);
        System.out.println(sb);

        // // ArrayList로 구현
		// ArrayList<Boolean> primeList;

		// // 사용자로부터의 콘솔 입력
		// Scanner scan = new Scanner(System.in);
		// int n = scan.nextInt();

		// // n <= 1 일 때 종료
		// if(n <= 1) return;

		// // n+1만큼 할당
		// primeList = new ArrayList<Boolean>(n+1);
		// // 0번째와 1번째를 소수 아님으로 처리
		// primeList.add(false);
		// primeList.add(false);
		// // 2~ n까지 소수로 설정
		// for(int i=2; i<=n; i++ )
		// 	primeList.add(i, true);

		// // 2부터  ~ i*i <= n
		// // 각각의 배수들을 지워간다.
		// for(int i=2; (i*i)<=n; i++){
		// 	if(primeList.get(i)){
		// 		for(int j = i*i; j<=n; j+=i) primeList.set(j, false);
		// 		//i*i 미만은 이미 처리되었으므로 j의 시작값은 i*i로 최적화할 수 있다.
		// 	}
		// }
		// StringBuffer sb = new StringBuffer();
		// sb.append("{");
		// for(int i=0; i<=n; i++){
		// 	if(primeList.get(i) == true){
		// 		sb.append(i);
		// 		sb.append(",");
		// 	}
		// }
		// sb.setCharAt(sb.length()-1, '}');

		// System.out.println(sb.toString());
    }

    public static void dfs(int number, int digit) {
        if(digit == n) {
            if(validPrimeNumber(number)) sb.append(number).append("\n");
            return;
        }
        for(int i=1; i<10; i++) {
            if(i%2 == 0) continue; // 짝수라면 더 이상 탐색할 필요 없음
            if(validPrimeNumber(number*10+i)) dfs(number*10+i, digit+1); // 소수라면 재귀함수로 자릿수를 늘림
        }
    }

    public static boolean validPrimeNumber(int v) {
        // 소수인가
        for(int i=2; i<=v/2; i++) {
            if(v%i == 0) return false;
        }
        return true;
    }
}
