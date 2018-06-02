public int[] exclusiveTime(int n, List<String> logs) {
        int[] time = new int[n];
        int[] acc = new int[n];
        
        List<String> stack = new ArrayList<>();
        
        for (int i = 0; i < logs.size(); i++){
            String s = logs.get(i);
            if (s.indexOf("start") != -1){
                stack.add(s);
            }
            else{
                int index = getIndex(s);
                int end = getTime(s);
                String prev = stack.remove(stack.size()-1);
                int start = getTime(prev);
                int gap = end - start - acc[index] + 1;
                time[index] += gap;
                
                if (stack.size() > 0){
                    int parentIdx = getIndex(stack.get(stack.size()-1));
                    acc[parentIdx] += gap;
                    if (parentIdx != index){
                        acc[parentIdx] += acc[index] ;
                        acc[index] = 0;
                    }
                }
                
            }
        }
        return time;
    }
    
    public int getIndex(String s){
        return Integer.valueOf(s.split(":")[0]);
    }
    
    public int getTime(String s){
        return Integer.valueOf(s.split(":")[2]);
    }