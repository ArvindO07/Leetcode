class Solution {
    public List<String> removeSubfolders(String[] folder) {
        PrefixTree root = new PrefixTree();
        List<String> result = new ArrayList<>();
        
        // Build the prefix tree
        for (String path : folder) {
            String[] parts = path.split("/");
            buildTree(root, parts);
        }
        
        // Check each path and collect non-subfolders
        for (String path : folder) {
            String[] parts = path.split("/");
            if (!isSubFolder(root, parts)) {
                result.add(path);
            }
        }
        
        return result;
    }

    private void buildTree(PrefixTree node, String[] parts) {
        for (int i = 1; i < parts.length; i++) {
            String part = parts[i];
            if (!node.children.containsKey(part)) {
                node.children.put(part, new PrefixTree());
            }
            node = node.children.get(part);
        }
        node.isEnd = true;
    }

    private boolean isSubFolder(PrefixTree node, String[] parts) {
        for (int i = 1; i < parts.length - 1; i++) {
            node = node.children.get(parts[i]);
            if (node.isEnd) {
                return true;
            }
        }
        return false;
    }

    static class PrefixTree {
        Map<String, PrefixTree> children;
        boolean isEnd;
        
        PrefixTree() {
            children = new HashMap<>();
            isEnd = false;
        }
    }
}