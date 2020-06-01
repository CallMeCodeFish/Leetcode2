package hard;

import java.util.*;

/**
 * @author Heng Yu
 * @date 5/31/20 4:39 PM
 */

/**
 * leetcode 588: Design In-Memory File System
 */
public class FileSystem {
    private static class FSNode {
        String name;
        StringBuilder content;
        TreeMap<String, FSNode> children;

        public FSNode(String name) {
            this.name = name;
            this.content = null;
            this.children = null;
        }
    }

    private FSNode root;

    public FileSystem() {
        root = new FSNode("/");
        root.children = new TreeMap<>();
    }

    public List<String> ls(String path) {
        if ("/".equals(path)) {
            return new ArrayList<>(root.children.keySet());
        }

        FSNode node = root;
        String[] split = path.split("/");
        for (int i = 1; i < split.length; i++) {
            String curPath = split[i];
            node = node.children.get(curPath);
        }

        return (node.children == null)? Arrays.asList(node.name) : new ArrayList<>(node.children.keySet());
    }

    public void mkdir(String path) {
        FSNode node = root;
        String[] split = path.split("/");
        for (int i = 1; i < split.length; i++) {
            String curPath = split[i];
            if (!node.children.containsKey(curPath)) {
                FSNode newNode = new FSNode(curPath);
                newNode.children = new TreeMap<>();
                node.children.put(curPath, newNode);
            }
            node = node.children.get(curPath);
        }
    }

    public void addContentToFile(String filePath, String content) {
        FSNode node = root;
        String[] split = filePath.split("/");
        for (int i = 1; i < split.length - 1; i++) {
            String curPath = split[i];
            if (!node.children.containsKey(curPath)) {
                FSNode newNode = new FSNode(curPath);
                newNode.children = new TreeMap<>();
                node.children.put(curPath, newNode);
            }
            node = node.children.get(curPath);
        }

        String filename = split[split.length - 1];
        if (!node.children.containsKey(filename)) {
            FSNode newFile = new FSNode(filename);
            newFile.content = new StringBuilder();
            node.children.put(filename, newFile);
        }

        FSNode file = node.children.get(filename);
        file.content.append(content);
    }

    public String readContentFromFile(String filePath) {
        FSNode node = root;
        String[] split = filePath.split("/");
        for (int i = 1; i < split.length - 1; i++) {
            String curPath = split[i];
            node = node.children.get(curPath);
        }

        String filename = split[split.length - 1];
        FSNode file = node.children.get(filename);

        return file.content.toString();
    }
}
