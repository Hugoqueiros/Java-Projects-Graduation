<?php

require '../application/Db_connection.php';

session_start();

$function = $_GET['f'];
if (function_exists($function)) {
    call_user_func($function);
}

function login_admin() {
    include '../application/Db_connection.php';
    $admin_email = $_POST['admin_email'];
    $admin_password = $_POST['admin_password'];
    $admin_password = md5($admin_password);
    $_SESSION['no_result'] = false;

    $query = "SELECT *  from admins WHERE admin_email='$admin_email' AND admin_password='$admin_password'";
    $result = mysqli_query($connection, $query);
    if (mysqli_num_rows($result) > 0) {
        while ($value_query = mysqli_fetch_assoc($result)) {
            $admin_name = $value_query["admin_name"];
            $admin_email = $value_query["admin_email"];
            $admin_password = $value_query["admin_password"];
        }

        $_SESSION['admin_name'] = $admin_name;
        $_SESSION['admin_email'] = $admin_email;
        $_SESSION['admin_password'] = $admin_password;
    } else {
        $_SESSION['no_result'] = true;
        header('Location: https://voto-eletronico.jbr-projects.pt/admin/');
    }
}

function logout_admin() {
    session_destroy();
    header('Location: https://voto-eletronico.jbr-projects.pt/admin/');
}

function add_user(){
    echo "oi ";
    include '../application/Db_connection.php';
    $add_user_name = $_POST['add_user_name'];
    $add_user_email = $_POST['add_user_email'];
    $add_user_password = $_POST['add_user_password'];
    $add_user_password = md5($add_user_password);
    $add_user_doc = $_POST['add_user_doc'];
    $add_user_nif = $_POST['add_user_nif'];
    $add_user_nmra = $_POST['add_user_nmra'];
    $query = "INSERT INTO users (user_name, user_password, user_email, user_document_type, user_nif) VALUES ('$add_user_name','$add_user_password', '$add_user_email', '$add_user_doc', '$add_user_nif')";
    $result = mysqli_query($connection, $query);
}
