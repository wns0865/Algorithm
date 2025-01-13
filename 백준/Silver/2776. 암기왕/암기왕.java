import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] question = new int[n];
            for (int j = 0; j < n; j++) {
                question[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(question);
            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int findNumber = Integer.parseInt(st.nextToken());

                int start = 0;
                int end = n - 1;
                boolean find = false;
                while (start <= end) {
                    int mid = (start + end) / 2;

                    if (question[mid] == findNumber) {
                    	 bw.write(1 + "\n");
                        find = true;
                        break;
                    } else if (question[mid] > findNumber) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }

                if (!find) {
                	 bw.write(0 + "\n");
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

