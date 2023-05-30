import java.util.Arrays;

public class SegmentTree {
    // Дерево отрезков позволяет за O(log n) выполнить ассоциативную операцию (сумма, умножение,
    // нахождение НОД, мин, макс) на некотором отрезке массива
    // реализация всех операций сверху - вниз
    // 1. запрос суммы на отрезке; (+) (+) 2. построение дерева; (+) 3. обновление элемента массива
    int[] tree; // дерево отрезков
    int[] arr; // массив, поданный на вход
    public SegmentTree(int[] a) {
        // подготовка к построению дерева: для удобства расширяем длину массива до ближайшей
        // степени двойки
        // длина массива-дерева - 2 * arr.length - 1
        int extendedLength = (int) Math.pow(2, log2(a.length));
        arr = Arrays.copyOf(a, extendedLength);
        tree = new int[2 * arr.length - 1];
        build( 0, 0, arr.length);
    }

    public int sum(int l, int r) {
        // sum [l; r)
        return sum(l, r, 0, 0, arr.length);
    }
    private int sum(int l, int r, int nodeNum, int leftBound, int rightBound) {
        if (leftBound >= r || rightBound <= l) {
            return 0; // возвращаем нейтральный элемент ассоциативной операции
        }
        if (leftBound <= l || r <= rightBound) {
            return tree[nodeNum];
        }
        int middle = (leftBound + rightBound) / 2;
        int leftChildSum = sum(l, r, 2 * nodeNum + 1, leftBound, middle);
        int rightChildSum = sum(l, r, 2 * nodeNum + 2, middle, rightBound);
        return leftChildSum + rightChildSum;
    }
    public void update(int index, int newValue) {
        arr[index] = newValue;
        update(index, newValue, 0, 0, arr.length);

    }
    private void update(int index, int newValue, int nodeNum, int leftBound, int rightBound) {
        if (rightBound - leftBound == 1) {
            tree[leftBound] = newValue;
            return;
        }
        int middle = (leftBound + rightBound) / 2;
        if (index < middle) {
            update(index, newValue, 2 * nodeNum + 1, leftBound, middle);
        } else {
            update(index, newValue, 2 * nodeNum + 2, middle, rightBound);
        }
        tree[nodeNum] = tree[2 * nodeNum + 1] + tree[2 * nodeNum + 2];
    }
    private void build(int nodeNum, int leftBound, int rightBound) {
        // вершина с номером nodeNum хранит в себе сумму на полуинтервале [leftBound; rightBound)
        if (rightBound - leftBound == 1) {
            tree[nodeNum] = arr[leftBound];
            return;
        }
        int middle = (leftBound + rightBound) / 2;
        build(2 * nodeNum + 1, leftBound, middle); // строим дерево отрезков для левого потомка
        build( 2 * nodeNum + 2, middle, rightBound); // для правого потомка

    }
    private int log2(int x) {
        // возвращает двоичный логарифм от числа, округленный вверх
        return (int) Math.ceil(Math.log10(x) / Math.log10(2));
    }
}
