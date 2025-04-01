public class Stack<T> {
    private Node<T> top;
    private int size;

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        if (!isEmpty()) {
            newNode.setNext(top);
            top.setPrevious(newNode);
        }
        top = newNode;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T data = top.getData();
        top = top.getNext();
        if (top != null) {
            top.setPrevious(null);
        }
        size--;
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.getData();
    }
}
