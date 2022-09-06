// dp 는 진짜 모르겠음... 더 열심히 공부해야할 듯ㅜ

// https://breathtaking-life.tistory.com/149
const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let [N, ...arr] = fs
  .readFileSync(filePath)
  .toString()
  .split("\n")
  .map((ele) => ele.split(" ").map(Number));

N = N[0];
const dp = new Array(N + 1).fill(0);

for (let i = 0; i < N; i++) {
  const [time, profit] = arr[i];
  if (i + time > N) continue; // 현재 날짜 + 기간이 n이 넘으면 상담 불가
  // dp => idx + 1 그 전날까지 끝날 일을 담고 있게 되가지고 해당 날부터 새 일을 할 수 있음.

  for (let j = i + time; j < N + 1; j++) {
    dp[j] = Math.max(dp[j], dp[i] + profit); // 현재 금액, i일 뒤에 받게 될 금액 비교
  }
}
console.log(Math.max(...dp));
