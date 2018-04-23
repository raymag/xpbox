var starNumber = 50;
var stars = new Array;

function setup() {
  createCanvas(innerWidth, innerHeight);
  for(var i=0;i<starNumber;i++){
    stars[i] = new Star;
  }
}

function draw() {
  background(0);
  for(var i=0;i<starNumber;i++){
    stars[i].show();
  }

}

function Star(){
  this.x = random(width);
  this.y = random(height);
  this.weight = random(10, 50);
  this.redtone = random(100, 255);
  this.greentone = this.redtone;
  this.bluetone = this.greentone;

  this.move = function () {
    this.x += random(-1, 1);
    this.y += random(-1, 1);
  }

  this.colorfly = function(){
    this.redtone += random(-3, 3);
    this.greentone += random(-3, 3);
    this.bluetone += random(-3, 3);
  }

  this.show = function(){
    noStroke();
    fill(this.redtone, this.greentone, this.bluetone);
    ellipse(this.x, this.y, this.weight, this.weight);
    this.move();
    this.colorfly();
  }
}
