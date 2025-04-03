// TC: O(N)
// SC: O(N)

public class LC938 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null) return 0;
        if(low>high) return 0;
        int cv = root.val;
        if(cv<low) return rangeSumBST(root.right, low, high);
        else if(cv>high) return rangeSumBST(root.left, low, high);
        return cv + rangeSumBST(root.left, low, cv) + rangeSumBST(root.right, cv, high);
    }
}