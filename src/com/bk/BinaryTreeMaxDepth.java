package com.bk;

/**
 * Leetcode - https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * 
 Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.

 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class BinaryTreeMaxDepth {
	public int maxDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}
		else {
			return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode one = new TreeNode(9);
		TreeNode two = new TreeNode(20);
		TreeNode tree = new TreeNode(15);
		TreeNode four = new TreeNode(7);
		TreeNode five = new TreeNode(25);

		root.left = one;
		root.right = two;
		two.left = tree;
		two.right = four;
		four.left = five;

		BinaryTreeMaxDepth binaryTreeMaxDepth = new BinaryTreeMaxDepth();
		System.out.println(binaryTreeMaxDepth.maxDepth(root));
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

