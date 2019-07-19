package com.cloud.gemini.datastruct.list;

/**
 * created by fufan on 2019-07-17 17:39
 **/
public interface List<E> {

    public void add(E e);

    public E get(int index);

    public void remove(int index);
}
