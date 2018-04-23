<?php
# ==== Carlos Magno Nascimento ==== #
# ======  Criado em 19/04/18 ====== #
echo "<style>
body{
	background:#cdcdcd;font-size:25px;
}
th,td{
	padding:10px;font-size:35px;text-align:center;
	color: rgba(50, 50, 50, 0);transition:0.5s;
	border-radius: 10px;
}
.darker{
	background: #222;
	color: rgba(250, 250, 250, 0);
}
table{
	box-shadow:5px 5px 8px #222;
	user-select:none;
	border-radius: 15px;
}
.normal:hover{
	color: #2f2f2f;
	text-shadow: 1px 3px 5px #111;
}
.darker:hover{
	color:#eee;
	text-shadow: 5px 3px 5px #333;
	transition:0.5s;
}
button{
	width:300px;
	height:50px;
	font-size:25px;
}
</style>
<script src='learn.js'></script>
<center>";
#===================================>
for($i=0;$i<5;$i++){
	for($j=0;$j<5;$j++){
		$matrix[$i][$j] = (5*$i)+($j+1);
	}
}
echo "<br/><br/><h2>Matriz 5x5</h2><table border='2'>";
$count = 1;
for($i=0;$i<5;$i++){
	echo "<tr>";
	for($j=0;$j<5;$j++){
		if($count++%2==0){
			echo "<td class='darker' id='e".($i+1)."-".($j+1)."'>";
		}else{
			print "<td class='normal' id='e".($i+1)."-".($j+1)."'>";
		}
		print $matrix[$i][$j]."</td>";
	}
	print "</tr>";
}
echo "<table><br/>
<button id='dp' onClick='dp()'>Diagonal Primária</button><br/>
<button id='ds' onClick='ds()'>Diagonal Secundária</button><br/>
<button id='ds' onClick='show()'>Mostrar Valores</button><br/>
";
?>
