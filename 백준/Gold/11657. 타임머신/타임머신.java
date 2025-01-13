import java.util.*;
import java.io.*;

//B11657
/*
 N개의 도시, 한 도시에 다른 도시로 도착하는 버스 M개
 각 버스는 A,B,C
 A는 시작, B는 도착, C는 걸리는 시간
 C가 0이면 순간 이동, C<0이면 시간을 되돌아감
 1번도시에서 출발해서 나머지 도시로 가는 가장 빠른 시간
 */
public class Main {
	static class ed{
		int start, end, value;
		public ed(int start, int end, int value) {
			this.start=start;
			this.end=end;
			this.value=value;
		}
		@Override
		public String toString() {
			return "ed [start=" + start + ", end=" + end + ", value=" + value + "]";
		}
		
	}
	static ArrayList<ed> edge; //간선 정보
	static long [] dist; //거리 저장
	static int n,m;
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		 StringTokenizer st =new StringTokenizer(br.readLine());
		  n=Integer.parseInt(st.nextToken());
		  m=Integer.parseInt(st.nextToken());
		 edge = new ArrayList<>();
		 dist= new long[n+1];
		 Arrays.fill(dist,Integer.MAX_VALUE);
		 for(int i=0;i<m;i++) {
			st =new StringTokenizer(br.readLine());
			edge.add(new ed(
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		 }
		 boolean isCycle= bf(1);
		 if(isCycle) bw.write(-1+"\n");
		 else {
			 for(int i=2;i<n+1;i++) {
				 if(dist[i]==Integer.MAX_VALUE) bw.write(-1+"\n");
				 else bw.write(dist[i]+"\n");
			 }
		 }
		 bw.flush();
	     bw.close();
	     br.close();
	}
	static boolean bf(int start) {
		//시작 노드는 0
		dist[start]=0;
		//노드 개수만큼 반복
		for(int i=1;i<n+1;i++) {
			//모든 간선 확인
			for(int j=0;j<m;j++) {
				ed tmp=edge.get(j); //현재 간선
				if(dist[tmp.start]==Integer.MAX_VALUE) continue;
				if(dist[tmp.end]>(dist[tmp.start]+tmp.value)) {
					dist[tmp.end]=dist[tmp.start]+tmp.value;
					if(i==n)return true;
					
				}
			}
			
		}
		return false;
	}
}
