class Solution {
    public String solution(String s) {
        String answer = "";
        String arr[] = s.split(" ",-1);
        for(String st: arr){
            if (st.length() == 0) {
                answer += " ";  // 공백 유지
                continue;
            }
            answer+=String.valueOf(st.charAt(0)).toUpperCase();
            for(int i=1;i<st.length();i++){
                char tmp =st.charAt(i); 
                answer+=String.valueOf(st.charAt(i)).toLowerCase();
            }
            answer+=" ";
            
        }
        answer=answer.substring(0,answer.length()-1);
        
        return answer;
    }
}