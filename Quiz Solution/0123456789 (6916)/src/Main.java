import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        switch(number) {
            case 0:
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            sb.append(" * * *\n");
            break;
            default:
            sb.append("      \n");
        }
        for(int i=0; i<3; i++) {
            switch(number) {
                case 0:
                case 4:
                case 7:
                case 8:
                case 9:
                sb.append("*     *\n");
                break;
                case 5:
                case 6:
                sb.append("*\n");
                break;
                case 1:
                case 2:
                case 3:
                sb.append("      *\n");
                break;
            }
        }
        switch(number) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 8:
            case 9:
            sb.append(" * * *\n");
            break;
            default:
            sb.append("      \n");
        }
        for(int i=0; i<3; i++) {
            switch(number) {
                case 0:
                case 6:
                case 8:
                sb.append("*     *\n");
                break;
                case 2:
                sb.append("*\n");
                break;
                case 1:
                case 3:
                case 4:
                case 5:
                case 7:
                case 9:
                sb.append("      *\n");
                break;
            }
        }
        switch(number) {
            case 0:
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            sb.append(" * * *\n");
            break;
            // default:
            // sb.append("      \n");
        }
        System.out.print(sb);
    }
}