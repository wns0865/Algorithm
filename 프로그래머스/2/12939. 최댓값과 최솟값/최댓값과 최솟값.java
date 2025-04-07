class Solution {
    public String solution(String s) {
        String answer = "";
        String [] arr= s.split(" ");
        int max =Integer.MIN_VALUE;
        int min= Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            int tmp = Integer.parseInt(arr[i]);
            if(tmp>=max) max=tmp;
            if(tmp<=min)min=tmp;
        }
        answer=min+" "+max;
        return answer;
    }
}