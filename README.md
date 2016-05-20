# interview_code
算法和数据结构的面试题目
##
# 一切为了面试 #
2016.5.13

慢慢来吧，离腾讯校招还有不到四个月，打算每天至少刷题两道。

其余时间慢慢做项目~~~

加油~~~~~！！！！！

ps:这里列出了所有的题目，并且分好类，相同的类型的题目在同一个包下。

然后在每个包下都会有该类型的所有题目信息。而且代码内都会有具体的思路和注释，欢迎指正！！！！

这里先给总目录：（持续更新~~~~~）

- 一、栈和队列

	/com/elseyu/stack_queue/

- 二、链表

	/com/elseyu/list/

-----
##一、栈和队列#
- 设计一个有getMin()功能的栈：实现一个特殊的栈，在实现栈的基础功能上，再返回栈中最小元素的基本操作

	第一种解法：/interview_code/src/com/elseyu/stack_queue/GetMinStack1.java

	第二种解法：/interview_code/src/com/elseyu/stack_queue/GetMinStack2.java

- 由两个栈实现一个队列
	
	经典题目，无需多说：/interview_code/src/com/elseyu/stack_queue/TwoStackQueue.java
														
	2016.5.13

=======

-	如何仅用递归函数逆序一个栈
	
	要求：只能用递归函数来实现，不能使用其他数据结构

	/interview_code/src/com/elseyu/stack_queue/ReverseStack.java

-	实现猫狗队列：
	
	有如下几个类：Pet、Cat、Dog，实现一种猫狗队列的结构，要求如下：

 * 1.add()方法可以将cat或dog实例放入队列之中
 * 2.poll()方法可以按先后次序弹出最早进入的宠物
 * 3.pollDog()方法可以按先后次序弹出最早进入的狗
 * 4.pollCat()方法可以按先后次序弹出最早进入的猫
 * 5.isEmpty()判断队列是否为空
 * 6.isDogEmpty()判断队列狗是否为空
 * 7.isCatEmpty()判断队列猫是否为空

	/interview_code/src/com/elseyu/stack_queue/DogCatQueue.java

	2016.5.14

=======


- 用一个栈实现另一个栈的排序
	
	要求：只能额外申请一个栈，允许使用变量，但是不能申请其它数据结构 

	/interview_code/src/com/elseyu/stack_queue/SortStack.java

-	生成窗口最大值数组：如果数组长为n，窗口为w，则窗口数组为n-w+1，它记录着每个窗口的最大值。

	/interview_code/src/com/elseyu/stack_queue/MaxWindow.java

	2016.5.15

=======
 

- 题目：构造数组的MaxTree：

	要求：给定一个数组，此数组没有重复值，用此数组的所有值构造一棵二叉树，使得这个树的的每一棵子树的树头都是最大值

	/interview_code/src/com/elseyu/stack_queue/MaxTree.java

-	求最大子矩阵的大小：
	
	要求：给定一个整数矩阵map，其中值只有0,1两种，求其中全是1的所有矩阵区域中，最大矩阵区域为1的数量

	/interview_code/src/com/elseyu/stack_queue/MaxChildMatrix.java

	2016.5.16

=======

-----
##二、链表#

- 打印两个有序链表的公共部分

	/interview_code/src/com/elseyu/list/CommonNode.java

- 删除单、双链表倒数第k个节点，后面给出双链表节点的定义（单链表节点的定义在同一个包中，就不特别给出了）

	/interview_code/src/com/elseyu/list/DeleteLastK.java

- 删除链表的中间节点或者a/b处的节点：

	/interview_code/src/com/elseyu/list/DeleteNode.java

- 反转单、双向链表：老经典题目了，不解释，上代码

	/interview_code/src/com/elseyu/list/ReVerseList.java

2016.5.17

=======

- 反转部分链表：给定一个单向链表的头节点head，以及两个整数from、to，在单链表把from到to的这一部分反转

	/interview_code/src/com/elseyu/list/ReversePartList.java

-	环形单链表解约瑟夫问题

	细化题目：比较简单，给定人数n，报数间隔是m，每个人都有从1~n的编号，依次从1到m循环报数，

	/interview_code/src/com/elseyu/list/JosephusProblem.java

2016.5.18

=======

- 判断一个链表是否为回文结构，进阶：如果链表长度是N，则时间复杂度请达到O(N),空间复杂度为O(1)

	/interview_code/src/com/elseyu/list/PalindromeList.java

- 将单向链表按某值划分为左边小、中间相等、右边大的形式，要求：划分后原顺序不变（应该说是稳定的），时间复杂度O(N),空间复杂度O(1)

	/interview_code/src/com/elseyu/list/Listpartition.java

2016.5.19

=======

- 复制含有随机节点的链表

	/interview_code/src/com/elseyu/list/CopyListWithRand.java

- 两个单链表相加生成相加链表问题描述：有点像大整数加法，假如给定一个链表1->2->3->null,那么它代表数值123，另一个链表2->3->null,它代表23，相加为146，返回1->4->6-null

	/interview_code/src/com/elseyu/list/AddList.java

2016.5.20

=======