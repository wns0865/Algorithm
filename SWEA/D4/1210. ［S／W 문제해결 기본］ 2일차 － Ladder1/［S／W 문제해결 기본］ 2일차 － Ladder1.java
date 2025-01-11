//S1210
import java.util.*;
import java.io.*;
public class Solution {
	static int dx[]= {0,0,1};
	static int dy[]= {1,-1,0};
	static class pos{
		int x, y;
		public pos(int x, int y) {
			this.x=x;
			this.y=y;
		}
		@Override
		public String toString() {
			return "pos [x=" + x + ", y=" + y + "]";
		}
		
	}
	static int arr[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1;t<=10;t++) {
			int Num= Integer.parseInt(br.readLine());
			 arr=new int[100][100];
			for(int i=0;i<100;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<100;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0;i<100;i++) {
				if(arr[0][i]==1) {
					if(start(i))
						{
						System.out.println("#"+Num+" "+i);
						break;
						}
				}
			}
		}
	}
	static boolean start(int s) {
		Queue<pos> q = new ArrayDeque<>();
		boolean isVisited[][]=new boolean[100][100];
		q.add(new pos(0,s));
		isVisited[0][s]=true;
		while(!q.isEmpty()) {
			pos tmp = q.poll();
			if(arr[tmp.x][tmp.y]==2)return true;
			if(tmp.x==99) return false;
			for (int i=0;i<3;i++) {
				int tx= tmp.x+dx[i];
				int ty= tmp.y+dy[i];
				if(!check(tx,ty)) continue;
				if(isVisited[tx][ty]) continue;
				if(arr[tx][ty]==0) continue;
				isVisited[tx][ty]=true;
				q.add(new pos(tx,ty));
				if(i<2) break;
			}
		}
		return false;
	}
	static boolean check(int a, int b) {
		if(a<0|| a>=100||b<0||b>=100) {
			return false;
		}
		return true;
	}
}
