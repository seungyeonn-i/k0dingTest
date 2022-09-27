import java.util.Arrays;

public class BOJ_10875 {

    static MyReader sc = new MyReader();
    static StringBuilder sb = new StringBuilder();

    static class Elem implements Comparable<Elem> {

        public String name;
        public int kor,eng,math;

        @Override   //정렬 조건
        public int compareTo(Elem other) {
            //국어 점수 내림차순(높은게 먼저)
            if(kor != other.kor) return other.kor - kor;
            //영어 점수 오름차순
            if(eng != other.eng) return eng - other.eng;
            //수학 점수 내림차순
            if(math != other.math) return other.math - math;
            return name.compareTo(other.name);
        }

    }

    static int N;
    static Elem[] arr;

    static void input() {
        N = sc.nextInt();
        arr = new Elem[N];
        for(int i=0;i<N;i++){
            arr[i] = new Elem();
            arr[i].name = sc.next();
            arr[i].kor = sc.nextInt();
            arr[i].eng = sc.nextInt();
            arr[i].math = sc.nextInt();
        }
    }

    static void pro() {
        Arrays.sort(arr);
        for (int i = 0; i < N; i++) {
            sb.append(arr[i].name).append('\n');
        }
        System.out.println(sb.toString());

    }

    public static void main(String[] args) {
        input();
        pro();
    }
}


