// 3085 2644
// https://www.acmicpc.net/source/41564277

const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const [NM, ...lines] = input;
const [N, M] = NM.split(" ").map((n) => parseInt(n));

const edges = Array(N + 1)
  .fill()
  .map((i) => []);
const depth = Array(N + 1).fill(0);
let answer = "";

function DFS(i) {
  let count = 0;

  const visited = Array(N + 1).fill(false);
  const stack = [i];
  visited[i] = true;

  while (stack.length >= 1) {
    const node = stack.pop();
    // forEach 로 변경하면 시간 초과가 난다...!
    // optimized for loop 으로 length 미리 구해두면 더 빠른 것임!!
    // https://velog.io/@cada/%EC%9E%90%EB%B0%94%EC%8A%A4%ED%81%AC%EB%A6%BD%ED%8A%B8-for-loop-%EC%86%8D%EB%8F%84-%EB%B9%84%EA%B5%90
    for (let i = 0, length = edges[node].length; i < length; i++) {
      const n = edges[node][i];
      if (!visited[n]) {
        count += 1;
        visited[n] = true;
        stack.push(n);
      }
    }
  }

  depth[i] = count;
}

for (let i = 0; i < M; i++) {
  const [A, B] = lines[i].split(" ").map((n) => parseInt(n));
  edges[B].push(A);
}

for (let i = 1; i <= N; i++) {
  DFS(i);
}

const max = Math.max(...depth);

for (let i = 0; i <= N; i++) {
  if (depth[i] === max) answer += i + " ";
}

console.log(answer.trim());
