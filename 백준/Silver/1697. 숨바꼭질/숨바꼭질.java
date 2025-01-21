//1697
import java.util.*;
public class Main {
	static class pos{
		int x,time;

		public pos(int x, int time) {
			super();
			this.x = x;
			this.time = time;
		}

		@Override
		public String toString() {
			return "pos [x=" + x + ", time=" + time + "]";
		}
		
	}
	static int N,K,arr[];
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		N=sc.nextInt();
		K=sc.nextInt();
		arr=new int [100001];
		Arrays.fill(arr, Integer.MAX_VALUE);
		start();
		System.out.println(arr[K]);
	}
	private static void start() {
	Queue<pos> q = new ArrayDeque<>();
	q.add(new pos(N, 0));
	arr[N]=0;
	while(!q.isEmpty()) {
		pos tmp= q.poll();
		for(int i=0;i<3;i++) {
			int tx =tmp.x;
			int ttime=tmp.time;
			if(i==0) {
				 tx+=1;
				 ttime+=1;
			}
			if(i==1) {
				 tx-=1;
				 ttime+=1;
			}
			if(i==2) {
				 tx=tmp.x*2;
				 ttime+=1;
			}
			if(tx<0 || tx>100000) continue;

			if(arr[tx]>ttime) {
				arr[tx]=ttime;
				q.add(new pos(tx, ttime));
			}
		}
	}
		
	}
}

