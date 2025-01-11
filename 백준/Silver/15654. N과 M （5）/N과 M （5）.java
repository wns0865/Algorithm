import java.util.*;
import java.io.*;
public class Main {
	static int n ,m,ans[],arr[];
	static boolean isVisited[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		ans= new int[m];
		arr= new int[n];
		isVisited=new boolean[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		dfs(0,0);
		System.out.println(sb);
		
	}

	private static void dfs(int start, int count) {
		if(count>=m) {
			for(int i=0;i<m;i++) {
				sb.append(ans[i]+" ");
			}sb.append("\n");
			return;
		}
		for(int i=0;i<n;i++) {
			if(!isVisited[i]) {
				ans[count]=arr[i];
				isVisited[i]=true;
				dfs(i+1,count+1);
				isVisited[i]=false;
			}
		}
		
	}
}
