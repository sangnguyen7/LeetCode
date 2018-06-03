public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;
        
        int[] c = getTasksFreq(tasks);
        
        int interval = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        
        int count = 0;
        
        while (count < tasks.length){
            int index = getNextExecuteTask(c, set);
            
            queue.add(index);
            
            interval++;
            
            if (index < 26){
                count++;
                set.add(index);
                c[index]--;
            }
            
            if (queue.size() > n){
                int done = queue.poll();
                set.remove(done);
            }
        }
        
        return interval;
    }
    
    public int getNextExecuteTask(int[] c, Set<Integer> set){
        
        int index = 26;
        
        for (int i = 0; i < 26; i++){
            
            if (!set.contains(i) && c[i] > c[index]){
                index = i;
            }
            
        }
        
        return index;
    }
    
    
    public int[] getTasksFreq(char[] tasks){
        
        int[] freq = new int[27];
        
        for (char c: tasks){
            freq[c-'A']++;
        }
        
        return freq;
    }