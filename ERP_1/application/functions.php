<?php

session_start();

$function = $_GET['function'];
if (function_exists($function)) {
    call_user_func($function);
}

function loginColaborador() {
    include '../application/db_connection.php';
    $employee_nmr = $_POST['employee_id'];
    $employee_pw = $_POST['employee_pw'];
    $employee_pw = md5($employee_pw);
    $_SESSION['no_result_employee'] = false;
    $query = "SELECT * FROM users WHERE user_id= '$employee_nmr' AND user_pw='$employee_pw' AND user_admin = '0'";
    $result = mysqli_query($connection, $query);
    if (mysqli_num_rows($result) > 0) {
        while ($value_query = mysqli_fetch_assoc($result)) {
            $employee_nmr = $value_query["user_id"];
            $employee_name = $value_query["user_name"];
            $employee_email = $value_query["user_email"];
            $employee_pw = $value_query["user_pw"];
            $employee = $value_query["user_admin"];
        }
        $_SESSION['employee_nmr'] = $employee_nmr;
        $_SESSION['employee_name'] = $employee_name;
        $_SESSION['employee_pw'] = $employee_pw;
        $_SESSION['employee_email'] = $employee_email;
        $_SESSION['employee'] = $employee;
    } else {
        $_SESSION['no_result_employee'] = true;
        header('Location: https://erp.jbr-projects.pt/employee/');
    }
}

function logout() {
    session_destroy();
    header('Location: https://erp.jbr-projects.pt');
}

function loginAdministrador() {
    include '../application/db_connection.php';
    $admin_email = $_POST['admin_email'];
    $admin_pw = $_POST['admin_pw'];
    $admin_pw = md5($admin_pw);
    $_SESSION['no_result_admin'] = false;
    $query = "SELECT * FROM users WHERE user_email = '$admin_email' AND user_pw = '$admin_pw' AND user_admin = '1'";
    $result = mysqli_query($connection, $query);
    if (mysqli_num_rows($result) > 0) {
        while ($value_query = mysqli_fetch_assoc($result)) {
            $admin_id = $value_query["user_id"];
            $admin_name = $value_query["user_name"];
            $admin_email = $value_query["user_email"];
            $admin_pw = $value_query["user_pw"];
            $admin = $value_query["user_admin"];
        }
        $_SESSION['admin_id'] = $admin_id;
        $_SESSION['admin_name'] = $admin_name;
        $_SESSION['admin_email'] = $admin_email;
        $_SESSION['admin_pw'] = $admin_pw;
        $_SESSION['admin'] = $admin;
    } else {
        $_SESSION['no_result_admin'] = true;
        header('Location: https://erp.jbr-projects.pt/admin/');
    }
}

//UTILIZADORES
//INSERIR UTILIZADORES
function add_user() {
    include '../application/db_connection.php';
    //VERIFICA SE O SERVER VAI FAZER O MÉTODO POST
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $added = false;
        //VERIFICA SE EXISTE O POST DAS VARIÁVEIS VINDAS POR JQUERY
        if (isset($_POST['add_user_name']) && isset($_POST['add_user_email']) && isset($_POST['add_user_pw']) && isset($_POST['add_user_phone'])) {
            $add_user_name = $_POST['add_user_name'];
            $add_user_name = utf8_decode($add_user_name);
            $add_user_email = $_POST['add_user_email'];
            $add_user_pw = $_POST['add_user_pw'];
            $add_user_pw = md5($add_user_pw);
            $add_user_phone = $_POST['add_user_phone'];
            $query = "INSERT INTO users (user_name, user_email, user_pw, user_phone, user_admin)
        VALUES ('$add_user_name','$add_user_email','$add_user_pw','$add_user_phone','0')";
            if (mysqli_query($connection, $query)) {
                //VARIAVEL QUE DIZ AO JQUERY QUE O EVENTO FOI ADICIONADO
                $added = true;
                echo $added;
            }
        }
    }
}

