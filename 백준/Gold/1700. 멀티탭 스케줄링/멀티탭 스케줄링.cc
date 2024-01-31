#include <cstdio>
#include <cstring>
#include <algorithm>
#include <vector>

using namespace std;

int n;
int k;
vector<int> seq;
int tap[100];

int main() {
	scanf("%d %d", &n, &k);
	fgetc(stdin);

	memset(tap, 0, sizeof(tap));

	for (int i = 0; i < k; ++i) {
		int tmp;
		scanf("%d", &tmp);
		fgetc(stdin);
		seq.push_back(tmp);
	}

	int rslt = 0;

	for (int i = 0; i < k; ++i) {
		bool flg = false;
		for (int j = 0; j < n; ++j) {
			if (seq[i] == tap[j]) {
				flg = true;
				break;
			}
		}

		if (flg) {
			continue;
		}

		for (int j = 0; j < n; ++j) {
			if (tap[j] == 0) {
				tap[j] = seq[i];
				flg = true;
				break;
			}
		}

		if (flg) {
			continue;
		}

		int swap;
		int val = -1;
		for (int j = 0; j < n; ++j) {
			int term = 0;
			for (int idx = i + 1; idx < k && tap[j] != seq[idx]; ++idx) {
				++term;
			}
			if (term > val) {
				swap = j;
				val = term;
			}
		}
		++rslt;
		tap[swap] = seq[i];
	}

	printf("%d\n", rslt);

	return 0;
}