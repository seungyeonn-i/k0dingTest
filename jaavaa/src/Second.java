import java.util.*;
import java.io.*;

public class Second {
    static class GasStation implements Comparable<GasStation> {
        int location;
        int fuel;

        public GasStation(int location, int fuel) {
            this.location = location;
            this.fuel = fuel;
        }

        @Override
        public int compareTo(GasStation o) {
            return this.location - o.location;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        GasStation[] stations = new GasStation[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int location = Integer.parseInt(st.nextToken());
            stations[i] = new GasStation(location, 0);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int fuel = Integer.parseInt(st.nextToken());
            stations[i].fuel = fuel;
        }

        Arrays.sort(stations);

        int answer = 0;
        int index = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            while (index < M && stations[index].location <= i) {
                pq.add(stations[index++].fuel);
            }

            if (G == 0) {
                if (pq.isEmpty()) {
                    System.out.println(-1);
                    return;
                }
                G += pq.poll();
                answer++;
            }
            G--;
        }

        System.out.println(answer);
    }
}
