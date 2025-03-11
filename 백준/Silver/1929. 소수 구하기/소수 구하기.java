import java.util.*;
import java.io.*;
/*
 * 에라토스테네스의 체
 * k=2부터 
 * N의 제곱근 이하까지 반복하여 자연수들중
 * k를 제외한 k의 배수들을 제외 시킨다
 */
public class Main {
	static int K,N;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		int n =(int)Math.sqrt(N)+1;
		boolean notPrime []= new boolean[N+1];
		notPrime[1]=true;
		for(int i=2;i<n;i++) {
			for(int j=2;i*j<N+1;j++) {
				notPrime[i*j]=true;
			}
		}
		for(int i=K;i<N+1;i++) {
			if(!notPrime[i]) System.out.println(i);
		}
	}
}
