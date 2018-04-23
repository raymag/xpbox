var dpc = 0;
var dsc = 0;
var showc = 0;
function show(){
	showc++;
	if(showc%2==0){
		window.location.reload();
	}
	document.getElementById('e1-1').style.color = '#222';
	document.getElementById('e1-2').style.color = '#eee';
	document.getElementById('e1-3').style.color = '#222';
	document.getElementById('e1-4').style.color = '#eee';
	document.getElementById('e1-5').style.color = '#222';
	
	document.getElementById('e2-1').style.color = '#eee';
	document.getElementById('e2-2').style.color = '#222';
	document.getElementById('e2-3').style.color = '#eee';
	document.getElementById('e2-4').style.color = '#222';
	document.getElementById('e2-5').style.color = '#eee';
	
	document.getElementById('e3-1').style.color = '#222';
	document.getElementById('e3-2').style.color = '#eee';
	document.getElementById('e3-3').style.color = '#222';
	document.getElementById('e3-4').style.color = '#eee';
	document.getElementById('e3-5').style.color = '#222';
	
	document.getElementById('e4-1').style.color = '#eee';
	document.getElementById('e4-2').style.color = '#222';
	document.getElementById('e4-3').style.color = '#eee';
	document.getElementById('e4-4').style.color = '#222';
	document.getElementById('e4-5').style.color = '#eee';
	
	document.getElementById('e5-1').style.color = '#222';
	document.getElementById('e5-2').style.color = '#eee';
	document.getElementById('e5-3').style.color = '#222';
	document.getElementById('e5-4').style.color = '#eee';
	document.getElementById('e5-5').style.color = '#222';
};
function dp(){
	dpc++;
	if(dpc%2==0){
		window.location.reload();
	}
	let e11 = document.getElementById('e1-1');
	let e22 = document.getElementById('e2-2');
	let e33 = document.getElementById('e3-3');
	let e44 = document.getElementById('e4-4');
	let e55 = document.getElementById('e5-5');
	e11.style.color = 'red';
	e22.style.color = 'red';
	e33.style.color = 'red';
	e44.style.color = 'red';
	e55.style.color = 'red';
};
function ds(){
	dsc++;
	if(dsc%2==0){
		window.location.reload();
	}
	let e11 = document.getElementById('e1-5');
	let e22 = document.getElementById('e2-4');
	let e33 = document.getElementById('e3-3');
	let e44 = document.getElementById('e4-2');
	let e55 = document.getElementById('e5-1');
	e11.style.color = 'green';
	e22.style.color = 'green';
	e33.style.color = 'green';
	e44.style.color = 'green';
	e55.style.color = 'green';
};