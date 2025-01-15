import java.util.*;
import java.io.*;
/*
 B11663
 점의 개수 N, 선분의 개수 M
 둘째 줄에는 점의 좌표
 셋째줄부터 M개의 줄에는 선분의 시작점과 끝점
 입력으로 주어진 선분마다, 선분위에 입력으로 주어진점이 몇 개 있는지 출력
 */
public class Main {

	static int n, m, dots[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		StringTokenizer st =new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		dots=new int[n];
		st =new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) 
			dots[i]=Integer.parseInt(st.nextToken());
		Arrays.sort(dots);
		for(int i=0;i<m;i++) {
			st =new StringTokenizer(br.readLine());
			int start= Integer.parseInt(st.nextToken());
			int end= Integer.parseInt(st.nextToken());
		       // 시작점 이상인 첫 번째 점의 위치
            int left = lowerBound(dots, start);
            // 끝점 이하인 마지막 점의 위치 + 1
            int right = upperBound(dots, end);
			
			sb.append(right-left).append("\n");		
		}
		System.out.println(sb);
			
	}
    private static int lowerBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    private static int upperBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
