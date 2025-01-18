import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[]= new int[st.countTokens()];
		int size=arr.length;
		for(int i =0;i<size;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int max=Integer.parseInt(br.readLine());
		int ans=0;
		Arrays.sort(arr);
		int left=0, right=size-1;
		while(left<right) {
			int tmp = arr[left]+ arr[right];
			if(tmp<max) {

				left++;
			}
			else if(tmp==max) 
			{
				ans++;
				left++;
				right--;
			}
			else
				right--;
			
		}
		System.out.println(ans);
	}
}
