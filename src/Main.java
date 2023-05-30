import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a = new int[] {1, 2, 3, 4, 5};
        SegmentTree st = new SegmentTree(a);
        System.out.println(Arrays.toString(st.tree));
    }
    private static double log2(int x) {
        // возвращает двоичный логарифм от числа, округленный вверх
        return Math.ceil(Math.log10(x) / Math.log10(2));
    }
}