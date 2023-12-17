#include <cstdio>
#include <cstring>

using namespace std;

int N;
int dp[1001][2];

int main() {
	memset(dp, 0, sizeof(dp));

	scanf("%d", &N);
	fgetc(stdin);

	dp[1][0] = 1;
	dp[1][1] = 0;
	dp[2][0] = 1;
	dp[2][1] = 1;

	for (int i = 3; i <= N; ++i) {
		dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) % 10007;
		dp[i][1] = (dp[i - 2][0] + dp[i - 2][1]) % 10007;
	}

	printf("%d\n", (dp[N][0] + dp[N][1]) % 10007);

	return 0;
}