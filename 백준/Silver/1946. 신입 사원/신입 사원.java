import java.util.*;
import java.io.*;
/*
 * 다른 모든 지원자와 비교했을 때 서류 심서 성적과 면접 성적 중
 * 적어도 하나가 다른 지원자보다 떨이짖 않는 자만 선발
 * 어떤 지원자 A의 성적이 다른 어떤 지원자 B의 성적에 비해
 * 서류심사 결과와 면접 성저깅 모두 떵어진다면 A는 결코 선발되지 않는다 
 */
public class Main {
	static class score implements Comparable<score>{
		int a,b;
		public score(int a, int b) {
			this.a=a;
			this.b=b;
		}
		@Override
		public int compareTo(score o) {
			
			return this.a-o.a;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine());
		int N=0;
		
		for(int t=0;t<T;t++) {
			List<score> list = new ArrayList<>();
			N=Integer.parseInt(br.readLine());
			int ans=1;
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				list.add(new score(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));	
			}
			Collections.sort(list);
			int min = list.get(0).b;
			for(int i=1;i<N;i++) {
				
				if(list.get(i).b<=min) {
					ans++;
					min=list.get(i).b;
				}
			}
			System.out.println(ans);
		}
		
	}
}
