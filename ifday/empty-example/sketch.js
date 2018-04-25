//VARIAVEIS GLOBAIS ===========================================================>
//=======================================================================>

//ARRAY DE OBJETOS ============================================================>
var irons = [];
var bullets = [];
var provas = [];
//VARIAVEIS DE CONFIGURACAO ====================================================>
var runspeed = 8;//DEFINE O RITMO DA ESTUDO E ESCOLA
var ifafinidade = 10;//GRAU DE SACRIFICIO E SUPERACAO DAS DISTRACOES
var naoafinidade = 5;
var playing = false;//DEFINE O ESTADO DE JOGO
var hearts = 5;
var score = 0;
var bulletspeed = 5;
var testspeed;
var nota = 0;

//FUNCAO SETUP ================================================================>
//=======================================================================>
function setup() {
	createCanvas( (innerWidth), (innerHeight) );
	player = new Student;//CRIA OBJETO STUDENT (JOGADOR)
}
//FUNCAO DRAW ===================================================================>
//=======================================================================>
function draw() {
	background(22);
	if(playing){
		//INFORMACOES DE ESCANTEIO
		textSize(32);
		fill(250);
		text('IF-Afinidade:', width/7*5, height/10);
		text((ifafinidade+'%'), width/7*5+200, height/10);

		text('Ritmo:', width/7*5, height/5);
		text(int(runspeed), width/7*5+100, height/5);

		player.paint();//DESENHA O JOGADOR
		
		for(var i=0;i<bullets.length;i++){
			bullets[i].paint();//DESENHA OS PROJETEIS DISPARADOS PELO JOGADOR
		}
		for(var i=0;i<provas.length;i++){
			provas[i].paint();//DESENHA AS AVALIACOES
		}
		//GERA NOVAS DISTRACOES DE ACORDO COM O RITMO
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
				score++;
			}
		}
		//ALUNO REPROVADO OU DESISTENTE
		if(hearts<=0){
			playing = false;
			hearts = 5;
			runspeed = 8;
			ifafinidade = 10;
			irons = [];
		}
		
		//GERA NOVAS PROVAS E AVALIACOES
		if(random(200)<=2){
			provas.push(new Avaliacao);
		}
		testspeed = runspeed+random(3);//AUMENTA A VELOCIDADE DAS PROVAS DE ACORDO COM O RITMO
	}
	//MENU DE JOGO
	if(playing==false){
		textSize(100);
		fill(100, 150, 100, 250);
		text('IF-Day', width*0.40, height*0.4);
		fill(100, 100, 100, 250);
		textSize(50);
		text('Um ano no IF', width*0.4, height/2);
		textSize(30);
		text('Pressione Enter para Jogar', width*0.01, height*0.95);
		text('Score: '+score, width*0.46, height/2+60);
	}
}
//FUNCAO KEYPRESSED ===============================================================>
//=======================================================================>
function keyPressed(){
	switch(keyCode){
		case UP_ARROW:
			player.jump();
			break;
		case ENTER:
			player.jump();
			if(playing==false){
				playing=true;
				score = 0;
			}
			break;
		case 88:
			player.shot();
			break;
		case 32:
			player.shot();
			break;
	}
}
//OBJETO STUDYBULLET (BALA) =================================================>
//=======================================================================>
function Studybullet(){
	this.x = player.x+(player.weight*0.9);
	this.y = player.y+(player.weight*0.5);
	this.xsize = 15;
	this.ysize = 10;
	this.move = function(){//ATUALIZA A POSICAO DO PROJETIL
		this.x+=bulletspeed;
	}
	this.paint = function(){//DESENHA O PROJETIL
		fill(25, 25, 250, 200);
		rect(this.x, this.y, this.xsize, this.ysize);
		this.move();
	}
}
//OBJETO STUDENT (JOGADOR) ===================================================>
//=======================================================================>
function Student(){
	//CONFIGURACAO DO OBJETO STUDENT
	this.x = width/3;
	this.y = height/2;
	this.weight = 50;//GROSSURA DO OBJETO
	this.redtone = 200;
	this.greentone = 50;
	this.bluetone = 50;
	this.gravity = 0.5;
	this.velocity = 0;
	this.jump_count = 2;
	this.jumpForce = 10;
	this.gunshot = runspeed;//QNT DE BALAS BASEADA NO RITMO
	
	//FUNCAO DE DISPARO
	this.shot = function(){
		if(this.gunshot>0){
			bullets.push(new Studybullet);//GERA NOVOS PROJETEIS NO ARRAY DE BALAS
			this.gunshot--;
		}
	}

	//FUNCAO DE SALTO
	this.jump = function(){
		if(this.jump_count>0){
			this.velocity += -this.jumpForce;
			this.jump_count--;
		}
	}

	//ATUALIZA A POSICAO DO OBJETO STUDENT
	this.loop = function(){
		this.velocity += this.gravity;
		this.y += this.velocity;

		if( (this.y+20)>height){//IMPEDE O OBJ STUDENT DE CAIR INFINITAMENTE
			this.y = height-20;
			this.velocity = 0;
			this.jump_count = 2;
		}
	}

	//DESENHA O OBJ STUDENT
	this.paint = function(){
		//COLORACAO VERDE ESCURO PARA BOA IF-AFINIDADE
		if(ifafinidade>50 && ifafinidade<=75){
			this.greentone = 100;
			this.redtone = 50;
		}
		//COLORACAO VERDE CLARO PARA OTIMA IF-AFINIDADE
		if(ifafinidade>75){
			this.greentone = 255;
			//POSSIBILIDADE DE GANHAR HEARTS QUANDO IF-AFINIDADE > 80
			if(ifafinidade>80 && frameCount%90==0){
				hearts++;
			}
			//AUMENTA O RITMO
			if(runspeed<=15){
				runspeed += 0.01;
				if(runspeed>10){
					runspeed+=0.1;
				}
			}
		}
		//COLORACAO VINHO ESCURO PARA BAIXA IF-AFINIDADE
		if(ifafinidade<=50 && ifafinidade>25){
			this.greentone = 50;
			this.redtone = 100;
		}
		//COLORACAO VERMELHA CLARA PARA PESSIMA IF-AFINIDADE
		if(ifafinidade<=25){
			this.redtone = 255;
			//DIMINUI O RITMO
			if(runspeed>=3){
				runspeed -= 0.01;
			}
			//POSSIBILIDADE DA PERDA DE HEARTS QUANDO IF-AFINIDADE<8
			if(frameCount%30==0 && ifafinidade<=8){
				hearts--;
			}
		}

		fill(this.redtone, this.greentone, this.bluetone);
		ellipse(this.x, this.y, this.weight, this.weight);
		this.loop();
		//RECARGA DOS PROJETEIS A SEREM DISPARADOS
		if(frameCount%300 == 0){
			this.gunshot = runspeed;
		}
	}
}
//OBJETO AVALIACAO (PROVA) ========================================================>
//=======================================================================>
function Avaliacao(){
	//CONFIGURACAO DO OBJ AVALIACAO
	this.size = 30;
	this.x = width*0.9;
	this.y = random(height*0.85, height*0.6);
	
	//ATUALIZA A POSICAO DO OBJ AVALIACAO
	this.loop = function(){
		this.x -= testspeed;
	}
	//DESENHA O OBJ AVALIACAO
	this.paint = function(){
		fill(253, 106, 2, 200);
		rect(this.x, this.y, this.size, this.size);
		this.loop();
	}
}
//OBJETO IRON (DISTRACOES) =============================================================>
//=======================================================================>
function Iron(){
	//CONFIGURACAO DO OBJ IRON
	this.xsize = random(50, 70);
	this.ysize = random(height/8, height/3-40);
	this.x = width-this.xsize;
	this.y = height-this.ysize;
	this.redtone = 100;
	this.greentone = 100;

	//ATUALIZA A POSICAO DO OBJ IRON
	this.loop = function(){
		this.x -= runspeed;
	}
	
	//VERIFICA SE HA CONTATO DOS OBJS IRON E STUDENT
	this.hits = function(student){
		if ( student.y >= this.y){
			if( student.x >= this.x && student.x < this.x+this.xsize){
				//COLORACAO VERMELHA PARA OBJ IRON CASO HAJA CONTATO
				this.redtone = 255;
				if(ifafinidade>0){//REDUCAO DA IF-AFINIDADE
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
		//VERIFICA A SUPERACAO DO OBJ IRON
		if ( student.y < this.y ){
			if ( student.x>this.x+this.xsize){
				//COLORACAO VERDE PARA OBJ IRON CASO SEJA SUPERADO
				this.greentone = 255;
				if(ifafinidade<100){
					ifafinidade+=0.5;//AUMENTO DA IF-AFINIDADE
				}
			}
		}
	}

	//VERIFICA SE OBJ IRON ESTA FORA DO CAMPO DE VISAO
	this.offscreen = function(){
		if( this.x < -this.xsize ){
			return true;
		}else{
			return false;
		}
	}

	//DESENHA O OBJ IRON
	this.paint = function(){
		fill(this.redtone, this.greentone, 100);
		rect(this.x, this.y, this.xsize, this.ysize);
		this.loop();
	}
}
