// TC: O(W + N); As N >> W => O(N)
// SC: O(N)
// where W is the width of the tree
// and N is the number of nodes in the tree

import java.util.*;

public class LC314 {
    class Pair {
        TreeNode tn;
        int idx;

        Pair(TreeNode tn, int idx) {
            this.tn = tn;
            this.idx = idx;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        Queue<Pair> q = new LinkedList<>();
        if(root!=null) q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Pair polled = q.poll();
                TreeNode polledNode = polled.tn;
                int polledIdx = polled.idx;
                min = Math.min(min, polledIdx);
                max = Math.max(max, polledIdx);
                if(!map.containsKey(polledIdx)) map.put(polledIdx, new ArrayList<>());
                map.get(polledIdx).add(polledNode.val);
                if(polledNode.left!=null) q.add(new Pair(polledNode.left, polledIdx-1));
                if(polledNode.right!=null) q.add(new Pair(polledNode.right, polledIdx+1));
            }
        }
        for(int i=min;i<=max;i++){
            ans.add(map.get(i));
        }
        return ans;
    }
}
