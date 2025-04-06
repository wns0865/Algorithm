import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arr[]= new int[12];
		arr[1]=1;arr[2]=2;arr[3]=4;
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			int n=Integer.parseInt(br.readLine());
			for(int j=4;j<=n;j++) {
				arr[j]=arr[j-1]+arr[j-2]+arr[j-3];
			}
			System.out.println(arr[n]);
		}
	}

}
