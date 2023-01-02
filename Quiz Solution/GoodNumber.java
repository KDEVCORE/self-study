import java.util.Scanner;

class GoodNumber {
    public static void mina(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String A = scanner.nextLine();
        long[] Ai = new long[N];
        String[] Ax = A.split(" ");

        for(int i=0; i<N; i++) {
            Ai[i] = Ax[i];
        }
    }
}