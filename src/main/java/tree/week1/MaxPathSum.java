package tree.week1;

import tree.Tree;

public class MaxPathSum {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(Tree.TreeNode root) {
        if(root == null)
        {
            return 0;
        }
        findMax(root);
        return max;
    }

    public int findMax(Tree.TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }
        int leftSum = Math.max(0,findMax(root.left));
        int rightSum = Math.max(0,findMax(root.right));
        max = Math.max(max,root.val+leftSum+rightSum);
        return root.val + Math.max(leftSum,rightSum);
    }
    public static void main(String[] args)
    {
        MaxPathSum mp = new MaxPathSum();
        System.out.println(mp.maxPathSum(Tree.constructTreeAndGetRoot()));
    }
}
