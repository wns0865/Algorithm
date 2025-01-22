import java.util.*;
import java.io.*;
public class Main {
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,1,0,-1};
	static int N;
	static int arr[][];
	static boolean isVisited[][];
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		arr=new int[N][N];
		isVisited=new boolean[N][N];
		int ans=0;
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<N;j++) {
				arr[i][j]=s.charAt(j)-'0';
			}
		}
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j]==1&&!isVisited[i][j]) {
					list.add(bfs(i,j));
					ans++;
				}
			}
		}
		System.out.println(ans);
        Collections.sort(list);
		for(int i=0;i<ans;i++) {
			System.out.println(list.get(i));
		}
	}
	static int bfs(int x, int y) {
		Queue<int []> q = new ArrayDeque<>();
		int cnt=1;
		q.add(new int[] {x,y});
		isVisited[x][y]=true;
		while(!q.isEmpty()) {
			int tmp[]=q.poll();
			for(int i=0;i<4;i++) {
				int tx=tmp[0]+dx[i];
				int ty=tmp[1]+dy[i];
				if(!check(tx,ty)) continue;
				if(arr[tx][ty]==0) continue;
				if(isVisited[tx][ty])continue;
				q.add(new int[] {tx,ty});
				cnt++;
				isVisited[tx][ty]=true;
			}
		}
		return cnt;
	}
	private static boolean check(int a, int b) {
		if(0>a||a>=N||0>b||b>=N)	return false;
		return true;
	}
}
