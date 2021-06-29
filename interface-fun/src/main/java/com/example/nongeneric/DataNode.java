package com.example.nongeneric;

public class DataNode {
    private Data data;
    private DataNode next;

    public DataNode(Data data, DataNode next) {
        this.data = data;
        this.next = next;
    }


    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public DataNode getNext() {
        return next;
    }

    public void setNext(DataNode next) {
        this.next = next;
    }
}
