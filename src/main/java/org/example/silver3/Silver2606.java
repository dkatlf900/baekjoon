package org.example.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Silver2606 {

    /**
     * Q, Silver-2667
     * 신종 바이러스인 웜 바이러스는 네트워크를 통해 전파된다.
     * 한 컴퓨터가 웜 바이러스에 걸리면 그 컴퓨터와 네트워크 상에서 연결되어 있는 모든 컴퓨터는 웜 바이러스에 걸리게 된다.
     * 예를 들어 7대의 컴퓨터가 <그림 1>과 같이 네트워크 상에서 연결되어 있다고 하자.
     * 1번 컴퓨터가 웜 바이러스에 걸리면 웜 바이러스는 2번과 5번 컴퓨터를 거쳐 3번과 6번 컴퓨터까지 전파되어 2, 3, 5, 6 네 대의 컴퓨터는
     * 웜 바이러스에 걸리게 된다. 하지만 4번과 7번 컴퓨터는 1번 컴퓨터와 네트워크상에서 연결되어 있지 않기 때문에 영향을 받지 않는다.
     *
     * 첫째 줄에는 컴퓨터의 수가 주어진다. 컴퓨터의 수는 100 이하인 양의 정수이고 각 컴퓨터에는 1번 부터 차례대로 번호가 매겨진다.
     * 둘째 줄에는 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수가 주어진다.
     * 이어서 그 수만큼 한 줄에 한 쌍씩 네트워크 상에서 직접 연결되어 있는 컴퓨터의 번호 쌍이 주어진다.
     *
     * 1번 컴퓨터가 웜 바이러스에 걸렸을 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 첫째 줄에 출력한다.
     * 7
     * 6
     * 1 2
     * 2 3
     * 1 5
     * 5 2
     * 5 6
     * 4 7
     */

    static int count = 0;

    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        int x = Integer.parseInt(br.readLine()); // 직접 연결되어 있는 컴퓨터 쌍의 수
        // 그래프 초기화
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프 정보 입력
        for (int i = 0; i < x; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // DFS를 통해 1번 컴퓨터와 연결된 컴퓨터 개수 계산
        boolean[] visited = new boolean[n + 1];
        dfs(graph, visited, 1);

        System.out.println(count-1);
    }

    static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int node) {
        visited[node] = true;
        count++;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(graph, visited, neighbor);
            }
        }
    }

    public int dfs(int[][] map, boolean[][] visited, int x, int y, int n) {
        // dx, dy 배열은 상하좌우 이동을 나타내는 배열
        // 상하좌우
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // 현재 위치를 방문했음을 표시하고, 영역의 크기를 1로 초기화합니다.
        visited[x][y] = true; //방문했음을 표시
        int count = 1;

        // 좌우상하로 이동하는 모든 경우를 계산한다.
        // 0, 1
        for(int i =0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 다음의 위치가 지도배열내에 있는지 확인이 필요. 인덱스 범위내에 있는지 확인
            if(nx >= 0 && ny >=0 && nx < n && ny < n){
                // 다음 검색이 1일때와 방문을 안한경우에만 탐색한다.
                if(map[nx][ny] == 1 && !visited[nx][ny]) {
                    // 다음 위치로 DFS 재귀함수 호출한다. 현재 크기에 더합니다.
                    count += dfs(map, visited, nx, ny, n);
                }
            }
        }
        // 현재 위치에서 출발하여 구한 영역의 크기를 반환합니다.
        return count;
    }

}
