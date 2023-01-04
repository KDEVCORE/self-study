import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class App {
    public static int[] a, temp;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        a = new int[n];
        temp = new int[n];
        for(int i=0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        
        mergeSort(0, n-1); // 병합 정렬 함수
        
        StringBuilder sb = new StringBuilder();
        for(int item: a) sb.append(item).append("\n");
        System.out.println(sb);

        bf.close();
    }

    public static void mergeSort(int s, int e) {
        if(e-s < 1) return;
        int m = s + (e-s) / 2;

        // 재귀 함수 형태
        mergeSort(s, m);
        mergeSort(m+1, e);

        for(int i=s; i<=e; i++) {
            temp[i] = a[i];
        }

        int k = s;
        int index1 = s;
        int index2 = m+1;
        while(index1 <= m && index2 <= e) { // 두 그룹을 병합
            // 양쪽 그룹의 index가 가리키는 값을 비교해 더 작은 수를 선택해 배열에 저장하고, 선택된 데이터의 index 값을 오른쪽으로 한 칸 이동
            if(temp[index1] > temp[index2]) {
                a[k] = temp[index2];
                index2++;
            } else {
                a[k] = temp[index1];
                index1++;
            }
            k++;
        }
        while(index1 <= m) { // 한쪽 그룹이 모두 선택된 후 남아 있는 값 정리
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
