#include<iostream>
using namespace std;

int sdoku[9][9];
bool check[10];

void reset() {
	for (int i = 0; i < 10; i++) {
		check[i] = false;
	}
}
int case1() {
	for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 9; j++) {
			if (!check[sdoku[i][j]])
				check[sdoku[i][j]] = true;
			else
				return false;
		}
		reset();
	}
	return true;
}

int case2() {
	for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 9; j++) {
			if (!check[sdoku[j][i]])
				check[sdoku[j][i]] = true;
			else
				return false;
		}
		reset();
	}
	return true;
}


int case3() {
	for (int i = 0; i <= 6; i+=3) {
		for (int j = 0; j <= 6; j+=3) {
			for (int k = i; k <= i + 2; k++) {
				for (int h = j; h <= j + 2; h++) {
					if (!check[sdoku[k][h]])
						check[sdoku[k][h]] = true;
					else
						return false;
				}
			}
			reset();
		}

	}
	return true;
}


int main() {
	int t;
	int num;

	cin >> t;

	for (int tc = 1; tc <= t; tc++) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				cin >> num;
				sdoku[i][j] = num;
			}
		}

	

		if (case1() && case2() && case3()) {
			cout << "#" << tc << " " << 1 << endl;
		}
		else {
			cout << "#" << tc << " " << 0 << endl;
		}
	}




}