package com.cloud.gemini.datastruct.list;

import java.util.Iterator;

/**
 *
 * 简单的链表实现，待完善
 * created by fufan on 2019-07-17 10:36
 **/
public class GmnLinkedList<E> implements Iterable<E>, List<E>{

    int size = 0;
    Node<E> first;
    Node<E> last;

    /**
     * default constructor
     */
    public GmnLinkedList() {
    }

    /**
     * 添加一个元素
     * @param e
     */
    public void add(E e) {

        Node<E> node = new Node<E>(e, null, null);
        if (first == null) {
            first = node;
            last = node;
            size ++;
            return;
        }
        last.next = node;
        node.prev = last;
        last = node;
        size ++;
    }

    /**
     * 根据索引取元素
     * @param index
     * @return
     */
    public E get(int index) {
        checkIndex(index);
        return getIndex(index).item;
    }

    /**
     * 根据索引删除元素
     * @param index
     */
    public void remove(int index) {
        checkIndex(index);
        unlink(index);
    }


    private void unlink(int index) {
        Node<E> node = getIndex(index);
        Node<E> prev = node.prev;
        Node<E> next = node.next;

        if (prev == null) {
            first = node.next;
        } else {
            node.prev.next = node.next;
        }

        if (next == null) {
            last = node.prev;
        } else {
            node.next.prev = node.prev;
        }

        size --;
    }

    public int getIndex(E e) {
        Node<E> cur = first;

        for (int i = 0; i < size; i ++) {
            if (cur.item == e) {
                return i;
            }
            cur = cur.next;
        }
        return -1;

    }

    private Node<E> getIndex(int index) {
        Node<E> cur = first;
        while(index > 0) {
            cur = cur.next;
            index --;
        }
        return cur;
    }


    public void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException();
        }
    }


    /**
     * implement Iterator method
     * 支持增强for循环
     * @return
     */
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> cur;
            public boolean hasNext() {
                if (cur == null && first != null) {
                    cur = first;
                    return true;
                }
                if (cur.next != null) {
                    cur = cur.next;
                    return true;
                }
                return false;
            }

            public E next() {
                return cur.item;
            }
            public void remove() {

            }
        };
    }

    /**
     * node
     * @param <E>
     */
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        public Node(E item, Node<E> next, Node<E> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }

    }

    public static void main(String[] args) {
        GmnLinkedList<String> linkedList = new GmnLinkedList<String>();

        linkedList.add("bb");
        linkedList.add("cc");
        linkedList.add("dd");
        linkedList.add("ee");
        linkedList.remove(4);
        System.out.println(linkedList.get(0));

        for (String s: linkedList) {
            System.out.println(s);
        }

    }
}
