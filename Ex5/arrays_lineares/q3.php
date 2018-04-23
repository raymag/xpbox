<?php
# ==== Carlos Magno Nascimento ==== #
# ======  Criado em 19/04/18 ====== #
echo "<style>body{background:#cdcdcd;font-size:25px;}</style><center>";
#===================================>
$B = array(0=>'Domingo',1=>'Segunda',2=>'Terça',3=>'Quarta',4=>'Quinta',5=>'Sexta',6=>'Sábado');
for($i=0;$i<7;$i++){
	$A[$i] = $i+1;
	$C[$i] = $A[$i]." - ".$B[$i];
}
print_r($C);
?>