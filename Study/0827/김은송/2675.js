const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let [T, ...inputs] = fs.readFileSync(filePath).toString().trim().split("\n");

let ans = [];
for (let input of inputs) {
  let [R, S] = input.split(" ");
  let str = "";
  for (let char of S) {
    str += char.repeat(R);
  }
  ans.push(str);
}
console.log(ans.join("\n"));
