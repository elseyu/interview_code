package com.elseyu.list;

/*
 * 向有序的环形单链表中插入新节点
 * 其实就是考代码的实现能力
 * 
 */
public class InsertNode {
	public static Node insertNum(Node head, int num) {
		Node newNode = new Node(num);
		//如果为空，新的节点就是头，并且连接后返回
		if (head == null) {
			newNode.next = newNode;
			return newNode;
		}
		Node pre = head;
		Node cur = head.next;
		while(cur != head) {
			//找到了合适的位置
			if (pre.value <= num && cur.value >= num) {
				break; //记得退出循环
			}
			pre = cur;
			cur = cur.next;
		}
		//在合适的位置插入
		pre.next = newNode;
		newNode.next = cur;
		//有可能出现num比所有节点大或者比所有节点小
		//所以最后返回要判断一下
		return num < head.value ? newNode : head;
		
	}
}
