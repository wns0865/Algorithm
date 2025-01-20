import java.util.*;
import java.io.*;
public class Main {
	static int n,m,v;
	static boolean isVisited[];
	static ArrayList <Integer> B,D;
	static ArrayList <Integer> [] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		v=Integer.parseInt(st.nextToken());
		B=new ArrayList<>();
		D=new ArrayList<>();
		list= new ArrayList[n+1];
		for(int i=1;i<n+1;i++) {
			list[i]=new ArrayList<>();
		}
		int a=0;int b=0;
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		 isVisited = new boolean[n+1];
		dfs(v,0);
		 isVisited = new boolean[n+1];
		bfs(v,0);
		for(int i=0;i<D.size();i++)System.out.print(D.get(i)+" ");
		System.out.println();
		for(int i=0;i<B.size();i++)System.out.print(B.get(i)+" ");
	}
	static void dfs(int num, int idx) {
		D.add(num);
		isVisited[num]=true;
		Collections.sort(list[num]);
		int size=list[num].size();
		for(int i=0;i<size;i++) {
			int tmp=list[num].get(i);
			if(isVisited[tmp]) continue;
			isVisited[tmp]=true;
			dfs(tmp,idx);
		}
		
	}
	
	static void bfs(int num, int idx) {
		Queue<Integer> q = new ArrayDeque<>();
		isVisited[num]=true;
		q.add(num);
		B.add(num);
		while(!q.isEmpty()) {
			int p = q.poll();
			Collections.sort(list[p]);
			int size=list[p].size();
			for(int i=0;i<size;i++) {
				int tmp =list[p].get(i);
				if(isVisited[tmp])continue;
				isVisited[tmp]=true;
				B.add(tmp);
				q.add(tmp);
			}
		}
	}
}
