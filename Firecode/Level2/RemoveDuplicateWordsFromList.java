/*
Given a List of Strings, write a method removeDuplicates that removes duplicate words from the List and returns an ArrayList of all the unique words. The returned ArrayList should be lexically alphabetically.

Input: [Hi, Hello, Hey, Hi, Hello, Hey]

Output: [Hello, Hey, Hi]

*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static ArrayList<String> removeDuplicates(List<String> input) {
    Set<String> vals = new TreeSet<>();
    for(String i : input){
        vals.add(i);
    }
    return new ArrayList<>(vals);

}
