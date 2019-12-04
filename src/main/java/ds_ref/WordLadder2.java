package ds_ref;

import java.util.*;

public class WordLadder2 {

    List<List<String>> res = new ArrayList<>();
    List<String> list = new LinkedList<>();
    Map<String, List<String>> map = new HashMap<>();


    Map<String, List<String>> words = new HashMap<>();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> results = new ArrayList<>();
        List<String> unVisitedWords = new ArrayList<>(wordList);
        List<String> visitedWords = new ArrayList<>();
        if (!unVisitedWords.contains(endWord)) {
            return results;
        }
        Map<String, List<String>> words = new HashMap<>();
        Queue<String> wordsQueue = new ArrayDeque<>();
        wordsQueue.add(beginWord);
        boolean found = false;
        while (!wordsQueue.isEmpty()) {
            int size = wordsQueue.size();
            for (int k = size - 1; k >= 0; k--) {
                String w = wordsQueue.remove();
                if (w.equals("cog")) {
                    System.out.println();
                }
                for (int i = 0; i < w.length(); i++) {
                    char[] chars = w.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String nwWord = String.valueOf(chars);
                        if (unVisitedWords.contains(nwWord)) {
                            if (!visitedWords.contains(nwWord)) {
                                visitedWords.add(nwWord);
                                wordsQueue.add(nwWord);
                            }
                            List<String> wr = words.getOrDefault(nwWord, new ArrayList<>());
                            wr.add(w);
                            words.put(nwWord, wr);
                        }
                        if (nwWord.equals(endWord)) {
                            found = true;
                        }
                    }

                }
            }
                if (found) break;
                unVisitedWords.removeAll(visitedWords);
                visitedWords.clear();

        }
        System.out.println("test");
        return null;
    }

    private void backTrace(){

    }

    public List<List<String>> findLadders1(String beginWord, String endWord, List<String> wordList) {
        if (wordList.size() == 0) return res;

        Queue<String> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        Set<String> unvisited = new HashSet<>(wordList);
        q.add(beginWord);
        unvisited.remove(beginWord);
        boolean found = false;

        // bfs
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = size - 1; k >= 0; k--) { // for each string in the queue
                String word = q.poll();
                for (int i = 0; i < word.length(); i++) {
                    char chs[] = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        chs[i] = c;
                        String newStr = new String(chs);
                        if (unvisited.contains(newStr)) {
                            if (!visited.contains(newStr)) {
                                visited.add(newStr);
                                q.add(newStr);
                            }
                            // build adjacent graph
                            if (map.containsKey(newStr)) map.get(newStr).add(word);
                            else {
                                List<String> l = new ArrayList<>();
                                l.add(word);
                                map.put(newStr, l);
                            }
                            if (newStr.equals(endWord)) found = true;
                        }
                    }//a-z
                }//first index-last index
            }//for each string
            if (found) break;
            unvisited.removeAll(visited);
            visited.clear();

        }

        // back trace based on the adjacent graph that we have built
        backTrace(endWord, beginWord);
        return res;
    }

    private void backTrace(String cur, String start) {
        if (cur.equals(start)) {
            list.add(0, start);
            res.add(new ArrayList<String>(list));
            list.remove(0); // backtrace by one step
            return;
        }
        list.add(0, cur);
        if (map.get(cur) != null) {
            for (String s : map.get(cur)) { // for each neighbors
                backTrace(s, start);
            }
        }
        list.remove(0);
    }

    static void printChar() {

        String s = "hot";
        System.out.println(s);
        for (int i = 0; i < s.length(); i++) {
            char[] ch1 = s.toCharArray();
            for (char ch = 'a'; ch <= 'z'; ch++) {
                ch1[i]=ch;
                System.out.print(String.valueOf(ch1)+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printChar();
        System.out.println(
                new WordLadder2().findLadders("hit", "cog",
                        Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }
}
