const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let [N, ...input] = fs
  .readFileSync(filePath)
  .toString()
  .split("\n")
  .map((ele) => ele.split(" ").map(Number));

N = N[0];
// 완~~~~~~~~~~~전 효율 떨어지는 내 풀이
// const getCombi = (arr, selectedNum) => {
//   const results = [];
//   if (selectedNum === 1) return arr.map((ele) => [ele]);
//   arr.forEach((fixed, index, origin) => {
//     const rest = origin.slice(index + 1);
//     const combis = getCombi(rest, selectedNum - 1);
//     const attached = combis.map((ele) => [fixed, ...ele]);
//     results.push(...attached);
//   });
//   return results;
// };

// const getTotal = (arr) => {
//   let total = 0;
//   getCombi(arr, 2).forEach(([i, j]) => {
//     total += input[i][j] + input[j][i];
//   });
//   return total;
// };
// const solution = (N) => {
//   let ppl = new Array(N).fill().map((_, idx) => idx);

//   let startLink = getCombi(ppl, N / 2);
//   let starts = startLink.slice(0, startLink.length / 2);
//   let links = startLink.slice(startLink.length / 2);
//   let min = Number.MAX_SAFE_INTEGER;

//   for (let i = 0; i < starts.length; i++) {
//     let start = starts[i];
//     let link = links[starts.length - 1 - i];
//     min = Math.min(Math.abs(getTotal(start) - getTotal(link)), min);
//   }
//   return min;
// };

// console.log(solution(N));

// https://www.acmicpc.net/source/45142235
const teamA = [],
  teamB = [];
let answer = Number.MAX_SAFE_INTEGER;
let overWrapCheck = false;

const makeTeam = (count) => {
  if (teamA.length === 1 && teamB.length === N - 1) {
    overWrapCheck = true;
  }
  // count 가 N 이 되면 모든 사람이 팀을 가졌다.
  if (count === N) {
    // 딱 반이 되었을 때.
    if (teamA.length === N / 2) {
      // A, B 비교
      const curr = teamCompare(teamA, teamB);
      answer = Math.min(answer, curr);
    }
    return;
  }

  if (!overWrapCheck) {
    if (teamA.length < N / 2) {
      teamA.push(count);
      makeTeam(count + 1);
      teamA.pop();
    }
    // 위에서 뱉은 놈을 B 에서 받게 됨! 그렇게 계속 팀을 만들고
    teamB.push(count);
    makeTeam(count + 1);
    teamB.pop();
  }
};

const teamCompare = (arr1, arr2) => {
  let score1 = 0;
  let score2 = 0;

  for (let i = 0; i < arr1.length - 1; i++) {
    for (let j = i + 1; j < arr1.length; j++) {
      score1 += input[arr1[i]][arr1[j]] + input[arr1[j]][arr1[i]];
      score2 += input[arr2[i]][arr2[j]] + input[arr2[j]][arr2[i]];
    }
  }
  return Math.abs(score1 - score2);
};

makeTeam(0);
console.log(answer);
