package dsa_jan_2026.binarytree;

public class PathSumEasy {
    public boolean hasPathSum(TreeNode root, int targetSum) {

        return hasPathSumRecursive(root, targetSum, 0);
    }

    private boolean hasPathSumRecursive(TreeNode currNode, int targetSum, int currSum) {
        if(currNode == null)
            return false;

        currSum = currSum + currNode.val;
        if(currNode.left==null && currNode.right==null && currSum==targetSum)
            return true;


        boolean isLeftPathSum = currNode.left==null ? false:hasPathSumRecursive(currNode.left, targetSum, currSum);
        if(isLeftPathSum)
            return true;

        boolean isRightPathSum = currNode.right==null ? false:hasPathSumRecursive(currNode.right, targetSum, currSum);
        if(isRightPathSum)
            return true;

        return false;
    }

    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
