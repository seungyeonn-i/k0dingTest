import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Crane {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0,0,0,0,0},
                                                {0,0,1,0,3},
                                                {0,2,5,0,1},
                                                {4,2,4,4,2},
                                                {3,5,1,3,1}},
                                                new int[]{1,5,3,5,1,2,1,4}));
    }
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();
        for (int move : moves) {
            for(int i = 0 ; i < board.length ; i++){
                if(board[move - 1][i] != 0){
                    if (!basket.empty() && basket.peek() == board[move - 1][i]){
                        basket.pop();
                        answer += 2;
                    }
                    else if(basket.empty()){
                        basket.add(board[move-1][i]);
                        board[move-1][i] = 0;
                    }
                    else{
                        basket.add(board[move-1][i]);
                        board[move-1][i] = 0;
                    }
                }
            }

        }
        return answer;
    }
}
