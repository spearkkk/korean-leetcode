#include <stdio.h>
#include <vector>
#include <algorithm>
#include <functional>

using namespace std;

void making(int n, int idx, const int cnt_a, const int cnt_p, const vector<char> & alph, char* pass);

int main() {
	int cnt_pass;
	int cnt_alph;
	vector<char> alph;

	scanf("%d %d\n", &cnt_pass, &cnt_alph);

	for (int i = 0; i < cnt_alph; ++i) {
		char tmp;
		scanf("%c", &tmp);
		fgetc(stdin);
		alph.push_back(tmp);
	}

	sort(alph.begin(), alph.end(), less<char>());

	//for (int i = 0; i < cnt_alph; ++i) {
	//	printf("%c ", alph.at(i));
	//}
	//printf("\n");

	for (int i = 0; i < cnt_alph - cnt_pass + 1; ++i) {
		char *pass = new char[cnt_pass + 1];
		pass[cnt_pass] = '\0';
		pass[0] = alph[i];
		making(1, i, cnt_alph, cnt_pass, alph, pass);
	}

	return 0;
}

void making(int n, int idx, const int cnt_a, const int cnt_p, const vector<char> & alph, char* pass) {
	if (n != cnt_p) {
		for(int i = 0; i < cnt_a - cnt_p + 1; ++i) {
			int tmp = i + n;
			if (tmp <= idx) {
				continue;
			}
			pass[n] = alph[tmp];
			making(n + 1, i + n, cnt_a, cnt_p, alph, pass);
		}
	}
	else {
		int flg = 0;
		for (int i = 0; i < cnt_p; ++i) {
			switch (pass[i]) {
			case 'a':
			case 'i':
			case 'o':
			case 'u':
			case 'e':
				++flg;
			}
		}
		if (flg == 0 || (cnt_p - flg) < 2) {
			return;
		}
		printf("%s\n", pass);
	}
}