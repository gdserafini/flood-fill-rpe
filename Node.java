public class Node<T> {
    private T data;
    private Node<T> next;
    private Node<T> previous;

    public Node(T data){
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    public void setNext(Node<T> next){
        this.next = next;
    }

    public void setPrevious(Node<T> previous){
        this.previous = previous;
    }

    public Node<T> getNext(){
        return this.next;
    }

    public Node<T> getPrevious(){
        return this.previous;
    }

    public T getData(){
        return this.data;
    }

    public void setData(T data){
        this.data = data;
    }
}
