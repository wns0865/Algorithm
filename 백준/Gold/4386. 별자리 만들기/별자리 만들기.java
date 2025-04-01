import java.util.*;
import java.io.*;
public class Main {
	static class pos{
		double x; double y;
		public pos(double x, double y) {
			this.x=x;
			this.y=y;
		}
	}
	static class edge implements Comparable<edge>{
		int x, y;
		double z;
		public edge(int x, int y, double z) {
			this.x=x;
			this.y=y;
			this.z=z;
		}
		@Override
		public int compareTo(edge o) {
			if(this.z>o.z)return 1;
			else if(this.z<o.z) return -11;
			else return 0;
		}
		@Override
		public String toString() {
			return "edge [x=" + x + ", y=" + y + ", z=" + z + "]";
		}
		
	}
	static int N,parent[];
	static ArrayList<edge> list;
	static ArrayList<pos> posList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		list =new ArrayList<>();
		posList = new ArrayList<>();
		N=Integer.parseInt(br.readLine());
		parent=new int[N];
		for(int i=0;i<N;i++)parent[i]=i;
		StringTokenizer st = new StringTokenizer("");
		
		for(int i=0;i<N;i++) {
			 st = new StringTokenizer(br.readLine());
			 double a=Double.parseDouble(st.nextToken());
			 double b=Double.parseDouble(st.nextToken());
			 posList.add(new pos(a,b));
		}
		for(int i=1;i<N;i++) {
			pos tmp = posList.get(i);
			for(int j=i-1;j>=0;j--) {
				pos tmp2 = posList.get(j);
				list.add(new edge(i,j,distance(tmp2,tmp)));
			}
			
		}
		Collections.sort(list);
		double sum=0;
		int edgeCnt=0;
		for(int i=0;i<list.size();i++) {
			edge tmp = list.get(i);
			if(union(tmp.x,tmp.y)) {
				sum+=tmp.z;
				edgeCnt++;
			}
			if(edgeCnt==N-1) break;
		}
		System.out.println(Math.round(sum*100)/100.0);
		
	}
	
	static double distance(pos a, pos b) {
		return Math.sqrt(Math.pow(b.x-a.x, 2)+Math.pow(b.y-a.y, 2));
	}
	
	static int find(int x) {
		if(parent[x]==x) return x;
		return parent[x]=find(parent[x]);
	}
	
	static boolean union(int x, int y) {
		x= find(x);
		y= find(y);
		if(x==y) return false;
		if(x>y) parent[x]=y;
		else parent[y]=x;
		return true;
	}
}
