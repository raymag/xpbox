var xhttp = new XMLHttpRequest();
xhttp.open("POST","https://quartogeek.000webhostapp.com/teste.php",true);
xhttp.setRequestHeader('Content-type','application/x-www-form-urlencoded');
var tempo = new Date();
var horas = tempo.getHours();
var minutos = tempo.getMinutes();
var segundos = tempo.getSeconds();
if(horas<10){
	horas = "0"+horas;
}
if(minutos<10){
	minutos = "0"+minutos;
}
if(segundos<10){
	segundos = "0"+segundos;
}
var momento = horas+":"+minutos+":"+segundos;

var dia = tempo.getDate();
var mes = tempo.getMonth()+1;
var ano = tempo.getFullYear();
if(dia<10){
	dia = "0"+dia;
}
if(mes<10){
	mes = "0"+mes;
}
var data = ano+"-"+mes+"-"+dia;
var web = window.location.href;
web = web.split('/')
web = web[2];
var params = "website="+web+"&hora="+momento+"&data_de_acesso="+data;
xhttp.send(params);
xhttp.abort();