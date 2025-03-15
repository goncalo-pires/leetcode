package com.leetcode.Medium;

import com.leetcode.utils.TreeNode;

public class ValidateBinarySearchTree {

    // This variable will keep track of the previous node's value during in-order traversal
    private Integer prev = null;

    /**
     * This method is called to check if the binary tree is a valid BST.
     * @param root the root of the binary tree
     * @return true if the tree is a valid BST, otherwise false
     */
    public boolean isValidBST(TreeNode root) {
        // Call the recursive helper function to validate the tree
        return isValid(root);
    }

    /**
     * Recursive helper function to perform in-order traversal and check validity of BST.
     * @param root the current node
     * @return true if the subtree rooted at the given node is a valid BST, otherwise false
     */
    public boolean isValid(TreeNode root) {
        if (root == null) return true;  // Base case: empty tree is a valid BST

        // Recursively check the left subtree
        if (!isValid(root.left)) return false;

        // If previous node's value is not smaller than the current node's value, it's not a valid BST
        if (prev != null && root.val <= prev) return false;

        // Update the previous node value to the current node's value
        prev = root.val;

        // Recursively check the right subtree
        return isValid(root.right);
    }

}
