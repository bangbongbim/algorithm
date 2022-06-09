#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

bool visited[101];
vector<int> graph[101];
int answer;
bool check = false;

void dfs(int p, int c, int cnt) {
	visited[p] = true;

	for (int i = 0; i < graph[p].size(); i++) {
		int next = graph[p][i];

		if (next == c) {
			answer = cnt+1;
			return;
		}

		if (!visited[next]) {
			dfs(next, c, cnt + 1);
		}
	}
}
int main() {
	int t;
	int p, c;
	int n;
	int x, y;

	cin >> t;
	cin >> p >> c;
	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> x >> y;
		graph[x].push_back(y);
		graph[y].push_back(x);
	}

	for (int i = 1; i <= n; i++) {
		sort(graph[i].begin(), graph[i].end());
	}


	dfs(p, c, 0);
	if (answer != 0)
		cout << answer;
	else
		cout << "-1";
}