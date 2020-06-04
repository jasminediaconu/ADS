package practice.MergeSort;

/**
 * Bottom-up (non-recursive) version of MergeSort.
 * This version runs in 0(n log n), faster than the recursive
 * version as it avoids the extra overheads of recursive calls and
 * temporary memory at each level.
 */
public class MergeSortNonRecursive {
    public static void merge(int[] in, int[] out, int start, int inc) {
        int firstEnd = Math.min(start + inc, in.length);
        int secondEnd = Math.min(start + 2 * inc, in.length);
        int x = start;
        int y = start + inc;
        int z = start;

        while (x < firstEnd && y < secondEnd) {
            if(in[x] < in[y])
                out[z++] = in[x++];
            else
                out[z++] = in[y++];
        }

        if(x < firstEnd) System.arraycopy(in, x, out, z, firstEnd - x);
        else if(y < secondEnd) System.arraycopy(in, y, out, z, secondEnd - y);
    }

    public static void mergeSortBottomUp(int[] origin) {
        if(origin == null || origin.length < 2) return;

        int n = origin.length;
        int[] src = origin;
        int[] dest = new int[n];
        int[] temp;

        for(int i = 1; i < n; i *= 2) {
            for(int j = 0; j < n; j += 2 * i)
                merge(src, dest, j, i);
            temp = src;
            src = dest;
            dest = temp;
        }

        if(origin != src) System.arraycopy(src, 0 , origin, 0, n);
    }
}
