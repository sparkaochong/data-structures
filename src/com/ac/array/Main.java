package com.ac.array;

/**
 * Description:
 * <p>
 * Created by aochong on 2020/4/16
 *
 * @author aochong
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Array arr = new Array(20);
        for(int i=0;i<10;i++){
            arr.addLast(i);
        }
        System.out.println(arr);
        arr.add(1,100);
        System.out.println(arr);
        arr.addFirst(66);
        System.out.println(arr);
        // 66,0,100,1,2,3,4,5,6,7,8,9

        arr.remove(2);
        System.out.println(arr);
        arr.removeElement(66);
        System.out.println(arr);
    }
}
