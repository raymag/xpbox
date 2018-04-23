function save(){
	saveCanvas();
}
//20x10
var player;
var speedW = -15;
var speedR = 5;
function setup() {
	createCanvas(innerWidth, innerHeight);
	player = new Player;
	//fruit = new Apple;
}

function keyPressed(){
	switch(keyCode){
		case LEFT_ARROW:
			player.left();
			player.weight+=speedW;
			player.redtone+=speedR;
			break;
		case RIGHT_ARROW:
			player.right();
			player.weight+=speedW;
			player.redtone+=speedR;
			break;
		case UP_ARROW:
			player.up();
			player.weight+=speedW;
			player.redtone+=speedR;
			break;
		case DOWN_ARROW:
			player.down();
			player.weight+=speedW;
			player.redtone+=speedR;
			break;
	}
}

function draw() {
	background(22);
	player.show();
	//fruit.show();
}
function Player(){
	this.x = width/20*10;
	this.y = height/10*5;
	this.weight = height/10;
	this.redtone = 100;
	
	this.show = function(){
		fill(this.redtone, 200, 150);
		ellipse(this.x, this.y, this.weight, this.weight);
	}
	
	this.left = function(){
		if( (this.x-width/20)>0 ){
			this.x-=width/20;
		}
	}
	this.right = function(){
		if( (this.x+width/20)<width ){
			this.x+=width/20;
		}	
	}
	this.up = function(){
		if( (this.y-height/10)>0 ){
			this.y-=height/10;
		}
	}
	this.down = function(){
		if( (this.y+height/10)<height-height/10 ){
			this.y+=height/10;
		}
	}
}
//function Apple(){
//	this.x = random(width/20, width/20*19);
//	this.y = random(height/10, height/10*9);
//	this.weight = 80;
	
//	this.show = function(){
//		fill(250, 100, 100);
//		ellipse(this.x, this.y, this.weight, this.weight);
//	}
//}