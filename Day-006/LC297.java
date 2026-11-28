/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    public void s(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append("N,");
            return ;
        }

        sb.append(root.val).append(",");
        s(root.left, sb);
        s(root.right, sb);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        s(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        int i[] = {0};

        return buildTree(nodes, i);
    }

    public TreeNode buildTree(String[] nodes, int i[]) {
        if(nodes[i[0]].equals("N")) {
            i[0]++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(nodes[i[0]]));
        i[0]++;

        root.left = buildTree(nodes, i);
        root.right = buildTree(nodes, i);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));