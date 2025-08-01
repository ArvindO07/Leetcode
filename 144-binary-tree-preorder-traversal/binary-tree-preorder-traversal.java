/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null ) return list;

        if(root.left == null && root.right == null){
            list.add(root.val);
            return list;
        }

        Stack<TreeNode> st = new Stack<>();

        st.push(root);

        while(!st.isEmpty()){
            TreeNode temp = st.pop();
            list.add(temp.val);

            if(temp.right!=null) st.push(temp.right);
            if(temp.left!=null) st.push(temp.left);
        }


        return list;

        
    }
}