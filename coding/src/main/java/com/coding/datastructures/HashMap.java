package com.coding.datastructures;

import java.util.*;

public class HashMap<K, V> implements Map<K, V>{
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>(20);
        map.put("Volodymyr", "Derkach");
        map.put("Pavlo", "Polyakov");
        map.put("Sergey", "Brin");
        map.put("Lary", "Page");
        map.put("Garry", "Rassel");
        map.put("Vasyl", "Lomachenko");
        map.put("Anatoliy", "Lomachenko");
        for (String s : map.keySet()) {
            System.out.println(String.format("key; %s, value: %s", s, map.get(s)));
        }
    }

    private List<Entry<K, V>>[] entries;
    private int size = 0, capacity = 0;

    public HashMap(int capacity) {
        this.capacity = capacity;
        entries = new List[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        int h = key.hashCode();
        int basket = h % capacity;
        List<Entry<K, V>> list = entries[basket];
        V value = null;
        for (Entry<K, V> entry : list) {
            if (entry.getKey().equals(key)) {
                value = entry.getValue();
                break;
            }
        }
        return value;
    }

    @Override
    public V put(K key, V value) {
        MapEntry newEntry = new MapEntry(key, value);
        int h = key.hashCode();
        int basket = Math.abs(h % capacity);
        System.out.println(basket);
        List<Entry<K, V>> list = entries[basket];
        if (list == null) {
            list = new LinkedList<>();
        }
        V prevValue = null;
        for (Entry<K, V> entry : list) {
            V v = entry.getValue();
            if (entry.equals(newEntry)) {
                prevValue = v;
                entry.setValue(value);
                break;
            }
        }
        if (prevValue == null) {
            list.add(newEntry);
            size++;
        }
        return prevValue;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {
        entries = new List[capacity];
        size = 0;
    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    private class MapEntry implements Entry<K, V> {
        public MapEntry(K key, V value) {

        }

        @Override
        public K getKey() {
            return null;
        }

        @Override
        public V getValue() {
            return null;
        }

        @Override
        public V setValue(V value) {
            return null;
        }
    }
}
