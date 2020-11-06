// On an alphabet board, we start at position (0, 0), corresponding to character board[0][0].
//
// Here, board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"], as shown in the diagram below.
//
//
//
// We may make the following moves:
//
// 'U' moves our position up one row, if the position exists on the board;
// 'D' moves our position down one row, if the position exists on the board;
// 'L' moves our position left one column, if the position exists on the board;
// 'R' moves our position right one column, if the position exists on the board;
// '!' adds the character board[r][c] at our current position (r, c) to the answer.
// (Here, the only positions that exist on the board are positions with letters on them.)
//
// Return a sequence of moves that makes our answer equal to target in the minimum number of moves.  You may return any path that does so.
//
//
//
// Example 1:
//
// Input: target = "leet"
// Output: "DDR!UURRR!!DDD!"
// Example 2:
//
// Input: target = "code"
// Output: "RR!DDRR!UUL!R!"
//
//
// Constraints:
//
// 1 <= target.length <= 100
// target consists only of English lowercase letters.

class Solution {
    class Position{
        int x;
        int y;
        Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private Map<Character, Position> initialize(){
        Map<Character, Position> values = new HashMap<>();
        char curr = 'a';
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 5 && curr <= 'z'; j++){
                values.put(curr++, new Position(i, j));
            }
        }
        return values;
    }

    public String alphabetBoardPath(String target) {
        Map<Character, Position> values = initialize();
        StringBuilder sb = new StringBuilder();
        Position prev = new Position(0, 0);
        for(Character c : target.toCharArray()){
            Position curr = values.get(c);
            if(curr.x == prev.x && curr.y == prev.y){
                sb.append("!");
            }else{
                if(curr.y < prev.y){
                    sb.append("L".repeat(prev.y - curr.y));
                }
                if(curr.x < prev.x){
                    sb.append("U".repeat(prev.x - curr.x));
                }
                if(curr.y > prev.y){
                    sb.append("R".repeat(curr.y - prev.y));
                }
                if(curr.x > prev.x){
                    sb.append("D".repeat(curr.x - prev.x));
                }

                sb.append("!");
            }
            prev = curr;
        }
        return sb.toString();
    }
}
// Time : O(N)
// Space : O(N)



class Solution {


    public String alphabetBoardPath(String target) {
        StringBuilder sb = new StringBuilder();
        int x = 0;
        int y = 0;
        for(Character c : target.toCharArray()){
            int dx = (c - 'a') / 5;
            int dy = (c - 'a') % 5;
            if(dy < y){
                sb.append("L".repeat(y - dy));
            }
            if(dx < x){
                sb.append("U".repeat(x - dx));
            }
            if(dy > y){
                sb.append("R".repeat(dy - y));
            }
            if(dx > x){
                sb.append("D".repeat(dx - x));
            }
            sb.append("!");
            x = dx;
            y = dy;
        }
        return sb.toString();
    }
}

// Time : O(N)
// Space : O(1)
