// In a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.
//
// Return the element repeated N times.
//
//
//
// Example 1:
//
// Input: [1,2,3,3]
// Output: 3
// Example 2:
//
// Input: [2,1,2,5,3,2]
// Output: 2
// Example 3:
//
// Input: [5,1,5,2,5,3,5,4]
// Output: 5
//
//
// Note:
//
// 4 <= A.length <= 10000
// 0 <= A[i] < 10000
// A.length is even






class Solution {
    public int repeatedNTimes(int[] A) {
        Set<Integer> set = new HashSet<>();
        for(int x : A){
            if(!set.add(x)){
                return x;
            }
        }
        return -1;
    }
}
// Time : O(N)
// Space :  O(N)





class Solution {
    public int repeatedNTimes(int[] A) {
        for(int i = 2; i < A.length; i++){
            if(A[i] == A[i-1] || A[i] == A[i-2]){
                return A[i];
            }
        }
        return A[0];
    }
}
// Time : O(N)
// Space : O(1)






class Solution {
        public int repeatedNTimes(int[] A) {
        int x = -1;
        int y = -1;
        int z = -1;
        for(int i = 0; i < A.length; i++){
        	if(x == A[i]){
        		return x;
        	}
        	if(y == A[i]){
        		return y;
        	}
        	if(z == A[i]){
        		return z;
        	}
        	x = y;
        	y = z;
        	z = A[i];
        }

        return -1;
    }
}

// Time : O(N)
// Space : O(1)
