class Solution {
    boolean solution(String s) {
        boolean answer = true;

        int cnt=0;
        for(int i=0;i<s.length();i++){
            char tmp = s.charAt(i);
            if(tmp=='(') cnt++;
            else cnt--;
            if(cnt<0) {
                answer=false;
                break;
            }
        }
        if(cnt!=0) answer=false;
        return answer;
    }
}