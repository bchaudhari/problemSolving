package com.bk;

import com.bk.utils.TreeNode;

/**
 * Leetcode - https://leetcode.com/problems/path-sum-iii/
 * 
 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class PathSum3 {
	int count = 0;
	public int pathSum(TreeNode root, int sum) {
		if(root == null){
			return 0;
		}
		else {
			sumPath(root, sum);
		}
		pathSum(root.left, sum);
		pathSum(root.right, sum);
		return count;
	}
	
	public int sumPath(TreeNode root, int sum) {
		if(root == null) return 0;
		
		if(sum == root.val) {
			count++;
		}
		sumPath(root.left, sum - root.val);
		sumPath(root.right, sum - root.val);
		return count;
	}
	public static void main(String[] args) {
		TreeNode a = new TreeNode(10);
		TreeNode b = new TreeNode(5);
		TreeNode c = new TreeNode(-3);
		TreeNode d = new TreeNode(3);
		TreeNode e = new TreeNode(2);
		TreeNode f = new TreeNode(11);
		TreeNode g = new TreeNode(3);
		TreeNode h = new TreeNode(0);
		TreeNode i = new TreeNode(1);
		
		TreeNode root = a;
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		c.right = f;
		d.left = g;
		d.right = h;
		e.right = i;
		
		PathSum3 pathSum = new PathSum3();
		System.out.println(pathSum.pathSum(root, 8));

	}
}

