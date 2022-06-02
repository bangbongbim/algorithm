#include<iostream>
#include<vector>
#include<queue>
using namespace std;

bool visited[100001];
int  route[100001];
vector<int> from;
int answer;

void bfs(int n,int k) {
	queue<pair<int, int>> q;
	q.push({ n,0 });
	visited[n] = false;

	while (!q.empty())
	{
		int current = q.front().first;
		int time = q.front().second;
		q.pop();

		if (current == k) {
			answer = time;
			while (current != n)
			{
				from.push_back(current);
				current = route[current];
			}
			from.push_back(n);
			return;
		}

		if (current - 1 >= 0 && current - 1 <= 100000 && !visited[current - 1]) {
			visited[current - 1] = true;
			q.push({ current - 1,time + 1 });
			route[current - 1] = current;
		}
		if (current + 1 >= 0 && current + 1 <= 100000 && !visited[current + 1]) {
			visited[current + 1] = true;
			q.push({ current + 1,time + 1 });
			route[current + 1] = current;
		}
		if (current * 2 >= 0 && current * 2 <= 100000 && !visited[current * 2]) {
			visited[current * 2] = true;
			q.push({ current * 2,time + 1 });
			route[current * 2] = current;
		}



	}


}
int main() {
	int n, k;

	cin >> n >> k;

	bfs(n, k);

	cout << answer << endl;
	
	for (int i = from.size() - 1; i >= 0; i--) {
		cout << from[i] << " ";
	}
}