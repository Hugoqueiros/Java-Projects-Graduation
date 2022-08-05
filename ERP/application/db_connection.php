<?php

$localhost = "localhost";
$username = "jbrproje";
$password = "j966VlpXr8";
$dbname = "jbrproje_ve";

$connection = mysqli_connect($localhost, $username, $password, $dbname);
if (!$connection) {
    die(mysqli_connect_error());
}
echo "DATABASE A FUNFAR";