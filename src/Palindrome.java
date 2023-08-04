


public class Palindrome {



    /**
     * Utilizes stacks to determine if the given string is a palindrome. This method ignores whitespace and case
     * sensitivity, but does not ignore digits or symbols.
     *
     * @param s a string comprised of any character
     * @return returns true if a palindrome (ignoring whitespace and case sensitivity), false otherwise
     */
    public boolean isPalindrome(String s) {
        if(s == null)
            throw new IllegalArgumentException();
        s = s.replaceAll("\\s", "");

        if(s.length() == 1)
            return true;

        int midpoint;
        if(s.length() % 2 == 1) {
            midpoint = ((s.length()) - 1) / 2;
            char charToRemove = s.charAt(midpoint);
            String removeItem = String.valueOf(charToRemove);
            s = s.replace(removeItem, "");
        }

        ArrayListStack<Character> originalStack = new ArrayListStack<>();
        ArrayListStack<Character> copyStack = new ArrayListStack<>();
        midpoint = s.length()/2;

        //Original stack
        for(int i = 0; i < s.length(); i++) {
            char charToAdd = s.charAt(i);
            originalStack.push(charToAdd);
        }

        //Copy stack
        for(int i = 0; i < midpoint; i++) {
            char element = (char) originalStack.pop();
            copyStack.push(element);
        }

        //Compare the two stacks
        while(!originalStack.empty()) {
            String original = String.valueOf(originalStack.pop());
            String copy = String.valueOf(copyStack.pop());
            if(!original.equalsIgnoreCase(copy))
                return false;
        }

        return true;

    } // End of method isPalindrome
}