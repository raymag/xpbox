var starNumber = 1;
var stars = new Array;

function setup() {
  createCanvas(innerWidth, innerHeight);
  for(var i=0;i<starNumber;i++){
    stars[i] = new Star;
  }
}

function draw() {
  background(22, 25, 50);
  for(var i=0;i<starNumber;i++){
    stars[i].show();
  }

}

function keyPressed(){
	switch(keyCode){
		case UP_ARROW:
			starNumber++;
			stars[starNumber-1] = new Star;
			break;
		case DOWN_ARROW:
			starNumber--;
			break;
		case LEFT_ARROW:
			for(var i=0;i<starNumber;i++){
				stars[i].speed--;
			}
			break;
		case RIGHT_ARROW:
			for(var i=0;i<starNumber;i++){
				stars[i].speed++;
			}
			break;
	}
}

function Star(){
  this.x = random(width);
  this.y = random(height);
  this.weight = random(10, 50);
  this.redtone = random(100, 255);
  this.greentone = this.redtone;
  this.bluetone = this.greentone;
  this.speed = 1;

  this.move = function () {
    this.x += random(-this.speed, this.speed);
    this.y += random(-this.speed, this.speed);
	//this.speed+=0.01;
	
	if(this.x>width || this.x<0){
		this.x = width/2;
	}
	if(this.y>height || this.y<0){
		this.y = height/2;
	}
  }

  this.colorfly = function(){
    this.redtone += random(-3, 3);
    this.greentone += random(-3, 3);
    this.bluetone += random(-3, 3);
  }

  this.show = function(){
    //noStroke();
    fill(this.redtone, this.greentone, this.bluetone);
    ellipse(this.x, this.y, this.weight, this.weight);
    this.move();
    this.colorfly();
  }
}
