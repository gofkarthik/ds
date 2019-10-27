package ds.trie.practise;


import java.util.HashMap;
import java.util.Map;

class TrieNode {

    Map<Character, TrieNode> children = new HashMap<>();

    boolean endOfWord = false;
}

public class Trie {

    private TrieNode rootNode = new TrieNode();

    void insert(String word) {
        TrieNode currentNode = rootNode;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = currentNode.children.get(ch);
            if (node == null) {
                node = new TrieNode();
                currentNode.children.put(ch, node);
            }
            currentNode = node;
        }
        currentNode.endOfWord = true;
    }

    boolean search(String word) {
        TrieNode currentNode = rootNode;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = currentNode.children.get(ch);
            if (node == null) {
                System.out.println("word not found " + word);
                return false;
            }
            currentNode = node;
        }

        if (currentNode.endOfWord == true) {
            System.out.println("word found " + word);
            return true;
        } else {
            System.out.println("word not found " + word);
            return false;
        }
    }


    void delete(String word) {
        if (search(word) == true) {
            delete(word, rootNode, 0);
        }
    }

    boolean delete(String word, TrieNode parentNode, int index) {

        char ch=word.charAt(index);
        TrieNode currentNode=parentNode.children.get(ch);

        boolean nodeCanBeDeleted ;
        if(currentNode.children.size() > 1){
            delete(word, currentNode, index+1);
            return false;
        }

        if(index == word.length() -1 ){

            if(currentNode.children.size() >= 1){
                currentNode.endOfWord = false;
                return false;
            }else{
                System.out.println("Character " + ch + " has no dependency, hence deleting it");
                parentNode.children.remove(ch);

                return true;
            }

        }

        if(currentNode.endOfWord){
            delete(word, currentNode, index+1);
            return false;
        }

        nodeCanBeDeleted=delete(word, currentNode, index+1);

        if(nodeCanBeDeleted){
            System.out.println("Character " + ch + " has no dependency, hence deleting it");
            parentNode.children.remove(ch);
            return true;
        }else{
            return false;
        }

    }


    public static void main(String[] args) {
        Trie t = new Trie();
        /*t.insert("bcde");
        t.insert("bckg");
        t.delete("bcde");
        t.search("bcde");
        t.search("bckg");
*/

       /* t.insert("bcde");
        t.insert("bcdefg");
        t.delete("bcde");
        t.search("bcde");
        t.search("bcdefg");*/

/*
        t.insert("bcde");
        t.insert("bc");
        t.delete("bcde");
        t.search("bcde");
        t.search("bcde");
        t.search("bc");
        t.search("b");*/

        t.insert("bcde");
        t.delete("bcde");
        t.search("bcde");
    }
}
