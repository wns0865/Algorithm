//B1647
/*
 * 마을은 N개의 집과 그들을 연결하는 M개의 길로 이루어져 있다. (양방향)
 * 마을을 분할 할때는 집들이 서로 연결되도록 분할해야됨
 * - 각 분리된 마을에 있는 임의의 두집 사이에 경로가 항상 존재해야한다.
 * 분뢰된 마을 사이에 있는 길들은 지워.
 * 나머지도 한가지 길만 냅두고, 최소로 해
 */
import java.util.*;
import java.io.*;
public class Main {
	static int N, M;
	static class edge implements Comparable<edge>{
		int x, y, z;
		public edge(int x, int y, int z) {
			this.x=x;
			this.y=y;
			this.z=z;
		}
	@Override
	public int compareTo(edge o) {
		return this.z-o.z;
	}
	}
	 static int parent[];
	static ArrayList<edge> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		parent=new int[N+1];
		for(int i=1;i<N+1;i++) {
			parent[i]=i;
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());			
			list.add(new edge(a,b,c));
		}
		Collections.sort(list);
		
		
		int edgeCnt=0;
		int sum = 0;
		int max=0;
		for(int i=0;i<M;i++) {
			edge tmp = list.get(i);
			if(union(tmp.x, tmp.y)) {
				edgeCnt++;
				sum+=tmp.z;
			}
			if(edgeCnt==N-1) {
//				간선의 비용들중 가장 큰 값 저장
				max=tmp.z;
				break;
			}
		}
		
		
//		기존의 최소 스패닝 트리에서 비용이 가장 큰 간선 하나만 제거하면
//		두 그룹의 최소 스패닝 트리가 되고,비용의 합은 최소가 된다
		int ans=sum-max;
		System.out.println(ans);
		
	}
	static int find(int x) {
		if(parent[x]==x) return x;
		return parent[x]=find(parent[x]);
	}
	static boolean union(int x, int y) {
		//각 노드의 부모 찾기
		x=find(x);
		y=find(y);
		//두개의 부모가 같다면 사이클 생김 -> false
		if(x==y) return false;
		if(x>y) parent[x]=y;
		else  parent[y]=x;
		return true;
		
	}
}
