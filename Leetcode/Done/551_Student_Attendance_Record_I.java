// You are given a string representing an attendance record for a student. The record only contains the following three characters:
// 'A' : Absent.
// 'L' : Late.
// 'P' : Present.
// A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).
//
// You need to return whether the student could be rewarded according to his attendance record.
//
// Example 1:
// Input: "PPALLP"
// Output: True
// Example 2:
// Input: "PPALLL"
// Output: False



class Solution {
    public boolean checkRecord(String s) {
        boolean absent = false;
        int lateCount = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'A'){
                if(absent){
                    return false;
                }
                absent = true;
                lateCount = 0;
            }else if(s.charAt(i) == 'L'){
                lateCount++;
                if(lateCount > 2){
                    return false;
                }
            }else{
                lateCount = 0;
            }
        }
        return true;
    }
}
// Time : O(N)
// Space : O(1)




class Solution {
    public boolean checkRecord(String s) {
        return !s.matches(".*(A.*A|LLL).*");
    }
}
// Time complexity : O(n)O(n). matchesmatches method takes O(n)O(n) time.
// Space complexity : O(1)O(1). No Extra Space is used.
