import java.util.*;
import java.io.*;
public class Main {
	static class pos{
		int x,y;
		public pos(int x, int y) {
			this.x=x;
			this.y=y;
		}
		@Override
		public String toString() {
			return "pos [x=" + x + ", y=" + y + "]";
		}
	}
	static class turn{
		int x; char y;
		public turn(int x, char y) {
			this.x=x;
			this.y=y;
		}
	}
	static int dx[]= {-1,0,1,0};
	static int dy[]= {0,1,0,-1};
	static int dir=1,ans=0, N;
	static Deque <pos> snakeQ = new ArrayDeque(); 
	static ArrayList <turn> turnList = new ArrayList();
	static ArrayList <pos> apple= new ArrayList();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		snakeQ.add(new pos(0,0));
		N=Integer.parseInt(br.readLine());
		int T=Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			apple.add(new pos(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1));
		}
		T=Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			turnList.add(new turn(Integer.parseInt(st.nextToken()),st.nextToken().charAt(0)));
		}
		while(true) {
			ans++;
			pos head = snakeQ.peekLast();
			snakeQ.add(new pos(head.x+dx[dir],head.y+dy[dir]));
			head=snakeQ.peekLast();
			if(meet(head)||head.x<0||head.x>=N||head.y<0||head.y>=N) break;
			else {
				boolean m = false;
				for(pos p: apple) {
					if(head.x==p.x&&head.y==p.y) {
						apple.remove(p);
						m=true;
						break;
					}
				}
				if(!m) snakeQ.pollFirst();
				boolean tu = false;
				turn now = null;
				for(turn t: turnList) {
					if(ans==t.x) {
						tu=true;
						now = t;
						break;
					}
				}
				if(tu) {
					if(now.y=='L') {
						if(dir==0) dir=3;
						else dir--;
					}
					else if(now.y=='D') {
						if(dir==3) dir=0;
						else dir++;
					}
				}
			}
		}
		System.out.println(ans);
		
	}
	static public boolean meet(pos head) {
		Deque <pos> tmps = new ArrayDeque();
		for(pos p: snakeQ) {
			tmps.add(p);
		}
		tmps.pollLast();
		for(pos p: tmps) {
			if(head.x==p.x&&head.y==p.y) return true;
		}
		return false;
	}
}
