#include<iostream>
#include<queue>
using namespace std;

bool visited[100001];
int answer;

void bfs(int n, int k) {
	queue<pair<int, int>> q;
	q.push({ n,0 });
	visited[n] = true;


	while (!q.empty())
	{
		int current = q.front().first;
		int time = q.front().second;
		q.pop();

		if (current == k) {
			answer = time;
			return;
		}

		if (current * 2 >= 0 && current * 2 <= 100000 && !visited[current * 2]) {
			visited[current * 2] = true;
			q.push({ current * 2,time });
		}
		if (current - 1 >= 0 && current - 1 <= 100000 && !visited[current - 1]) {
			visited[current - 1] = true;
			q.push({ current - 1,time + 1 });
		}
		if (current + 1 >= 0 && current + 1 <= 100000 && !visited[current + 1]) {
			visited[current + 1] = true;
			q.push({ current + 1,time + 1 });
		}
	
	}
}
int main() {
	int n, k; 

	cin >> n >> k;

	bfs(n, k);

	cout << answer;
}