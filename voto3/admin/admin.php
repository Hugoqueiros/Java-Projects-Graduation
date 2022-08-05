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

function add_user() {
    include '../application/Db_connection.php';
    $user_registed = false;
    $add_user_name = $_POST['add_user_name'];
    $add_user_email = $_POST['add_user_email'];
    $add_user_password = $_POST['add_user_password'];
    $add_user_password = md5($add_user_password);
    $add_user_doc = $_POST['add_user_doc'];
    $add_user_nif = $_POST['add_user_nif'];
    $add_user_nmra = $_POST['add_user_nmra'];
    $query_select_nif = "SELECT user_nif FROM user WHERE user_nif = '$add_user_nif'";
    $query_select_nmra = "SELECT user_nmra FROM users WHERE user_nmra = '$add_user_nmra'";
    $query_select_email = "SELECT user_email FROM users WHERE user_email = '$add_user_email' ";
    $result_nif = mysqli_query($connection, $query_select_nif);
    $result_nmra = mysqli_query($connection, $query_select_nmra);
    $result_email = mysqli_query($connection, $query_select_email);
    if (mysqli_num_rows($result_nif) > 0) {
        $user_registed = true;
        echo $user_registed;
    } else if (mysqli_num_rows($result_nmra) > 0) {
        $user_registed = true;
        echo $user_registed;
    } else if (mysqli_num_rows($result_email) > 0) {
        $user_registed = true;
        echo $user_registed;
    } else {
        
        if ($add_user_doc == "cc") {
            $query = "INSERT INTO users (user_name, user_password, user_email, user_document_type, user_nif)
            VALUES ('$add_user_name','$add_user_password', '$add_user_email', '$add_user_doc', '$add_user_nif')";
            $result = mysqli_query($connection, $query);
        } else {
            if ($add_user_nif == "") {
                $query = "INSERT INTO users (user_name, user_password, user_email, user_document_type, user_nmra)
                        VALUES ('$add_user_name','$add_user_password', '$add_user_email', '$add_user_doc', '$add_user_nmra')";
                $result = mysqli_query($connection, $query);
            } else {
                $query = "INSERT INTO users (user_name, user_password, user_email, user_document_type, user_nif, user_nmra)
                        VALUES ('$add_user_name','$add_user_password', '$add_user_email', '$add_user_doc', '$add_user_nif', '$add_user_nmra')";
                echo json_encode($query);
                $result = mysqli_query($connection, $query);              
            }
        }
    }
}

function add_event(){
    include '../application/Db_connection.php';
    $add_event_title = $_POST['add_event_title'];
    $add_event_description = $_POST['add_event_description'];
    $add_event_date_ini = $_POST['add_event_date_ini'];
    $add_event_date_exp = $_POST['add_event_date_exp'];
    $query = "INSERT INTO events (event_title, event_description, event_date_ini, event_date_exp)
        VALUES ('$add_event_title', '$add_event_description', '$add_event_date_ini', '$add_event_date_exp')";
    $result = mysqli_query($connection, $query);    
}

function get_event(){
    include '../application/Db_connection.php';
    $query_events = "SELECT * FROM events";
    $result_event = mysqli_query($connection, $query_events);
    return $result_event;
}

function get_users(){
    include '../application/Db_connection.php';
    $query_users = "SELECT * FROM users";
    $result_users = mysqli_query($connection, $query_users);
    return $result_users;
}
