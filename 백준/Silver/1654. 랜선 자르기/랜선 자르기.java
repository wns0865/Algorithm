import java.util.*;
import java.io.*;

public class Main {
	static int K,N,max;
	static int lan[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		K=Integer.parseInt(st.nextToken());;
		N=Integer.parseInt(st.nextToken());
		lan=new int[K];
		max=0;
		for(int i=0;i<K;i++) {
			lan[i]=Integer.parseInt(br.readLine());
			max=Math.max(lan[i],max);
		}
		sb.append(search(1,max));
		System.out.println(sb);
		
	}
	static long search(long start, long end) {
		long ans=0;
		while(start<=end) {
			long mid = (start+end)/2;
			int cnt = check(mid);
			if(cnt<N) {
				end=mid-1;
			}else {
				ans=mid;
				start=mid+1;
			}
		}
		return ans;
	}
	private static int check(long mid) {
		int sum=0;
		for(int i=0;i<K;i++) {
			sum+=lan[i]/mid;
		}
		return sum;
	}
}
