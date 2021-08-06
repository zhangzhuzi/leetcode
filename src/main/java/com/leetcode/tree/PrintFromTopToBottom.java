package com.leetcode.tree;

import com.leetcode.entity.TreeNode;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: PrintFromTopToBottom
 * @date: 2021/8/4 17:50
 * @author: zsz
 */
public class PrintFromTopToBottom {

    //打印成一行
    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> ret = new ArrayList<>();
        queue.add(root);
        while (queue.size() > 0) {
            int cnt = queue.size();
            while (cnt-- > 0) {
                TreeNode cur = queue.poll();
                if (cur == null) {
                    continue;
                }
                ret.add(cur.val);
                queue.add(cur.left);
                queue.add(cur.right);
            }
        }
        return ret;
    }

    //打印成多行
    public ArrayList<ArrayList<Integer>> printFromTopToBottom2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        queue.add(root);
        while (queue.size() > 0) {
            ArrayList<Integer> line = new ArrayList<>();
            int cnt = queue.size();
            while (cnt-- > 0) {
                TreeNode cur = queue.poll();
                if (cur == null) {
                    continue;
                }
                line.add(cur.val);
                queue.add(cur.left);
                queue.add(cur.right);
            }
            if (line.size() > 0) {
                ret.add(line);
            }
        }
        return ret;
    }

    //Z字打印成多行
    public ArrayList<ArrayList<Integer>> printFromTopToBottom2Z(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        queue.add(root);
        boolean reverse = false;
        while (queue.size() > 0) {
            ArrayList<Integer> line = new ArrayList<>();
            int cnt = queue.size();
            while (cnt-- > 0) {
                TreeNode cur = queue.poll();
                if (cur == null) {
                    continue;
                }
                line.add(cur.val);
                queue.add(cur.left);
                queue.add(cur.right);
            }
            if (reverse) {
                // 这个骚操作是我没想到的！还能用工具类来翻转？那我还写啥翻转的方法？
                Collections.reverse(line);
            }
            reverse = !reverse;
            if (line.size() > 0) {
                ret.add(line);
            }
        }
        return ret;
    }
}
