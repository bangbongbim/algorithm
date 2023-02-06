import java.util.*;
import java.io.*;


public class 장애물인식프로그램
{
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static List<Integer> list = new ArrayList<>();
    static int blocks;
    public static void main(String args[])throws Exception
    {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        
        // 입력
        for(int i = 0 ; i<N;i++){
            String str = br.readLine();
            for(int j = 0 ; j < str.length() ;j++)
            map[i][j] = str.charAt(j) - '0';
        }


        // 위치가 블록이고 방문하지 않은곳이면 bfs
        for(int i = 0 ; i < N ;i++){
            for(int j = 0 ; j < N ; j++){
                if(map[i][j] == 1 && !visited[i][j])
                {
                   blocks++;
                   int count = bfs(i,j);
                   list.add(count);
                }
            }
        }

        // 정렬
        Collections.sort(list);
        System.out.println(blocks);

        // 정렬된 리스트 출력
        for(int i = 0 ; i<list.size();i++)
        System.out.println(list.get(i));
        
    }
    static int bfs(int y,int x){
        Queue<int[]> q = new ArrayDeque<>();
        int count = 0;

        q.offer(new int[] {y,x});
        visited[y][x] = true;
        count++;
        while(!q.isEmpty()){
            int size = q.size();

            for(int s=0 ; s<size;s++){
                int[] top = q.poll();

                for(int d = 0; d<4;d++){
                    int ny = top[0] + dy[d];
                    int nx = top[1] +dx[d];

                    if(ny<0 || nx<0 || ny>=N || nx>=N || visited[ny][nx]||map[ny][nx]==0)
                        continue;

                    q.offer(new int[] {ny,nx});
                    visited[ny][nx] =true;
                    count++;
                }
            }
        }
            return count;
    }

}