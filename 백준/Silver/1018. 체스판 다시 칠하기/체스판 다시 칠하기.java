import java.util.*;
import java.io.*;

public class Main {
	static int N,M;
	static char[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		for(int i=0;i<N;i++) {
			String s =br.readLine();
			for(int j=0;j<M;j++) {
				arr[i][j]=s.charAt(j);
			}
		}
		int min=Integer.MAX_VALUE;
		for(int i=0;i<=N-8;i++) {
			for(int j=0;j<=M-8;j++) {
				min=Math.min(draw(i,j),min);
			}
		}
		
		System.out.println(min);
		
	}
	static int draw(int x, int y) {
		char start=arr[x][y];
		int cnt1=0;
		for(int i=x;i<x+8;i++) {
			for(int j=y;j<y+8;j++) {
				if(arr[i][j]!=start) {
					cnt1++;
				}
				if(start=='B') start='W';
				else start='B';
			}
			if(start=='B') start='W';
			else start='B';
		}
		
		start=arr[x][y];
		if(start=='B') start='W';
		else start='B';
		int cnt2=0;
		for(int i=x;i<x+8;i++) {
			for(int j=y;j<y+8;j++) {
				if(arr[i][j]!=start) {
					cnt2++;
				}
				if(start=='B') start='W';
				else start='B';
			}
			if(start=='B') start='W';
			else start='B';
		}
		
		
		return Math.min(cnt1,cnt2);
	}
}
