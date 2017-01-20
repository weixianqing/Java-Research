package leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by shelvin on 17/1/17 at 11:09.
 */

public class BinaryTreeInorderTraversal_94
{
    public ArrayList<Integer> inorderTraversal(TreeNode root)
    {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.empty())
        {
            while (cur != null)
            {
                stack.add(cur);
                cur = cur.left;
            }

            cur = stack.peek();
            stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }

        return res;
    }
}
