package com.learn.algorithm.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lianshun
 * @date 2021/7/6 6:39 下午
 * @description
 */
public class InorderTraversal {
    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
       List<Integer> list = new ArrayList<>();
       TreeNode treeNode = root;
       if(treeNode.left != null && treeNode.left.left !=null){}


       return list;
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
