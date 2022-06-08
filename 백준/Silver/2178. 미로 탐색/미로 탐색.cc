#include<iostream>
#include<queue>
#include<string>
using namespace std;


int graph[101][101];
bool visited[101][101];
int n, m;
int answer;

struct p {
	int cur_n;
	int cur_m;
	int number;
};



void bfs(int cur_n, int cur_m) {
	queue<p> q;
	q.push({ 1,1,1 });
	visited[cur_n][cur_m] = true;


	while (!q.empty())
	{
		int cur_n = q.front().cur_n;
		int cur_m = q.front().cur_m;
		int number = q.front().number;
		q.pop();

		if (cur_n == n && cur_m == m) {
			cout << number;
			return;
		}

		if (cur_n - 1 >= 1 && graph[cur_n - 1][cur_m] == 1 && !visited[cur_n - 1][cur_m]) {
			visited[cur_n - 1][cur_m] = true;
			q.push({ cur_n - 1,cur_m,number + 1 });

		}
		if (cur_n + 1 <= n && graph[cur_n + 1][cur_m] == 1 && !visited[cur_n + 1][cur_m]) {
			visited[cur_n + 1][cur_m] = true;
			q.push({ cur_n + 1,cur_m,number + 1 });

		}
		if (cur_m - 1 >= 1 && graph[cur_n][cur_m - 1] == 1 && !visited[cur_n][cur_m - 1]) {
			visited[cur_n][cur_m - 1] = true;
			q.push({ cur_n ,cur_m - 1,number + 1 });

		}
		if (cur_m + 1 <= m && graph[cur_n][cur_m + 1] == 1 && !visited[cur_n][cur_m + 1]) {
			visited[cur_n][cur_m + 1] = true;
			q.push({ cur_n,cur_m + 1,number + 1 });
		}

	}

}
int main() {
	string c;
	cin >> n >> m;


	for (int i = 1; i <= n; i++) {
		cin >> c;
		for (int s = 1; s <= c.length(); s++) {
			graph[i][s] = c[s - 1] - '0';
		}
	}

	bfs(1, 1);








}