class Drop {
	float x = 940/2;
	float y = 0;
	float speed = 1;
	
	void fall(){
		y = y+speed;
	}
	void show(){
		stroke(0, 200, 50);
		line(x, y, x, y+10);
	}
}