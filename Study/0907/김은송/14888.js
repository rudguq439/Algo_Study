const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let [N, ...input] = fs.readFileSync(filePath).toString().split("\n");
let numbers = input[0].split(" ").map(Number);
let operators = input[1].split(" ").map(Number);
N = parseInt(N);

let max = -100000000;
let min = 100000000;

let queue = [[numbers[0], 1, [...operators]]];
let front = 0;
let rear = 0;

const doCalculation = (cur, num, idx) => {
  switch (idx) {
    case 0:
      return cur + num;
    case 1:
      return cur - num;
    case 2:
      return cur * num;
    case 3:
      return parseInt(cur / num);
  }
};

while (front <= rear) {
  let [cur, numIdx, availOp] = queue[front++];
  if (numIdx === N) {
    if (cur < min) min = cur;
    if (cur > max) max = cur;
    continue;
  }

  availOp.forEach((ele, idx, origin) => {
    if (ele) {
      let calculated = doCalculation(cur, numbers[numIdx], idx);
      let updated = [...origin];
      updated[idx] -= 1;
      queue.push([calculated, numIdx + 1, updated]);
      rear++;
    }
  });
}
console.log(max + "\n" + min);
// https://www.acmicpc.net/source/43734138 방법은 거의 비슷한데 dfs 굴린 방식이 좋다. 굳이 queue 를 만들 필요 없었음을...
