import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder(s);
        if(check(sb)) answer++;

        for(int i=0;i<s.length()-1;i++){
            char tmp = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(tmp);
            if(check(sb))answer++;
              
        }
        return answer;
    }
    static boolean check(StringBuilder sb){
        Stack<Character> stack = new Stack<>();
         for(int i=0;i<sb.length();i++){
            char tmp = sb.charAt(i);
            if(tmp=='('||tmp=='{'||tmp=='['){
                stack.push(tmp);
            }
            else{
                if(stack.isEmpty()) return false;
                char close = stack.pop();
                if(tmp ==')'&& close!='(') return false;
                if(tmp =='}'&& close!='{') return false;
                if(tmp ==']'&& close!='[') return false;
                
            }
         }
        return stack.isEmpty();
    }
    
    // static boolean check(StringBuilder sb){
    //     int scnt=0;
    //     int bcnt=0;
    //     int lcnt=0;     
    //     for(int i=0;i<sb.length();i++){
    //         if(sb.charAt(i)=='('){
    //             scnt++; 
    //         }else if(sb.charAt(i)==')'){
    //             scnt--;
    //         }else if(sb.charAt(i)=='{'){
    //             bcnt++;
    //         }else if(sb.charAt(i)=='}'){
    //           bcnt--;
    //         }else if(sb.charAt(i)=='['){
    //             lcnt++;
    //         }else if(sb.charAt(i)==']'){
    //             lcnt--;
    //         }
    //         if(scnt<0 || bcnt<0 || lcnt<0 ){
    //             return false;
    //         }
    //     }
    //      if(scnt!=0 || bcnt!=0 || lcnt!=0 ){
    //             return false;
    //         }
    //     return true;
    // }
}