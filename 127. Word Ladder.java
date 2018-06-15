public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        if (beginWord.equals(endWord)) return 1;
        
        Map<String, Integer> map = new HashMap<>();
        
        for (String s : wordList){
            map.put(s, -1);
        }
        
        if (!map.containsKey(endWord)) return 0;
        
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        map.put(beginWord, 1);
        
        while (!queue.isEmpty()){
            String s = queue.poll();
            if (s.equals(endWord)) return map.get(s);
            
            List<String> transWords = getTransformedWords(s, map);
            
            queue.addAll(transWords);
        }
        
        return 0;
    }
    
    public List<String> getTransformedWords(String s, Map<String, Integer> map){
        List<String> result = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i++){
            for (int j = 0; j < 26; j++){
                char c = (char)(j + 'a');
                String transWord = s.substring(0,i) + c + s.substring(i+1);
                if (map.containsKey(transWord) && map.get(transWord) == -1){
                    result.add(transWord);
                    map.put(transWord, map.get(s) + 1);
                }
            }
        }
        
        return result;
    }