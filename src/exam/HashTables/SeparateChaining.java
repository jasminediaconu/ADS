package exam.HashTables;

import java.util.LinkedList;

class Entry {
    public final String key;
    public final Integer value;

    public Entry(String s, Integer v) {
        key = s;
        value = v;
    }

    public boolean equals(String s) {
        return s == null && key == null || key.equals(s);
    }

    @Override
    public boolean equals(Object o) {
        return this == o || o != null && getClass() == o.getClass() && this.equals(((Entry) o).key);
    }

    public String getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }
}

abstract class HashTable {
    protected LinkedList<Entry>[] myTable;

    /**
     * Constructs a new HashTable.
     *
     * @param capacity to be used as capacity of the table.
     * @throws IllegalArgumentException if the input capacity is invalid.
     */
    @SuppressWarnings("unchecked")
    public HashTable(int capacity) {
        if (capacity < 1) throw new IllegalArgumentException();

        myTable = new LinkedList[capacity];

        for (int i = 0; i < capacity; i++) {
            myTable[i] = new LinkedList<>();
        }
    }

    /**
     * Add a key value pair to the HashTable.
     *
     * @param key   to identify the value.
     * @param value that is identified by the key.
     */
    public void put(String key, Integer value) {
        int hashed = hash(key);

        //if(myTable[hashed] == null) return;

        myTable[hashed].add(new Entry(key, value));
    }

    /**
     * @param key to look for in the HashTable.
     * @return true iff the key is in the HashTable.
     */
    public boolean containsKey(String key) {
        int hashed = hash(key);

        for (Entry e : myTable[hashed]) {
            if (e.getKey().equals(key))
                return true;
        }

        return false;
    }

    /**
     * Get a value from the HashTable.
     *
     * @param key that identifies the value.
     * @return the value associated with the key or `null` if the key is not in the HashTable.
     */
    public Integer get(String key) {
        int hashed = hash(key);

        int value = 0;
        boolean flag = false;

        if (myTable[hashed] != null) {
            for (Entry e : myTable[hashed]) {
                if (e.getKey().equals(key))
                    flag = true;
                value = e.getValue();
            }
        }

        return flag ? value : null;
    }

    /**
     * @return the capacity of the HashTable.
     */
    public int getCapacity() {
        return myTable.length;
    }

    /**
     * Hashes a string/key.
     *
     * @param item to hash.
     * @return the hashcode of the string, modulo the capacity of the HashTable.
     */
    public abstract int hash(String item);
}
