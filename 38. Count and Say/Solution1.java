class Solution
{
    public String countAndSay(int n) 
    {
        String s = "1";
        for(int i = 1; i<n; i++)
        {
            s = compress(s);
        }
        return s;
    }
    
    public String compress(String s)
    {
        char[] newchar = s.toCharArray();
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<newchar.length; i++)
        {
            if(i+1 >= newchar.length || newchar[i] != newchar[i+1])
            {
                sb.append(count);
                sb.append(newchar[i]);
                count = 1;
            }
            else
                count++;
        }
        return sb.toString();
    }
    
}