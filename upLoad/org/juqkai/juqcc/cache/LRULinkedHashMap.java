package org.juqkai.juqcc.cache;

import java.util.LinkedHashMap;

public class LRULinkedHashMap<K, V> extends LinkedHashMap<K, V> {
	private final Integer maxCapacity;
	private static final float DEFAULT_LOAD_FACTOR = 0.75f;   
	
	public LRULinkedHashMap(Integer maxCapacity) {
		super(maxCapacity, DEFAULT_LOAD_FACTOR, true);
		this.maxCapacity = maxCapacity;
	}
	
	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
		return size() > maxCapacity; 
	}
}
