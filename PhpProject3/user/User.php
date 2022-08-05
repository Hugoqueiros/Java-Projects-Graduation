<?php

require '../application/Db_connection.php';

$user_document_type = $_POST['user_document_type'];
$user_password = $_POST['user_password'];
$user_nif = $_POST['user_nif'];
$query = "SELECT * FROM users WHERE user_nif='$user_nif' AND user_password='$user_password' AND user_document_type='$user_document_type'";
$result = mysqli_query($connection, $query);
if (mysqli_num_rows($result) > 0) {
    while ($value_query = mysqli_fetch_assoc($result)) {
        $user_name = $value_query["user_name"];
        $user_password = $value_query["user_password"];
        $user_email = $value_query["user_email"];
        $user_nif = $value_query["user_nif"];
        $user_nmra = $value_query["user_nmra"];
        $user_document_type = $value_query["user_document_type"];
        $user_change_pw = $value_query["user_change_pw"];
        $user_key = $value_query["user_key"];
    }


    session_start();
    $_SESSION['user_name'] = $user_name;

    echo "<script>console.log('Utilizador existe');</script>";
} else {
    echo "<script>console.log('Utilizador não existe');</script>";
}

