import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder ();
		int T= Integer.parseInt(br.readLine());
		Deque<Integer> q = new ArrayDeque<>();
		for(int i=0;i<T;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			switch (s) {
			case "push":
				int N = Integer.parseInt(st.nextToken());
				q.offer(N);
				break;
			case "pop":
				if(q.size()!=0)	sb.append(q.poll()+"\n");
				else sb.append(-1+"\n");
				break;
			case "size":
				sb.append(q.size()+"\n");
				break;
			case "empty":
				if(q.size()==0) sb.append(1+"\n");
				else sb.append(0+"\n");
				break;
			case "front":
				if(q.size()==0) sb.append(-1+"\n");
				else sb.append(q.peek()+"\n");
				break;
			case "back":
				if(q.size()!=0) sb.append(q.peekLast()+"\n");
				else sb.append(-1+"\n");
				break;
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
