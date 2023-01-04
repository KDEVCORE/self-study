import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine()); // n: 1~500000
        int k = Integer.parseInt(bf.readLine()); // k: 1~n
        int[] a = new int[n]; // 오름차순 정렬
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(a, 0, n-1, k-1);
        System.out.println(a[k-1]);
    }

    public static void quickSort(int[] a, int s, int e, int k) {
        if(s < e) {
            int pivot = partition(a, s, e);
            if(pivot == k) return; // k번째 수가 pivot이면 더 구할 필요 없음
            else if(k < pivot) quickSort(a, s, pivot-1, k); // k가 pivot보다 작으면 왼쪽 그룹만 정렬 수행
            else quickSort(a, pivot+1, e, k); // k가 pivot보다 크면 오른쪽 그룹만 정렬 수행
        }
    }

    public static int partition(int[] a, int s, int e) {
        if(s+1 == e) {
            if(a[s] > a[e]) swap(a, s, e);
            return e;
        }

        int m = (s+e)/2;
        swap(a, s, m); // 중앙값을 첫번째 요소로 이동
        int pivot = a[s];
        int i = s+1, j=e;
        while(i<=j) {
            while(pivot < a[j] && j > 0) { // pivot보다 작은 수가 나올 때까지 j--
                j--;
            }
            while(pivot > a[i] && i < a.length-1) { // pivot보다 큰 수가 나올 때까지 i++
                i++;
            }
            if(i<=j) {
                swap(a, i++, j--);
            }
        }

        a[s] = a[j];
        a[j] = pivot;
        return j;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
