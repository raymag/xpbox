<?php
session_start();
unset($_SESSION["players"]);
unset($_SESSION["numPlayers"]);
unset($_SESSION["numTeams"]);
unset($_SESSION["undefined"]);
unset($_SESSION["bronze"]);
unset($_SESSION["silver"]);
unset($_SESSION["gold"]);
header("location:homepage.php")
?>