import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		if(N==1)System.out.println(0);
		else {
		int n =(int)Math.sqrt(N)+1;
		boolean notPrime[]=new boolean[N+1];
		
		notPrime[1]=true;
		for(int i=2;i<n;i++) {
			if(notPrime[i]) continue;
			for(int j=2;i*j<N+1;j++) {
				notPrime[i*j]=true;
			}
		}
		ArrayList <Integer> list=new ArrayList<>();
		
		for(int i=2;i<N+1;i++) {
			if(!notPrime[i]) list.add(i);
		}
		long sum[]=new long[list.size()+1];
		for(int i=1;i<list.size()+1;i++) {
			sum[i]=sum[i-1]+list.get(i-1);
		}
		int cnt=0;
		int left=0;
		int right=0;
		while(right<=list.size()) {
			long tmp=sum[right]-sum[left];
	
			if(tmp==N) {
				cnt++;
			}
			if(tmp>N) {
				left++;
			}
			else right++;
			
		}
		System.out.println(cnt);
		}
	}
}
