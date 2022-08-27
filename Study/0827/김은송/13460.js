const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let [size, ...board] = fs.readFileSync(filePath).toString().trim().split("\n");

let [N, M] = size.split(" ").map(Number);
board = board.map((ele) => ele.split(""));
let red = { row: 0, col: 0 };
let blue = { row: 0, col: 0 };
let exit = { row: 0, col: 0 };

for (let i = 1; i < N - 1; i++) {
  for (let j = 1; j < M - 1; j++) {
    switch (board[i][j]) {
      case "R":
        red = { row: i, col: j };
        break;
      case "B":
        blue = { row: i, col: j };
        break;
      case "O":
        exit = { row: i, col: j };
        break;
    }
  }
}

const move = (board, red, blue, direction) => {
  let unit = { row: 0, col: 0 };
  // 입구로 빠져나갔는데 따로 표시를 안 해줘서, 계속 있는 것처럼 됨....
  // 이것 때문에 통과를 못했다.
  let exited = { red: false, blue: false };
  board = board.map((ele) => [...ele]);
  red = { ...red };
  blue = { ...blue };
  switch (direction) {
    case "up":
      unit.row = -1;
      break;
    case "down":
      unit.row = 1;
      break;
    case "left":
      unit.col = -1;
      break;
    case "right":
      unit.col = 1;
      break;
  }

  while (true) {
    let flag = false;
    if (!exited.red && board[red.row + unit.row][red.col + unit.col] === ".") {
      board[red.row + unit.row][red.col + unit.col] = "R";
      board[red.row][red.col] = ".";
      red.row += unit.row;
      red.col += unit.col;
      flag = true;
    } else if (
      !exited.red &&
      board[red.row + unit.row][red.col + unit.col] === "O"
    ) {
      board[red.row][red.col] = ".";
      red.row += unit.row;
      red.col += unit.col;
      exited.red = true;
    }
    if (board[blue.row + unit.row][blue.col + unit.col] === ".") {
      board[blue.row + unit.row][blue.col + unit.col] = "B";
      board[blue.row][blue.col] = ".";
      blue.row += unit.row;
      blue.col += unit.col;
      flag = true;
    } else if (board[blue.row + unit.row][blue.col + unit.col] === "O") {
      board[blue.row][blue.col] = ".";
      blue.row += unit.row;
      blue.col += unit.col;
      flag = false;
    }
    if (!flag) break;
  }
  return [board, red, blue];
};

const checkExit = (red, blue, exit) => {
  let redExit = false;
  let blueExit = false;
  if (red.row === exit.row && red.col === exit.col) redExit = true;
  if (blue.row === exit.row && blue.col === exit.col) blueExit = true;

  return [redExit, blueExit];
};

let cnt = 0;
let queue = [[board, red, blue, cnt]];
let front = 0;
let rear = 0;
let ds = ["up", "down", "left", "right"];
let ans = -1;
let visited = new Set();
visited.add(red.row + "," + red.col + "," + blue.row + "," + blue.col);

while (front <= rear) {
  [board, red, blue, cnt] = queue[front++];
  for (let direction of ds) {
    let [movedBoard, movedRed, movedBlue] = move(board, red, blue, direction);
    let [redExit, blueExit] = checkExit(movedRed, movedBlue, exit);
    let newCnt = cnt + 1;
    if (blueExit) continue;
    if (redExit) {
      ans = newCnt;
      break;
    } else if (newCnt < 10) {
      let visitedKeyString =
        movedRed.row +
        "," +
        movedRed.col +
        "," +
        movedBlue.row +
        "," +
        movedBlue.col;
      if (visited.has(visitedKeyString)) continue;
      queue.push([movedBoard, movedRed, movedBlue, newCnt]);
      rear += 1;
      visited.add(visitedKeyString);
    }
  }
  if (ans !== -1) break;
}

console.log(ans);

// 시간 효율:https://www.acmicpc.net/source/47972477
// visited 할때!! 다차원 배열로 하는 방식이 좋은 듯!!
