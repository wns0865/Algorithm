/*
*다음 큰 숫자?
1. n의 다음 큰 숫자는 n보다 큰 자연수
2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때의 1의 갯수가 같다.
3. n의 다음 큰 숫자는 조건 1 2를 만족하는 수 중 가장 작은 수
*/
class Solution {
    public int solution(int n) {
        int answer = 0;
        String nowB = Integer.toBinaryString(n);
        int now1 = oneCnt(nowB);
        
        String nexB="";
        int nex1=0;
        for(int i=n+1;i<=Integer.MAX_VALUE;i++){ 
        nexB = Integer.toBinaryString(i);
        nex1 = oneCnt(nexB);
            if(nex1==now1){
                answer=i;
                break;
            }
        }
        return answer;
    }
    static int oneCnt(String string){
    int cnt=0;  
    for(int i=0;i<string.length();i++){
          char tmp = string.charAt(i);  
          if(tmp=='1') cnt++;
        }
    return cnt;
}
}
