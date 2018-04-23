<?php
# ==== Carlos Magno Nascimento ==== #
# ======  Criado em 19/04/18 ====== #
echo "<style>body{background:#cdcdcd;font-size:25px;}</style><center>";
#===================================>
for($i=0;$i<10;$i++){
	$vector[$i] = $i*5;
}
for($i=0;$i<10;$i++){
	if($vector[$i]%2!=0){
		echo "$vector[$i]<br/>";
	}
}
?>