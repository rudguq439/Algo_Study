const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let [N, ...stairs] = fs
  .readFileSync(filePath)
  .toString()
  .trim()
  .split("\n")
  .map(Number);
// 현재 계단을 [안 밟았을때([i-1][1]), 밟았을 때([i-1][0]+현재값)] 최대값

// // 현재 계단에서 가능한 경우의 수
// // 1.x o o  => 2를 봐야 함
// let dp1 = [];
// // 2. o x o => 3, 4 중 큰 값
// let dp2 = [];
// // 3. x o x => 2
// let dp3 = [];
// // 4. o o x => 1
// let dp4 = [];

let dp = [
  [0, 0],
  [stairs[0], stairs[0]],
];

for (let i = 2; i <= N; i++) {
  dp[i] = [
    dp[i - 1][1] + stairs[i - 1],
    Math.max(dp[i - 2][0], dp[i - 2][1]) + stairs[i - 1],
  ];
}
console.log(Math.max(...dp[N]));
