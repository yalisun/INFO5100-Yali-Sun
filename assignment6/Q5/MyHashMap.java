package assignment6.Q5;

public class MyHashMap {

	private Integer[] data;

	public MyHashMap() {
		data = new Integer[1000001];
	}

	public void put(int key, int value) {
		data[key] = value;
	}

	public int get(int key) {
		if (data[key] == null) {
			return -1;
		}
		return data[key];
	}

	public void remove(int key) {
		data[key] = null;
	}

	public static void main(String[] args) {
		MyHashMap hashMap = new MyHashMap();
		hashMap.put(1, 1);
		hashMap.put(2, 2);
		System.out.println(hashMap.get(1));            // returns 1
		System.out.println(hashMap.get(3));            // returns -1 (not found)
		hashMap.put(2, 1);          // update the existing value
		System.out.println(hashMap.get(2));            // returns 1
		hashMap.remove(2);          // remove the mapping for 2
		System.out.println(hashMap.get(2));            // returns -1 (not found)
	}
}
