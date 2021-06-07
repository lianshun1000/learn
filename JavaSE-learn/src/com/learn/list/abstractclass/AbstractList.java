package com.learn.list.abstractclass;

import com.learn.list.inter.List;

public abstract class AbstractList<E> implements List<E> {

    protected int size;

    @Override
    public int size() {
        return size;
    }

    //判断当前集合中是否含有元素
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    //indexOf：去寻找对应的元素，如果找到了返回元素索引，没找到返回-1
    @Override
    public boolean contains(E element) {
        return indexOf(element) != -1;
    }

    @Override
    public void add(E element) {
        add(size,element);
    }
}
