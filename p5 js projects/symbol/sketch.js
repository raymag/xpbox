function save(){
	saveCanvas();
}
function setup() {
  createCanvas(500, 500);
}

function draw() {
  background(22);
  fill(255, 102, 0);
  ellipse(250, 240, 130, 130);
  fill(22);
  noStroke();
  ellipse(250, 249, 110, 110);
  fill(255, 102, 0, 200);
  rect(245, 135, 10, 120);
  fill(255, 102, 0, 50);
  ellipse(250, 135, 10, 10);
}