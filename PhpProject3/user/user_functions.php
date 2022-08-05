<?php

require '../application/Db_connection.php';
$user_regist_name = $_POST['user_regist_name'];
echo $_POST['user_regist_name'];

//não recebe o utilizador!!
$insert = "INSERT INTO users (user_name) VALUES ($user_regist_name)";
if (mysqli_query($connection, $insert)) {
    echo "<script>console.log('Utilizador registado com sucesso');</script>";
} else {
    echo "<script>console.log('Utilizador não registado');</script>";
}

echo "<script>console.log('" . json_encode($user_regist_name) . "');</script>";
