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
// dp[(i + 1)일] 그 전날까지 끝날 일의 가능한 수 중 최댓값을 담고 있게 됨.
const dp = new Array(N + 1).fill(0);

for (let i = 0; i < N; i++) {
  const [time, profit] = arr[i];
  // 현재 날짜 + 기간이 N 넘으면 기한을 넘기는 것이니 상담 불가
  if (i + time > N) continue;
  // i + time 일부터는 해당 일은 완수 가능하니까 i + time 이후 날들은 쭉 비교함.
  for (let j = i + time; j < N + 1; j++) {
    // 해당 날의 현재 금액과 (i+1 일의 일을 하게 된다면 받게 될 금액 + 그 전날까지 한 일의 금액) 비교
    dp[j] = Math.max(dp[j], dp[i] + profit);
  }
}
console.log(Math.max(...dp));
