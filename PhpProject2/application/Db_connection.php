<?php

$localhost = "localhost";
$username = "jbrproje";
$password = "j966VlpXr8";
$dbname = "jbrproje_ve";

$connection = mysqli_connect($localhost, $username, $password, $dbname);
if ($connection) {
    echo "Ligação Estabelecida";
} else {
    echo "Erro na Ligação";
}
