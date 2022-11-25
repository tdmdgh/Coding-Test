package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B1949 {
    static int N;
    static int [] people;
    static List<Integer>[] tree;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
        N = Integer.parseInt(br.readLine());
        people = new int [N+1];
        dp = new int[N+1][2];
        tree = new ArrayList[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i< N+1; i++){
            people[i] = Integer.parseInt(st.nextToken());
            tree[i] = new ArrayList<>();
        }
        for(int i = 0 ; i<N-1;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }
        DFS(1,0);
        System.out.println(Math.max(dp[1][1],dp[1][0]));
    }
    static void DFS(int n,int parent){
        for(int child : tree[n]){
            if(child!=parent){
                DFS(child,n);
                dp[n][0] += Math.max(dp[child][1],dp[child][0]);
                dp[n][1] += dp[child][0];
            }
        }
        dp[n][1] += people[n];
    }
}
