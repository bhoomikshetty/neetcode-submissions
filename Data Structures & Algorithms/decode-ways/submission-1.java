class Solution 
{
    public int count(int i, String s)
    {
        if(i >= s.length()) return 1;
        if(s.charAt(i) == '0') return 0;
        return count(i+1, s) + ((i + 1 < s.length() && (((s.charAt(i) - '0') * 10) + (s.charAt(i+1) - '0')) <= 26) ? count(i+2, s) : 0);
    }
    public int numDecodings(String s) 
    {
        if(s.charAt(0) == '0') return 0;
        return count(0, s);
    }
}
