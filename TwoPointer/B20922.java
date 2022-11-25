package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B20922 {
    static int N, K;
    static int[] arr;
    static int[] count = new int[100001];
    ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right = 0;
        int ans = 0;
        while (left <= right) {
            if (right < N && count[arr[right]] < K) {
                count[arr[right]]++;
                right++;
            } else if (count[arr[right]] == K) {
                count[arr[left]]--;
                left++;
            }
            ans = Math.max(ans, right - left);
            if (right == N) break;
        }
        System.out.println(ans);

    }
}
