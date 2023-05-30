public class Main {
    public static void main(String[] args) {
        SegmentTreeTesting testing = new SegmentTreeTesting();
        System.out.println("--- Sum query test ---");
        testing.sumTest();
        System.out.println("--- Update value test ---");
        testing.updateTest();
    }
}