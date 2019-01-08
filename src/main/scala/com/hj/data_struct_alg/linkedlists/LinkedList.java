package com.hj.data_struct_alg.linkedlists;

/**
 * @author hejin-Yu
 * @desc 每个节点，都有一个后继
 */
public class LinkedList<T> {

    private class Node {
        private T t;
        private Node next;

        public Node(T t, Node next) {
            this.t = t;
            this.next = next;
        }

        public Node(T t) {
            this(t, null);
        }

        public Node() {
            this(null, null);
        }
    }


    private Node head;
    private int size;

    public LinkedList() {

        head = new Node();
        size =0;
    }

    public int getSize() {
        return size;
    }

    public void add(int index, T t) {
        if (index < 0 || index > size) {
            throw new RuntimeException("索引号有误");
        }

        /**
         * 在index处寻找上个节点
         * 确定上个节点后，重新构建后继
         */
        Node pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        /*
         * ~~~~~~~~~~~~~~~~~~~~~~
         * 重新定义上个节点的后继 为本节点
         * 本节点的后继，为上个节点的后继 -----------可以引入第三者，来思考这个 add 操作
         * ~~~~~~~~~~~~~~~~~~~~~~
         */
        pre.next = new Node(t, pre.next);
        size++;
    }

    public void addFisrt(T t) {
        add(0, t);
    }

    public void addLast(T t) {
        add(size, t);
    }

    public T remove(int index) {
        /*
         * ~~~~~~~~~~~~~~~~~~~~~~
         * 打散，重组， 当前索引号的元素，移除
         *
         * 上个节点的后继 指向 当前节点的后继
         *
         * size --
         * ~~~~~~~~~~~~~~~~~~~~~~
         */

        Node pre =head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        Node cur =pre.next;
        T rs =cur.t;

        pre.next = cur.next;

        cur =null;
        size --;

        return rs;
    }

    public T removeFirst(){
        return remove(0);
    }
    public T removeLast(){
        return remove(size-1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        Node cur = head.next;
        while(cur != null){
            res.append(cur.t + "->");
            cur = cur.next;
        }
        res.append("NULL");

        return res.toString();
    }
}
