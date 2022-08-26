package tree.week1;

import tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class AllRootToLeafPathWithTarget {

    int sum = 0;
    List<List<Integer>> paths = null;

    public List<List<Integer>> pathSum(Tree.TreeNode root, int targetSum) {
        sum = targetSum;
        paths = new ArrayList();
        getPaths(root,0, new ArrayList());
        return paths;
    }

    private void getPaths(Tree.TreeNode root, int currSum, List<Integer> path) {
        if(root == null)
        {
            return;
        }
        path.add(root.val);
        currSum = currSum + root.val;
        if(root.left == null && root.right == null)
        {
            if(currSum == sum)
            {
                List<Integer> matchedPath = new ArrayList(path);
                paths.add(matchedPath);
            }
        }
        getPaths(root.left,currSum,path);
        getPaths(root.right,currSum,path);
        currSum = currSum - root.val;
        path.remove(path.size()-1);
    }

    public static void main(String[] args)
    {
        AllRootToLeafPathWithTarget allRootToLeafPathWithTarget = new AllRootToLeafPathWithTarget();
        System.out.println(allRootToLeafPathWithTarget.pathSum(Tree.constructTreeAndGetRoot(), 11));
    }
}
