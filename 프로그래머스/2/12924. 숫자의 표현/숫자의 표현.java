class Solution {
    public int solution(int n) {
        int arr[] = new int[n+1];
        arr[1]=1;
        for(int i=2;i<=n;i++){
           arr[i]=i+arr[i-1]; 
        }
        int start =1;
        int end=1;
        int cnt=0;
        int sum=0;
        while(start<=end&&(start<n+1&&end<n+1)){
            int tmp = arr[end]-arr[start-1];
            if(tmp==n){
                cnt++;
                 if(end<n+1){
                      end++;
                    }
                else start++;
            }
            else if(tmp>n)start++;
            else end++;
        }
        int answer = cnt;
        return answer;
    }
}