package hard;

import java.util.*;

/**
 * @author Heng Yu
 * @date 5/15/20 7:48 PM
 */

/**
 * leetcode 212: Word search II
 * solution: using words to construct trie and check grid in board
 */
public class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        List<String> res = new ArrayList<>();
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (String word : words) {
            for (int i = 0; i < m; ++i) {
                boolean canBreak = false;
                for (int j = 0; j < n; ++j) {
                    if (helper(word, 0, board, visited, i, j, dirs)) {
                        res.add(word);
                        canBreak = true;
                        break;
                    }
                }
                if (canBreak) break;
            }
        }

        return res;
    }

    private boolean helper(String word, int index, char[][] board, boolean[][] visited, int i, int j, int[][] dirs) {
        if (word.charAt(index) != board[i][j]) return false;

        if (index == word.length() - 1) return true;

        int m = board.length;
        int n = board[0].length;

        visited[i][j] = true;

        boolean ret = false;

        for (int[] dir : dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (ni >= 0 && ni < m && nj >= 0 && nj < n && !visited[ni][nj]) {
                if (helper(word, index + 1, board, visited, ni, nj, dirs)) {
                    ret = true;
                    break;
                }
            }
        }

        visited[i][j] = false;

        return ret;
    }
}

class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    String word = null;
    public TrieNode() {}
}


class Solution {
    char[][] _board = null;
    ArrayList<String> _result = new ArrayList<String>();

    public List<String> findWords(char[][] board, String[] words) {

        // Step 1). Construct the Trie
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;

            for (Character letter : word.toCharArray()) {
                if (node.children.containsKey(letter)) {
                    node = node.children.get(letter);
                } else {
                    TrieNode newNode = new TrieNode();
                    node.children.put(letter, newNode);
                    node = newNode;
                }
            }
            node.word = word;  // store words in Trie
        }

        this._board = board;
        // Step 2). Backtracking starting for each cell in the board
        for (int row = 0; row < board.length; ++row) {
            for (int col = 0; col < board[row].length; ++col) {
                if (root.children.containsKey(board[row][col])) {
                    backtracking(row, col, root);
                }
            }
        }

        return this._result;
    }

    private void backtracking(int row, int col, TrieNode parent) {
        Character letter = this._board[row][col];
        TrieNode currNode = parent.children.get(letter);

        // check if there is any match
        if (currNode.word != null) {
            this._result.add(currNode.word);
            currNode.word = null;
        }

        // mark the current letter before the EXPLORATION
        this._board[row][col] = '#';

        // explore neighbor cells in around-clock directions: up, right, down, left
        int[] rowOffset = {-1, 0, 1, 0};
        int[] colOffset = {0, 1, 0, -1};
        for (int i = 0; i < 4; ++i) {
            int newRow = row + rowOffset[i];
            int newCol = col + colOffset[i];
            if (newRow < 0 || newRow >= this._board.length || newCol < 0
                    || newCol >= this._board[0].length) {
                continue;
            }
            if (currNode.children.containsKey(this._board[newRow][newCol])) {
                backtracking(newRow, newCol, currNode);
            }
        }

        // End of EXPLORATION, restore the original letter in the board.
        this._board[row][col] = letter;

        // Optimization: incrementally remove the leaf nodes
        if (currNode.children.isEmpty()) {
            parent.children.remove(letter);
        }
    }
}

