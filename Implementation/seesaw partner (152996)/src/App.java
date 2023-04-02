import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        int[] weights = {100,180,360,100,270};
        System.out.println(new Solution().solution(weights));
    }
}

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        int count = 0;
        for(int i=0; i<weights.length-1; i++) {
            if(i > 0 && weights[i] == weights[i-1]) {
                count--;
                answer += count;
                continue;
            }
            count = 0;
            int x2 = weights[i] * 2;
            int x3 = weights[i] * 3;
            int x4 = weights[i] * 4;
            for(int j=i+1; j<weights.length; j++) {
                int y2 = weights[j] * 2;
                int y3 = weights[j] * 3;
                int y4 = weights[j] * 4;
                if(weights[i] == weights[j] || x2 == y3 || x2 == y4 || x3 == y2 ||  x3 == y4 || x4 == y2 || x4 == y3) {
                    count++;
                }
            }
            answer += count;
        }
        return answer;
    }
}