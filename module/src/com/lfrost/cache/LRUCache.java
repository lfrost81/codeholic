package com.lfrost.cache;

import java.util.HashMap;

public class LRUCache {
	private int maxSize;
	private int curSize = 0;
	private CacheItem head = new CacheItem(-1, null);
	private CacheItem tail = new CacheItem(-2, null);
	private HashMap<Integer, CacheItem> lookup = new HashMap<Integer, CacheItem> ();
	
	public LRUCache(int maxSize) {
		this.maxSize = maxSize;
		head.next = tail;
		head.prev = null;
		tail.prev = head;
		tail.next = null;
	}
	
	public CacheItem pop(CacheItem item) {
		item.prev.next = item.next;
		item.next.prev = item.prev;
		return item;
	}
	
	public void push(CacheItem prev, CacheItem item) {
		prev.next.prev = item;
		item.next = prev.next;
		prev.next = item;
		item.prev = prev;
	}
	
	public CacheItem access(int id) {
		CacheItem item = null;
		if( lookup.containsKey(id) ) {
			item = lookup.get(id);
			item = pop(item);
			push(head, item);
		}
		else {
			item = new CacheItem(id, null);
			push(head, item);

			if( curSize >= maxSize ) {
				lookup.remove(tail.prev.id);
				pop(tail.prev);
			}
			else {
				curSize++;
			}
			lookup.put(id, item);
		}

		return item;
	}
	
	public void view() {
		CacheItem cur = head;
		while(cur.next != tail) {
			cur = cur.next;
			System.out.print(String.format("%d\t", cur.id));
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(4);
		// add 4 item to be full
		cache.access(1);
		cache.access(2);
		cache.access(3);
		cache.access(4);

		// re access 2 items
		cache.access(1);
		cache.access(3);

		// access new 2 items, then 6, 5, 3, 1 will be remainder
		cache.access(5);
		cache.access(6);
		cache.access(6);
		cache.access(6);
		cache.access(6);
		cache.access(6);
		cache.access(6);
		cache.access(6);
		cache.access(5);
		cache.access(1);
		cache.access(2);
		
		cache.view();
	}
}

class CacheItem {
	public CacheItem(int id, byte[] data) {
		this.id = id;
		this.data = data;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(id);
		return sb.toString();
	}
	
	int id;
	byte[] data;
	CacheItem prev;
	CacheItem next;
}
