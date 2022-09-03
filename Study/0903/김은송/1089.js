const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let [N, ...input] = fs.readFileSync(filePath).toString().trim().split("\n");
// 나는 너무 하드코딩으로 풀었음
// 다른 분 풀이 참고하여 수정! 출처: https://www.acmicpc.net/source/43232080
const fail = [
  [[1], [1, 4], []],
  [
    [1, 2, 3, 7],
    [0, 1, 2, 3, 4, 5, 6, 7, 8, 9],
    [5, 6],
  ],
  [[1, 7], [0, 1, 7], []],
  [[1, 3, 4, 5, 7, 9], [0, 1, 2, 3, 4, 5, 6, 7, 8, 9], [2]],
  [[1, 4, 7], [1, 4, 7], []],
];
const getCurrentLocationAvg = (num) => {
  let isPossible = new Array(10).fill(true);
  for (let j = 0; j < 5; j++) {
    let row = num[j];
    for (let k = 0; k < 3; k++) {
      if (row[k] === "#") {
        for (let idx of fail[j][k]) {
          isPossible[idx] = false;
        }
      }
    }
  }
  let sum = 0;
  let cnt = 0;
  isPossible.forEach((num, idx) => {
    if (num) {
      sum += idx;
      cnt += 1;
    }
  });
  return cnt ? sum / cnt : -1;
};

const solve = (input, N) => {
  let average = 0;
  let cnt = N - 1;
  for (let i = 0; i < N * 4; i += 4) {
    let num = [];
    for (let j = 0; j < 5; j++) {
      num.push(input[j].substring(i, i + 3));
    }
    let locationAvg = getCurrentLocationAvg(num);
    if (locationAvg === -1) {
      average = -1;
      break;
    }
    average += locationAvg * Math.pow(10, cnt--);
  }
  console.log(average);
};
solve(input, N);
