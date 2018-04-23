<?php
# ==== Carlos Magno Nascimento ==== #
# ======  Criado em 19/04/18 ====== #
echo "<style>body{background:#cdcdcd;font-size:25px;}</style><center>";
#===================================>
$dados_usuario = array(
	"nome" => $_POST["name"],
	"senha" => $_POST["passwd"],
	"email" => $_POST["email"],
	"idade" => $_POST["age"],
	"altura" => $_POST["height"]
	);
foreach($dados_usuario as $info){
	echo $info."<br/>";
}
?>