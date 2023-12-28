#include <stdio.h>
#include <math.h>

int searching(int N, int i, int j);

int main() {
	int N;
	int i;
	int j;

	while(scanf("%d %d %d", &N, &i, &j) != EOF) {
		fgetc(stdin);
		printf("%d\n", searching(N, i, j));
	}
	return 0;
}

int searching(int N, int i, int j) {
	if (N == 0) {
		return 0;
	}
	//printf("i = %d, j = %d\n", i, j);

	int deli = pow(2, N - 1);
	int flg_i = 1;
	int flg_j = 1;
	
	if (i < deli) {
		flg_i = 0;
	}
	if (j < deli) {
		flg_j = 0;
	}
	return (flg_i * 2 + flg_j) * pow(2, 2 * (N - 1))
		+ searching(N - 1, i >= deli ? i - deli : i, j >= deli ? j - deli : j);
}
