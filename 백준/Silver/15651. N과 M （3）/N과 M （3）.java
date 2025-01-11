
import java.util.*;
import java.io.*;
public class Main {
	
	static int n;
	static int m;
	static int[]  arr;
	static boolean [] check;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
	
		arr=new int[n];
		check= new boolean[n];
		
		dfs(0);
		System.out.println(sb);
	}

	public static void dfs (int idx){
		
		if(idx==m) {
			for(int i=0;i<m;i++) {
			sb.append(arr[i]).append(" ");
		}
			sb.append("\n");
			return;
		}
		else {
		for(int i=0;i<n;i++) {
			
			arr[idx]=i+1;
			check[i]=true;
			dfs(idx+1);
			check[i]=false;
			}
		}
	}
}