//FUNÇÃO QUE ELIMINA O UTILIZADOR
function delete_user() {
    include '../application/db_connection.php';
    //VERIFICA SE O SERVER VAI FAZER O MÉTODO POST
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $user_deleted = false;
        //VERIFICA SE EXISTE O POST DAS VARIÁVEIS VINDAS POR JQUERY
        if (isset($_POST['user_id'])) {
            $user_id = $_POST['user_id'];
            $query = "DELETE FROM users WHERE user_id = '$user_id'";
            if (mysqli_query($connection, $query)) {
                //VARIAVEL QUE DIZ AO JQUERY QUE O UTILIZADOR FOI ELIMINADO
                $user_deleted = true;
                echo $user_deleted;
            }
        }
    }
}

//FUNÇÃO QUE VAI BUSCAR TODOS OS UTILIZADORES
function get_users() {
    include '../application/db_connection.php';
    $query_users = "SELECT * FROM users ORDER BY user_id ASC";
    $result_users = mysqli_query($connection, $query_users);
    return $result_users;
}

//FUNÇÃO PARA EDITAR UTILIZADOR
function edit_user() {
    include '../application/db_connection.php';
    $user_edited = false;
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        //VERIFICA SE EXISTE O POST DAS VARIÁVEIS VINDAS POR JQUERY
        if (isset($_POST['edit_user_name']) && isset($_POST['edit_user_email']) && isset($_POST['edit_user_phone']) && isset($_POST['edit_user_id'])) {
            $edit_user_id = $_POST['edit_user_id'];
            $edit_user_name = $_POST['edit_user_name'];
            $edit_user_name = utf8_decode($edit_user_name);
            $edit_user_email = $_POST['edit_user_email'];
            $edit_user_phone = $_POST['edit_user_phone'];
            $query = "UPDATE users SET user_name='$edit_user_name', user_email='$edit_user_email', user_phone='$edit_user_phone' WHERE user_id = '$edit_user_id'";
            if (mysqli_query($connection, $query)) {
                $user_edited = true;
            }
        }
    }
    echo $user_edited;
}

//PRODUTOS
//INSERIR PRODUTO
function add_product() {
    include '../application/db_connection.php';
    //VERIFICA SE O SERVER VAI FAZER O MÉTODO POST
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $added = false;
        //VERIFICA SE EXISTE O POST DAS VARIÁVEIS VINDAS POR JQUERY
        if (isset($_POST['add_product_name'])) {
            $add_product_name = $_POST['add_product_name'];
            $add_product_name = utf8_decode($add_product_name);
            $query = "INSERT INTO products (product_name)
        VALUES ('$add_product_name')";
            if (mysqli_query($connection, $query)) {
                //VARIAVEL QUE DIZ AO JQUERY QUE O EVENTO FOI ADICIONADO
                $added = true;
                echo $added;
            }
        }
    }
}

//FUNÇÃO PARA EDITAR PRODUTO
function edit_product() {
    include '../application/db_connection.php';
    $product_edited = false;
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        //VERIFICA SE EXISTE O POST DAS VARIÁVEIS VINDAS POR JQUERY
        if (isset($_POST['edit_product_name'])){
            $edit_product_id = $_POST['edit_product_id'];
            $edit_product_name = $_POST['edit_product_name'];
            $edit_product_name = utf8_decode($edit_product_name);
            $query = "UPDATE products SET product_name='$edit_product_name' WHERE product_id = '$edit_product_id'";
            if (mysqli_query($connection, $query)) {
                $product_edited = true;
            }
        }
    }
    echo $product_edited;
}

//FUNÇÃO QUE ELIMINA O PRODUTO
function delete_product() {
    include '../application/db_connection.php';
    //VERIFICA SE O SERVER VAI FAZER O MÉTODO POST
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $product_deleted = false;
        //VERIFICA SE EXISTE O POST DAS VARIÁVEIS VINDAS POR JQUERY
        if (isset($_POST['product_id'])) {
            $product_id = $_POST['product_id'];
            $query = "DELETE FROM products WHERE product_id = '$product_id'";
            if (mysqli_query($connection, $query)) {
                //VARIAVEL QUE DIZ AO JQUERY QUE O UTILIZADOR FOI ELIMINADO
                $product_deleted = true;               
            }
        }
    }
    echo $product_deleted;
}


//FUNÇÃO QUE VAI BUSCAR TODOS OS FORNECEDORES
function get_products() {
    include '../application/db_connection.php';
    $query_products = "SELECT * FROM products";
    $result_products = mysqli_query($connection, $query_products);
    return $result_products;
}

