// Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
//
// Implement the LRUCache class:
//
// LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
// int get(int key) Return the value of the key if the key exists, otherwise return -1.
// void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
// The functions get and put must each run in O(1) average time complexity.
//
//
//
// Example 1:
//
// Input
// ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
// [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
// Output
// [null, null, null, 1, null, -1, null, -1, 3, 4]
//
// Explanation
// LRUCache lRUCache = new LRUCache(2);
// lRUCache.put(1, 1); // cache is {1=1}
// lRUCache.put(2, 2); // cache is {1=1, 2=2}
// lRUCache.get(1);    // return 1
// lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
// lRUCache.get(2);    // returns -1 (not found)
// lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
// lRUCache.get(1);    // return -1 (not found)
// lRUCache.get(3);    // return 3
// lRUCache.get(4);    // return 4
//
//
// Constraints:
//
// 1 <= capacity <= 3000
// 0 <= key <= 10^4
// 0 <= value <= 10^5
// At most 2 * 10^5 calls will be made to get and put.






/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
class LRUCache {

    private Map<Integer, Integer> map;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<Integer, Integer>(capacity, 0.75F, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest)
            {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }
}
// Time : O(N)
// Space : O (N)






class LRUCache {

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
    }

    private void addNode(DLinkedNode node){
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node){
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;

        prev.next = next;
        next.prev = prev;
        node.next = null;
        node.prev = null;
    }

    private void moveToHead(DLinkedNode node){
        removeNode(node);
        addNode(node);
    }

    private DLinkedNode popTail(){
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int capacity;
    private int size;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        tail = new DLinkedNode();

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node == null){
            return -1;
        }
        moveToHead(node);
        return node.value;

    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);

        if(node == null){
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            cache.put(key, newNode);
            addNode(newNode);

            size++;

            if(size > capacity){
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
                size--;
            }
        } else{
            node.value = value;
            moveToHead(node);
        }
    }
}
// Time : O(1)
// Space : O(capacity)
