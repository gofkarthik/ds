package ds_ref;

import javafx.util.Pair;

import java.util.*;

public class WordLadder {


    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Map<String, List<String>> wordCombinations = new HashMap<>();
        int L = beginWord.length();
        for (String word : wordList) {
            for (int i = 0; i < L; i++) {
                String wordFormation = word.substring(0, i) + "*" + word.substring(i + 1, L);
                List<String> wordsCombo = wordCombinations.getOrDefault(wordFormation, new ArrayList<>());
                wordsCombo.add(word);
                wordCombinations.put(wordFormation, wordsCombo);
            }
        }
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1));
        while (!queue.isEmpty()) {
            Pair<String, Integer> elements = queue.remove();
            String word = elements.getKey();
            int level = elements.getValue();
            for (int i = 0; i < L; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, L);
                List<String> words = wordCombinations.getOrDefault(newWord,new ArrayList<>());
                for (String w : words) {
                    if (w.equals(endWord)) {
                        return level + 1;
                    } else {
                        if (!visited.containsKey(w)) {
                            visited.put(w, true);
                            queue.add(new Pair<>(w, level + 1));
                        }
                    }
                }
            }
        }
        return 0;
    }

    public static int ladderLength_1(String beginWord, String endWord, List<String> wordList) {

        // Since all words are of same length.
        int L = beginWord.length();

        // Dictionary to hold combination of words that can be formed,
        // from any given word. By changing one letter at a time.
        HashMap<String, ArrayList<String>> allComboDict = new HashMap<String, ArrayList<String>>();

        wordList.forEach(
                word -> {
                    for (int i = 0; i < L; i++) {
                        // Key is the generic word
                        // Value is a list of words which have the same intermediate generic word.
                        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                        ArrayList<String> transformations =
                                allComboDict.getOrDefault(newWord, new ArrayList<String>());
                        transformations.add(word);
                        allComboDict.put(newWord, transformations);
                    }
                });

        // Queue for BFS
        Queue<Pair<String, Integer>> Q = new LinkedList<Pair<String, Integer>>();
        Q.add(new Pair(beginWord, 1));

        // Visited to make sure we don't repeat processing same word.
        HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
        visited.put(beginWord, true);

        while (!Q.isEmpty()) {
            Pair<String, Integer> node = Q.remove();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < L; i++) {

                // Intermediate words for current word
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

                // Next states are all the words which share the same intermediate state.
                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<String>())) {
                    // If at any point if we find what we are looking for
                    // i.e. the end word - we can return with the answer.
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }
                    // Otherwise, add it to the BFS Queue. Also mark it visited
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        Q.add(new Pair(adjacentWord, level + 1));
                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(
                ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }
}

