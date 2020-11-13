// Given two input integers a and b, write a method to determine the number of bits required to be swapped to convert a to b.
//
// Example:
//
// a = 21, Binary code = 10101
// b = 31, Binary code = 11111
// bitSwapRequired(a,b) --> 2


// java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

public int bitSwapRequired(int a, int b) {
    int count = 0;
    while(a != 0 || b != 0){
        if(a!=0&&b!=0){
            count += (a%2) ^ (b%2);
            a>>=1;
            b>>=1;
        }else if(a!=0){
            count++;
            a>>=1;
        }else{
            count++;
            b>>=1;
        }
    }
    return count;
}
// Time : O(N)
// Space : O(1)



public int bitSwapRequired(int a, int b) {
    int count = 0;
    int x = a ^ b;
    while(x != 0){
        x &= (x-1);
        count++;
    }
    return count;
}
// Time : O(N)
// Space : O(1)
