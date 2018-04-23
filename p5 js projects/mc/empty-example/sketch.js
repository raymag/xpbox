function save(){
	saveCanvas();
}
function setup() {
  createCanvas(500, 500);
}

function draw() {
  background(22);
  //x = ellipse(250, 250, 10, 10);
  fill(255, 102, 0, 200);
  ellipse(250, 200, 90, 90)
  fill(240);
  //fill(255, 102, 0);
  noStroke();
  rect(245, 250, 10, 60);
  ellipse(230, 290, 50, 45);
  fill(22);
  ellipse(230, 290, 30, 30);
  fill(240);
  rect(205, 250, 40, 10);
  
  
  rect(150, 250, 10, 60);
  rect(170, 250, 10, 60);
  rect(190, 250, 10, 60);
  rect(150, 250, 50, 10);

  ellipse(295, 280, 70, 70);
  fill(22);
  rect(295, 260, 50, 25);
  ellipse(295, 280, 50, 50);
  fill(240);
  rect(299, 278,30, 8);
}