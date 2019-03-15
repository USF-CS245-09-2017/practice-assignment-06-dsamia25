public class ArrayQueue<T> implements Queue<T> {
    private Object[] tempArray;
    private T[] a;
    int head = 0;
    int tail = 0;

    public ArrayQueue() {
        tempArray = new Object[10];
        a = (T[]) tempArray;
    }

    public T dequeue() {
        if (head >= tail) {
            throw new IndexOutOfBoundsException("There is nothing to dequeue");
        } else {
            T temp = a[head];
            head++;
            return temp;
        }
    }

    public void enqueue(T item) {
        if (tail == a.length - 1) {
            growArray();
        }
        a[tail] = item;
        tail++;
    }

    public boolean empty() {
        if (head == tail) {
            return true;
        } else {
            return false;
        }
    }

    public void growArray() {
        Object[] tempObjectArray = new Object[2 * a.length];
        T[] temp = (T[]) tempObjectArray;
        int tempIndex = 0;
        for (int i = head; i < a.length; i++) {
            temp[tempIndex] = a[i];
            tempIndex++;
        }
        head = 0;
        tail = tempIndex - 1;
        a = temp;
    }
}
