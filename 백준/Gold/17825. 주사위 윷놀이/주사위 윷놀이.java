import java.io.*;
import java.util.*;
public class Main {
	static int ans;
	static int[] arr = new int[10]; 
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0; i< 10; i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		int[][]map = new int[4][30];
		// 0 && 5 , 0 && 10 && 15
		map[0] =  new int[] {0,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,-1,-1,-1,-1,-1,-1,-1};
		map[1] =  new int[] {0,0,0,0,0,10,13,16,19,25,30,35,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
		map[2] =  new int[] {0,0,0,0,0, 0, 0, 0, 0, 0,20,22,24,25,30,35,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
		map[3] =  new int[] {0,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,30,28,27,26,25,30,35,40,-1,-1,-1,-1,-1};
		int[]score = new int[4];
		///40 이면 0,20으로, 25면 1,9  30이면 1,10, 35,1,11 
		
		boolean[][] v =new boolean[4][30];
		v[0][0]= true;
		check(0,new int[4], new int[4],map,v,0);//주사위 ,핀위치, map, 도착한 말 , 점수 
		System.out.println(ans);
	}

	private static void check(int N, int[] X, int[] Y, int[][] map, boolean[][] v,int score) {
		if(N==10) {
			ans = score>ans?score:ans;
			return;
		}
		for(int i =0; i< 4; i++) {
			int a = X[i];
			int b = Y[i];
			if( map[X[i]][Y[i]] ==-1) continue;
			v[X[i]][Y[i]]= false;
			int x = 0; 
			if(X[i]==0) {
				switch(Y[i]){
				case 5: x= 1; break;
				case 10: x =2; break;
				case 15: x=3; break;
				}
			}
			X[i]+=x;
			Y[i]+=arr[N];
			int m = map[X[i]][Y[i]];
			if(X[i]!=0) {
				switch(m) {
				case 40:
					X[i] = 0;Y[i]=20;
					break;
				case 25:
					X[i]=1;Y[i]=9;break;
				case 30:
					X[i] = 1;Y[i]=10;break;
				case 35 : 
					X[i]=1;Y[i]=11;break;
				}
			}
			///40 이면 0,20으로, 25면 1,9  30이면 1,10, 35,1,11 
			if(!v[X[i]][Y[i]]) {
				if(m!=-1) {
					v[X[i]][Y[i]] = true;
					check(N+1,X,Y,map,v,score+m);
					v[X[i]][Y[i]] = false;
				}else {
					//System.out.print(i+"번이 "+map[X[i]][Y[i]]+" ");
					check(N+1,X,Y,map,v,score);
				}
				
			}
			X[i]=a;
			Y[i]=b;
			v[X[i]][Y[i]]= true;
		}
	}
}