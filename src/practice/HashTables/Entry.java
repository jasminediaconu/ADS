package practice.HashTables;

public class Entry {
    public final String key;
    public final String value;

    public Entry(String s, String v) {
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

    public String getValue() {
        return value;
    }
}