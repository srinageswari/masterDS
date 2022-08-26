package tree.week1;

import tree.Tree;

public class PathsCountWithTargetSum_I {

    static int paths = 0;
    static int target = 0;

    public static int pathSum(Tree.TreeNode root, int sum) {
        target = sum;
        outerDFS(root);
        return paths;
    }

    private static void outerDFS(Tree.TreeNode root){
        if (root != null) {
            System.out.println();
            System.out.println("root "+root.val);
            innerDFS(root, 0);
            outerDFS(root.left);
            outerDFS(root.right);
        }
    }

    private static void innerDFS(Tree.TreeNode root, int currSum){
        if (root != null) {
            System.out.print(root.val+" ");
            currSum += root.val;
            if (currSum == target)
                paths++;
            innerDFS(root.left, currSum);
            innerDFS(root.right, currSum);
        }
    }

    public static void main(String[] args)
    {
        PathsCountWithTargetSum_I pathsCountWithTargetSum = new PathsCountWithTargetSum_I();
        pathsCountWithTargetSum.pathSum(Tree.constructTreeAndGetRoot(), 11);
    }
}
