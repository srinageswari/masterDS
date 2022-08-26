package tree.week1;

import tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class AllPathsWithTargetSum {
    int target = 0;
    List<List<Integer>> paths = null;
    List<Integer> path = null;

    public List<List<Integer>> pathSum(Tree.TreeNode root, int targetSum) {
        target = targetSum;
        paths = new ArrayList();
        path = new ArrayList();
        findPaths(root,path);
        return paths;
    }

    public void findPaths(Tree.TreeNode root, List<Integer> path)
    {
        if(root == null)
        {
            return;
        }
        path.add(root.val);
        findPaths(root.left,path);
        findPaths(root.right,path);

        int tempSum = 0;
        List<Integer> sublist = new ArrayList();
        for(int i=path.size()-1; i>=0; i--)
        {
            sublist.add(path.get(i));
            tempSum = tempSum + path.get(i);
            if(tempSum == target)
            {
                paths.add(sublist);
                break;
            }
        }
        path.remove(path.size()-1);
    }

    public static void main(String[] args)
    {
        AllPathsWithTargetSum allPathsWithTargetSum = new AllPathsWithTargetSum();
        System.out.println(allPathsWithTargetSum.pathSum(Tree.constructTreeAndGetRoot(), 11));
    }


}
