/**
Problem: https://leetcode.com/problems/shortest-word-distance-ii/
*/
class WordDistance {
    HashMap<String, List<Integer>> wordIndexMap;
    int size = 0;
    
    public WordDistance(String[] wordsDict) {
       // initialization
        size = wordsDict.length;
        wordIndexMap = new HashMap<>();
            
        for (int i = 0; i < size; ++i) {
	        if (!wordIndexMap.containsKey(wordsDict[i])) {
                wordIndexMap.put(wordsDict[i], new ArrayList<Integer>());
            }
            wordIndexMap.get(wordsDict[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> loc1 = wordIndexMap.get(word1);
        List<Integer> loc2 = wordIndexMap.get(word2);
        int i1 = 0, i2 = 0;
        int minDistance = size + 1;
        while (i1 < loc1.size() && i2 < loc2.size()) {
            minDistance = Math.min(minDistance, Math.abs(loc1.get(i1) - loc2.get(i2)));
            if (loc1.get(i1) < loc2.get(i2)) {
                ++i1;
            } else {
                ++i2;
            }
        }
        return minDistance;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */