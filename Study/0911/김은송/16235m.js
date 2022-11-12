// 첫 코드는 시간 초과 떠서 https://www.acmicpc.net/source/39881274 참고
// 시간 줄이는 것이 목표였으나, 내 코드가 더 오래 걸림..ㅜ
// sort 생각하면 당연히 오래 걸린다. 작은 얘들이 뒤에 추가되니까, 처음에만 내림차순으로 정렬시키고, 뒤부터 확인해야 할 듯
// const fs = require("fs");
// const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
// let input = fs.readFileSync(filePath).toString().split("\n");

// console.log(solution(input));
const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});
let input = [];
rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  console.log(solution(input));
  process.exit();
});
function solution(given) {
  let [NMK, ...input] = given.map((ele) => ele.split(" ").map(Number));
  let [N, M, K] = NMK;
  let land = new Array(N).fill().map(() => new Array(N).fill(5));
  let A = input.slice(0, N);
  let answer = 0;
  let trees = new Array(N)
    .fill()
    .map(() => new Array(N).fill().map(() => new Array()));
  input
    .slice(N)
    .forEach(([row, col, age]) => trees[row - 1][col - 1].push(age));

  for (let i = 0; i < K; i++) {
    trees = year(N, trees, land, A);
  }
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
      answer += trees[i][j].length;
    }
  }
  return answer;
}

function year(N, trees, land, A) {
  trees = spring(trees, land, N);
  winter(land, N, A);
  return trees;
}

function spring(trees, land, N) {
  // 작은 얘들이 뒤로 쌓이니까 사실 뒤로 도는 쪽이 효율적임!!
  let temp = new Array(N)
    .fill()
    .map(() => new Array(N).fill().map(() => new Array()));
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
      let dead = false;
      let treesOnSquare = trees[i][j];
      if (!treesOnSquare.length) continue;
      treesOnSquare = treesOnSquare.sort((a, b) => a - b);

      for (let k = 0; k < treesOnSquare.length; k++) {
        let age = treesOnSquare[k];
        // spring
        if (!dead && age <= land[i][j]) {
          land[i][j] -= age;
          temp[i][j].push(age + 1);
          // fall
          if ((age + 1) % 5 === 0) {
            breed(i, j, temp, N);
          }
        } else {
          // summer
          if (!dead) dead = true;
          land[i][j] += parseInt(age / 2);
        }
      }
    }
  }
  return temp.map((el) => el.map((e) => [...e]));
}

function breed(i, j, temp, N) {
  const dr = [-1, -1, -1, 0, 0, 1, 1, 1];
  const dc = [-1, 0, 1, -1, 1, -1, 0, 1];

  for (let k = 0; k < 8; k++) {
    const nr = dr[k] + i;
    const nc = dc[k] + j;
    if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
    temp[nr][nc].push(1);
  }
}

function winter(land, N, A) {
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
      land[i][j] += A[i][j];
    }
  }
}
