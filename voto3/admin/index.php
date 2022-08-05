<?php
require '../application/header.php';
session_start();
if (!$_SESSION['admin_name']) {
    ?>
    <!-- Login do utilizador -->
    <h1>Login</h1>
    <?php if (isset($_SESSION['no_result'])) {
        ?> 
        <h5 style="color: red;">Administrador não existe!</h5>
    <?php } ?>
    <div>
        <label>Email: </label>
        <input id="admin_email" type="email">
        <span class="helper-error" id="helper-error-admin-email"></span>
    </div>     
    <br>
    <div>
        <label>Password: </label>
        <input id="admin_password" type="password">
        <span class="helper-error" id="helper-error-admin-password"></span>
        <br>
        <a href="#">Esqueceu-se da sua password?</a>
    </div>
    <br>
    <br>
    <button id="btn_next" onclick="admin_login();">Entrar</button>
    <?php
} else {
    //print_r($_SESSION);
    ?>    
    <a href="https://voto-eletronico.jbr-projects.pt/admin/admin.php?f=logout_admin" type="button">Sair da Conta</a>
    <div id="utilizadores">
        <h1>Utilizadores</h1>
        <div>
            <label>Nome do Utilizador: </label>
            <input id="add_user_name">
            <span class="helper-error" id="helper-error-add-user-name"></span>
        </div>
        <div>
            <label>Email: </label>
            <input id="add_user_email" type="email">
            <span class="helper-error" id="helper-error-add-user-email"></span>
        </div>
        <div>
            <label>Password: </label>
            <input id="add_user_password" type="password">
            <span class="helper-error" id="helper-error-add-user-password"></span>
        </div>
        <div>
            <label>Confirmar Password: </label>
            <input id="add_user_confirm_password" type="password">
            <span class="helper-error" id="helper-error-add-user-confirm-password"></span>
        </div>
        <div>
            <label for="add_user_doc">Tipo do documento: </label>
            <select name="add_user_doc" id="add_user_doc">
                <option selected disabled>Selecione uma opção</option>
                <option value="cc">Cartão de Cidadão</option>
                <option value="nmra">Número de Aluno</option>
            </select>
        </div>
        <div id="div_add_user_nif">
            <label>NIF: </label>
            <input id="add_user_nif" maxlength="9" minlength="9" onkeypress="return only_numbers(event)">
            <span class="helper-error" id="helper-error-add-user-nif"></span>
        </div>
        <div id="div_add_user_nmra">
            <label>Numero do Aluno: </label>
            <input id="add_user_nmra" minlength="4" maxlength="10" onkeypress="return only_numbers(event)">
            <span class="helper-error" id="helper-error-add-user-nmra"></span>
        </div>
        <br>
        <button type="button" onclick="add_user();">Adicionar Utilizador</button>
        <br>
        <br>
        <table style="width:100%">
            <tr>
                <th>Nome</th>
                <th>NIF</th>
                <th>Número de Aluno</th>
            </tr>
            <?php
            include "admin.php";
            $result_users = get_users();
            while ($row = mysqli_fetch_assoc($result_users)) {
                ?>
                <tr>
                    <th><?php echo $row['user_name']; ?></th>
                    <th><?php echo $row['user_nif']; ?></th>
                    <th><?php echo $row['user_nmra']; ?></th>
                </tr>
                <?php
            }
            ?>
        </table>
    </div>
    <?php
}
require '../application/footer.php';
?>
