class Solution {
    public int countSubstrings(String s) {
        if (s.length() < 2) return s.length();
        
        char[] c = s.toCharArray();
        int n = c.length;
        
        int count = n;
        
        for (int i = 1; i < n; i++){
            count += countPalindrome(c, i-1, i) + countPalindrome(c, i-1, i+1);
        }
        
        return count;
    }
    
    public int countPalindrome(char[] c, int i, int j){
        int count = 0; 
        
        while (i >=0 && j < c.length && c[i] == c[j]){
            count++;
            i--;
            j++;
        }
        
        return count;
    }
}