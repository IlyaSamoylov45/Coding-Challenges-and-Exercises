/*
Write a method duplicate to find the repeated or duplicate elements in an array.
This method should return a list of repeated integers in a string with the elements sorted in ascending order (as illustrated below).


duplicate({1,3,4,2,1}) --> "[1]"
duplicate({1,3,4,2,1,2,4}) --> "[1, 2, 4]"

Note: You may use toString() method to return the
standard string representation of most data structures, and
Arrays.sort() to sort your result.
*/

// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public static String duplicate(int[] numbers){
  TreeSet<Integer> result = new TreeSet<Integer>();
  // Sort the array
  Arrays.sort(numbers);
  //Iterate over the array
  for(int i = 1; i < numbers.length; i++) {
      // If previous element is the same as current, its the duplicate element
      if(numbers[i] == numbers[i - 1]) {
          result.add(numbers[i]);
      }
  }
  return result.toString();
}
