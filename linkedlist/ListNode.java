package linkedlist;

class ListNode<T> {
    private T value;
    private ListNode<T> nextNode;

    public ListNode(T value) {
        this.value = value;
    }

    public T value() {
        return value;
    }

    public ListNode<T> next() {
        return nextNode;
    }

    public void next(ListNode<T> node) {
        nextNode = node;
    }
}
