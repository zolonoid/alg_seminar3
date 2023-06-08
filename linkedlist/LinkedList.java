package linkedlist;

import java.util.Iterator;

/**
 * Класс LinkedList является односвязным списком.
 */
public class LinkedList<T> implements Iterable<T> {
    private int size = 0;
    private ListNode<T> head;
    private ListNode<T> tail;

    public void add(T node) {
        var newNode = new ListNode<T>(node);
        if (size == 0) {
            tail = head = newNode;
        } else {
            ListNode<T> temp = tail;
            tail = newNode;
            temp.next(newNode);
        }
        size++;
    }

    // Задание 1.
    // Метод разворота связного списка.
    public void reverse() {
        if (size < 2)
            return;
        ListNode<T> current = head;
        ListNode<T> next = head.next();
        head = tail;
        tail = current;
        while (next != null) {
            ListNode<T> temp = next.next();
            next.next(current);
            current = next;
            next = temp;
        }
        tail.next(null);
    }

    // Задание 2.
    // Получить n-е число с конца односвязного списка, предварительно не узнавая его
    // размер. В данном случае размер вычисляется заранее при добавлении нового
    // элемента в список.
    public T getEnd(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        ListNode<T> node = head;
        for (int i = size - index - 1; i > 0; i--) {
            node = node.next();
        }
        return node.value();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<T> {
        private ListNode<T> nextNode;

        public Iter() {
            nextNode = head;
        }

        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        @Override
        public T next() {
            T value = nextNode.value();
            nextNode = nextNode.next();
            return value;
        }
    }
}
