import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class App {
    public static int[] a, temp;
    public static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // n: 1~500000
        a = new int[n];
        temp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        count = 0;
        mergeSort(0, n-1);
        System.out.println(count);
    }

    public static void mergeSort(int s, int e) {
        if(e-s < 1) return;
        int m = s + (e-s) / 2;

        mergeSort(s, m);
        mergeSort(m+1, e);
        for(int i=s; i<=e; i++) {
            temp[i] = a[i];
        }

        int k = s;
        int index1 = s, index2 = m+1;
        while(index1 <= m && index2 <= e) {
            if(temp[index1] > temp[index2]) {
                a[k] = temp[index2];
                count += index2-k;
                index2++;
            } else {
                a[k] =temp[index1];
                index1++;
            }
            k++;
        }
        while(index1 <= m) {
            a[k] = temp[index1];
            k++;
            index1++;
        }
        while(index2 <= e) {
            a[k] = temp[index2];
            k++;
            index2++;
        }
    }
}
