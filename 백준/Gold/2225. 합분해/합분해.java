import java.util.*;
import java.io.*;
/*
 * 0부터 N까지의 정수 K를 더해서 그 합이 N이 되는 경우의 수
 * ex)N=20 K=2
 * (0,20),(1,19),(2,18)...(20,0);
 */

public class Main {
	public static void main(String[] args)throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); 
			int k = Integer.parseInt(st.nextToken()); 
			int[][] dp = new int[k+1][n+1]; // 
			
			for(int i=1;i<=k;i++) {
				dp[i][0]=1;
			}
			for(int i=1;i<=k;i++) {
				for(int j=1;j<=n;j++) {
					dp[i][j] = (dp[i][j-1] + dp[i-1][j])%1000000000;
				}
			}
			System.out.println(dp[k][n]);
		}
}
