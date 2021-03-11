package com.pl.algorithm.based._02_linkedList;

import java.util.Objects;

/**
 * @param <T> 单向链表元素类型
 * @author LIPIAO
 * @date 2021/3/11 9:29
 */
public class Node<T> {

    private T vaue;
    private Node<T> next;

    public Node() {
    }

    public Node(T vaue) {
        this.vaue = vaue;
    }

    public Node(T vaue, Node<T> next) {
        this.vaue = vaue;
        this.next = next;
    }

    public T getVaue() {
        return vaue;
    }

    public void setVaue(T vaue) {
        this.vaue = vaue;
    }

    public Node<T> next() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(vaue, node.vaue) &&
                Objects.equals(next, node.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vaue, next);
    }

    @Override
    public String toString() {
        return "Node{" +
                "vaue=" + vaue +
                ", next=" + next +
                '}';
    }
}
