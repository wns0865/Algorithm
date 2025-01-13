import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			int n =Integer.parseInt(br.readLine());
			HashSet<Integer> question = new HashSet<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					question.add(Integer.parseInt(st.nextToken()));
				}	
			int m =Integer.parseInt(br.readLine());
			ArrayList<Integer> answer = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
				for(int j=0;j<m;j++) {
					if(question.contains(Integer.parseInt(st.nextToken()))) bw.write(1 + "\n");
					else bw.write(0 + "\n");
					}
			}
		
        bw.flush();
        bw.close();
        br.close();
	}
	}

