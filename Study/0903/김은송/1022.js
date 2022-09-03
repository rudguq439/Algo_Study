const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let [R1, C1, R2, C2] = fs
  .readFileSync(filePath)
  .toString()
  .trim()
  .split(" ")
  .map(Number);

const find = (row, col) => {
  let maxPoint = Math.max(Math.abs(row), Math.abs(col));
  let num = (maxPoint * 2 + 1) ** 2;
  if (row === maxPoint) {
    return num - (maxPoint - col);
  } else if (col === -maxPoint) {
    num -= maxPoint * 2;
    return num - (maxPoint - row);
  } else if (row === -maxPoint) {
    num -= maxPoint * 2 * 2;
    return num - (maxPoint + col);
  } else {
    num -= maxPoint * 2 * 3;
    return num - (maxPoint + row);
  }
};
let ans = [];
let max = 1;
for (let i = R1; i <= R2; i++) {
  let row = [];
  for (let j = C1; j <= C2; j++) {
    row.push(find(i, j));
  }
  let rowMaxLen = Math.max(...row).toString().length;
  if (rowMaxLen > max) max = rowMaxLen;
  ans.push(row);
}
ans = ans.map((row) => {
  return row.map((ele) => ele.toString().padStart(max, " ")).join(" ");
});
console.log(ans.join("\n"));

// 내 시간의 반절인 풀이: https://www.acmicpc.net/source/10321495
