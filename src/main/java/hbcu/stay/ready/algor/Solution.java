package hbcu.stay.ready.algor;

import java.util.HashMap;

public class Solution {
    // 1. Create a HashMap count of all words in magazineText
    // 2. Create a HashMap count of all words in message
    // 3. If one of the values in message exceeds the corresponding value in magazineText,
    // return False
    // 4. Else { return true }

    public Boolean harmlessRansomNote(String message , String magazineText){
        HashMap<String, Integer> magazineTextTracker = new HashMap<>();
        HashMap<String, Integer> messageTracker = new HashMap<>();

        String[] stringedMagazineText = magazineText.split(" ");
        String[] stringedMessage = message.split(" ");

        for (String magazineWord : stringedMagazineText) {
            if (!magazineTextTracker.containsKey(magazineWord)) {
                magazineTextTracker.put(magazineWord, 1);
            }
            else {
                int currentValue = magazineTextTracker.get(magazineWord);
                currentValue++;
                magazineTextTracker.put(magazineWord, currentValue);
            }
        }

        for (String messageWord : stringedMessage) {
            if (!messageTracker.containsKey(messageWord)) {
                messageTracker.put(messageWord, 1);
            }
            else {
                int currentValue = messageTracker.get(messageWord);
                currentValue++;
                messageTracker.put(messageWord, currentValue);
            }
        }


        for (String word : stringedMessage) {
            // if a word in the message is not found in the magazineText, return false
            if(!magazineTextTracker.containsKey(word)) {
                return false;
            }

            // If a word in the message is found in the magazineText,
            // check how many times it is found in the magazineText.

            // If value is > 1, subtract the value
            // If value == 1, remove element from Magazine (because the word
            // cannot be used again)
            else if(magazineTextTracker.containsKey(word) && magazineTextTracker.get(word) > 1) {
                int currentValue = magazineTextTracker.get(word);
                currentValue--;
                magazineTextTracker.put(word, currentValue);
            }

            // The word must be in the magazine, and the value must equal 1
            else {
                magazineTextTracker.remove(word);
            }
        }

        return true;
    }
}
