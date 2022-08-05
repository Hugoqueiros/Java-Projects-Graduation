<?php
require 'application/header.php';
session_start();
if (!$_SESSION['user_name']) {
    ?>
    <!-- Login do utilizador -->
    <h1>Login</h1>
    <?php if (isset($_SESSION['no_result'])) {
        ?> 
        <h5 style="color: red;">Utilizador não existe!</h5>
    <?php } ?>
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
        <span class="helper-error" id="helper-error-nif"></span>
    </div>
    <div id="nmr_nmra">
        <label>Numero do Aluno: </label>
        <input id="login_user_nmra" minlength="4" maxlength="10" onkeypress="return only_numbers(event)">
        <span class="helper-error" id="helper-error-nmra"></span>
    </div>
    <br>
    <div id="pw">
        <label>Password: </label>
        <input id="login_user_password" type="password">
        <span class="helper-error" id="helper-error-password"></span>
        <br>
        <a href="#">Esqueceu-se da sua password?</a>
    </div>
    <br>
    <br>
    <button id="btn_next" onclick="user_verify();" disabled>Seguinte</button>
    <br>
    <br>
    <!-- Se o user existir vai inserir na div o input para a inserção da key enviada por email, através de jquery -->
    <div id="key">   
    </div>

    <?php
} else {
    //print_r($_SESSION);
    ?>    
    <a href="https://voto-eletronico.jbr-projects.pt/user/user.php?f=logout_user" type="button">Sair da Conta</a>
<?php
}
require 'application/footer.php';
?>
