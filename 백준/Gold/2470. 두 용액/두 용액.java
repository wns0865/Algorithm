import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// -99 -2 -1 4 10 98
		int n=Integer.parseInt(br.readLine());
		int arr[] =new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int min=Integer.MAX_VALUE;
		int x=0, y=0;
		int left = 0, right = n-1;	
		while(left<right) {
			int tmp=arr[left]+arr[right];
			if(Math.abs(tmp)<min) {
				min=Math.abs(arr[left]+arr[right]);
				x=arr[left];
				y=arr[right];
			}
			if(tmp>=0) {
				right--;
			}
			else {
				left++;
			}
		}
		System.out.println(x+" "+y);
	}
}
