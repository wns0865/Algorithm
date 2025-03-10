import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T= Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			Stack<Character> stack = new Stack<>();
			String s = br.readLine();
			/*
			 * 여는 괄호 갯수 선언
			 * 여는 괄호? ++
			 * 닫는 괄호? ->여는 괄호 -- 만약 여는 괄호 수가 1보다 작다? 끝내고 No
			 */
			int open=0;
			for(int i=0;i<s.length();i++) {
				char tmp=s.charAt(i);
				if(tmp=='(') open++;
				else if(open>0) open--;
				else if(open<1) {
					open--;
					break;
				}
			}
			if(open==0) sb.append("YES"+"\n");
			else sb.append("NO"+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
