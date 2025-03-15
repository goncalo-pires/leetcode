package com.leetcode.Medium;

import java.util.Stack;

public class SimplifyPath {

    /**
     * Simplifies an absolute path to its canonical form.
     *
     * @param path the original absolute path
     * @return the simplified canonical path
     */
    public String simplifyPath(String path) {
        // Split the path by "/" to extract individual components (directories or files)
        String[] parts = path.split("/");

        // Stack to hold the components of the path
        Stack<String> stack = new Stack<>();

        // Iterate over the parts of the path
        for (String part : parts) {
            // If the part is empty or just ".", skip it (this means the current directory or redundant slashes)
            if (part.isEmpty() || part.equals(".")) {
                continue;
            }

            // If the part is "..", pop from the stack (go to the parent directory) if the stack is not empty
            if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // Otherwise, push the part (directory or file) onto the stack
                stack.push(part);
            }
        }

        // If the stack is empty, return the root directory
        if (stack.isEmpty()) {
            return "/";
        }

        // Build the canonical path using the stack
        StringBuilder sb = new StringBuilder();
        // Pop elements from the stack to construct the path
        while (!stack.isEmpty()) {
            sb.insert(0, "/" + stack.pop());
        }

        // Return the final simplified canonical path
        return sb.toString();
    }
}
