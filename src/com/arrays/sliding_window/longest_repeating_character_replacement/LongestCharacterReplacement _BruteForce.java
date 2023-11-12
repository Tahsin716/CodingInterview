public class LongestCharacterReplacement {
    public static int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int maxLength = 0;

        // Iterate through each character in the string as the potential starting point
        for (int start = 0; start < s.length(); start++) {
            char targetChar = s.charAt(start);

            int replacements = 0; // Number of replacements allowed
            int currentLength = 0; // Current length of the window

            // Extend the window as long as we have replacements available
            for (int end = start; end < s.length(); end++) {
                char currentChar = s.charAt(end);

                if (currentChar != targetChar) {
                    replacements++;
                }

                // If the number of replacements exceeds the allowed limit (k),
                // update the window and check if the length can be increased
                while (replacements > k) {
                    char startChar = s.charAt(start);
                    if (startChar != targetChar) {
                        replacements--;
                    }
                    start++;
                }

                // Update the current length of the window
                currentLength = end - start + 1;

                // Update the maxLength if the current window is longer
                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }
}
