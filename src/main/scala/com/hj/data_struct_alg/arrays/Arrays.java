package com.hj.data_struct_alg.arrays;

/**
 * @author hejin-Yu
 * @desc 自定义的数组
 */
public class Arrays<T> {
    /*
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *
     * Java中 数组，先开辟 内存存储空间
     * 再往空间里存值
     *
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    private T[] data; //存储数据的空间
    private int size; // 空间中的实际存放元素个数

    public Arrays(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public Arrays() {
        this(10);
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    /*
     * ~~~~~~~~~~~~~~~~~~~~~~
     * 内存存储空间，容量不足，自动扩容
     * 实际存储元素个数及其有限，避免内存浪费，自动减容
     * ~~~~~~~~~~~~~~~~~~~~~~
     */
    private void reSize() {

        if (size == getCapacity()) {
            resetData(getCapacity() * 2);
        }
        //size减小之后如果到了四分之一长度，那就缩容为原来容量的一半，但是同时要注意 data.length/2不是0
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resetData(getCapacity() / 2);
        }
    }

    private void resetData(int newCapacity) {
        T[] newArray = (T[]) new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            newArray[i] = data[i];
        }
        data = newArray;
    }

    /**
     * 索引号，校验
     * 不能小于0 ，也不能跨索引
     *
     * @param index
     */
    private void validIndex(int index) {
        if (index < 0 || index > size) {
            throw new RuntimeException("add failed: illegal index");
        }
    }

    public void add(int index, T t) {
        validIndex(index);
        reSize();
        /*
         * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
         *
         * 重置其他元素
         *
         * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
         */

       /* for(int i=index+1;i<size;i++){

            需要从高位开始移动元素
            data[i]=data[i+1];
        }*/

       for(int i=size-1;i>=index;i--){
           data[i+1] =data[i];
       }

        data[index]=t;
        size ++;

    }

    public void addFirst(T t) {
        add(0, t);
    }

    public void addLast(T t) {
        add(size, t);
    }

    /**
     * find it, return it's index
     * otherwise,return -1
     *
     * @param t
     * @return
     */
    public int find(T t) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(t)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * if Contained,then return true
     *
     * @param t
     * @return
     */
    public boolean isContain(T t) {
        return find(t) != -1;
    }

    public T get(int index) {
        return data[index];
    }

    public T getFirst() {
        return data[0];
    }

    public T getLast() {
        return data[size - 1];
    }

    /*
     * ~~~~~~~~~~~~~~~~~~~~~~
     * 数据弹出
     * 返回该索引号 对应的元素
     * 且
     * remove it from current Array
     * ~~~~~~~~~~~~~~~~~~~~~~
     */
    public T pop(int index) {
        if (isEmpty()) return null;
        T rs = data[index];

        data[index] = null;
        size--;
        return rs;
    }

    public T popFirst() {
        return pop(0);
    }

    public T popLast() {
        return pop(size - 1);
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder("[");

        for (int i = 0; i < size; i++) {
            builder.append(data[i]).append("\t");
        }

        return builder.substring(0, builder.length() - 1) + "]";
    }
}
