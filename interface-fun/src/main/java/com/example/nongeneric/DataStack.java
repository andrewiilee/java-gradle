package com.example.nongeneric;

import com.example.generic.Node;

public class DataStack {
    DataNode top;

    public DataStack() {
        this.top = null;
    }

    public void push (Data item) {
        DataNode insert = new DataNode(item, null);

        if (top == null) {
            top = insert;
        } else {
            insert.setNext(top);
            top = insert;
        }
    }

    public Data peek() {
        return top.getData();
    }

    public Data pop() {
        Data retValue = top.getData();
        top = top.getNext();
        return retValue;
    }
}
