// 13:39
// 1차 시도: ...런타임 에러? -> readline 으로 수정

// 정석대로 풀면 시간 초과 뜸.
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";

const input = require("fs").readFileSync(filePath).toString().split("\n");
console.time("TEST");
let [n, m, k] = input[0].split(" ").map((e) => parseInt(e));
const nutritions = input.slice(1, n + 1).map((e) => e.split(" ").map(Number));
const land = Array.from(new Array(n), () => new Array(n).fill(5));
const trees = new Array(n)
  .fill()
  .map(() => new Array(n).fill().map(() => new Array()));
input.slice(n + 1).forEach((tree) => {
  let [r, c, age] = tree.split(" ").map(Number);
  trees[r - 1][c - 1].push(age);
});

while (k--) {
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      let nutrition = land[i][j];
      const treeList = trees[i][j];

      let diedIndex = -1;

      // 봄
      for (let k = treeList.length - 1; k >= 0; k--) {
        const age = treeList[k];
        if (age === -1) break;
        if (age <= nutrition) {
          nutrition -= age;
          treeList[k] += 1;
        } else {
          diedIndex = k;
          break;
        }
      }
      land[i][j] = nutrition;

      // 여름
      for (let k = diedIndex; k >= 0; k--) {
        const age = treeList[k];
        if (age === -1) break;
        land[i][j] += Math.floor(age / 2);
        treeList[k] = -1;
      }
    }
  }

  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      const treeList = trees[i][j];
      // 가을
      for (let k = treeList.length - 1; k >= 0; k--) {
        const age = treeList[k];
        if (age === -1) break;
        if (age % 5 === 0) breed(i, j);
      }
      addNutrition(i, j);
    }
  }
}

console.log(countAliveTree());

function breed(i, j) {
  const dr = [-1, -1, -1, 0, 0, 1, 1, 1];
  const dc = [-1, 0, 1, -1, 1, -1, 0, 1];

  for (let k = 0; k < 8; k++) {
    const nr = dr[k] + i;
    const nc = dc[k] + j;
    if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
    trees[nr][nc].push(1);
  }
}

function addNutrition(i, j) {
  land[i][j] += nutritions[i][j];
}

function countAliveTree() {
  let count = 0;
  console.log(trees);
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      for (let k = trees[i][j].length - 1; k >= 0; k--) {
        const age = trees[i][j][k];
        if (age === -1) break;
        else count++;
      }
    }
  }
  return count;
}
