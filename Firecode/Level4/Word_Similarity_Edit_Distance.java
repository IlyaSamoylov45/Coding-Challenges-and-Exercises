// Edit distance is a classic algorithm that is used in many applications, including Spell Correction, DNA Sequencing and Natural Language Processing. Given two Strings, a and b, write a method - editDistance that returns the minimum number of operations needed to transform a into b. The following character operations are allowed :
//
// a) Replace character
// b) Insert character
// c) Delete character
//
// Examples :
//
// editDistance("sale", "sales") => 1
//
// Operations :
// 1) Insert "s"
//
// editDistance("sale", "sold") => 2
//
// Operations :
// 1) Replace "a" with "o"
// 2) Replace "e" with "d"
//
// editDistance("sa", "s") => 1
//
// Operations :
// 1) Delete "a"




// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public int editDistance(String a, String b){
    int[][] arr = new int[a.length() + 1][b.length() + 1];
    for(int i = 1; i < a.length(); i++){
        arr[i][0] = i;
    }
    for(int j = 1; j < b.length(); j++){
        arr[0][j] = j;
    }
    for(int i = 0; i < a.length(); i++){
        for(int j = 0; j < b.length(); j++){
            if(a.charAt(i) == b.charAt(j)){
                arr[i+1][j+1] = arr[i][j];
            }else{
                arr[i+1][j+1] = Math.min(Math.min(arr[i+1][j], arr[i][j+1]), arr[i][j]) + 1;
            }
        }
    }
    return arr[a.length()][b.length()];
}
// Time : O(N)
// Space : O(N)
