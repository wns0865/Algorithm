import java.util.*;
import java.io.*;
public class Main {
	static int n ,m,arr[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		arr= new int[m];
		dfs(0,0);
		System.out.println(sb);
		
	}

	private static void dfs(int start, int count) {
		if(count>=m) {
			for(int i=0;i<m;i++) {
				sb.append(arr[i]+" ");
			}sb.append("\n");
			return;
		}
		for(int i=0;i<n;i++) {
				arr[count]=i+1;
				dfs(i+1,count+1);
		}
		
	}
}
