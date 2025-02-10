import java.util.*;
import java.io.*;
/*
 생성 고양이 1마리를 생성
 복제 고양이 일부를 복제
 	 ㄴ 0~k마리 고양이를 집에 ㅊ가 가능
 최소 횟수로 정확하게 N마리의 고양이
 */
public class Main {
	static long N;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Long.parseLong(br.readLine());
		if(N==0) {
			System.out.println(0); 
			return;
		}
		long cnt=1;
		long total=1;
		while(total!=N) {
			if(N-total>=total) {
				total*=2;
			}
			else total+=N-total;
			cnt++;
		}
		System.out.println(cnt);
	}
}
