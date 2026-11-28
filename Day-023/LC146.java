class LRUCache {
    LinkedHashMap<Integer,Integer> map;
    int cap;

    public LRUCache(int capacity) {
        map = new LinkedHashMap<>();
        cap = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        int val = map.remove(key);
        map.put(key,val);
        return map.get(key);
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            int val = map.remove(key);
            map.put(key,value);
        } else {
            map.put(key, value);
        }
        if(map.size() > cap) {
            map.pollFirstEntry();
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */