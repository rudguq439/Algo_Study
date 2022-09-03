// 16:44~ 17:06
const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let [N, ...words] = fs.readFileSync(filePath).toString().trim().split("\n");
let answer = [];

// words 를 차례대로 확인함
for (let word of words) {
  let wordLen = word.length;
  let isPrefix = false;
  let temp = [];

  // answer(앞서서 미리 확인한 word들)를 순회
  for (let i = 0; i < answer.length; i++) {
    let check = answer[i];
    let checkLen = check.length;
    // word 가 더 길면 check 가 접두사인지 확인. check 가 접두사면 다시 안 넣고 다음으로 넘어감
    if (checkLen < wordLen && word.substring(0, checkLen) === check) continue;
    // word 가 접두사면 변수를 true 로 변경
    if (checkLen >= wordLen && word === check.substring(0, wordLen)) {
      isPrefix = true;
    }
    // 통과했으면 ,check 은 괜찮으니까 temp 엔 넣기
    temp.push(check);
  }
  // 다 확인하고, word 가 접두사가 아니면 temp에 넣기~
  if (!isPrefix) temp.push(word);
  answer = [...temp];
}
console.log(answer.length);

// 정렬하고 startswith 로 풀면 됐다!! https://www.acmicpc.net/source/30404730
answer = 0;
words
  .sort((a, b) => a.localeCompare(b))
  .forEach((word, index) => {
    let candidate = 1;
    // 정렬했으니, 뒤에 놈들만 확인하면 됨
    for (let i = index + 1; i < words.length; ++i) {
      // 하나라도 해당 문자열로 시작하면 꽝인듯
      if (words[i].startsWith(word)) {
        candidate = 0;
        break;
      }
    }
    // 뒤에 word를 접두사로 가지는 경우가 없으니 answer 에 1을 더해줌
    answer += candidate;
  });
console.log(answer);
