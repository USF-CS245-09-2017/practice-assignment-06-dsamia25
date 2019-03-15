public class ArrayStack<T> implements Stack<T> {
    private Object[] tempArray;
    private T[] a;
    int index;

    public ArrayStack(){
        tempArray = new Object[10];
        a = (T[]) tempArray;
        index = 0;
    }

    public void push(T item) {
        if (index == a.length) {
            growArray();
        }
        a[index] = item;
        index++;
    }

    public T pop() {
        if (index == 0) {
            throw new IndexOutOfBoundsException("Nothing to pop");
        } else {
            T temp = a[index - 1];
            index--;
            return temp;
        }
    }

    public T peek() {
        if (index == 0) {
            throw new IndexOutOfBoundsException("Nothing to peek");
        } else {
            return a[index - 1];
        }
    }

    public boolean empty() {
        if (index == 0) {
            return true;
        }
        return false;
    }

    public void growArray() {
        Object[] tempObjectArray = new Object[2 * a.length];
        T[] temp = (T[]) tempObjectArray;
        for (int i = 0; i < a.length; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }
}
