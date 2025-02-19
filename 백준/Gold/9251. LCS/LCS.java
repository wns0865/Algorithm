import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		char arr1[] = new char[s1.length()+ 1];
		char arr2[] = new char[s2.length()+ 1];
		for(int i = 1; i <= s1.length(); i++) {
			arr1[i] = s1.charAt(i - 1);
		}
		for(int i = 1; i <= s2.length(); i++) {
			arr2[i] = s2.charAt(i - 1);
		}
		int dp[][] = new int[s2.length() + 1][s1.length()+ 1];

		for(int i = 1; i <= s2.length(); i++) {
			for(int j = 1; j <= s1.length(); j++) {
				if(arr2[i] == arr1[j]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}
				else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}System.out.println(dp[s2.length()][s1.length()]);
	}
}