# interview_code
算法和数据结构的面试题目
##
# 一切为了面试 #
2016.5.13

慢慢来吧，离腾讯校招还有不到四个月，打算每天至少刷题两道。

其余时间慢慢做项目~~~

加油~~~~~！！！！！

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

