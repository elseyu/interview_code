package com.elseyu.binarytree;

/*
 * 在二叉树中找到一个结点的后继节点
 * 假如有一个新定义的树节点（如下），每个节点都有一个parent指针。后继节点的定义：在中序遍历的过程中，
 * 在一个节点的后面就是后节点
 * 思路：
 * 1.很容易想到可以往一个节点一层一层往上找到父节点，然后再中序遍历找到该节点，后面跟着的就是后继节点
 * 2.上面的思路不用多说，下面来个更好的：
 * 情况一：如果node有右子树，那么后继节点就是右子树最左边的节点
 * 情况二：如果node没有右子树，那么先看看node节点是不是该父节点的左孩子，如果是，父节点就是后继结点；
 * 如果不是，是右孩子，那么一直往上移动，直到找到一个节点是父节点的左孩子，那么这个父节点就是后继节点
 * 情况三：在情况二中，一直往上找都找不到这样的节点，说明该节点没有后继结点
 */
//新节点的定义
class NewNode {
	int value;
	NewNode left;
	NewNode right;
	NewNode parent;
	
	public NewNode(int val) {
		this.value = val;
	}
}

public class NextNode {
	public static NewNode getNextNode(NewNode node) {
		if (node == null) {
			return null;
		}
		//如果有右孩子
		if (node.right != null) {
			//找到右子树最左边的那个
			node = node.right;
			while(node != null) {
				node = node.left;
			}
			return node;
		} else {
			//找到父节点(找到本身是父节点左孩子的节点)
			NewNode parent = node.parent;
			while (parent != null && parent.left != node) {
				node = parent;
				parent = node.parent;
			}
			return parent;
		}
		
		
	}
}
