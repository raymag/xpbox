var irons = [];
var runspeed = 8;
var ifafinidade = 10;
var naoafinidade = 5;
var playing = false;
var hearts = 5;
function setup() {
	createCanvas( (innerWidth), (innerHeight) );
	player = new Student;
}

function draw() {
	background(22);
	if(playing){
		textSize(32);
		fill(250);
		text('IF-Afinidade:', width/7*5, height/10);
		text((ifafinidade+'%'), width/7*5+200, height/10);
	
		text('Ritmo:', width/7*5, height/5);
		text(int(runspeed), width/7*5+100, height/5);
	
		player.paint();
		if( runspeed <= 8){
			if( frameCount % int(random(80, 82)) == 0 ){
				irons.push(new Iron);
			}
		}
		if (runspeed>8){
			if(frameCount % int(random(20, 22)) == 0){
				irons.push(new Iron);
			}
		}
		for(var i=irons.length-1;i>=0;i--){
			irons[i].paint();
			if( irons[i].hits(player) ){
				console.log('Grr');
			}
			if( irons[i].offscreen() ){
				irons.splice(i, 1);
			}
		}
		if(hearts<=0){
			playing = false;
			hearts = 5;
		}
	}
	if(playing==false){
		textSize(100);
		fill(100, 150, 100, 250);
		text('IF-Day', width*0.40, height*0.4);
		fill(100, 100, 100, 250);
		textSize(50);
		text('Um ano no IF', width*0.4, height/2);
		textSize(30);
		text('Pressione Enter, ou Up para Jogar', width*0.01, height*0.95);
	}
}

function keyPressed(){
	switch(keyCode){
		case UP_ARROW:
			player.jump();
			if(playing==false){
				playing=true;
			}
			break;
		case ENTER:
			player.jump();
			if(playing==false){
				playing=true;
			}
			break;
	}
}

function Student(){
	this.x = width/3;
	this.y = height/2;
	this.weight = 50;
	this.redtone = 200;
	this.greentone = 50;
	this.bluetone = 50;
	this.gravity = 0.5;
	this.velocity = 0;
	this.jump_count = 2;
	this.jumpForce = 10;
	
	this.jump = function(){
		if(this.jump_count>0){
			this.velocity += -this.jumpForce;
			this.jump_count--;
		}
	}
	
	this.loop = function(){
		this.velocity += this.gravity;
		this.y += this.velocity;
		
		if( (this.y+20)>height){
			this.y = height-20;
			this.velocity = 0;
			this.jump_count = 2;
		}
	}
	
	this.paint = function(){
		if(ifafinidade>50 && ifafinidade<=75){
			this.greentone = 100;
			this.redtone = 50;
		}
		if(ifafinidade>75){
			this.greentone = 255;
			if(ifafinidade>80 && frameCount%90==0){
				hearts++;
			}
			if(runspeed<=15){
				runspeed += 0.01;
				if(runspeed>10){
					runspeed+=0.1;
				}
			}
		}
		if(ifafinidade<=50 && ifafinidade>25){
			this.greentone = 50;
			this.redtone = 100;
		}
		if(ifafinidade<=25){
			this.redtone = 255;
			if(runspeed>=3){
				runspeed -= 0.01;
			}
			if(frameCount%30==0 && ifafinidade<=8){
				hearts--;
			}
		}
		
		fill(this.redtone, this.greentone, this.bluetone);
		ellipse(this.x, this.y, this.weight, this.weight);
		this.loop();
	}
}

function Iron(){
	this.xsize = random(50, 70);
	this.ysize = random(height/5, height/3-40);
	this.x = width-this.xsize;
	this.y = height-this.ysize;
	this.redtone = 100;
	this.greentone = 100;
	
	this.loop = function(){
		this.x -= runspeed;
	}
	
	this.hits = function(student){
		if ( student.y >= this.y){
			if( student.x >= this.x && student.x < this.x+this.xsize){
				this.redtone = 255;
				if(ifafinidade>0){
					ifafinidade-=naoafinidade;
					if(runspeed>10){
						ifafinidade-=naoafinidade;
					}
					if(ifafinidade<0){
						ifafinidade=0;
					}
				}
			}
		}
		if ( student.y < this.y ){
			if ( student.x>this.x+this.xsize){
				this.greentone = 255;
				if(ifafinidade<100){
					ifafinidade+=0.5;
				}
			}
		}
	}
	
	this.offscreen = function(){
		if( this.x < -this.xsize ){
			return true;
		}else{
			return false;
		}
	}
	
	this.paint = function(){
		fill(this.redtone, this.greentone, 100);
		rect(this.x, this.y, this.xsize, this.ysize);
		this.loop();
	}
}