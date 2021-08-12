package com.learn.list;

import com.learn.list.abstractclass.AbstractList;

public class LinkedList<E> extends AbstractList<E> {

    private Node first;
    private Node last;

    //private int size;从父类继承

    private static class Node<E> {
        Node<E> pre;
        Node<E> next;
        E element;

        public Node(Node pre, Node next, E element) {
            this.pre = pre;
            this.next = next;
            this.element = element;
        }
    }


    @Override
    public E get(int index) {
        checkElementIndex(index);
        return node(index).element;
    }

    private Node<E> node(int index) {
        Node x = first;
        //判断需要查找的节点是靠近头部还是尾部，靠近头则从头开始找，靠近尾部则从尾开始找
        if (index > size >> 1) {
            x = last;
            for (int i = size - 1; i > index; i--) {
                x = x.pre;
            }
        } else {
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
        }
        return x;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException(":Index:" + index + ",Size:" + size);
        }
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    @Override
    public E set(int index, E element) {
        //在指定索引上修改值，并且返回旧值
        checkElementIndex(index);
        Node<E> node = node(index);
        E oldElement = node.element;
        node.element = element;
        return oldElement;
    }

    @Override
    public void add(int index, E element) {
        checkPositionIndex(index);
        /*if(index == 0) {
            first = new Node<>(first,element);
        }else{
            Node<E> pre = node(index - 1);
            Node<E> next = pre.next;
            pre.next = new Node<>(next, element);
        }
        size++;*/

        if (index == size) {
            linkLast(element);
        } else {
            linkBefore(element, node(index));
        }
        size++;
    }

    private void linkLast(E element) {
        Node<E> l = last;
        Node<E> newNode = new Node<>(l, null, element);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
    }

    private void linkBefore(E element, Node<E> node) {
        Node<E> pre = node.pre;
        Node<E> newNode = new Node<>(pre, node, element);
        node.pre = newNode;
        if (pre == null) {
            first = newNode;
        } else {
            pre.next = newNode;
        }
    }


    private void checkPositionIndex(int index) {
        if (!isPosition(index)) {
            throw new IndexOutOfBoundsException(":Index:" + index + ",Size:" + size);
        }
    }

    private boolean isPosition(int index) {
        return index >= 0 && index <= size;
    }

    @Override
    public E remove(int index) {
        checkElementIndex(index);
        /*Node<E> oldNode = first;
        if(index == 0 ){
            first = first.next;
        }else {
            Node<E> pre = node(index - 1);
            oldNode = pre.next;
            pre.next = oldNode.next;
        }
        size --;*/
        Node<E> node = node(index);
        Node<E> pre = node.pre;
        Node<E> next = node.next;

        if (pre == null) {
            first = next;
            next.pre = null;
        } else {
            pre.next = next;
        }
        if (next == null) {
            last = pre;
        } else {
            next.pre = pre;
        }
        size--;
        return null;
    }

    @Override
    public int indexOf(E element) {
        //查找有没有element元素，有则返回它的index，没有返回-1
        Node<E> x = first;
        int index = 0;
        if (element == null) {
            for (Node i = x; i != null; i = i.next) {
                if (element == i.element) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node i = x; i != null; i = i.next) {
                if (element.equals(i.element)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
    }


    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        Node x = first;
        for (Node i = x; i != null; i = i.next) {
            sb.append(i.element);
            if (i.next == null) {
                return sb.append("]").toString();
            }
            sb.append(",");
        }
        return sb.toString();
    }
}
