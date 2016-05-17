package com.elseyu.list;
/**
 *	打印两个有序链表的公共部分：
 *	太简单，直接上代码
 */
public class CommonNode {
	public static void printCommonNode(Node head1, Node head2) {
		while(head1 != null && head2!= null) {
			if(head1.value < head2.value) {
				head1 = head1.next;
			} else if (head1.value > head2.value) {
				head2 = head2.next;
			} else {
				System.out.println(head1.value + "");
				head1 = head1.next;
				head2 = head2.next;
			}
		}
	}
}

/**
 *	节点代码
 */
class Node {
	public int value;
	public Node next;
	
	public Node(int value) {
		this.value = value;
	}
	
}
