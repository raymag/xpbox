<?php
//$username = $_POST['username'];
//$password = $_POST['password'];

$con = mysqli_connect('localhost', "id4412926_raymag", "magmar", "id4412926_teste");
$query = "SELECT ('username', 'password') FROM usuarios";
$result = mysqli_query($con, $query);

echo $result;
mysqli_close($con);
?>