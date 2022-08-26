package tree.week1;

import tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class PathsCountWithTargetSum_II {

    static int paths = 0;
    static List<Integer> path = new ArrayList<>();

    public static int pathSum(Tree.TreeNode root, int targetSum) {
        getPathsCount(root, targetSum);
        return paths;
    }

    public static void getPathsCount(Tree.TreeNode node, int sum) {

        if(node == null)
            return;

        path.add(node.val);

        getPathsCount(node.left, sum);
        getPathsCount(node.right, sum);

        int temp = 0;
        System.out.println("Path "+path);
        for(int i=path.size()-1; i>=0; i--) {

            temp += path.get(i);

            if(temp == sum)
                paths++;
        }

        path.remove(path.size()-1);
    }

    public static void main(String[] args)
    {
        PathsCountWithTargetSum_II pathsCountWithTargetSum = new PathsCountWithTargetSum_II();
        System.out.println(pathsCountWithTargetSum.pathSum(Tree.constructTreeAndGetRoot(), 11));
    }
}
