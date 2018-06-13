public List<String> letterCombinations(String digits) {
        if (null == digits || "".equals(digits)){
            return new ArrayList<>();
        }
        String[] letters = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        return letterCombinationsHelper(digits, letters);
    }
    
    public List<String> letterCombinationsHelper(String digits, String[] letters){
        List<String> result = new ArrayList<>();
        if (null == digits || "".equals(digits)){
            result.add("");
            return result;
        }
        
        int digit = digits.charAt(0) - '0';
        List<String> suffix = letterCombinationsHelper(digits.substring(1), letters);
        
        for (int i = 0; i < letters[digit].length(); i++){
            char letter = letters[digit].charAt(i);
            for (String s : suffix){
                result.add(letter + s);
            }
        }
        
        return result;
    }