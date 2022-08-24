// const fs = require("fs");
// const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
// let word = fs.readFileSync(filePath).toString().trim();
// let letterDict = {};

// for (let char of word) {
//   char = char.toUpperCase();
//   if (letterDict.hasOwnProperty(char)) letterDict[char] += 1;
//   else letterDict[char] = 1;
// }

// letterDict = Object.entries(letterDict).sort((a, b) => b[1] - a[1]);

// letterDict.length > 1 && letterDict[0][1] === letterDict[1][1]
//   ? console.log("?")
//   : console.log(letterDict[0][0]);

// 시간 효율: https://www.acmicpc.net/source/47417698
// 내장함수를 활용하면 됐음!!!!!
const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filePath).toString().trim().toUpperCase();
const checker = new Array(26).fill(0);

for (let i = 0; i < input.length; i++) {
  const ascii = input[i].charCodeAt() - 65;
  checker[ascii] += 1;
}
const maxNum = Math.max(...checker);
// 첫번째 인덱스와 마지막 인덱스의 일치여부를 확인한다.
const notDuplicate = checker.indexOf(maxNum) === checker.lastIndexOf(maxNum);

console.log(
  notDuplicate ? String.fromCharCode(65 + checker.indexOf(maxNum)) : "?"
);
