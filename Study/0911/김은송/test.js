let N = 2;
let test = new Array(N)
  .fill()
  .map(() => new Array(N).fill().map(() => new Array()));
test[1][1].push(1);
let test2 = test.map((ele) => ele.map((el) => [...el]));
test[1][1].push(2);
console.log(test2);
