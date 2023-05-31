public class Main {
    public static void main(String[] args) {
        SegmentTreeTesting testing = new SegmentTreeTesting();
        System.out.println("--- Sum query test ---");
        testing.sumTest();
        System.out.println("--- Update value test ---");
        testing.updateTest();
        System.out.println("--- Average time of sum query test ---");
        testing.averageTimeSumTest();
        System.out.println("--- Average time of update value test ---");
        testing.averageTimeUpdateTest();
    }
}