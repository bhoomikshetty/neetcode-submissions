class Solution 
{
    public boolean isAnagram(String s, String t) 
    {
        int ans = 0;

        int[] character_map = new int[26];

        for(int i=0; i<s.length(); i++) character_map[s.charAt(i) - 'a']++;
        for(int i=0; i<t.length(); i++) character_map[t.charAt(i) - 'a']--;
        
        for(int character_count: character_map) if(character_count != 0) return false;
        return true;
    }
}
