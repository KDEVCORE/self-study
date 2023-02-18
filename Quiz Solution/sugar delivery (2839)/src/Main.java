import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int orderWeight = Integer.parseInt(br.readLine());
        int[] sugarPackage = {3, 5};
        int[] count = new int[orderWeight + 1];
        for(int i=0; i<sugarPackage.length; i++) {
            if(orderWeight < sugarPackage[i]) break;
            count[sugarPackage[i]] = 1;
            for(int kg=sugarPackage[i]+1; kg<=orderWeight; kg++) {
                if(count[kg - sugarPackage[i]] > 0) {
                    switch(sugarPackage[i]) {
                        case 3:
                            count[kg] = count[kg - sugarPackage[i]] + 1;
                        break;
                        case 5:
                            count[kg] = count[kg] > 0 ? Math.min(count[kg], count[kg - sugarPackage[i]] + 1) : count[kg - sugarPackage[i]] + 1;
                        break;
                    }
                }
            }
        }
        System.out.println(count[orderWeight] == 0 ? -1 : count[orderWeight]);
    }
}
