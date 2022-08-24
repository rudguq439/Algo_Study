const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let [info, ...sea] = fs.readFileSync(filePath).toString().trim().split("\n");
let [N, M] = info.split(" ").map(Number);

const getGlaciers = (N, M, sea) => {
  let glaciers = [];
  for (let i = 0; i < N; i++) {
    sea[i] = sea[i].split(" ").map(Number);
    for (let j = 0; j < M; j++) {
      if (sea[i][j] !== 0) glaciers.push([i, j]);
    }
  }
  return glaciers;
};

const meltGlaciers = (input, glaciers) => {
  let newGlaciers = [];
  let temp = input.map((ele) => ele.slice());

  for (let [nr, nc] of glaciers) {
    let melted = arounds.filter(([dr, dc]) => {
      return !isGlacier(nr + dr, nc + dc, input);
    }).length;

    if (input[nr][nc] - melted > 0) {
      temp[nr][nc] -= melted;
      newGlaciers.push([nr, nc]);
    } else {
      temp[nr][nc] = 0;
    }
  }
  return [temp, newGlaciers];
};

const checkDivided = (input, glaciers, N, M) => {
  let queue = [[...glaciers[0]]];
  let front = 0;
  let rear = 0;
  let cnt = 1;
  let visited = new Array(N).fill().map(() => new Array(M).fill(false));
  visited[glaciers[0][0]][glaciers[0][1]] = true;
  while (front <= rear) {
    let [row, col] = queue[front++];
    arounds.forEach(([dr, dc]) => {
      let nr = dr + row;
      let nc = dc + col;
      if (isGlacier(nr, nc, input) && !visited[nr][nc]) {
        queue.push([nr, nc]);
        visited[nr][nc] = true;
        cnt += 1;
        rear += 1;
      }
    });
  }
  return cnt;
};

const isGlacier = (row, col, arr) => {
  return row >= 0 && row < N && col >= 0 && col < M && arr[row][col] !== 0
    ? true
    : false;
};

const getMeltingTime = (N, M, sea) => {
  let timeSpent = 0;
  while (glaciers.length > 1) {
    let cnt = checkDivided(sea, glaciers, N, M);
    if (cnt !== glaciers.length) return timeSpent;
    [sea, glaciers] = meltGlaciers(sea, glaciers);
    timeSpent++;
  }
  return 0;
};

let glaciers = getGlaciers(N, M, sea);
let arounds = [
  [1, 0],
  [0, 1],
  [-1, 0],
  [0, -1],
];

console.log(getMeltingTime(N, M, sea));

// 다른 풀이: 시간이 훨씬 효율적임
// https://www.acmicpc.net/source/41250980
