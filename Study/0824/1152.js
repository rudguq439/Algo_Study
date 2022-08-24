const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let word = fs
  .readFileSync(filePath)
  .toString()
  .trim()
  .split(" ")
  .filter(Boolean);
console.log(word.length);
