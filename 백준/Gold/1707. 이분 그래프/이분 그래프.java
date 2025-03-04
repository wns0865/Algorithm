import java.util.*;
import java.io.*;
/*
그래프의 정점의 집합을 둘로 분할
각 직합에 속한 정점끼리는 서로 인접하지 않도록 분할 할 수 있다
이런게 이분 그래프 
그래프가 주어지면 얘가 이분인지 아닌지 판별

 */

public class Main {
	static class pos{
		int x, y;
		public pos (int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	static ArrayList<Integer> list[];
	static int V, E;
	public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			list = new ArrayList[V+1];
			int arr[]=new int[V+1];
			for(int i=1;i<V+1;i++) {
				list[i]=new ArrayList<>();
			}
			for(int i=0;i<E;i++) {
				st= new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);
				list[b].add(a);
			}
			boolean ans=true;
			for(int i=1;i<V+1;i++) {
				if(arr[i]==0) {//방문 안한거
					if(!color(i,arr))//정점 번호와 색칠배열
					{
						ans=false;
						break;
					}
				}
			}
			if(!ans)System.out.println("NO");
			else System.out.println("YES");
		}
	}
	static boolean color(int start, int arr[]) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.add(start);
		arr[start]=1; //처음시작은 1로
		while (!q.isEmpty()) {
			int tmp = q.poll();
			for(int i:list[tmp]) {
				if(arr[i]==0) {
					arr[i]=-arr[tmp];
					q.add(i);
				}
				else if(arr[i]==arr[tmp]) {
					return false;
				}
			}
		}
		return true;
	}
}
