const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let [N, ...gameBoard] = fs.readFileSync(filePath).toString().trim().split("\n");

N = parseInt(N);
gameBoard = gameBoard.map((ele) => ele.split(" ").filter(Boolean).map(Number));

const zeroFill = (arr, N) => {
  let len = arr.length;
  while (len++ !== N) {
    arr.push(0);
  }
  return arr;
};

const getMovedLine = (line, N, start) => {
  let newLine = [];
  let madeThisTurn = false;
  let changeUnit = start === 0 ? 1 : -1;
  for (start; start < N && start >= 0; start += changeUnit) {
    let prev = newLine.pop();
    // 0인 경우는 pop 한 값 다시 넣어주고 넘겨야 하는데 0도 똑같이 새 라인에 넣고 있었ㅇ므...
    if (!line[start]) {
      if (prev) newLine.push(prev);
      continue;
    }
    if (prev === line[start] && !madeThisTurn) {
      prev *= 2;
      newLine.push(prev);
      madeThisTurn = true;
    } else {
      if (prev) newLine.push(prev);
      newLine.push(line[start]);
      madeThisTurn = false;
    }
  }
  return changeUnit === 1
    ? zeroFill(newLine, N)
    : zeroFill(newLine, N).reverse();
};

const getLine = (direction, gameBoard, lineNum) => {
  if (direction === "up" || direction === "down") {
    let line = [];
    for (let i = 0; i < N; i++) {
      line.push(gameBoard[i][lineNum]);
    }
    return line;
  }
  return gameBoard[lineNum];
};

const changeLine = (direction, gameBoard, movedLine, lineNum) => {
  if (direction === "up" || direction === "down") {
    for (let i = 0; i < N; i++) {
      gameBoard[i][lineNum] = movedLine[i];
    }
  } else {
    gameBoard[lineNum] = movedLine;
  }
  return gameBoard;
};

const move = (direction, gameBoard, N) => {
  gameBoard = JSON.parse(JSON.stringify(gameBoard));
  let startIdx = 0;
  if (direction === "down" || direction === "right") startIdx = N - 1;
  for (let i = 0; i < N; i++) {
    let line = getLine(direction, gameBoard, i);
    let movedLine = getMovedLine(line, N, startIdx);
    gameBoard = changeLine(direction, gameBoard, movedLine, i);
  }
  return gameBoard;
};
const getMax = (gameBoard, N) => {
  let maxNum = 0;
  for (let i = 0; i < N; i++) {
    maxNum = Math.max(maxNum, ...gameBoard[i]);
  }
  return maxNum;
};

const play = (gameBoard, N) => {
  let left = move("left", gameBoard, N);
  let right = move("right", gameBoard, N);
  let up = move("up", gameBoard, N);
  let down = move("down", gameBoard, N);
};

const main = (gameBoard, N) => {
  let directions = ["left", "right", "up", "down"];
  let maxNums = new Set();
  let queue = [[gameBoard, 0]];
  let front = 0;
  let end = 0;
  while (front <= end) {
    let [now, cnt] = queue[front++];
    if (cnt < 5) {
      directions.forEach((direction) => {
        let test = move(direction, now, N);
        queue.push([move(direction, now, N), cnt + 1]);
        end++;
      });
    } else {
      maxNums.add(getMax(now, N));
    }
  }
  console.log(Math.max(...maxNums));
};

main(gameBoard, N);

// 그냥 moveup, down, left, right 쪼개서 깔끔하게 해결..
// https://www.acmicpc.net/source/46955385
