// 문제 이해를 잘못해서 시간을 엄청 잡아먹음...문제도 꼼꼼하게 읽고 꼭꼭!! 예제 출력이 왜 저렇게 되었는지 확인하자.
const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let [A, B] = fs.readFileSync(filePath).toString().trim().split(" ");

let sameCnt = 0;
let aLen = A.length;
for (let i = 0; i <= B.length - aLen; i++) {
  let temp = 0;
  for (let j = 0; j < aLen; j++) {
    if (A[j] === B[j + i]) temp++;
  }
  if (temp > sameCnt) sameCnt = temp;
}
console.log(aLen - sameCnt);

// 내풀이보다 훨씬 빠름. 그치만 protype 쓰는 것보다 그냥 split 하는 쪽이 빨라서 내 나름대로 수정해서 사용
// https://www.acmicpc.net/source/43123864
let res = 987654321;
for (let i = 0; i + A.length <= B.length; i += 1) {
  const str = B.substring(i, i + A.length);
  const cnt = A.split("").reduce(
    (acc, cur, i) => (acc += str[i] !== cur ? 1 : 0),
    0
  );

  res = Math.min(res, cnt);
}
console.log(res);
