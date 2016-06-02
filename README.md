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

	[/com/elseyu/stack_queue](https://github.com/elseyu/interview_code/blob/master/com/elseyu/stack_queue "栈和队列")

- 二、链表

	[/com/elseyu/list](https://github.com/elseyu/interview_code/blob/master/com/elseyu/list "链表")

- 三、二叉树

	[/com/elseyu/binarytree](https://github.com/elseyu/interview_code/blob/master/com/elseyu/binarytree "二叉树")

-----
##一、栈和队列#
- 设计一个有getMin()功能的栈：实现一个特殊的栈，在实现栈的基础功能上，再返回栈中最小元素的基本操作

	第一种解法：[/com/elseyu/stack_queue/GetMinStack1.java](https://github.com/elseyu/interview_code/blob/master/com/elseyu/stack_queue/GetMinStack1.java "第一种解法")

	第二种解法：[/com/elseyu/stack_queue/GetMinStack2.java](https://github.com/elseyu/interview_code/blob/master/com/elseyu/stack_queue/GetMinStack2.java "第二种解法")

- 由两个栈实现一个队列
	
	经典题目，无需多说：

	[/com/elseyu/stack_queue/TwoStackQueue.java](https://github.com/elseyu/interview_code/blob/master/com/elseyu/stack_queue/TwoStackQueue.java "由两个栈实现一个队列")
														
	2016.5.13

=======

-	如何仅用递归函数逆序一个栈
	
	要求：只能用递归函数来实现，不能使用其他数据结构

	[/com/elseyu/stack_queue/ReverseStack.java](https://github.com/elseyu/interview_code/blob/master/com/elseyu/stack_queue/ReverseStack.java "如何仅用递归函数逆序一个栈")

-	实现猫狗队列：
	
	有如下几个类：Pet、Cat、Dog，实现一种猫狗队列的结构，要求如下：

 * 1.add()方法可以将cat或dog实例放入队列之中
 * 2.poll()方法可以按先后次序弹出最早进入的宠物
 * 3.pollDog()方法可以按先后次序弹出最早进入的狗
 * 4.pollCat()方法可以按先后次序弹出最早进入的猫
 * 5.isEmpty()判断队列是否为空
 * 6.isDogEmpty()判断队列狗是否为空
 * 7.isCatEmpty()判断队列猫是否为空

	[/com/elseyu/stack_queue/DogCatQueue.java](https://github.com/elseyu/interview_code/blob/master/com/elseyu/stack_queue/DogCatQueue.java "实现猫狗队列")

	2016.5.14

=======


- 用一个栈实现另一个栈的排序
	
	要求：只能额外申请一个栈，允许使用变量，但是不能申请其它数据结构 

	[/com/elseyu/stack_queue/SortStack.java](https://github.com/elseyu/interview_code/blob/master/com/elseyu/stack_queue/SortStack.java "用一个栈实现另一个栈的排序")

-	生成窗口最大值数组：如果数组长为n，窗口为w，则窗口数组为n-w+1，它记录着每个窗口的最大值。

	[/com/elseyu/stack_queue/MaxWindow.java](https://github.com/elseyu/interview_code/blob/master/com/elseyu/stack_queue/MaxWindow.java "生成窗口最大值数组")

	2016.5.15

=======
 

- 题目：构造数组的MaxTree：

	要求：给定一个数组，此数组没有重复值，用此数组的所有值构造一棵二叉树，使得这个树的的每一棵子树的树头都是最大值

	[/com/elseyu/stack_queue/MaxTree.java](https://github.com/elseyu/interview_code/blob/master/com/elseyu/stack_queue/MaxTree.java "构造数组的MaxTree")

-	求最大子矩阵的大小：
	
	要求：给定一个整数矩阵map，其中值只有0,1两种，求其中全是1的所有矩阵区域中，最大矩阵区域为1的数量

	[/com/elseyu/stack_queue/MaxChildMatrix.java](https://github.com/elseyu/interview_code/blob/master/com/elseyu/stack_queue/MaxChildMatrix.java "求最大子矩阵的大小")

	2016.5.16

=======

-----
##二、链表#

- 打印两个有序链表的公共部分

	[/interview_code/src/com/elseyu/list/CommonNode.java](https://github.com/elseyu/interview_code/blob/master/com/elseyu/list/CommonNode.java "打印两个有序链表的公共部分")


- 删除单、双链表倒数第k个节点，后面给出双链表节点的定义（单链表节点的定义在同一个包中，就不特别给出了）

	[/com/elseyu/list/DeleteLastK.java](https://github.com/elseyu/interview_code/blob/master/com/elseyu/list/DeleteLastK.java "删除单、双链表倒数第k个节点")

- 删除链表的中间节点或者a/b处的节点：

	[/com/elseyu/list/DeleteNode.java](https://github.com/elseyu/interview_code/blob/master/com/elseyu/list/DeleteNode.java "删除链表的中间节点或者a")

- 反转单、双向链表：老经典题目了，不解释，上代码

	[/com/elseyu/list/ReVerseList.java](https://github.com/elseyu/interview_code/blob/master/com/elseyu/list/ReVerseList.java "反转单、双向链表")

2016.5.17

=======

- 反转部分链表：给定一个单向链表的头节点head，以及两个整数from、to，在单链表把from到to的这一部分反转

	[/com/elseyu/list/ReversePartList.java](https://github.com/elseyu/interview_code/blob/master/com/elseyu/list/ReversePartList.java "反转部分链表")

-	环形单链表解约瑟夫问题

	细化题目：比较简单，给定人数n，报数间隔是m，每个人都有从1~n的编号，依次从1到m循环报数，

	[/com/elseyu/list/JosephusProblem.java](https://github.com/elseyu/interview_code/blob/master/com/elseyu/list/JosephusProblem.java "环形单链表解约瑟夫问题")

2016.5.18

=======

- 判断一个链表是否为回文结构，进阶：如果链表长度是N，则时间复杂度请达到O(N),空间复杂度为O(1)

	[/com/elseyu/list/PalindromeList.java](https://github.com/elseyu/interview_code/blob/master/com/elseyu/list/PalindromeList.java "判断一个链表是否为回文结构")

- 将单向链表按某值划分为左边小、中间相等、右边大的形式，要求：划分后原顺序不变（应该说是稳定的），时间复杂度O(N),空间复杂度O(1)

	[/com/elseyu/list/Listpartition.java](https://github.com/elseyu/interview_code/blob/master/com/elseyu/list/Listpartition.java "将单向链表按某值划分为左边小、中间相等、右边大的形式")

2016.5.19

=======

- 复制含有随机节点的链表

	[/com/elseyu/list/CopyListWithRand.java](https://github.com/elseyu/interview_code/blob/master/com/elseyu/list/CopyListWithRand.java "复制含有随机节点的链表")

- 两个单链表相加生成相加链表，问题描述：有点像大整数加法，假如给定一个链表1->2->3->null,那么它代表数值123，另一个链表2->3->null,它代表23，相加为146，返回1->4->6-null

	[/com/elseyu/list/AddList.java](https://github.com/elseyu/interview_code/blob/master/com/elseyu/list/AddList.java "两个单链表相加生成相加链表")

2016.5.20

=======

- 两个单链表相交的一系列问题：在这里，单链表可能有环，也可能无环。给定两个单链表的的头head1、head2，这两个链表可能相交，也可能不相交。请设计一个函数，如果两个链表相交，则返回相交的第一个节点；若不相交则返回null要求：时间复杂度：O(n+m),空间复杂度O(1)

	[/com/elseyu/list/IntersectList.java](https://github.com/elseyu/interview_code/blob/master/com/elseyu/list/IntersectList.java "两个单链表相交的一系列问题")

2016.5.21

=======

- 将单链表每k个节点之间逆序:给定一个但单链表的头节点，请设计一个函数，实现这个单链表,在每k个节点之间逆序，如果最后不足k个节点，则不用调整

	[/com/elseyu/list/ReverseEveryKPart.java](https://github.com/elseyu/interview_code/blob/master/com/elseyu/list/ReverseEveryKPart.java "将单链表每k个节点之间逆序")

- 删除无序链表中重复出现的节点

	[/com/elseyu/list/RemoveRepeatNode.java](https://github.com/elseyu/interview_code/blob/master/com/elseyu/list/RemoveRepeatNode.java "删除无序链表中重复出现的节点")

2016.5.22

=======

- 在单链表中删除指定值的节点:给定头节点head，和指定值value，删除链表中值为value的点

	[/com/elseyu/list/RemoveValue.java](https://github.com/elseyu/interview_code/blob/master/com/elseyu/list/RemoveValue.java "在单链表中删除指定值的节点")

-	将搜索二叉树转换成双向链表：现在有一颗搜索二叉树，请将它转换为有序的双向链表

	[/com/elseyu/list/SBT2DoubleList.java](https://github.com/elseyu/interview_code/blob/master/com/elseyu/list/SBT2DoubleList.java "将搜索二叉树转换成双向链表")

- 单链表的选择排序(待修正)

	[/com/elseyu/list/SelectionSortInList.java](https://github.com/elseyu/interview_code/blob/master/com/elseyu/list/SelectionSortInList.java "单链表的选择排序")

2016.5.24

=======

- 向有序的环形单链表中插入新节点

	[/com/elseyu/list/InsertNode.java](https://github.com/elseyu/interview_code/blob/master/com/elseyu/list/InsertNode.java "向有序的环形单链表中插入新节点")

- 合并两个有序的单链表

	[/com/elseyu/list/MergeList.java](https://github.com/elseyu/interview_code/blob/master/com/elseyu/list/MergeList.java "合并两个有序的单链表")

2016.5.25

=======

-----
##三、二叉树#

- 分别用递归和非递归的方式先序、中序、后序遍历二叉树

	[/com/elseyu/binarytree/TraverseTree.java](https://github.com/elseyu/interview_code/blob/master/com/elseyu/binarytree/TraverseTree.java "分别用递归和非递归的方式先序、中序、后序遍历二叉树")

2016.5.26

=======

- 实现二叉树的序列化和反序列化
 * 二叉树被记录成文件的过程叫做序列化，通过文件内容重建原来二叉树的过程叫做
 * 二叉树的反序列化。给定一棵二叉树的头节点head，并已知节点类型为32位的整数，
 * 请设计一种二叉树序列化和反序列化的方案。

	[/com/elseyu/binarytree/SerializeTree.java](https://github.com/elseyu/interview_code/blob/master/com/elseyu/binarytree/SerializeTree.java "实现二叉树的序列化和反序列化")

- 二叉树的层次遍历

	[/com/elseyu/binarytree/LevelTraverse.java](https://github.com/elseyu/interview_code/blob/master/com/elseyu/binarytree/LevelTraverse.java "二叉树的层次遍历")

- 已知二叉树的先根、中根遍历，创建二叉树

	[/com/elseyu/binarytree/CreateTree.java](https://github.com/elseyu/interview_code/blob/master/com/elseyu/binarytree/CreateTree.java "已知二叉树的先根、中根遍历，创建二叉树")

2016.5.27

=======

- 找到二叉树中最大的搜索二叉树

	[/com/elseyu/binarytree/BiggestSubBST.java](https://github.com/elseyu/interview_code/blob/master/com/elseyu/binarytree/BiggestSubBST.java "找到二叉树中最大的搜索二叉树")

2016.5.29

=======

- 二叉树的按层打印

	[/com/elseyu/binarytree/PrintbyLevel.java](https://github.com/elseyu/interview_code/blob/master/com/elseyu/binarytree/PrintbyLevel.java "二叉树的按层打印")

- 调整搜索二叉树中两个错误的节点：一棵二叉树原本是搜索二叉树，但是有两个节点调换了位置，使得这棵不再是搜索叉树。请找出这两个节点并返回。

	[/com/elseyu/binarytree/TwoErrorNodeInBST.java](https://github.com/elseyu/interview_code/blob/master/com/elseyu/binarytree/TwoErrorNodeInBST.java "调整搜索二叉树中两个错误的节点")

2016.5.30

=======

	//坑爹，体测摔伤了，前两天没心情写代码····

- 判断t1树是否包含t2树全部的拓扑结构

	[/com/elseyu/binarytree/CheckContains.java](https://github.com/elseyu/interview_code/blob/master/com/elseyu/binarytree/CheckContains.java "判断t1树是否包含t2树全部的拓扑结构")

- 调整搜索二叉树中两个错误的节点：一棵二叉树原本是搜索二叉树，但是有两个节点调换了位置，使得这棵不再是搜索叉树。请找出这两个节点并返回。

	[/com/elseyu/binarytree/TwoErrorNodeInBST.java](https://github.com/elseyu/interview_code/blob/master/com/elseyu/binarytree/TwoErrorNodeInBST.java "判断t1树是否包含t2树全部的拓扑结构")

2016.6.02

=======