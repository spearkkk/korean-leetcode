#include <bits/stdc++.h>

using namespace std;


int main(void) {
    ios::sync_with_stdio(0);
    
    int n;
    int m;
    
    cin.tie(0);
    cin >> n >> m;
    
    std::vector<int> pts;
    int scores[n][m];
    
    for (int i = 0; i < n; i++)  {
        pts.push_back(0); // index 0 is first cursor
    
        for (int j = 0; j < m; j++) {
            cin >> scores[i][j];
        }
    }
    
    
    // sorting
    for (int i = 0; i < n; i++) {
        sort(scores[i], scores[i] + m);
    }
    
    int ans = 1000000000 + 1;
    
    while(1) {
        int minIdx;
        
        int min = 1000000000 + 1;
        int max = -1;
        
        for (int i = 0; i < n; i++) {
            int tmp = scores[i][pts[i]];
            
            if (tmp < min) {
                min = tmp;
                minIdx = i;
            }
            
            if (max < tmp) {
                max = tmp;
            }
        }
        
        ans = std::min(ans, max - min);
        pts[minIdx] += 1;
        
        // escape
        if (pts[minIdx] == m) {
            break;
        }
    
    }
    
    cout << ans;
}
