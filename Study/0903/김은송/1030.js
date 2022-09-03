// 설계가 안 되가지고 풀이 참고함
// https://blue-jay.tistory.com/33
const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const [s, N, K, R1, R2, C1, C2] = fs
  .readFileSync(filePath)
  .toString()
  .trim()
  .split(" ")
  .map(Number);

function find(row, col, n, k, width) {
  if (width == 1) return 0;

  let beforeWidth = Math.floor(width / n);
  // 검정색부분(가운데)의 시작.
  let middleStart = Math.floor(((n - k) / 2) * beforeWidth);
  // 일단 정중앙 검정색에 걸릴때만 거른다! 검정색은 계속 들어가다보면 언젠간 가운데 검정색에 걸릴 수 밖에 없음.
  if (
    row >= middleStart &&
    row < width - middleStart &&
    col >= middleStart &&
    col < width - middleStart
  ) {
    // 한 번 검정색이면 계속 검정색이니까 1 반환
    return 1;
  }
  // 예시 N:3 K:1로 설명하면
  // 정중앙 검은색 부분말고 나머지 8(N**2-1)구역들은 똑같음~ 그래서 제일 왼쪽 위 놈만 남긴다고 상상해도 된다.
  // 한 줄은 beforeWidth 가 3(N)번 반복된 형태이기에 나머지가 같으면, 나랑 동일한 놈인 것이다.
  // example => s = 3 일때 (0,8) 이랑 (18, 26) 이 같은 놈임!
  // 즉, row % beforeWidth, col % beforeWidth 요거는 제일 왼쪽 위 구역의 나와 동일한 놈의 좌표를 찾는 작업임
  return find(row % beforeWidth, col % beforeWidth, n, k, beforeWidth);
}

// 미리 다 만드는 것은 시간복잡도가 좋지 않고 메모리도 비효율적으로 사용하게 됨.
// 그래서 역으로 필요한 부분만 find() 함수를 통해 거슬러올라가는 방식을 사용해야 한다.
function solve(s, n, k, r1, r2, c1, c2) {
  let ans = [];
  // 주어진 지수를 거듭제곱한 값! n ** s
  let width = Math.pow(n, s);

  for (let i = r1; i <= r2; i++) {
    let row = [];
    for (let j = c1; j <= c2; j++) {
      row.push(find(i, j, n, k, width));
    }
    ans.push(row);
  }
  for (let i = 0; i < ans.length; i++) {
    console.log(ans[i].reduce((a, b) => a + "" + b));
  }
}
solve(s, N, K, R1, R2, C1, C2);
