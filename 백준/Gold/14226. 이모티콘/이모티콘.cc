#include <iostream>
#include <queue>
#define MAX 1000
using namespace std;

int target;
int visited[MAX + 1][MAX + 1]; // 중복 체크
struct Info
{
	int num, clip, depth;
}info;
queue <Info> que;

int main() {
	cin >> target;
	que.push({ 1, 0, 0 }); 

	while (!que.empty())
	{
		auto k = que.front(); que.pop();
		int num = k.num;
		int clip = k.clip;
		int depth = k.depth;

		if (num == target) { // 값에 도달한 경우 종료
			cout << depth << '\n';
			return 0;
		}

		//1번 명령어 : clip으로 복사.
		if (clip < num) { 
			que.push({ num, num, depth + 1 });
		}

		//2번 명령어 : clip 갯수 붙여넣기
		if (!visited[num][clip] and clip + num <= 1000 and clip) {
			visited[num][clip] = 1;
			que.push({ num + clip, clip, depth + 1 });
		}

		//3번 명령어 : 1개 제거
		if (!visited[num - 1][clip] and num > 2) {
			visited[num - 1][clip] = 1;
			que.push({ num - 1, clip, depth + 1 });
		}
	}
	return 0;
}