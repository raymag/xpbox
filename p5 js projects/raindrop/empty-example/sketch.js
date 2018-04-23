function save(){
	saveCanvas();
}

var ds = new Array;
var redton = 60;
var goingred = true;

var starNumber = 20;
var stars = new Array;

function setup() {
  createCanvas(window.innerWidth, window.innerHeight);
  for(var i=0;i<200;i++){
	  ds[i] = new Drop;
  }
  for(var i=0;i<starNumber;i++){
	  stars[i] = new Star;
  }
}

function draw() {
	var tr = random(120, 130);
	background(redton, 90, tr);
	if(goingred){
		redton+=0.2;
		if(redton>=200){
			goingred = false;
		}
	}
	if(!goingred){
		redton-=0.5;
		if(redton<=60){
			goingred = true;
		}
	}
	if(random(500)<=1){
		background(250, 250, 80, 100);
	}
	
	fill(0, 0, 0, 90);
	ellipse(width/2+105, height/3+4, 90, 90);
	fill(245, 240, 200, 150);
	ellipse(width/2+100, height/3, 110, 100);
	
	for(var i=0;i<starNumber;i++){
		stars[i].show();
	}
	
	
	fill(42, 56, 47, 250);
	triangle(0, width/2+200, width/2, width/3, width, width/2+200);
	fill(22, 36, 27, 250);	
	triangle(200, width/2+200, width/2, width/3, width, width/2+200);
	fill(42, 56, 47, 250);
	triangle(width/4*3, width/2+150, width/2+500, width/3, width, width/2+200);
	fill(22, 32, 32, 210);
	triangle(width/4*5, width/2+150, width/2+500, width/3, width, width/2+200);
	fill(22, 42, 27, 250);
	ellipse(0, width/2+150, width/2, width/3);
	
	for(var i=0;i<200;i++){
		ds[i].fall();
		ds[i].show();
		if(ds[i].y>height){
			ds[i].y=0;
		}
		if(ds[i].speed>15){
			ds[i].speed = 8;
			ds[i].x=random(width);
		}
	}

}

function Drop(){
	this.x = random(width);
	this.y = random(-100, -5);
	this.speed = random(4, 10);
	this.t = random(150, 255);
	
	this.fall = function(){
		this.y += this.speed;
		this.speed+= 0.01;
		//rotate(0.02);
	}
	this.show = function(){
		fill(random(150, 200), random(150, 200), random(200, 255), this.t);
		noStroke();
		rect(this.x, this.y, 10, 30);
	}
}
function Star(){
	this.x = random(width);
	this.y = random(height/5*4);
	this.weight = random(5, 10);
	this.color = random(100, 250);
	
	this.show = function(){
		fill(this.color);
		ellipse(this.x, this.y, this.weight, this.weight);
	}
}