//FORNECEDORES
//FUNÇAO PARA INSERIR FORNECEDORES
function add_provider() {
    include '../application/db_connection.php';
    //VERIFICA SE O SERVER VAI FAZER O MÉTODO POST
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $added = false;
        //VERIFICA SE EXISTE O POST DAS VARIÁVEIS VINDAS POR JQUERY
        if (isset($_POST['add_provider_email']) && isset($_POST['add_provider_name'])) {
            $add_provider_name = $_POST['add_provider_name'];
            $add_provider_name = utf8_decode($add_provider_name);
            $add_provider_email = $_POST['add_provider_email'];
            $query = "INSERT INTO providers (provider_name,provider_email)
        VALUES ('$add_provider_name','$add_provider_email')";
            if (mysqli_query($connection, $query)) {
                //VARIAVEL QUE DIZ AO JQUERY QUE O EVENTO FOI ADICIONADO
                $added = true;
                echo $added;
            }
        }
    }
}

//FUNÇÃO QUE ELIMINA O FORNECEDOR
function delete_provider() {
    $provider_deleted = false;
    include '../application/db_connection.php';
    //VERIFICA SE O SERVER VAI FAZER O MÉTODO POST
    if ($_SERVER["REQUEST_METHOD"] == "POST") {

        //VERIFICA SE EXISTE O POST DAS VARIÁVEIS VINDAS POR JQUERY
        if (isset($_POST['provider_id'])) {
            $provider_id = $_POST['provider_id'];
            $query = "DELETE FROM providers WHERE provider_id = '$provider_id'";
            if (mysqli_query($connection, $query)) {
                //VARIAVEL QUE DIZ AO JQUERY QUE O UTILIZADOR FOI ELIMINADO
                $provider_deleted = true;
            }
        }
    }
    echo $provider_deleted;
}

//FUNÇÃO PARA EDITAR FORNECEDOR
function edit_provider() {
    include '../application/db_connection.php';
    $provider_edited = false;
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        //VERIFICA SE EXISTE O POST DAS VARIÁVEIS VINDAS POR JQUERY
        if (isset($_POST['edit_provider_name']) && isset($_POST['edit_provider_email']) && isset($_POST['edit_provider_id'])) {
            $edit_provider_id = $_POST['edit_provider_id'];
            $edit_provider_name = $_POST['edit_provider_name'];
            $edit_provider_name = utf8_decode($edit_provider_name);
            $edit_provider_email = $_POST['edit_provider_email'];
            $query = "UPDATE providers SET provider_name='$edit_provider_name', provider_email='$edit_provider_email' WHERE provider_id = '$edit_provider_id'";
            if (mysqli_query($connection, $query)) {
                $provider_edited = true;
            }
        }
    }
    echo $provider_edited;
}

//FUNÇÃO QUE VAI BUSCAR TODOS OS FORNECEDORES
function get_providers() {
    include '../application/db_connection.php';
    $query_providers = "SELECT * FROM providers ORDER BY provider_id ASC";
    $result_providers = mysqli_query($connection, $query_providers);
    return $result_providers;
}

//ENCOMENDAS
//FUNÇÃO QUE VAI BUSCAR TODAS AS ENCOMENDAS
function get_requests() {
    include '../application/db_connection.php';
    $query_requests = "SELECT * FROM request ORDER BY request_id ASC";
    $result_requests = mysqli_query($connection, $query_requests);
    return $result_requests;
}

//FUNÇÃO QUE ELIMINA A ENCOMENDA
function delete_order() {
    $order_deleted = false;
    include '../application/db_connection.php';
    //VERIFICA SE O SERVER VAI FAZER O MÉTODO POST
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        //VERIFICA SE EXISTE O POST DAS VARIÁVEIS VINDAS POR JQUERY
        if (isset($_POST['request_id'])) {
            $request_id = $_POST['request_id'];
            $query = "DELETE FROM requests WHERE request_id = '$request_id'";
            if (mysqli_query($connection, $query)) {
                //VARIAVEL QUE DIZ AO JQUERY QUE O UTILIZADOR FOI ELIMINADO
                $order_deleted = true;
            }
        }
    }
    echo $order_deleted;
}
