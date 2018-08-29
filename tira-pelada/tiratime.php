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
<?php 
session_start();
$players = $_SESSION["players"];
$numPlayers = $_SESSION["numPlayers"];
$numTeams = $_SESSION["numTeams"];
$undefined = $_SESSION["undefined"]; 
$bronze = $_SESSION["bronze"];
$silver = $_SESSION["silver"];
$gold = $_SESSION["gold"];
$teams = array();
$teamScores = array();
for($i=0;$i < $numTeams;$i++){
    $teams[] = array();
    $teams[$i][0] = 0;
}

while($gold-- >0){
    foreach($players as $player){ 
        sort($teams);
        if($player["playerCategory"] == "gold" && count($teams[0])<6 ){
            $teams[0][] = $player;
            $teams[0][0] += 3;
            unset($players[array_search($player, $players)]);
        }
    }
}
while($silver-- >0){
    foreach($players as $player){
        sort($teams);
        if($player["playerCategory"] == "silver" && count($teams[0])<6 ){
            $teams[0][] = $player;
            $teams[0][0] += 2;
            unset($players[array_search($player, $players)]);
        }
    }
}
while($bronze-- >0){
    foreach($players as $player){
        sort($teams);
        if($player["playerCategory"] == "bronze" && count($teams[0])<6 ){
            $teams[0][] = $player;
            $teams[0][0] += 1;
            unset($players[array_search($player, $players)]);
        }
    }
}
while($undefined-- >0){
    foreach($players as $player){
        if($player["playerCategory"] == "undefined" && count($teams[0])<6 ){
            $min = count($teams[0]);
            $minTeam = $teams[0];
            foreach($teams as $team){
                if(count($teams[0])<$min){
                    $min = $team[0];
                    $minTeam = $team;
                }
            }
            $teams[array_search($teams, $minTeam)][] = $player;
            unset($players[array_search($player, $players)]);
        }
    }
}
echo count($teams)." Times<br>";
foreach($teams as $team){
    // echo "<br>";
    echo "<hr>";
    echo "<br>";
    echo "Pontos: ".$team[0];
    echo "<br/>";
    for($i=1;$i<count($team);$i++){
        echo $team[$i]["playerCategory"]." - ".$team[$i]["playerName"];
        echo "<br/>";
    }
    echo "<br>";
}
echo "<hr>";
// foreach($players as $player){
//     if()
// }
// var_dump($players);
?>
<a href="homepage.php">Voltar</a>
</div> 
</body>
</html>