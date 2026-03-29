class Trie {
    Trie[] children = new Trie[26];
    boolean isEnd = false;
}

class PrefixTree 
{

    Trie trie;
    public PrefixTree() 
    {
        trie = new Trie();
    }

    public void insert(String word) 
    {
        System.out.println(Arrays.toString(trie.children));

        Trie curr = trie;
        for(char w=0; w<word.length(); w++)
        {
            if(curr.children[word.charAt(w) - 'a'] == null)
            {
                Trie newTrie = new Trie();
                curr.children[word.charAt(w) - 'a'] = newTrie;
                curr = newTrie;
            }
            else curr = curr.children[word.charAt(w) - 'a'];
        }

        curr.isEnd = true;
    }

    public boolean search(String word) 
    {
        Trie curr = trie;

        System.out.println(Arrays.toString(curr.children));
        for(char w=0; w<word.length(); w++)
        {
            if(curr.children[word.charAt(w) - 'a'] == null) return false;
            curr = curr.children[word.charAt(w) - 'a'];
        }

        return curr.isEnd;
    }

    public boolean startsWith(String prefix) 
    {
        Trie curr = trie;
        for(char w=0; w<prefix.length(); w++)
        {
            if(curr.children[prefix.charAt(w) - 'a'] == null) return false;
            curr = curr.children[prefix.charAt(w) - 'a'];
        }

        return true;
    }
}
