import java.util.*;
import java.io.*;
public class Main {
	static int n ,m,arr[];
	static boolean isVisited[];
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		isVisited=new boolean[n];
		arr= new int[m];
		dfs(0);//1부터 0개
		
		
	}
	static void dfs(int count) {
		if(count>=m) {
			for(int i=0;i<m;i++) {
				System.out.print(arr[i]+" ");
			}System.out.println();
			return;
		}
		for(int i=0;i<n;i++) {
			if(!isVisited[i]) {
				arr[count]=i+1;
				isVisited[i]=true;
				dfs(count+1);
				isVisited[i]=false;
			}
		}
	}
}
