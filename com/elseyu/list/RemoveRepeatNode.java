package com.elseyu.list;

import java.util.HashSet;

/*
 * 删除无序链表中重复出现的节点
 * 思路：
 * 1.利用哈希表，先将头节点放进hash表，从左到右遍历链表，每次检查当前
 * 遍历的点是否存在在hash表中
 * 2.如果在，这个节点删除；如果不在，继续将此节点放进hash表中
 * 3.这里时间复杂度O(n),空间复杂度O(n)
 */
public class RemoveRepeatNode {
	public static void removeRepNode(Node head) {
		if (head == null) {
			return ;
		}
		//集合
		HashSet<Integer> set = new HashSet<>();
		//保存前一个节点
		Node pre = head;
		Node cur = head.next;
		set.add(head.value);
		while (cur != null) {
			//判断集合中是否存在
			if (set.contains(cur.value)) {
				pre.next = cur.next;
			} else { //不存在则添加进去
				pre = cur;
				set.add(cur.value);
			}
			cur = cur.next;
		}
	}
	
	//方法2：类似于选择排序
	//1.先检查头节点，然后往后遍历，相同的删除
	//2.继续检查后一个节点，后面相同的全部删除
	//3.一直到结束
	//这里时间复杂度时O(n^2),空间复杂度时O(1)，我想是不能接受的吧、、
	//不写了
}
