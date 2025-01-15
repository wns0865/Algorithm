import java.util.*;
import java.io.*;

public class Main {
    static class line implements Comparable<line>{
        int x, y, v;
        public line(int x, int y, int v) {
            this.x=x;
            this.y=y;
            this.v=v;
        }
        @Override
        public String toString() {
            return "line [x=" + x + ", y=" + y + ", v=" + v + "]";
        }
        @Override
        public int compareTo(line o) {
            return this.v - o.v;
        }
    }
    
    static int N,M,dist[];
    static boolean isVisited[];
    static ArrayList<ArrayList<line>> lines;
    static ArrayList<line> answer;
    
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        dist=new int[N+1];
        isVisited=new boolean[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        
        lines = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            lines.add(new ArrayList<>());
        }
        answer = new ArrayList<>();
        
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            lines.get(x).add(new line(x,y,v));
            lines.get(y).add(new line(y,x,v));
        }
        dik(1);

        System.out.println(answer.size());
        for(line l : answer) {
            System.out.println(l.x + " " + l.y);
        }
    }

    static void dik(int start) {
        PriorityQueue<line> pq = new PriorityQueue<>();
        dist[start]=0;
        pq.offer(new line(start,start,0));
        
        while(!pq.isEmpty()) {
            line tmp = pq.poll();
            
            if(!isVisited[tmp.y]) {
                isVisited[tmp.y] = true;
                if(tmp.x != tmp.y) answer.add(tmp); 
            }
            
            for(line next : lines.get(tmp.y)) {
                if(dist[next.y] > dist[tmp.y] + next.v) {
                    dist[next.y] = dist[tmp.y] + next.v;
                    pq.offer(new line(next.x, next.y, dist[next.y]));
                }
            }
        }
    }
}