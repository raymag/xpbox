//============================PROJETO--->IF-DAY<----===========================>
//=========================IDEALIZADO-EM-23/04/2018============================>
//==========================CARLOS=MAGNO=NASCIMENTO============================>
//=============================================================================>

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
	//ESTADO DE JOGO
	if(playing){
		background(154, 211, 230);//DESENHA O CEU AZUL
		noStroke();
		//DESENHA AS NUVENS DO PLANO DE FUNDO
		fill(227, 227, 227, 100);
		ellipse(width*0.1, height*0.1, 400, 100);
		ellipse(width*0.17, height*0.2, 430, 150);
		ellipse(width*0.6, height*0.02, 400, 100);
		ellipse(width*0.87, height*0.1, 300, 100);
		ellipse(width*0.57, height*0.2, 430, 150);
		//DESENHA O CENÁRIO DE FUNDO (MONTANHAS, MORROS, ETC)
		fill(104, 140, 132);
		ellipse(width*0.7, height, 1000, 800);
		triangle(width*0.8, height, width, height*0.5, width*1.1, height);
		triangle(-60, height, width*0.1, height/2, width*0.3, height);
		fill(94, 130, 102);
		triangle(-10, height, width*0.2, height/2, width*0.3, height);
		triangle(width*0.8, height, width*0.9, height*0.3, width*1.1, height);
		fill(104, 140, 132);
		triangle(30, height, width*0.3, height/3, width*0.5, height);
		fill(94, 130, 102);
		triangle(width*0.3, height, width*0.3, height/3, width*0.5, height);
		//INFORMACOES DE ESCANTEIO
		textSize(32);
		fill(22);
		text('Afinidade:', width/7*5, height/10);
		text((ifafinidade+'%'), width/7*5+200, height/10);
		text('Ritmo:', width/7*5, height/5);
		text(int(runspeed), width/7*5+100, height/5);
		text('Pontos: '+nota, width/7*5, height/4);
		//RENDERIZA O CHAO
		fill(150);
		rect(0, height-20, width, 20);

		player.paint();//DESENHA O JOGADOR
		
		
		
		//DESENHA OS PROJETEIS DISPARADOS PELO JOGADOR
		for(var i=0;i<bullets.length;i++){
			bullets[i].paint();
			//ELIMINA OBJ BULLETS FORA DO CAMPO DE VISAO
			if(bullets[i].offscreen()){
				bullets.splice(i, 1);
			}
			//VERIFICA O TOQUE DO OBJ BULLET COM O OBJ AVALIACAO
			try{
				for(var j=0;j<provas.length-1;j++){
					if(bullets[i].touching(provas[j])){
						provas.splice(j, 1);//CASO VERDADEIRO, ELIMINA O OBJ AVALIACAO
						nota++;
						//SORTEA +1 HEART
						if(random(20)<=10){
							hearts++;
						}
					}
				}
			}catch{}
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
			bulletspeed = 5;
			irons = [];
			bullets = [];
			provas = [];
		}
		
		//GERA NOVAS PROVAS E AVALIACOES
		if(random(200)<=2){
			provas.push(new Avaliacao);
		}
		testspeed = runspeed+random(3);//AUMENTA A VELOCIDADE DAS PROVAS DE ACORDO COM O RITMO
	}
	//MENU DE JOGO
	if(playing==false){
		background(22);
		textSize(100);
		fill(100, 150, 100, 250);
		text('School-Days', width*0.3, height*0.4);
		fill(100, 100, 100, 250);
		textSize(50);
		text('A annos in schola', width*0.35, height/2);
		textSize(30);
		text('Pressione Enter para Jogar', width*0.01, height*0.95);
		text('Pontos: '+nota, width*0.46, height/2+60);
		//text('Score: '+score, width*0.46, height/2+60);
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
				nota = 0;
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
	//CONFIGURACAO DO OBJ STUDYBULLET
	this.x = player.x+(player.weight*0.9);
	this.y = player.y+(player.weight*0.5);
	this.xsize = 15;
	this.ysize = 10;
	//ATUALIZA A POSICAO DO PROJETIL
	this.move = function(){
		this.x+=bulletspeed;
	}
	//DESENHA O PROJETIL
	this.paint = function(){
		fill(25, 25, 250, 200);
		rect(this.x, this.y, this.xsize, this.ysize);
		this.move();
	}
	//VERIFICA SE OBJ STUDYBULLET ESTA FORA DO CAMPO DE VISAO
	this.offscreen = function(){
		if(this.x>width){
			return true;
		}else{
			return false;
		}
	}
	//
	this.touching = function(obj){
		//obj = provas[obj];
		if( (this.x+this.xsize) > obj.x ){
			if( (this.y>obj.y) && (this.y+this.ysize<obj.y+obj.size) ){
				return true
			}
		}
		return false;
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
		
		stroke(22, 22, 22, 100);
		fill(this.redtone, this.greentone, this.bluetone);
		ellipse(this.x, this.y, this.weight, this.weight);
		this.loop();
		//RECARGA DOS PROJETEIS A SEREM DISPARADOS
		if(frameCount%300 == 0){
			this.gunshot = runspeed;
		}
		fill(55, 55, 55, 100);
		ellipse(this.x+(this.weight*0.4), this.y+(this.weight*0), 10, 20);
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
	//VERIFICA SE OBJ Avaliacao ESTA FORA DO CAMPO DE VISAO
	this.offscreen = function(){
		if( (this.x+this.size)<0){
			return true;
		}else{
			return false;
		}
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