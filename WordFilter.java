/**
 * @link:https://leetcode.com/problems/prefix-and-suffix-search/
 Given many words, words[i] has weight i.

Design a class WordFilter that supports one function, WordFilter.f(String prefix, String suffix). It will return the word with given prefix and suffix with maximum weight. If no word exists, return -1.

Examples:
Input:
WordFilter(["apple"])
WordFilter.f("a", "e") // returns 0
WordFilter.f("b", "") // returns -1
 */
class WordFilter {
    String[] words;
    public WordFilter(String[] words) {
        this.words = words;
    }
    
    public int f(String prefix, String suffix) {
        int ind = -1;
        for(int i=words.length-1;i>=0;i--){
            String s = words[i];
            if(s.length() >= prefix.length() && s.length() >= suffix.length() && isEqual(prefix, suffix, s)){
                ind = i;
                break;
            }
        }
        return ind;
    }
    private boolean isEqual(String pre, String suf, String s){
        for(int i=0;i<pre.length();i++){
            if(pre.charAt(i) != s.charAt(i)){
                return false;
            }
        }
        int ind = s.length()-1;
        for(int i=suf.length()-1;i>=0;i--){
            if(suf.charAt(i) != s.charAt(ind--)){
                return false;
            }
        }
        return true;
        //return prefix.equals(s.substring(0, prefix.length())) && suffix.equals(s.substring(s.length()-suffix.length(), s.length())) ;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */