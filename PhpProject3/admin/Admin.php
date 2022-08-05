<?php

function add_user() {
   echo 'ADICIONAR UTILIZADOR';
    $user_regist_name = $_POST['user_regist_name'];
    $user_regist_password = $_POST['user_regist_password'];
    $user_regist_email = $_POST['user_regist_email'];
    $user_regist_nif = $_POST['user_regist_nif'];
    $user_regist_doc = $_POST['user_regist_doc'];
    $user_regist_key = $_POST['user_regist_key'];

    $query = "INSERT INTO users (user_name, user_password, user_email, user_nif, user_document_type, user_key)
    VALUES ('$user_regist_name','$user_regist_password','$user_regist_email','$user_regist_nif','$user_regist_doc','$user_regist_key')";
    $insert = mysqli_query($connection, $query);
    if ($insert) {
        echo "<script>console.log('Utilizador registado com sucesso');</script>";
    } else {
        echo "<script>console.log('Utilizador não registado');</script>";
    }
}