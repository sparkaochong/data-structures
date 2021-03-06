package com.ac.array;

/**
 * Description:
 * <p>
 * Created by aochong on 2020/4/16
 *
 * @author aochong
 * @version 1.0
 */
public class Array {

    private int[] data;
    private int size;

    /**
     * 构造函数，传入数组的容量capacity构造Array
     * @param capacity
     */
    public Array(int capacity){
        this.data = new int[capacity];
        size = 0;
    }

    /**
     * 无参数构造函数，默认数组的容量capacity=10
     */
    public Array(){
        this(10);
    }

    /**
     * 获取数组中的元素个数
     * @return 元素的个数
     */
    public int getSize(){
        return size;
    }

    /**
     * 获取数组的容量
     * @return 数组的容量
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 返回数组是否为空
     * @return true/false
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 往数组中最后插入一个元素
     * @param e 插入的元素
     */
    public void addLast(int e){
        add(size,e);
    }

    /**
     * 往数组中第一个位置插入一个元素
     * @param e 插入的元素
     */
    public void addFirst(int e){
        add(0,e);
    }

    /**
     * 往数组指定位置插入元素
     * @param index 位置
     * @param e 插入的元素
     */
    public void add(int index, int e){
        if(data.length==size){
            throw new IllegalArgumentException("AddLast failed. Array is full.");
        }
        if(index<0 || index>size){
            throw new IllegalArgumentException("AddLast failed. Require index >= 0 and index <= size.");
        }
        for(int i=size-1;i>=index;i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 获取index索引位置的元素
     * @param index 索引下标
     * @return data[index]
     */
    int get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    /**
     * 修改index索引位置的元素
     * @param index 索引下标
     * @param e 需要修改的值
     */
    void set(int index,int e){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        data[index] = e ;
    }

    /**
     * 查找数组中是否有元素e
     * @param e 查找的元素
     * @return true/false
     */
    public boolean contains(int e){
        for(int i=0;i<size;i++){
            if(data[i] == e){
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
     * @param e 需要朝招的元素
     * @return index
     */
    public int find(int e){
        for(int i=0;i<size;i++){
            if(data[i] == e){
                return i;
            }
        }
        return -1;
    }

    /**
     * 查找数组中所有元素e出现的索引
     * @param e 需要查找的元素
     * @return Array
     */
    public Array findAll(int e){
        Array arr = new Array(20);

        for(int i=0;i<size;i++){
            if(data[i] == e){
                arr.addLast(i);
            }
        }
        return arr;
    }

    /**
     * 从数组中删除index位置的元素，返回删除的元素
     * @param index 需要删除元素的索引
     */
    public int remove(int index){
        if(index<0 || index>=size){
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }
        int ret = data[index];
        for(int i=index+1;i<size;i++){
            data[i-1] = data[i];
        }
        size--;
        return ret;
    }

    /**
     * 从数组中删除第一个元素，返回删除的元素
     * @return 删除的元素
     */
    public int removeFirst(){
        return remove(0);
    }

    /**
     * 从数组中删除最后一个元素，返回删除的元素
     * @return
     */
    public int removeLast(){
        return remove(size-1);
    }

    /**
     * 从数组中删除元素e
     * @param e 需要删除的元素
     */
    public void removeElement(int e){
        int index = find(e);
        if(index != -1){
            remove(index);
        }
    }

    /**
     * 从数组中删除所有元素e
     * @param e 需要删除的元素
     */
    public void removeAllElement(int e){
        int index = find(e);
        while(index != -1){
            remove(index);
            index = find(e);
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array: size = %d, capacity = %s\n", size, data.length));
        sb.append('[');
        for(int i=0;i < size;i++){
            sb.append(data[i]);
            if(i != size - 1){
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
