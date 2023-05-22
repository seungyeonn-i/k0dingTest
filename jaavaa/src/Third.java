import java.util.*;

public class Third {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("카드의 개수를 입력하세요: ");
        int C = scanner.nextInt();

        System.out.print("주기 N을 입력하세요: ");
        int N = scanner.nextInt();

        List<Integer> cards = new ArrayList<>();
        for (int i = 1; i <= C; i++) {
            cards.add(i);
        }

        shuffleCards(cards, N);

        System.out.println("카드 섞기 결과: " + cards);
    }

    public static void shuffleCards(List<Integer> cards, int N) {
        List<Integer> temp = new ArrayList<>();
        while (true) {
            temp.clear();

            // 위에서 사장과 아래에서 사장을 제외한 나까지 카드들을 순서를 유지한 채 가장 위쪽으로 올립니다.
            for (int i = 1; i < cards.size() - 1; i++) {
                temp.add(cards.get(i));
            }

            // 위로 올라온 카드들의 수를 확인합니다.
            if (temp.size() > N) {
                // 위로 올라온 카드들의 수가 N을 초과하면 해당 카드들에 대해서만 카드 섞기를 처음부터 반복합니다.
                cards.clear();
                cards.add(0);  // 기상 위의 주기 1 카드 추가
                cards.addAll(temp);
            } else {
                // 위로 올라온 카드들의 수가 N을 초과하지 않으면 1회 수행 과정을 마칩니다.
                break;
            }
        }
    }
}
