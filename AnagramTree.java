public class AnagramTree {
    private class TreeNode {
        private byte[] summary;
        private WordNode words;
        private TreeNode left;
        private TreeNode right;

        private TreeNode(byte[] summary, WordNode words) {
            this.summary = summary;
            this.words = words;
            left = null;
            right = null;
        }
    }

    private class WordNode {
        private String word;
        private WordNode next;

        private WordNode(String word) {
            this.word = word;
            next = null;
        }
    }

    private TreeNode head;

    public AnagramTree() {
        head = new TreeNode(new byte[] {127}, null);
    }

    public void add(String word) {
        byte[] wordSum = stringToSummary(word);

        TreeNode subtree = head;
        while (true) {
            if (compareSummaries(wordSum, subtree.summary) < 0) {
                if (subtree.left == null) {
                    subtree.left = new TreeNode(wordSum, new WordNode(word));
                    return;
                } else {
                    subtree = subtree.left;
                }
            } else if (compareSummaries(wordSum, subtree.summary) > 0) {
                if (subtree.right == null) {
                    subtree.right = new TreeNode(wordSum, new WordNode(word));
                    return;
                } else {
                    subtree = subtree.right;
                }
            } else {
                if (!isIn(subtree.words, word)) {
                    WordNode temp = subtree.words;
                    subtree.words = new WordNode(word);
                    subtree.words.next = temp;
                    return;
                } else {
                    return;
                }

            }
        }
    }

    private boolean isIn(WordNode w, String word) {
        if (w.word == word) {
            return true;
        }
        WordNode temp = w;
        while (temp != null) {
            if (temp.word.equals(word))
                return true;
            else
                temp = temp.next;
        }
        return false;

    }

    public void anagrams() {

        helper(head.right);
    }

    private void helper(TreeNode subtree) {
        if (subtree == null) {
            return;
        } else {
            if (subtree.words.next != null) {
                WordNode beep = subtree.words;
                while (beep != null) {
                    System.out.print(beep.word + " ");
                    beep = beep.next;
                }
                System.out.println();
            }
        }
        helper(subtree.left);
        helper(subtree.right);
    }

    private int compareSummaries(byte[] left, byte[] right) {
        int index = 0;
        while (index < left.length && index < right.length) {
            if (left[index] == right[index]) {
                index++;
            } else {
                return (right[index] - left[index]);
            }
        }
        return 0;
    }

    private byte[] stringToSummary(String word) {
        byte[] summary = new byte[26];
        int index;
        for (int i = 0; i < word.length(); i++) {
            index = word.charAt(i) - 'a';
            summary[index]++;
        }
        return summary;
    }
}

class Anagrammer {
    public static void main(String[] args)
    {
        Words read = new Words("C:\\Users\\yroxa\\Downloads\\warAndPeace.txt");
        AnagramTree boop = new AnagramTree();
        while(read.hasNext())
        {
            boop.add(read.next());
        }
        boop.anagrams();
    }
}
