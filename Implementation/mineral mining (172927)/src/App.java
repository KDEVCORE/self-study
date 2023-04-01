import java.util.Arrays;
import java.util.Comparator;

public class App {
    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        int[] picks = {0, 1, 99};
        String[] minerals = {"diamond", "diamond", "diamond", "diamond", "diamond", "diamond"};
        // int[] picks = {1, 3, 2};
        // String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
        // int[] picks = {0, 1, 1};
        // String[] minerals = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};
        System.out.println(sol.solution(picks, minerals));
    }
}

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int pickCount = picks[0] + picks[1] + picks[2];
        int[][] section = new int[minerals.length / 5 + 1][3];
        for(int i=0; i<minerals.length && pickCount>0; i++) {
            switch(minerals[i])
            {
                case "diamond":
                    section[i / 5][0] += 1;
                    section[i / 5][1] += 5;
                    section[i / 5][2] += 25;
                    break;
                case "iron":
                    section[i / 5][0] += 1;
                    section[i / 5][1] += 1;
                    section[i / 5][2] += 5;
                    break;
                case "stone":
                    section[i / 5][0] += 1;
                    section[i / 5][1] += 1;
                    section[i / 5][2] += 1;
            }
            if(i % 5 == 4) pickCount--;            
        }
        Arrays.sort(section, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[2] < o2[2]) 
                    return 1;
                else 
                    return -1;
            }
        });
        for(int i=0, pick=0; i < section.length; i++) {
            while(pick < 3 && picks[pick] == 0) pick++;
            if(pick == 3) break;
            picks[pick]--;
            answer += section[i][pick];
        }
        return answer;
    }
}