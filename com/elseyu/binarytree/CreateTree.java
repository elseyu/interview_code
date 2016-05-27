package com.elseyu.binarytree;
/*
 * 如何创建一颗二叉树
 * 分析结论：
 * 1.已知二叉树的一种遍历顺序是不能确定一棵二叉树的
 * 2.已知二叉树的先根、中根或者中根、后跟遍历能够唯一确定一颗二叉树；
 * 但是已知先根和后跟还是不能确定一棵二叉树
 * 3.已知标明空子树的先根遍历可以唯一确定一颗二叉树
 */
public class CreateTree {
	//已知二叉树的先根、中根求二叉树
	/*
	 * 分析：设先根遍历的结果是preList，中根数组是inList
	 * 1.由先根次序可知，根节点一定是preList[0];我们知道根节点一定在inList中
	 * 所以设位置是第i个，则是inList[i]
	 * 2.由中根次序可知，在i左边，一定是该节点的左子树，在i右边，一定是该节点的右子树；
	 * 假设数组长n，则inList[0]...inList[i-1]为左子树的中根遍历；
	 * inList[i+1]...inList[n-1]是右子树的中根遍历
	 * 3.同理，preList[1]...preList[i]是左子树的先根遍历；
	 * preList[i+1]...preList[n-1]是右子树的先根遍历
	 * 4.不断递归上述过程
	 */
	
	public static Node createTree(int[] preList, int[] inList) {
		//合法性
		if (preList == null || inList == null || preList.length != inList.length) {
			return null;
		}
		int n = preList.length;
		return createByPreAndIn(preList, inList, 0, n - 1, 0, n - 1);
	}

	private static Node createByPreAndIn(int[] preList, int[] inList, 
			int preStart, int preEnd, int inStart, int inEnd) {
		//检查参数,不相等说明参数错误
		if ((preEnd - preStart) != (inEnd - inStart)) {
			return null;
		}
		
		//头节点就是preList[start]
		Node head = new Node(preList[preStart]);
		//只有一个的时候,此时无论是中根还是先跟遍历都是它
		if (preEnd == preStart ) {
			//返回时先检验一下，如果不等说明参数错误
			return preList[preEnd] == inList[inEnd] ? head : null;
		}
		//在中根次序中找到head（在这里我假设数组里没有重复的数，有重复数值的话不好处理）
		int pos = -1;
		for (int i = inStart; i <= inEnd; i++) {
			if (inList[i] == head.value) {
				pos = i;
				break;
			}
		}
		if (pos == -1) {
			//说明没找到，则参数是错误的
			return null;
		}
		
		head.left = createByPreAndIn(preList, inList, preStart + 1, pos, inStart, pos - 1);
		head.right = createByPreAndIn(preList, inList, pos + 1, preEnd, inStart, inEnd);
		return head;
	}

}
