public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        
        RandomListNode copyHead = new RandomListNode(head.label);
        map.put(head, copyHead);
        RandomListNode p = head.next;
        RandomListNode cp = copyHead;
        
        while(p!=null){
            RandomListNode copy = new RandomListNode(p.label);
            cp.next = copy;
            cp = copy;
            map.put(p, copy);
            p = p.next;
        }
        
        p = head;
        
        while (p!=null){
            cp = map.get(p);
            if (p.random != null){
                cp.random = map.get(p.random);
            }
            p = p.next;
        }
        
        return copyHead;
    }