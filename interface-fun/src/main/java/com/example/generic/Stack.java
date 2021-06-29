package com.example.generic;

public class Stack<T> {

    Node<T> top;

    public Stack() {
        this.top = null;
    }

    public void push (T item) {
        Node<T> insert = new Node<>(item, null);

        if (top == null) {
            top = insert;
        } else {
            insert.setNext(top);
            top = insert;
        }
    }

    public T peek() {
        return top.getData();
    }

    public T pop() {
        T retValue = top.getData();
        top = top.getNext();
        return retValue;
    }
}
