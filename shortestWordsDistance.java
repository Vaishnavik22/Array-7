/**
Problem:
Given an array of strings wordsDict and two different strings that already exist in the array word1 and word2, return the shortest distance between these two words in the list.

Example 1:
Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "coding", word2 = "practice"
Output: 3

Example2:
Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "coding"
Output: 1

https://leetcode.com/problems/shortest-word-distance/
*/
class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int word1Pointer = -1, word2Pointer = -1;
        int minDist = Integer.MAX_VALUE;
        
        
        for (int i = 0; i < wordsDict.length; ++i) {
            if (wordsDict[i].equals(word1)) {
                word1Pointer = i;
                if (word2Pointer != -1 && minDist > Math.abs(word2Pointer - word1Pointer)) {
                    minDist = Math.abs(word2Pointer - word1Pointer);
                }
            } else if (wordsDict[i].equals(word2)) {
                word2Pointer = i;
                if (word1Pointer != -1 && minDist > Math.abs(word1Pointer - word2Pointer)) {
                    minDist = Math.abs(word2Pointer - word1Pointer);
                }
            }
        }
        
        return minDist;
    }
}