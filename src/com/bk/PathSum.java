package com.bk;

import com.bk.utils.TreeNode;

/**
 * Leetcode - https://leetcode.com/problems/path-sum/
 * 
 Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

 *
 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		boolean result = false;
		if(root == null){
			return false;
		}

		if (isLeafNode(root) && sum == root.val) {
			return true;
		} else {
			result = result || hasPathSum(root.left, sum - root.val);
			result = result || hasPathSum(root.right, sum - root.val);
		}
		return result;
	}

	public boolean isLeafNode(TreeNode root) {
		return (root.left == null && root.right == null);
	}


	public static void main(String[] args) {
		TreeNode a = new TreeNode(5);
		TreeNode b = new TreeNode(4);
		TreeNode c = new TreeNode(8);
		TreeNode d = new TreeNode(11);
		TreeNode e = new TreeNode(13);
		TreeNode f = new TreeNode(4);
		TreeNode g = new TreeNode(7);
		TreeNode h = new TreeNode(2);
		TreeNode i = new TreeNode(1);

		TreeNode root = a;
		a.left = b;
		a.right = c;
		b.left = d;
		c.left = e;
		c.right = f;
		d.left = g;
		d.right = h;
		f.right = i;

		PathSum pathSum = new PathSum();
		System.out.println(pathSum.hasPathSum(root, 22));

	}
}

