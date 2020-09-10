import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private Map<Integer, Node> map;
    int capacity;
    Node head;
    Node tail;
    class Node{
        int key;
        int value;
        Node next;
        Node prev;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = null;
        tail = null;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node cur = map.get(key);
            insert(remove(cur));
            return cur.value;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        Node check = map.get(key);
        if(check != null){
            insert(remove(check));
        }else{
            if(map.size() == capacity){
                map.remove(tail.key);
                remove(tail);
            }
            Node newNode = new Node(key, value);
            insert(newNode);
            map.put(key, newNode);
        }
    }
    
    private Node remove(Node node){
        if(node == null){
            return null;
        }
        if(node == head && head== tail) {
        	head = tail = null;
        	return node;
        }
        if(node == head){
            head = head.next;
        }else if(node == tail){
            tail = tail.prev;
        }else{
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        node.prev = null;
        node.next = null;
        return node;
    }
    
    private void insert(Node node){
        if(node == null){
            return;
        }
        if(head == null){
            head = tail = node;
            return;
        }
        node.next = head;
        head.prev = node;
        head = node;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache obj = new LRUCache(1);
		obj.put(1, 1);
		System.out.println(obj.get(1));
		obj.put(2, 2);
		
		obj.put(3, 3);
		System.out.println(obj.get(2));
	}

}
