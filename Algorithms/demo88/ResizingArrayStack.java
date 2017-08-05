package Algorithms.demo88;

import java.util.Iterator;

import Algorithms.Base.Base;


/**
 * Created by pokedo on 2017/1/16.
 */
//impelments Iterable<Item> 指明自定义特定需求的迭代器,需实现
//  public Iterator<Item> iterator() 的方法
public class ResizingArrayStack<Item> implements Iterable<Item> {

    //定容数组栈
    private Item[] a = (Item[]) new Object[1];
    private int N = 0;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < a.length; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public void push(Item item) {
        if (N == a.length)
            resize(a.length * 2);
        a[N] = item;
        N++;
    }

    public Item pop() {
        Item item = a[--N];
        a[N] = null;
        if (N == a.length / 4)
            resize(a.length / 2);
        return item;
    }


    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = N;

        public boolean hasNext() {
            return i > 0;
        }

        public Item next() {
            return a[--i];
        }

        public void remove() {
        }
    }

    public static void main(String args[]) {
        // 主要目的为对一个定容的数组栈可以利用自定义的Iterator进行逆向迭代
        ResizingArrayStack<Integer> stack = new ResizingArrayStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        Iterator<Integer> ite = stack.iterator();
        while (ite.hasNext()) {
            System.out.println(ite.next());
        }
    }
}
