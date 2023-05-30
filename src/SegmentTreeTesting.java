public class SegmentTreeTesting {
    public void sumTest() {
        for (int i = 1; i <= 50; i++) {
            int arraySize = i * 100000;
            int[] array = new int[arraySize];
            SegmentTree st = new SegmentTree(array);
            int l = (int) (Math.random() * arraySize / 2);
            int r = (int) (Math.random() * arraySize / 2 + arraySize / 2);
            st.sum(l, r);
            System.out.printf("%d %d\n", arraySize, st.iterations);
        }
    }
    public void updateTest() {
        for (int i = 1; i <= 50; i++) {
            int arraySize = i * 100000;
            int[] array = new int[arraySize];
            SegmentTree st = new SegmentTree(array);
            int index = (int) (Math.random() * arraySize);
            int newValue = (int) (Math.random() * 10000 + 1);
            st.update(index, newValue);
            System.out.printf("%d %d\n", arraySize, st.iterations);
        }
    }
}
