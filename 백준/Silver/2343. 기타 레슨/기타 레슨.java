import java.util.*;
import java.io.*;
/*
 강의의 수 N, 블루레이의 수 M
 9 3
 1 2 3 4 5 6 7 8 9
 M개로 잘랐을때 그 합 중 가장큰값이, 최소가 되게 잘라라
 
 */
public class Main {
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		st= new StringTokenizer(br.readLine());
		int arr[]=new int[N];
		int arrsum[]=new int[N];
		int max=0; int sum=0;
		for(int i=0;i<N;i++) {
			int num=Integer.parseInt(st.nextToken());
			arr[i]=num;
			sum+=num;
			arrsum[i]=sum;
			max=Math.max(num,max);
		}
		int left=max;
		int right=sum;
		while(left<=right) {
			int mid=(left+right)/2;
			int cnt=check(arr,arrsum,mid);
			if(cnt>M) {
				left=mid+1;
			}else {
				right=mid-1;
			}
		}
		
		System.out.println(left);
	}
	
	static int check(int array[],int sum[],int size) {
		int ans=0, tmp=0;
		for(int i=0;i<N;i++) {
			if(i==N-1) ans++;
			if(sum[i]-tmp>size) {
				ans++;
				tmp=sum[i-1];
			}
		}
		return ans;
	}
	
}
