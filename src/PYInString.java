import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PYInString {

    //대문자와 소문자가 섞여있는 문자열 s가 주어집니다. s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True,
    // 다르면 False를 return 하는 solution를 완성하세요.
    // 'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다. 단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.
    //예를 들어 s가 "pPoooyY"면 true를 return하고 "Pyy"라면 false를 return 합니다.

    // 대소문자 구별하지 않고 py 갯수 비교 , py 없으면 true

    //-> p가 들어오면 무조건 y가 들어와야함. 그래서 cnt 이용하여 갯수 비교
    //-> 대소문자 상관 없으므로 그냥 py 대입

    public static void main(String[] args) {
        System.out.println(solution("pPoooyY"));
    }

    static boolean solution(String s) {
        boolean answer = true;
        char c = ' ';
        int cnt = 0;

        for(int i=0;i<s.length();i++){
            c = s.charAt(i);

            if(c == 'p' || c == 'P')
                cnt++;
            else if(c == 'y' || c == 'Y')
                cnt--;
        }
        //문자열 순회 끝나고 cnt 비교
        if(cnt != 0)
            return false;
        return true;
    }
}
