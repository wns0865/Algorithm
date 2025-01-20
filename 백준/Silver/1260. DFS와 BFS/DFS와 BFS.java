import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int n,m,v,arr[][];
	static boolean isVisited[];
	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	n=sc.nextInt();
	m=sc.nextInt();
	v=sc.nextInt();
	isVisited=new boolean[n+1];
	arr=new int[1001][1001];
	for(int i=0;i<m;i++) {
		int x=sc.nextInt();
		int y=sc.nextInt();
		arr[x][y]=arr[y][x]=1;
	}
	dfs(v);
	isVisited=new boolean[n+1];
	System.out.println();
	bfs(v);
	
	
	
}
	static void dfs (int node) {
	isVisited[node]=true;
	System.out.print(node +" ");
	for(int i=1;i<n+1;i++) {
		if(!(isVisited[i])&&arr[node][i]==1)
		{
			dfs(i);
		}
	}
	}
	
	static void bfs(int node) {
		Queue<Integer> q =new ArrayDeque<>();
		q.offer(node);
		isVisited[node]=true;
		System.out.print(node+" ");
		while(!q.isEmpty())
		{
			int tmp=q.poll();
			for(int i=1;i<n+1;i++) {
			if(arr[tmp][i]==1&&!(isVisited[i])) {
				isVisited[i]=true;
				q.offer(i);
				System.out.print(i+" ");
			}
			}
			
		}
		
	}
}
