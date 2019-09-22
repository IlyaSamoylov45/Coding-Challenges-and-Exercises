/*
Write a method that takes in an input String and returns true if all the characters in the String are unique and false if there is even a single repeated character.
The method should return true if the input is null or empty String.

Examples:
areAllCharactersUnique("abcde") -> true
areAllCharactersUnique("aa") -> false
areAllCharactersUnique("") -> true
areAllCharactersUnique(null) -> true
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static boolean areAllCharactersUnique(String str){
    if(str == null){
        return true;
    }
    int[] val = new int[256];
    for(int i = 0; i < str.length(); i++){
        int c = str.charAt(i);
        if(val[c]++ > 0){
            return false;
        }
    }
    return true;
}
