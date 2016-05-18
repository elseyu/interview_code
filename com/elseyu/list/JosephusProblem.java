package com.elseyu.list;

/*
 * 环形单链表解约瑟夫问题：记得才学C的时候用数组的方法解过，但是远没有用java爽啊！！
 * 细化题目：比较简单，给定人数n，报数间隔是m，每个人都有从1~n的编号，依次从1到m循环报数，
 * 数到m的人出队，直到最后只剩一个人为止。求最后生存下来的的人的编号
 * 思路：1.根据人数n构成一个具有n个节点环形单链表，每个节点依次编号
 * 2.有一个指针从链表头head开始报数，数到m的时候删除该节点
 * 3.直到剩下最后一个节点，返回该节点的编号
 * 这里的时间复杂度是O(N*M)
 * 进阶：后面会给出进阶解法
 */
public class JosephusProblem {
	public int josephusProblemByList(int n, int m) {
		//永远少不了的判断参数合法性
		if (n <= 0 || m <= 0) {
			return 0;
		}
		
		//生成具有n个节点环形单链表
		Node head = new Node(1);
		Node move = head;
		for (int i = 2; i <= n; i++) {
			move.next = new Node(i);
			move = move.next;
		}
		move.next = head; //收尾相连形成环
		//下面开始进行报数操作
		int len = n;
		int count = 1; //计数器
		while (len > 1) {
			if (count == m) {
				move.next = head.next;
				head = head.next;  //删除操作
				count = 1;
				len--;
				continue; //退出这一层循环；你问为啥?因为做删除操作的时候已经做了报数的动作,我们要知道，每做一次报数动作都要判断的
			}
			head = head.next; //报数操作就是不断移动
			move = move.next;
			count++; //计数器加1
		}
		return head.value;
	}
	
	/*
	 * 进阶解法：好吧，其实我也不是很明白。
	 * 思路：其实就是通过一些规律和数学手段，找出递归规律
	 * 递归公式：f(n) = (f(n-1) + m -1) % n + 1
	 * 推导过程这里就不给出了
	 * 这里的时间复杂度是O(N)
	 */
	
	public static int josephusProblemPro(int n, int m) {
		if (n == 1) {
			return 1;
		}
		return (josephusProblemPro(n - 1, m) + m - 1) % n + 1;
	}
	
}









