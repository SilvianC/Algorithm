package P14466;

import java.util.*;
import java.io.*;

public class Main {
    static int n,k,r;
    // 존의 농장
    static int[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visited;
    static ArrayList<Node>[][] bridges;
    static Node[] cows;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1];
        bridges = new ArrayList[n+1][n+1];

        for(int i = 0;i<=n;i++){
            for(int j = 0;j<=n;j++){
                bridges[i][j] = new ArrayList<Node>();
            }
        }

        int r1, c1, r2, c2;
        for(int i = 0;i<r;i++){
            st = new StringTokenizer(br.readLine());
            r1 = Integer.parseInt(st.nextToken());
            c1 = Integer.parseInt(st.nextToken());
            r2 = Integer.parseInt(st.nextToken());
            c2 = Integer.parseInt(st.nextToken());

            bridges[r1][c1].add(new Node(r2,c2));
            bridges[r2][c2].add(new Node(r1,c1));
        }

        cows = new Node[k];
        int nowR, nowC;

        for(int i = 0;i < k; i++){
            st = new StringTokenizer(br.readLine());

            nowR = Integer.parseInt(st.nextToken());
            nowC = Integer.parseInt(st.nextToken());
            cows[i] = new Node(nowR, nowC);
        }

        System.out.println(process());
    }
    static int process(){
        int cnt = 0;

        for(int i = 0;i < k-1;i++){
            visited = new boolean[n+1][n+1];

            bfs(cows[i].x, cows[i].y);

            for(int j = i+1;j < k;j++){
                Node node = cows[j];
                if(!visited[node.x][node.y]){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    static void bfs(int x, int y){
        Queue<Node> q = new ArrayDeque<Node>();

        q.add(new Node(x,y));

        while(!q.isEmpty()){
            // nextNode
            Node nn = q.poll();

            int nx, ny;
            for(int d = 0;d<4;d++){
                nx = nn.x + dx[d];
                ny = nn.y + dy[d];

                if(nx<=0 || ny <= 0 || nx > n || ny > n || visited[nx][ny])
                  continue;

                int size = bridges[nn.x][nn.y].size();
                boolean isBridge = false;
                for(int i = 0; i <size;i++){
                    // connectNode
                    Node cn = bridges[nn.x][nn.y].get(i);
                    if(cn.x == nx && cn.y == ny){
                        isBridge = true;
                        break;
                    }
                }
                // 다리 연결
                if(isBridge)
                    continue;
                visited[nx][ny] = true;
                q.add(new Node(nx, ny));
            }
        }

    }
}
class Node{
    int x;
    int y;
    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}