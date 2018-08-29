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
        if($player["playerCategory"] == "gold"){
            sort($teams);
            $teams[0][] = $player;
            $teams[0][0] += 3;
            unset($players[array_search($player, $players)]);
        }
    }
}
while($silver-- >0){
    foreach($players as $player){
        if($player["playerCategory"] == "silver"){
            sort($teams);
            $teams[0][] = $player;
            $teams[0][0] += 2;
            unset($players[array_search($player, $players)]);
        }
    }
}
while($bronze-- >0){
    foreach($players as $player){
        if($player["playerCategory"] == "bronze"){
            sort($teams);
            $teams[0][] = $player;
            $teams[0][0] += 1;
            unset($players[array_search($player, $players)]);
        }
    }
}
while($undefined-- >0){
    foreach($players as $player){
        if($player["playerCategory"] == "undefined"){
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
    echo "+++++++++++++++++++";
    echo "<br>";
    echo "Pontos: ".$team[0];
    echo "<br/>";
    for($i=1;$i<count($team);$i++){
        echo $team[$i]["playerCategory"]." - ".$team[$i]["playerName"];
        echo "<br/>";
    }
    echo "<br>";
}
// var_dump($players);
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>TiraPelada</title>
    <link rel="stylesheet" href="../dw2/css/padrao.css">
</head>
<body>
<div id="container">
<div id="section">
<ol>
<?php 
?>
</ol>
</div> 
</body>
</html>