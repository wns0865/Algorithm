import java.util.*;
class Solution {
    public int[] solution(String s) {
        int zeroCnt=0;
        int tryCnt=0;
        
        while(!s.equals("1")){
        tryCnt++;
            
        String []arr1 = s.split("0");
            
        int sum=0;
            
        for(int i=0;i<arr1.length;i++){
            sum+=arr1[i].length();
        }
        zeroCnt+=s.length()-sum;
  
        s= Integer.toBinaryString(sum);
            
        }
        int[] answer = {tryCnt,zeroCnt};
        
        return answer;
    }
}