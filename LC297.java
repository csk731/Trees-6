// TC: O(N)
// SC: O(N)


import java.util.*;

public class LC297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer ans = new StringBuffer();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode polled = q.poll();
            String separator = (ans.length()>0) ? ";" : "";
            if(polled==null) ans.append(separator+"N");
            else {
                ans.append(separator+polled.val);
                q.add(polled.left);
                q.add(polled.right);
            }
        }
        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("N")) return null;
        String[] parsedData = data.split(";");
        int ptr = 0, n = parsedData.length;
        TreeNode ans = new TreeNode(Integer.parseInt(parsedData[ptr++]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(ans);
        while(!q.isEmpty()){
            TreeNode polled = q.poll();
            if(!parsedData[ptr].equals("N")) {
                TreeNode left = new TreeNode(Integer.parseInt(parsedData[ptr]));
                polled.left = left;
                q.add(left);
            }
            ptr++;
            if(!parsedData[ptr].equals("N")) {
                TreeNode right = new TreeNode(Integer.parseInt(parsedData[ptr]));
                polled.right = right;
                q.add(right);
            }
            ptr++;
        }
        return ans;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
