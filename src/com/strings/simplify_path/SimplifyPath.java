package com.strings.simplify_path;

import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath {
    public String simplifyPath(String path) {
        // Create a deque to store the directories in the path
        Deque<String> deque = new ArrayDeque<>();

        // Split the path string into directories
        String[] dirs = path.split("/");

        // Traverse through the directories in the path
        for (String dir : dirs) {
            // Ignore empty or current directory (".") and continue to next directory
            // Go back one directory ("..") by removing the last directory in the stack
            if (dir.equals("..")) {
                if (!deque.isEmpty()) deque.pop();
            }
            // add the directory to the deque, if it is not empty and not current directory (".")
            else if (!dir.isEmpty() && !dir.equals(".")){
                deque.push(dir);
            }
        }

        // If the deque is empty, return the root directory "/"
        if (deque.isEmpty()) return "/";

        // Construct the simplified path string by joining the directories in the deque
        StringBuilder builder = new StringBuilder();
        while (!deque.isEmpty()) {
            builder.append("/");
            builder.append(deque.pollLast());
        }

        return builder.toString();
    }
}

