<?php
# ==== Carlos Magno Nascimento ==== #
# ======  Criado em 19/04/18 ====== #
echo "<style>body{background:#cdcdcd;font-size:25px;}</style><center>";
#===================================>
$count = 0;
for($num = 1; $num<=100;$num++){
	if($num%2==0){
		$vector[$count++] = $num;
		};
}
for($i = 0;$i<50;$i++){
	echo "[$i] ".$vector[$i]."<br/>";
}
?>