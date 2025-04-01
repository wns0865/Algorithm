import java.util.*;
import java.io.*;

public class Main  {
	static int N,M,parent[];
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
	static ArrayList<edge> list;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		M=Integer.parseInt(br.readLine());
		parent = new int[N+1];
		for(int i=1;i<N+1;i++)parent[i]=i;
		list = new ArrayList<>();
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			list.add(new edge(a,b,c));
		}
		Collections.sort(list);
		int sum=0;
		int edgeCnt=0;
		for(int i=0;i<M;i++) {
			edge tmp = list.get(i);
			if(union(tmp.x,tmp.y)) {
				sum+=tmp.z;
				edgeCnt++;
			}
			if(edgeCnt==N-1) break;
		}
		System.out.println(sum);
		
	}
	static int find(int x) {
		if(parent[x]==x) return x;
		return parent[x]=find(parent[x]);
	}
	static boolean union ( int x ,int y) {
		x= find(x);
		y= find(y);
		if(x==y) return false;
		if(x>y) parent[x]=y;
		else parent[y]=x;
		return true;
	}
}
