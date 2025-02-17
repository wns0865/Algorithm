import java.util.*;
import java.io.*;
public class Main {
	static int N,fibo[];
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		fibo=new int[41];
		fibo[0]=0;fibo[1]=1;
		for(int i=2;i<41;i++) {
			fibo[i]=fibo[i-1]+fibo[i-2];
		}
		for(int t=0;t<N;t++) {
			int size=Integer.parseInt(br.readLine());
			if(size==0) {
				System.out.println(1+" "+0);
			}else {
				System.out.println(fibo[size-1]+" "+fibo[size]);				
			}
		}
	}
}

