//B 1920
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N= Integer.parseInt(br.readLine());
		HashSet<Integer> set=new HashSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		int M= Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			if(set.contains(Integer.parseInt(st.nextToken()))) System.out.println(1);
			else System.out.println(0);
		}
	}
}
