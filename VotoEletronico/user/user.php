<?php

require '../application/Db_connection.php';
require '../application/PHPMailer-5.2-stable/PHPMailerAutoload.php';

session_start();

$function = $_GET['f'];
if (function_exists($function)) {
    call_user_func($function);
}

function verify_user() {
    include '../application/Db_connection.php';
    include 'PHPMailer-5.2-stable/PHPMailerAutoload.php';

    //se for false o user está a tentar fazer login com nmra, se for true está a tentar com o nif
    $is_nif = false;
    //se for false não existe o utilizador na bd, se for true já existe
    $_SESSION['no_result'] = false;
    //se houver um user e se tiver enviado um email com a key a esse utilizador então a variavel passa a true e diz ao jquery para acrescentar o input para isnerção da key
    $user_found = false;
    $user_document_type = $_POST['user_document_type'];
    $user_password = $_POST['user_password'];
    $user_password = md5($user_password);


    if ($_POST['user_nmra']) {
        $user_nmra = $_POST['user_nmra'];
        $query = "SELECT * FROM users WHERE user_nmra='$user_nmra' AND user_password='$user_password' AND user_document_type='$user_document_type'";
        $is_nif = false;
    }

    if ($_POST['user_nif']) {
        $user_nif = $_POST['user_nif'];
        $query = "SELECT * FROM users WHERE user_nif='$user_nif' AND user_password='$user_password' AND user_document_type='$user_document_type'";
        $is_nif = true;
    }

    $result = mysqli_query($connection, $query);
    if (mysqli_num_rows($result) > 0) {

        $user_key = md5(microtime() . rand());
        if ($is_nif == true) {
            $query_insert = "UPDATE users SET user_key='$user_key' WHERE user_nif='$user_nif' AND user_password='$user_password' AND user_document_type='$user_document_type'";
            $query_get_email = "SELECT * FROM users WHERE user_nif='$user_nif' AND user_password='$user_password' AND user_document_type='$user_document_type'";
        } else {
            $query_insert = "UPDATE users SET user_key='$user_key' WHERE user_nmra='$user_nmra' AND user_password='$user_password' AND user_document_type='$user_document_type'";
            $query_get_email = "SELECT * FROM users WHERE user_nmra='$user_nmra' AND user_password='$user_password' AND user_document_type='$user_document_type'";
        }

        $result_insert = mysqli_query($connection, $query_insert);
        $result_after = mysqli_query($connection, $query_get_email);

        //select à bd para receber o email do utilizador que está a fazer o login
        while ($value_query = mysqli_fetch_assoc($result_after)) {
            $user_name = $value_query["user_name"];
            $user_password = $value_query["user_password"];
            $user_email = $value_query["user_email"];
            $user_nif = $value_query["user_nif"];
            $user_nmra = $value_query["user_nmra"];
            $user_document_type = $value_query["user_document_type"];
            $user_change_pw = $value_query["user_change_pw"];
            $user_key = $value_query["user_key"];
        }

        $mail = new PHPMailer;

        $mail->isSMTP();                                      // Set mailer to use SMTP
        $mail->Host = 'voto-eletronico.jbr-projects.pt';  // Specify main and backup SMTP servers
        $mail->SMTPAuth = true;                               // Enable SMTP authentication
        $mail->Username = 'geral@voto-eletronico.jbr-projects.pt';                 // SMTP username
        $mail->Password = 'voto_hj12345';                           // SMTP password
        $mail->SMTPSecure = 'ssl';                            // Enable TLS encryption, `ssl` also accepted
        $mail->Port = 465;                                    // TCP port to connect to

        $mail->setFrom('no-reply@voto-eletronico.jbr-projects.pt', 'NO-REPLY - VOTO ELETRONICO');    // Add a recipient
        $mail->addAddress($user_email);               // Name is optional
        // Optional name
        $mail->isHTML(true);                                  // Set email format to HTML
        $mail->Subject = 'ESTE E UM EMAIL AUTOMATICO POR FAVOR NAO RESPONDA A ESTE EMAIL';
        $mail->Body = "A sua chave para iniciar sessão em voto-eletronico.jbr-projects.pt: <br><br>$user_key";
        $mail->AltBody = "A sua chave para iniciar sessao em voto-eletronico.jbr-projects.pt: $user_key";

        if (!$mail->send()) {
            $mail->ErrorInfo;
        }
        $user_found = true;
        echo $user_found;
    } else {
        $_SESSION['no_result'] = true;
        header("Location: https://voto-eletronico.jbr-projects.pt");
    }
}

function login_user() {
    include '../application/Db_connection.php';

    $is_nif = false;
    $user_document_type = $_POST['user_document_type'];
    $user_password = $_POST['user_password'];
    $user_password = md5($user_password);
    $user_key = $_POST['user_key'];

    if ($_POST['user_nmra']) {
        $user_nmra = $_POST['user_nmra'];
        $query = "SELECT * FROM users WHERE user_nmra='$user_nmra' AND user_password='$user_password' AND user_document_type='$user_document_type' AND user_key='$user_key'";
        $is_nif = false;
    }

    if ($_POST['user_nif']) {
        $user_nif = $_POST['user_nif'];
        $query = "SELECT * FROM users WHERE user_nif='$user_nif' AND user_password='$user_password' AND user_document_type='$user_document_type' AND user_key='$user_key'";
        $is_nif = true;
    }
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

        $_SESSION['user_name'] = $user_name;
        $_SESSION['user_password'] = $user_password;
        $_SESSION['user_email'] = $user_email;
        if ($is_nif == true) {
            $_SESSION['user_nif'] = $user_nif;
        } else {
            $_SESSION['user_nmra'] = $user_nmra;
        }
        $_SESSION['user_document_type'] = $user_document_type;
        $_SESSION['user_change_pw'] = $user_change_pw;
        $_SESSION['user_key'] = $user_key;
    } else {
        header('Location: https://voto-eletronico.jbr-projects.pt');
    }
}

function logout_user() {
    session_destroy();
    header('Location: https://voto-eletronico.jbr-projects.pt');
}
