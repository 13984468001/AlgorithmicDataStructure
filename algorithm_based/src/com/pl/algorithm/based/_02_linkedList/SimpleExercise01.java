package com.pl.algorithm.based._02_linkedList;

import java.util.ArrayList;

/**
 * @author LIPIAO
 * @date 2021/3/11 9:34
 * <p>
 * 单向链表和双向链表最简单的练习
 * <p>
 * 1.单链表和双链表如何反转
 * <p>
 * 2.把给定值都删除
 * <p>
 * 链表相关的问题几乎都是coding问题
 */
public class SimpleExercise01 {

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  1.1. 单链表如何反转

    /**
     * 反转给定头部节点的单向链表
     *
     * @param head
     * @return 返回新链表头部节点
     */
    public static Node<Integer> reversalSingleLinkedList(Node<Integer> head) {
        //如何反转呢？
        //这里我们借助两个变量 pre表示head的前一节点，next表示head的后一节点
        //反转：将head的next取出，放入当前next变量中；
        //      head之前的next指向的是下一节点，那么既然要反转，现在将其指向前一个节点pre
        //      当head反转完成后，跳往下一个节点
        //      这时pre往后跳一个节点，到了head这里；head往后跳一个节点来到了next这里
        //循环上边反转这个行为直到需要反转的节点的子节点next=null，也就是head==null时结束
        Node<Integer> pre = null, next = null;

        //循环反转节点，要反转节点的后指向
        while (null != head) {
            //开始时next是head的next，pre是head的pre，是null
            next = head.next();
            //让head的next指向反转：next指向pre，pre第一次循环时为null，所以head的next指向了null，即head变成了尾部节点
            head.setNext(pre);
            //让节点后移，pre变成head
            pre = head;
            //让节点后移，head变成next
            head = next;
            //循环这个行为直到结束
        }

        //最后一次循环，pre会来到反转前的最后一个节点，新head诞生
        return pre;
    }

    /**
     * 使用for循环，再反转，让链表回到但反转前的状态
     *
     * @param head
     * @return
     */
    public static Node<Integer> againReversalSingleLinkedList(Node<Integer> head) {
        if (null == head) {
            return null;
        }

        //把链表的每个节点加入到List
        ArrayList<Node<Integer>> nodes = new ArrayList<>();
        nodes.add(head);
        while (head.next() != null) {
            nodes.add(head.next());
            head = head.next();
        }

        //head变尾节点
        nodes.get(0).setNext(null);
        for (int i = 1; i < nodes.size(); i++) {
            //让当前节点的下一节点指向当前节点的前一个节点，不断重复这个行为直到结束
            nodes.get(i).setNext(nodes.get(i - 1));
        }

        //经过for循环反转后，ArrayList的最后一个元素就变成了新的head
        return nodes.get(nodes.size() - 1);
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  1.2. 双链表如何反转

    /**
     * 反转一个双向链表，链表节点的值类型为Integer
     *
     * @param head 链表头部节点
     * @return 反转后新的头部节点
     */
    public static DoubleNode<Integer> reversalIntegerDoubleNode(DoubleNode<Integer> head) {

        //pre表示head的前一个节点，next表示head的后一个节点
        DoubleNode<Integer> pre = null, next = null;

        //循环反转节点，要反转节点的前后指向
        while (null != head) {
            next = head.next();
            //反转next让其指向前一个节点
            head.setNext(pre);
            //反转last让其指向后一个节点
            head.setLast(next);
            pre = head;
            head = next;
        }

        return pre;
    }

    /**
     * 对节点值为整型的双向链表再反转，让其恢复反转前的状态
     *
     * @param head 需要反转的链表头
     * @return 反转后链表新的头
     */
    public static DoubleNode<Integer> againReversalIntegerDoubleNode(DoubleNode<Integer> head) {

        //使用for循环怎么实现双向链表的反转呢
        //首先需要将链表的每一个节点找一个容器存起来
        //然后遍历这个容器中每个元素也就是链表的每个节点
        //遍历过程中对每个节点的前后指向进行反转

        if (null == head) {
            return null;
        }

        ArrayList<DoubleNode<Integer>> doubleNodes = new ArrayList<>();
        while (null != head) {
            doubleNodes.add(head);
            //循环取到链表的所有子节点
            head = head.next();
        }

        //遍历反转
        //既然要反转，那么容器中首元素的next就应该为null了，因为反转后它被放到链表的最后；而last节点指向next
        doubleNodes.get(0).setLast(doubleNodes.get(0).next());
        doubleNodes.get(0).setNext(null);
        for (int i = 1; i < doubleNodes.size(); i++) {
            doubleNodes.get(i).setLast(doubleNodes.get(i).next());
            doubleNodes.get(i).setNext(doubleNodes.get(i - 1));
        }

        return doubleNodes.get(doubleNodes.size() - 1);
    }


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  2. 把给定值都删除

    /**
     * 在给定链表中删除给点的值
     *
     * @param head 给定的链表
     * @param num  删除的值
     * @return 新链表的头结点
     */
    public static Node<Integer> deleteGivenValueByNode(Node<Integer> head, int num) {

        //过滤首节点连续出现值为num的情况
        while (null != head) {
            if (head.getVaue() != num) {
                break;
            }
            head = head.next();
        }

        //准备两个变量来解耦删除节点的过程
        Node<Integer> pre = head, cur = head;
        while (cur != null) {
            if (cur.getVaue() == num) {
                pre.setNext(cur.next());
            } else {
                pre = cur;
            }
            cur = cur.next();
        }

        //如果第一次循环没有删除头节点，那么头结点不会改变
        return head;
    }

}
