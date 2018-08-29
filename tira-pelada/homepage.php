<?php
session_start();
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>TiraPelada</title>
    <link rel="stylesheet" href="css/padrao.css">
</head>
<body>
<div id="container">
<div id="section">
<fieldset>

<ol>
<?php 
if(isset($_POST["playerName"][0])){
    $playerName = $_POST["playerName"];
    $playerCategory = $_POST["playerCategory"];

    $players = $_SESSION["players"];
    $player = array();
    $player["playerName"] = $playerName;
    $player["playerCategory"] = $playerCategory;
    $players[] = $player;
    $numPlayers = count($players);
    $numTeams = round($numPlayers/5);
    $undefined = 0; 
    $bronze = 0;
    $silver = 0;
    $gold = 0;
    foreach($players as $player){
        switch ($player["playerCategory"]){
            case "bronze":
                $bronze++;
                break;
            case "silver":
                $silver++;
                break;
            case "gold":
                $gold++;
                break;    
            default:
                $undefined++;
                break;
        }
    }
    $_SESSION["numPlayers"] = $numPlayers;
    $_SESSION["numTeams"] = $numTeams;
    $_SESSION["undefined"] = $undefined; 
    $_SESSION["bronze"] = $bronze;
    $_SESSION["silver"] = $silver;
    $_SESSION["gold"] = $gold;
    // echo "Num P -> ".$numPlayers;

    $_SESSION["players"] = $players;

    foreach($players as $player){
        echo "==========";
        echo "<br>";
        echo "Nome: ".$player["playerName"];
        echo "<br>";
        echo "Categoria: ".$player["playerCategory"];
        echo "<br>";
    }
    
    echo "<br><br><br>";
    echo "<br>";
    echo "Jogadores: $numPlayers";
    echo "<br>";
    echo "Times: $numTeams";
    echo "<br>";
    echo "Ouro: $gold";
    echo "<br>";
    echo "Prata: $silver";
    echo "<br>";
    echo "Bronze: $bronze";
    echo "<br>";
    echo "Indefinido: $undefined";
    echo "<br>";

}
// echo "Jogadores: $numPlayers";

// unset($_SESSION["players"]);
?>
</ol>

<form method="post">
<fieldset>
<legend>Adicionar Jogador</legend>
<label>Nome: <input type="text" required name="playerName"> </label><br>
<label>Desconhecido: <input type="radio" checked name="playerCategory" value="undefined"></label><br>
<label>Bronze: <input type="radio" name="playerCategory" value="bronze"></label><br>
<label>Prata: <input type="radio" name="playerCategory" value="silver"></label><br>
<label>Ouro: <input type="radio" name="playerCategory" value="gold"></label><br>
<br>
<input type="submit" value="Adicionar"><br>
<a href="tiratime.php">Tirar Time</a><br>
<a href="limpartime.php">Limpar Time</a>
</fieldset>
</form>
</fieldset>
</div>
<?php 
if(isset($_SESSION["players"]) && !isset($_POST["playerName"])){
    // $teams = $_SESSION["teams"];
    $players = $_SESSION["players"];
    $numPlayers = $_SESSION["numPlayers"];
    $numTeams = $_SESSION["numTeams"];
    $undefined = $_SESSION["undefined"]; 
    $bronze = $_SESSION["bronze"];
    $silver = $_SESSION["silver"];
    $gold = $_SESSION["gold"];

    echo "<br>";
    echo "Jogadores: $numPlayers";
    echo "<br>";
    echo "Times: $numTeams";
    echo "<br>";
    echo "Ouro: $gold";
    echo "<br>";
    echo "Prata: $silver";
    echo "<br>";
    echo "Bronze: $bronze";
    echo "<br>";
    echo "Indefinido: $undefined";
    echo "<br>";
    echo "<hr>";

    echo "<div class='container'>";
    foreach($players as $player){
        // echo "==========";
        echo "<div class='player-block'>";
        echo "Nome: ".$player["playerName"];
        echo "<br>";
        echo "Categoria: ".$player["playerCategory"];
        echo "</div>";
    }
    echo "</div>";
}else{
    $teams = array();
    $players = array();
    $undefined = 0; 
    $bronze = 0;
    $silver = 0;
    $gold = 0;
    if(!isset($_SESSION["players"])){
        $_SESSION["players"] = array();
        $_SESSION["numPlayers"] = 0;
        $_SESSION["numTeams"] = 0;
        $_SESSION["undefined"] = $undefined;
        $_SESSION["bronze"] = $bronze;
        $_SESSION["silver"] = $silver;
        $_SESSION["gold"] = $gold;
        
    }
}
?>

</div> 
</body>
</html>