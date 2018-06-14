public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int[] DP = new int[s.length()];
        Arrays.fill(DP, -1);
        //return wordBreakHelper(s, 0, wordSet, DP) == 1? true:false;
        
        return wordBreakStack(s, wordSet, DP) == 1? true:false;
    }
    
    public int wordBreakHelper(String s, int i, Set<String> wordSet, int[] DP){
        if (i == s.length()) return 1;
        if (DP[i] != -1) return DP[i];
        
        DP[i] = 0;
        String word = "";
        for (int j = i; j < s.length(); j++){
            word += s.charAt(j);
            if (wordSet.contains(word) && wordBreakHelper(s, j + 1, wordSet, DP) == 1){
                DP[i] = 1;
                break;
            }
        }
        return DP[i];       
    }
    
    public int wordBreakStack(String s, Set<String> wordSet, int[] DP){
        
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while (!stack.empty()){
            int index = stack.pop();
            if (index == s.length())
                return 1;
            if (DP[index] ==-1){
                String word = "";
                for (int i = index; i < s.length(); i++){
                    word += s.charAt(i);
                    if (wordSet.contains(word)){
                        stack.push(i+1);
                    }
                }
                
                DP[index] = 0;
            }
           
        }
        
        return 0;
    }