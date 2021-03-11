package com.pl.algorithm.based._02_linkedList;

import java.util.Objects;

/**
 * @param <T> 双向链表元素类型
 * @author LIPIAO
 * @date 2021/3/11 9:31
 */
public class DoubleNode<T> {
    private T vaue;
    private DoubleNode<T> last;
    private DoubleNode<T> next;

    public DoubleNode() {
    }

    public DoubleNode(T vaue) {
        this.vaue = vaue;
    }

    public DoubleNode(T vaue, DoubleNode<T> last, DoubleNode<T> next) {
        this.vaue = vaue;
        this.last = last;
        this.next = next;
    }

    public T getVaue() {
        return vaue;
    }

    public void setVaue(T vaue) {
        this.vaue = vaue;
    }

    public DoubleNode<T> last() {
        return last;
    }

    public void setLast(DoubleNode<T> last) {
        this.last = last;
    }

    public DoubleNode<T> next() {
        return next;
    }

    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoubleNode<?> that = (DoubleNode<?>) o;
        return vaue.equals(that.vaue) &&
                last.equals(that.last) &&
                next.equals(that.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vaue, last, next);
    }

    @Override
    public String toString() {
        return "DoubleNode{" + "vaue=" + vaue + ", last=" + last + ", next=" + next + '}';
    }
}
