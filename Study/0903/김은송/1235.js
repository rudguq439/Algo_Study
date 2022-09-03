// 15:25 ~ 15:43
const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";

let [N, ...nums] = fs.readFileSync(filePath).toString().trim().split("\n");
let len = nums[0].length;
N = parseInt(N);
for (let i = 1; i <= len; i++) {
  let numSet = new Set();
  for (let num of nums) {
    let key = num.slice(len - i);
    if (numSet.has(key)) {
      break;
    } else {
      numSet.add(key);
    }
  }
  if (numSet.size === N) {
    console.log(i);
    break;
  }
}

// 왜 data.shift() 앞에 + 붙이나 했더니 string을 number 로 만듦!
// 출처: https://www.acmicpc.net/source/45059023
// let data = fs.readFileSync(filePath).toString().trim().split("\n");
// console.log(+data.shift(), data);
