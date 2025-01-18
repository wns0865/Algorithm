import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int arr[]= new int[N];
		int total[]=new int[N];
		int sum=0;
		for(int i =0;i<N;i++) {
			int tmp=Integer.parseInt(st.nextToken());
			arr[i]=tmp;
			sum+=tmp;
			total[i]=sum;
		}
		int ans=0;
		int left =0; int right=0;
		while(right<N&&left<N) {
			int tmp=total[right]-total[left]+arr[left];
			if(tmp==M) {
				ans++;
				right++;
			}
			else if(tmp>M) {
				left++;
			}
			else right++;
			
		}
		System.out.println(ans);
		
	}
}
