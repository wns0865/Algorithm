import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static boolean[] isVisited;
	static String[] arr;
	static List<String> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = br.readLine().split(" ");

		isVisited = new boolean[10];
		dfs("",0);
		System.out.print(list.get(list.size() - 1) + "\n");

		System.out.print(list.get(0));
		
	}
    
	static void dfs(String num, int idx) {
		if(idx == N+1) {
			list.add(num);
			return;
		}
		for(int j = 0 ; j < 10; j++) {

			if(isVisited[j]) {
				continue;
						
			}
			if(idx == 0 || ckeck(Character.getNumericValue(num.charAt(idx - 1)), j , arr[idx-1])) {
			    isVisited[j] = true;
				dfs(num+j, idx+1);
				isVisited[j] = false;				
			}
		}
		
	}
	
	static boolean ckeck(int a, int b, String c) {
		if (c.equals(">")) {
			if(a < b) return false;
		} else if (c.equals("<")){
			if(a > b) return false;
		}
		return true;
	}

}
