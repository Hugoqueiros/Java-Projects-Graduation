<?php
include '../user/user.php';
print_r($_SESSION);
echo session_status();
?>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="assets/css/styles.css">
        <title>Teste</title>
    </head>
    <body>
        
        <?php if (session_status() === 2) { ?>
            <button >Sair da Conta</button>
        <?php } else { ?>
            <!-- Login do utilizador -->
            <h1>Login</h1>
            <label for="doc">Tipo do documento: </label>
            <select name="doc" id="doc">
                <option selected disabled>Selecione uma opção</option>
                <option value="cc">Cartão de Cidadão</option>
                <option value="nmra">Número de Aluno</option>
            </select>
            <br>
            <br>
            <div id="nmr_nif">
                <label>NIF: </label>
                <input id="login_user_nif" maxlength="9" minlength="9" onkeypress="return only_numbers(event)"> 
            </div>
            <div id="nmr_nmra">
                <label>Numero do Aluno: </label>
                <input id="login_user_nmra" minlength="4" maxlength="10" onkeypress="return only_numbers(event)">
            </div>
            <br>
            <div id="pw">
                <label>Password: </label>
                <input id="login_user_password" type="password">
                <a href="#">Esqueceu-se da sua password?</a>
            </div>
            <br>
            <!--<label>Chave: </label>
            <input>-->
            <br>
            <button onclick="user_login();">Seguinte</button>
        <?php } ?>
        <script type="text/javascript" src="assets/js/jquery-3.6.0.min.js"></script>
        <script type="text/javascript" src="assets/js/scripts.js"></script>
    </body>
</html>