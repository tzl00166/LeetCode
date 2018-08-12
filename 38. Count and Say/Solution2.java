class Solution {
    public String countAndSay(int n) {
        if(n == 0)
            return "";
        
        String input = "1";
        for(int i = 1; i < n; i++){
            StringBuilder sb = new StringBuilder();
            int point = 0;
            String prev = "";
            int curr_count = 1;
            while(point < input.length()){
                char c = input.charAt(point++);
                if(prev != "" && c == prev.charAt(1))
                    curr_count++;
                else{
                    sb.append(prev);
                    curr_count = 1;
                }
                prev = String.valueOf(curr_count) + c;
            }
            sb.append(prev);
            input = sb.toString();
        }
        
        return input;
    }
}