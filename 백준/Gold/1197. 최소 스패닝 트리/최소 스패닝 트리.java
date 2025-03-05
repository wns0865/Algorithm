import java.util.*;
import java.io.*;

public class Main {
/*
 * 최소 신장 트리 MST?
 * 주어진 모든 정점들을 연결하는 부분 그래프 중에서
 * 그 가중치의 합이 최소인 트리
 * 
 * 크루스칼
 * 1. 간선들을 가중치의 오름차순으로 정렬
 * 2. 그중 가장 작은 간선 선택
 * 3. 그 간선이 사이클을 형성하면 제외
 * 4. 아니라면 MST에 추가
 * 5. 모든 간선에 대해 반복
 */
	static class edge implements Comparable<edge>{
		int x,y,z;
		public edge(int x,int y, int z) {
			this.x=x;
			this.y=y;
			this.z=z;
		}
		@Override
		public int compareTo(edge o) {
			return this.z-o.z;
		}
		@Override
		public String toString() {
			return "edge [x=" + x + ", y=" + y + ", z=" + z + "]";
		}
		
	}
	static ArrayList<edge> list;
	static int V,E,parent[]; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		parent=new int[V+1];
		for(int i=1;i<V+1;i++)parent[i]=i;
		list =new ArrayList<>();
		for(int i=0;i<E;i++) {
			st= new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			int z=Integer.parseInt(st.nextToken());
			list.add(new edge(x,y,z));			
		}
		Collections.sort(list);
		int ans=0;
		int edgeCnt=0;
		for(int i=0;i<list.size();i++) {
			edge tmp = list.get(i);
			if(union(tmp.x,tmp.y)) {
				ans+=tmp.z;
				edgeCnt++;
			}
			if(edgeCnt==V-1) {
				break;
			}
		}
		System.out.println(ans);
	}
	static boolean union(int x, int y) {
		x=find(x);
		y=find(y);
		if(x==y) return false;
		if(x<=y)parent[y]=x;
		else parent[x]=y;
		return true;
	}
	static int find(int x) {
		if(parent[x]==x) return x;
		//		return find(parent[x]);
		return parent[x]=find(parent[x]);
	}

}
