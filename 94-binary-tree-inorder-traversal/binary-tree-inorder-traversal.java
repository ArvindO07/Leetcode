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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;

        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        root = root.left;
        while(!st.isEmpty() || root !=null){

            if(root !=null){
                st.push(root);
                root = root.left;
            }else{
                root = st.pop();
                list.add(root.val);
                root = root.right;

            }

        }

        return list;
        
    }
}