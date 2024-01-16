package org.example.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Silver2667 {

    /**
     * Q, Silver-2667
     * <그림 1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을,
     * 0은 집이 없는 곳을 나타낸다.
     * 철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다.
     * 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다.
     * 대각선상에 집이 있는 경우는 연결된 것이 아니다. <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다.
     * 지도를 입력하여 단지수를 출력하고,
     * 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.
     *
     *
     * 첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.
     * 7
     * 0110100
     * 0110101
     * 1110101
     * 0000111
     * 0100000
     * 0111110
     * 0111000
     */
    public void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        boolean[][] visited = new boolean[n][n];

        for(int i=0;i<n;i++) {
            String a = br.readLine();
            for(int j=0; j<n; j++) {
                map[i][j] = a.charAt(j) - '0'; // 아스키코드를 빼서 정수값을 획득하기 위해 '0'을 제한다
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        // 모든 좌표에 대해서 DFS 수행
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(map[i][j] == 1 && !visited[i][j]) { // 아직 탐색하지 않았을때 실행
                    result.add(dfs(map,visited,i,j,n));
                }
            }
        }

        // 결과 출력
        Collections.sort(result);
        System.out.println(result.size());
        for (int count : result) {
            System.out.println(count);
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
