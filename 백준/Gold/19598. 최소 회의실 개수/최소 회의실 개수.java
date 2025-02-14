import java.util.*;
import java.io.*;
public class Main {
	static class time implements Comparable<time>{
		int start, end;
		public time(int start,int end) {
			this.start=start;
			this.end=end;
		}
		@Override
		public int compareTo(time o) {
			if(this.start==o.start)
				return this.end-o.start;
			return this.start-o.start;
		}
		
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		List<time> list = new ArrayList<>();
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			list.add(new time(a,b));
		}
		Collections.sort(list);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(list.get(0).end);
		for(int i=1;i<N;i++) {
			if(pq.peek()<=list.get(i).start) {
				pq.poll();
				
			}
			pq.add(list.get(i).end);
		}
		System.out.println(pq.size());
	}
}
