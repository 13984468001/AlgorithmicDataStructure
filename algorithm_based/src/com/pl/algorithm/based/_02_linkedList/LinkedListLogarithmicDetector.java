package com.pl.algorithm.based._02_linkedList;

/**
 * @author LIPIAO
 * @date 2021/3/11 10:11
 * <p>
 * 链表对数器
 */
public class LinkedListLogarithmicDetector {

    /**
     * 测试链表反转程序
     */
    public static void main(String[] args) {

        int sampleNum = 1_000_000;
        int size = 100;
        int maxValue = 100;

        for (int i = 0; i < sampleNum; i++) {
            //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 单向链表反转程序对数验证
            //产生一个随机链表
            Node<Integer> singleNode = generateRandomIntegerLinkedList(size, maxValue);
            //反转链表
            Node<Integer> reversalNode = SimpleExercise01.reversalSingleLinkedList(singleNode);
            //再反转链表
            Node<Integer> singleNode02 = SimpleExercise01.againReversalSingleLinkedList(reversalNode);
            if (!checkReversalNodeEqual(singleNode, singleNode02)) {
                System.out.println("单向链表反转程序存在BUG……");
                break;
            }


            //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 双向链表反转程序对数验证
            DoubleNode<Integer> doubleNode1 = generateRandomIntegerDoubleLinkedList(size, maxValue);
            DoubleNode<Integer> reversalDoubleNode = SimpleExercise01.reversalIntegerDoubleNode(doubleNode1);
            DoubleNode<Integer> doubleNode2 = SimpleExercise01.againReversalIntegerDoubleNode(reversalDoubleNode);
            if (!checkReversalDoubleNodeEqual(doubleNode1, doubleNode2)) {
                System.out.println("双向链表反转程序存在BUG……");
                break;
            }


            //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 验证删除单向链表中的指定值
            int num = (int) (Math.random() * 10), value = -1, i_ = 1;
            Node<Integer> tempNode = singleNode;
            Node<Integer> tempNode2 = singleNode;
            while (tempNode != null) {
                if (i_ == num) {
                    value = tempNode.getVaue();
                    break;
                }
                tempNode = tempNode.next();
                i_++;
            }
            if (num != 0 && value != -1) {
                Node<Integer> deleteByNodeOK = SimpleExercise01.deleteGivenValueByNode(tempNode2, value);
                while (deleteByNodeOK != null) {
                    if (deleteByNodeOK.getVaue() == value) {
                        System.out.println("删除单向链表中指定值 Not Success……");
                        break;
                    }
                    deleteByNodeOK = deleteByNodeOK.next();
                }
            }

        }

        System.out.println("链表反转程序对数验证结束~~~");

    }

    /**
     * 产生一个随机整型单向链表
     *
     * @param size
     * @param maxValue
     * @return
     */
    public static Node<Integer> generateRandomIntegerLinkedList(int size, int maxValue) {
        //随机产生长度,最小为1
        size = (int) (Math.random() * (size + 1));
        if (0 == size) {
            return null;
        }

        size--;
        //生成头部head
        Node<Integer> head = new Node<>((int) (Math.random() * (maxValue + 1)));
        //前一节点pre=head
        Node<Integer> pre = head;
        //开始生成链表
        while (size != 0) {
            //生成当前节点cur
            Node<Integer> cur = new Node<>((int) (Math.random() * (maxValue + 1)));
            //pre的next指向cur
            pre.setNext(cur);
            //pre向后移动一个节点。重复这个行为将会得到一个单向链表
            pre = cur;
            size--;
        }

        return head;
    }

    /**
     * 产生一个双向链表，链表节点的值类型为Integer
     *
     * @param size     链表长度
     * @param maxValue 链表节点中的最大值
     * @return 链表头部
     */
    public static DoubleNode<Integer> generateRandomIntegerDoubleLinkedList(int size, int maxValue) {
        //随机产生长度,最小为1
        size = (int) (Math.random() * (size + 1));
        if (0 == size) {
            return null;
        }

        size--;
        //生成头部head
        DoubleNode<Integer> head = new DoubleNode<>((int) (Math.random() * (maxValue + 1)));
        //前一节点pre=head
        DoubleNode<Integer> pre = head;
        //开始生成链表
        while (size != 0) {
            //生成节点cur
            DoubleNode<Integer> cur = new DoubleNode<>((int) (Math.random() * (maxValue + 1)));
            //cur的last指向pre
            cur.setLast(pre);
            //pre的next指向cur
            pre.setNext(cur);
            //pre向后移动一个节点。重复这个行为将会得到一个双向链表
            pre = cur;
            size--;
        }

        return head;
    }


    /**
     * 检查两个非环形单向链表是否相同
     *
     * @param head1
     * @param head2
     * @return 所有节点完全相同返回true
     */
    public static boolean checkReversalNodeEqual(Node<Integer> head1, Node<Integer> head2) {
        while (null != head1 && null != head2) {
            if (head1.getVaue() != head2.getVaue()) {
                return false;
            }

            head1 = head1.next();
            head2 = head2.next();
        }

        return null == head1 && null == head2;
    }

    /**
     * 检查两个非环形双向链表是否相同
     * <p>
     * 检查的标准是什么呢？
     * next与last指向的节点的值一样
     *
     * @param head1
     * @param head2
     * @return 所有节点完全相同返回true
     */
    public static boolean checkReversalDoubleNodeEqual(DoubleNode<Integer> head1, DoubleNode<Integer> head2) {

        if (null == head1 && null == head2) {
            return true;
        }

        if ((null == head1 && null != head2) || null != head1 && null == head2) {
            return false;
        }

        //给定头结点中任意一个往前的指向不为空就不具备可比性
        if (null != head1.last() || null != head2.last()) {
            return false;
        }

        //记录两个链表的尾节点
        DoubleNode<Integer> end01 = null, end02 = null;

        //先比较正向各子节点的值
        while (null != head1 && null != head2) {
            if (head1.getVaue() != head2.getVaue()) {
                return false;
            }
            end01 = head1;
            end02 = head2;
            head1 = head1.next();
            head2 = head2.next();
        }

        //如果到达尾部节点，next都是null，如果不是，不可比，直接返回false
        if (head1 != null || head2 != null) {
            return false;
        }

        //再反向比较last指向的各节点的值
        while (end01 != null && end02 != null) {
            if (end01.getVaue() != end02.getVaue()) {
                return false;
            }
            end01 = end01.last();
            end02 = end02.last();
        }

        //正反向来回比较各节点的值相等后，反向比较到达头结点时last指向必定是null
        return null == end01 && null == end02;
    }

}
