package practice.HashTables;

/**
 * HashTable open addressing with Double Hashing method.
 */
public class HashTableDH {
        public int capacity;
        public Entry[] table;

        /**
         * Constructs a new HashTable.
         *
         * @param capacity to be used as capacity of the table.
         * @throws IllegalArgumentException if the input capacity is invalid.
         */
        @SuppressWarnings("unchecked")
        public HashTableDH(int capacity) {
            if(capacity < 1) throw new IllegalArgumentException();
            this.capacity = capacity;

            table = new Entry[capacity];
        }

        /**
         * Find the bucket where to insert the entry with the Quadratic Probing algorithm.
         * @return
         */
        public int findBucket(String key) {
            if(key == null) return -1;
            int hashed = hash(key);

            for(int i = 0; i < this.capacity; i++) {
                int index = (hashed + i * hashed) % this.capacity;
                if(table[index] == null || table[index].getKey() == null || table[index].getKey().equals(key)) {
                    return index;
                }
            }

            return -1;
        }

        /**
         * Add a key value pair to the HashTable.
         *
         * @param key   to identify the value.
         * @param value that is identified by the key.
         */
        public boolean put(String key, String value) {
            int bucket = findBucket(key);

            if(bucket != -1) {
                Entry entry = new Entry(key, value);
                table[bucket] = entry;
                return true;
            }

            return false;
        }

        /**
         * Retrieve the value of the entry associated with this key.
         *
         * Returns null, if the key is null.
         *
         * @param key
         *     String representing the key of the entry to look for.
         * @return value of the entry as String iff the entry with this key is found in the hash table, else null.
         */
        public String get(String key) {
            int bucket = findBucket(key);
            if(bucket != -1 && table[bucket] != null && table[bucket].getKey() != null) return table[bucket].getValue();

            return null;
        }

        /**
         * Remove the entry associated with this key from the hash table.
         *
         * Returns false, if the key is null.
         *
         * @param key
         *     String representing the key of the entry to remove.
         * @return true iff the entry has been successfully removed, else false.
         */
        public boolean remove(String key) {
            int bucket = findBucket(key);

            if(bucket != -1 && table[bucket] != null && table[bucket].getKey() != null) {
                setDefunct(bucket);
                return true;
            }

            return false;
        }

        /**
         * Takes as input an index and sets the entry in that location as defunct.
         *
         * @param index
         *     The index of the spot that is defunct.
         */
        public void setDefunct(int index) {
            this.table[index] = new Entry(null, null);
        }

        /**
         * Hashes a string representing a key.
         *
         * @param key
         *     String that needs to be hashed.
         * @return the hashcode of the string, modulo the capacity of the HashTable.
         */
        public int hash(String key) {
            return Math.abs(key.hashCode()) % capacity;
        }
}
