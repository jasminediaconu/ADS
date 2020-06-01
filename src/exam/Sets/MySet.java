package exam.Sets;

import java.util.*;

public class MySet extends HashSet<String> {
    private static final long serialVersionUID = 1L;

    public MySet() {
        super();
    }

    /**
     * @return the union of the elements of this and that
     */
    public MySet union(MySet that) {
        MySet result = new MySet();

        for(String e : this) {
            if(!result.contains(e)) result.add(e);
        }

        if(that != null && !that.isEmpty()) {
            for(String e : that) {
                if(!result.contains(e)) result.add(e);
            }
        }

        return result;
    }

    /**
     * @return the intersection of the elements of this and that
     */
    public MySet intersection(MySet that) {
        MySet result = new MySet();

        if(that != null && !that.isEmpty()) {
            for(String e : this) {
                if(that.contains(e) &&
                        !result.contains(e)) result.add(e);
            }
        }

        return result;
    }

    /**
     * @return the difference of the elements of this and that
     */
    public MySet difference(MySet that) {
        MySet result = new MySet();

        if(that == null || that.isEmpty()) {
            for (String e : this) {
                if (!result.contains(e)) result.add(e);
            }
        } else {
            for (String e : this) {
                if (!that.contains(e) &&
                        !result.contains(e)) result.add(e);
            }
        }

        return result;
    }

    /**
     * @return the exclusive or (XOR) of the elements of this and that
     */
    public MySet exclusiveOr(MySet that) {
        MySet result = new MySet();

        if(that == null || that.isEmpty()) {
            for (String e : this) {
                if (!result.contains(e)) result.add(e);
            }
        } else {
            for (String e : this) {
                if (!that.contains(e) &&
                        !result.contains(e)) result.add(e);
            }

            for (String s : that) {
                if (!this.contains(s) &&
                        !result.contains(s)) result.add(s);
            }
        }

        return result;
    }

    /**
     * @return a String representation of a MySet object
     *
     * <MySet{Delft,Rotterdam,Leiden}>
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if(!(this == null && this.isEmpty())) {
            for (String e : this) {
                sb.append(e + ",");
            }
        }

        sb.deleteCharAt(sb.length()-1);

        return "<MySet{" + sb + "}>";
    }
}
