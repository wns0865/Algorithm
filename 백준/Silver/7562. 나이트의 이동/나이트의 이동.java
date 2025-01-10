//B7562
import java.util.*;
import java.io.*;
public class Main {
	static class pos{
		int x, y,n;
		public pos(int x, int y,int n) {
			this.x=x;
			this.y=y;
			this.n=n;
		}
		@Override
		public String toString() {
			return "pos [x=" + x + ", y=" + y + ", n=" + n + "]";
		}
		
	}
	static int dx[]= {-2,-1,1,2,2,1,-1,-2};
	static int dy[]= {1,2,2,1,-1,-2,-2,-1};
	static int size,ans=0,min=Integer.MAX_VALUE;
	static boolean isVisited[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N= Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			size= Integer.parseInt(br.readLine());
			int arr[][]=new int[size][size];
			isVisited=new boolean[size][size];
			StringTokenizer st = new StringTokenizer(br.readLine());
			pos start = new pos(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),0);
			st = new StringTokenizer(br.readLine());
			pos end =  new pos(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),0);
			
			System.out.println(find(start,end));
		}
	}
	 static int find(pos start, pos end) {
		Queue<pos> q = new ArrayDeque<>();
		q.add(start);
		while(!q.isEmpty()) {
			pos tmp = q.poll();
			if(tmp.x==end.x&& tmp.y==end.y) {
				return tmp.n;
			}
			for(int d=0;d<8;d++) {
				int tx= tmp.x+dx[d];
				int ty= tmp.y+dy[d];
				if(!check(tx,ty)) continue;
				if(isVisited[tx][ty])continue;
				isVisited[tx][ty]=true;
				q.add(new pos(tx,ty,tmp.n+1));
			}
		}
		return -1;
	}
	 static boolean check(int a, int b) {
		 if(0>a||a>=size||b<0||b>=size) return false;
		 return true;
	 }
}
