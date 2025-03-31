public class LinkedinList<T> {
    private Node<T> top;
    private Node<T> bottom;
    private int size;

    public LinkedinList(){
        this.top = null;
        this.bottom = null;
        this.size = 0;
    }

    public void add(T data){
        var newNode = new Node<T>(data);
        if(this.top == null && this.bottom == null){
            this.top = newNode;
            this.bottom = newNode;
            this.size = 1;
        }
        else{
            this.bottom.setNext(newNode);
            newNode.setPrevious(this.bottom);
            this.top = newNode;     
            this.size++;      
        }
    }

    public Node<T> getNode(int index){
        checkIndex(index);
        if(index <= this.size / 2){
            var currentNode = this.bottom;
            for(int i = 0; i < index; i++){
                currentNode = currentNode.getNext();
            }
            return currentNode;
        }
        var currentNode = this.top;
        for(int i = this.size - 1; i > index; i--){
            currentNode = currentNode.getPrevious();
        }
        return currentNode;
    }

    public T get(int index){
        checkIndex(index);
        return getNode(index).getData();
    }

    public void add(T data, int index){
        checkIndex(index);
        var newNode = new Node<T>(data);
        var previousNode = index > 0 ? getNode(index-1) : null;
        var nextNode = getNode(index+1);
        newNode.setNext(nextNode);
        newNode.setPrevious(previousNode);
        previousNode.setNext(newNode);
        nextNode.setPrevious(newNode);
        if(index == 0) this.bottom = newNode;
        this.size++;
    }

    public void remove(int index){
        checkIndex(index);
        var previousNode = getNode(index-1);
        var nextNode = getNode(index+1);
        previousNode.setNext(nextNode);
        nextNode.setPrevious(previousNode);
        if(index == 0) this.bottom = nextNode;
        if(index == getSize() - 1) this.top = previousNode;
        this.size--;
    }

    public void remove(T data){
        var index = find(data);
        if(index != -1){
            remove(index);
        }
        this.size--;
    }

    public void set(T data, int index){
        checkIndex(index);
        var currentNode = getNode(index);
        currentNode.setData(data);
    }

    public int find(T data){
        if(isEmpty()) return -1;
        else{
            for(int i = 0; i < getSize(); i++){
                if(get(i).equals(data)){
                    return i;
                }
            }
            return -1;
        }
    }

    private boolean isEmpty(){
        return this.size == 0;
    }

    public int getSize(){ return this.size; }

    private void checkIndex(int index){
        if(index < 0 || index >= getSize()){
            throw new IndexOutOfBoundsException(
                "Index out of bounds"
            );
        }
    }
}
