import java.util.*;
import java.io.*;
public class  Main {
	static int N,M,max,arr[][];
	public static void main(String[] args) throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		arr=new int[N][M];
		for(int i=0;i<N;i++) {
		 String s = br.readLine();
			for(int j=0;j<M;j++) {
				arr[i][j]=s.charAt(j)-'0';
				}
		}
		max=1;
		for(int i=0;i<N-1;i++) {
			for(int j=0;j<M-1;j++) {
				if(N-i<=max||M-j<=max) {
					break;
				}
				max=Math.max(max,find(i,j));
			}
		}
		System.out.println(max*max);
	}
	static int find(int x,int y) {
		int now=arr[x][y];
		int max=1;
		int size=Math.min(N-x,M-y);
		for(int i=1;i<size;i++) {
			if(arr[x+i][y]==now&&arr[x][y+i]==now
					&& arr[x+i][y+i]==now) {	
                max=Math.max(max,i+1);
			}
		}
		return max;
	}
}
