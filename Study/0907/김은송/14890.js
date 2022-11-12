// // 2시간 걸린 듯 ..ㅎ
// const fs = require("fs");
// const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
// let [NL, ...roads] = fs.readFileSync(filePath).toString().split("\n");
// let [N, L] = NL.split(" ").map(Number);
// roads = roads.map((ele) => ele.split(" ").map(Number));
// let ans = 0;
// // 너무 느림!
// const isPassable = (row) => {
//   let flag = true;
//   let installed = new Array(N).fill(false);

//   for (let j = 0; j < N - 1; j++) {
//     if (Math.abs(row[j] - row[j + 1]) === 1) {
//       let same = row[j] < row[j + 1] ? j : j + 1;
//       let unit = same === j ? -1 : 1;
//       let cnt = 0;
//       while (cnt < L) {
//         if (
//           row[same] === row[same + cnt * unit] &&
//           !installed[same + cnt * unit]
//         ) {
//           installed[same + cnt++ * unit] = true;
//           continue;
//         }
//         flag = false;
//         break;
//       }
//     } else if (row[j] !== row[j + 1]) {
//       flag = false;
//       break;
//     }
//   }
//   if (flag) ans += 1;
// };

// for (let i = 0; i < N; i++) {
//   let row = roads[i];
//   let col = [];
//   for (let j = 0; j < N; j++) col.push(roads[j][i]);
//   isPassable(row);
//   isPassable(col);
// }
// console.log(ans);
// 다른 분의 답안. 아이디어가 너무 좋음ㅜㅡㅜ
const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filePath).toString().split("\n");
const isRoad = (road, L) => {
  // count 가 음수: 앞으로 해당 칸만큼 경사로가 설치되어야 한다.
  // count 가 양수: 앞의 칸들 중에서 count 된 칸 수만큼 경사로를 설치할 수 있다.
  let count = 1;
  for (let i = 0; i < road.length - 1; i++) {
    if (road[i] === road[i + 1]) count++;
    else if (road[i] + 1 === road[i + 1] && count >= L) count = 1;
    // count >= 0 이다. 앞서서 조건을 만족했다.
    // count = 1 - L: 이제 탐색을 하면서 뒤에 경사로를 설치할 수 있는지 확인해야 함.
    // L 개를 채워야 하는데, road[i+1] 은 확인된거니, 1-L로 시작.
    else if (road[i] - 1 === road[i + 1] && count >= 0) count = 1 - L;
    else return false;
  }
  return count >= 0 ? true : false;
};

const solution = (input) => {
  const [N, L] = input[0].split(" ").map(Number);
  const map = input.slice(1).map((ele) => ele.split(" ").map(Number));
  let ways = 0;
  for (let i = 0; i < N; i++) {
    const road1 = map[i];
    const road2 = map.map((row) => row[i]);
    if (isRoad(road1, L)) ways++;
    if (isRoad(road2, L)) ways++;
  }
  console.log(ways);
};

solution(input);
