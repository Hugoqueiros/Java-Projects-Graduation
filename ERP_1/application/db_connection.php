<?php

$localhost = "localhost";
$username = "jbrproje";
$password = "j966VlpXr8";
$dbname = "jbrproje_erp";

$connection = mysqli_connect($localhost, $username, $password, $dbname);
if (!$connection) {
    die(mysqli_connect_error());
}