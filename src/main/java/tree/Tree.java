package tree;

public class Tree {

    TreeNode root;

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode constructTreeAndGetRoot()
    {
        Tree tree = new Tree();
        tree.root = new TreeNode(6);
        tree.root.left = new TreeNode(3);
        tree.root.right = new TreeNode(5);
        tree.root.right.right = new TreeNode(4);
        tree.root.left.left = new TreeNode(2);
        tree.root.left.right = new TreeNode(5);
        tree.root.left.right.right = new TreeNode(4);
        tree.root.left.right.left = new TreeNode(7);
        return tree.root;
    }

//                 6
//              /      \
//             3          5
//            /   \          \
//           2     5          4
//               /    \
//              7       4
}
