#include<iostream>
#include<queue>
using namespace std;

int answer;
int visited[1001][1001]; // 중복 체크

struct emoticon {
	int emoticons;
	int time;
	int clip;
};

void bfs(int s) {
	queue<emoticon>q;
	q.push({ 1, 0,0 });


	while (!q.empty())
	{
		int emoticons = q.front().emoticons;
		int time = q.front().time;
		int clip = q.front().clip;
		q.pop();

		if (emoticons == s) {
			answer = time;
			return;
		}

		if (clip<emoticons) {
			q.push({ emoticons,time + 1,emoticons });
		}
		if (!visited[emoticons][clip] && clip+emoticons<=1000 && clip) {
			q.push({ emoticons + clip,time + 1,clip });
			visited[emoticons][clip] = 1;

		}
		if (!visited[emoticons-1][clip] && emoticons > 2) {
			q.push({ emoticons - 1,time + 1,clip });
			visited[emoticons - 1][clip] = 1;
		}

	}
}

int main() {
	int s;

	cin >> s;

	bfs(s);

	cout << answer;

}