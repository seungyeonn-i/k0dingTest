public class BOJ_10875 {


    public static void main(String[] args) {

    }
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

    static void input() {

    }

    static void pro() {

    }
}


