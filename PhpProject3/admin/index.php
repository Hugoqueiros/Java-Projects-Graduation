
<!DOCTYPE html>
<html>
    <head>
        <title>Teste</title>
    </head>
    <body>

        <!-- Registo do utilizador -->
        <h1>Registo</h1>
        <label>Nome: </label>
        <input id="user_regist_name" type="text">
        <br>
        <label>Email: </label>
        <input id="user_regist_email" type="email">
        <br>
        <label for="docs">Tipo de documento: </label>
        <select name="docs" id="user_regist_doc">
            <option value="bi">Bilhete de Identidade</option>
            <option value="cc">Cartão de Cidadão</option>
        </select>
        <br>
        <label>NIF: </label>
        <input id="user_regist_nif" type="text" minlength="9" maxlength="9">
        <br>
        <label>Password: </label>
        <input id="user_regist_password" type="password">
        <br>
        <label>Chave: </label>
        <input id="user_regist_key" type="text">
        <br>
        <button onclick="user_regist();">Enviar</button>

        <script type="text/javascript" src="assets/js/jquery-3.6.0.min.js"></script>
        <script type="text/javascript" src="assets/js/scripts.js"></script>
    </body>
</html>