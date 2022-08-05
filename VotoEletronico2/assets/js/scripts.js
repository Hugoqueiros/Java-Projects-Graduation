var url = "https://voto-eletronico.jbr-projects.pt/";

//-------------------------------------------------------------------------- SCRIPTS USERS --------------------------------------------------------------------------


//FUNÇÃO PARA O SELECT DO LOGIN
$("#doc").change(function () {
    var selected_option = $('#doc').val();
    if (selected_option == 'cc') {
        $('#nmr_nmra').css('display', 'none');
        $('#nmr_nif').css('display', 'block');
        $('#pw').css('display', 'block');
        $('#btn_next').prop("disabled", false);
    } else {
        $('#nmr_nmra').css('display', 'block');
        $('#nmr_nif').css('display', 'none');
        $('#pw').css('display', 'block');
        $('#btn_next').prop("disabled", false);
    }
});

//APENAS NÚMEROS NO INPUT DO NIF E NUMERO DO ALUNO
function only_numbers(evt) {
    var charCode = (evt.which) ? evt.which : event.keyCode
    if (charCode > 31 && (charCode < 48 || charCode > 57))
        return false;
    return true;
}

//FUNÇÃO DE VERIFICAÇÃO DE UTILIZADOR
user_verify = function () {
    var submit = true;
    var selected_option = $('#doc').val();
    var login_user_password = $('#login_user_password').val();
    if (selected_option == 'cc') {
        var login_user_nif = $('#login_user_nif').val();
        if (login_user_nif == '') {
            $('#helper-error-nif').text('*O nif é obrigatório!');
            submit = false;
        } else if (login_user_nif.length < 9) {
            $('#helper-error-nif').text('*O nif não tem 9 caracteres!');
            submit = false;
        } else {
            $('#helper-error-nif').text('')
        }
        if (login_user_password == '') {
            $('#helper-error-password').text('*A password é obrigatória!');
            submit = false;
        } else {
            $('#helper-error-password').text('')
        }

        if (submit == true) {
            $.ajax({
                url: 'user/user.php?f=verify_user',
                type: "POST",
                data: {user_document_type: selected_option, user_password: login_user_password, user_nif: login_user_nif}
            }).done(function (user_found) {
                if (user_found == true) {
                    $('#key').append('<label>Chave: </label>');
                    $('#key').append('<input id="login_user_key" type="password">');
                    $('#key').append('<span class="helper-error" id="helper-error-key"></span>');
                    $('#key').append('<br><a href="#">Não recebeu a chave?</a>');
                    $('#key').append('<br><br><button onclick="user_login();">Entrar</button>');
                } else {
                    window.location.href = url;
                }
            });
        }
    } else {
        var login_user_nmra = $('#login_user_nmra').val();
        if (login_user_nmra == '') {
            $('#helper-error-nmra').text('*O número de aluno é obrigatório!');
            submit = false;
        } else if (login_user_nmra.length < 4 || (login_user_nmra.length > 4 && login_user_nmra.length < 10)) {
            $('#helper-error-nmra').text('*O número de aluno tem de ter 4 ou 10 números!');
            submit = false;
        } else {
            $('#helper-error-nmra').text('')
        }
        if (login_user_password == '') {
            $('#helper-error-password').text('*A password é obrigatória!');
            submit = false;
        } else {
            $('#helper-error-password').text('')
        }
        if (submit == true) {
            $.ajax({
                url: 'user/user.php?f=verify_user',
                type: "POST",
                data: {user_document_type: selected_option, user_password: login_user_password, user_nmra: login_user_nmra}
            }).done(function (user_found) {
                if (user_found == true) {
                    $('#key').append('<label>Chave: </label>');
                    $('#key').append('<input id="login_user_key" type="password">');
                    $('#key').append('<span class="helper-error" id="helper-error-key"></span>');
                    $('#key').append('<br><a href="#">Não recebeu a chave?</a>');
                    $('#key').append('<br><br><button onclick="user_login();">Entrar</button>');
                } else {
                    window.location.href = url;
                }
            });
        }
    }
};

user_login = function () {
    var submit = true;
    var selected_option = $('#doc').val();
    var login_user_password = $('#login_user_password').val();
    var login_user_key = $('#login_user_key').val();
    if (selected_option == 'cc') {
        var login_user_nif = $('#login_user_nif').val();
        if (login_user_key == '') {
            $('#helper-error-key').text('*A chave é obrigatória!');
            submit = false;
        } else {
            $('#helper-error-key').text('')
        }
        if (submit == true) {
            $.ajax({
                url: 'user/user.php?f=login_user',
                type: "POST",
                data: {user_document_type: selected_option, user_password: login_user_password, user_nif: login_user_nif, user_key: login_user_key},
                success: function () {
                    //SWEET ALERT FUNCTION
                    window.location.href = url;
                }
            });
        }
    } else {
        var login_user_nmra = $('#login_user_nmra').val();
        if (login_user_key == '') {
            $('#helper-error-key').text('*A chave é obrigatória!');
            submit = false;
        } else {
            $('#helper-error-key').text('')
        }
        if (submit == true) {
            $.ajax({
                url: 'user/user.php?f=login_user',
                type: "POST",
                data: {user_document_type: selected_option, user_password: login_user_password, user_nmra: login_user_nmra, user_key: login_user_key},
                success: function () {
                    //SWEET ALERT FUNCTION
                    window.location.href = url;
                }
            });
        }

    }
};

//-------------------------------------------------------------------------- SCRIPTS ADMINS --------------------------------------------------------------------------


//FUNÇÃO DE LOGIN DE ADMIN
admin_login = function () {
    var submit = true;
    var admin_email = $('#admin_email').val();
    var admin_password = $('#admin_password').val();
    var testEmail = /^[A-Z0-9._%+-]+@([A-Z0-9-]+\.)+[A-Z]{2,4}$/i;
    if (admin_email == '') {
        $('#helper-error-admin-email').text('*O email do administrador é obrigatório!');
        submit = false;
    } else if (!testEmail.test(admin_email)) {
        $('#helper-error-admin-email').text('*O email do administrador introduzido não é valido!');
        submit = false;
    } else {
        $('#helper-error-admin-email').text('');
    }

    if (admin_password == '') {
        $('#helper-error-admin-password').text('*A password do administrador é obrigatória!');
        submit = false;
    } else {
        $('#helper-error-admin-password').text('');
    }
    if (submit == true) {
        $.ajax({
            url: 'admin.php?f=login_admin',
            type: "POST",
            data: {admin_email: admin_email, admin_password: admin_password},
            success: function () {
                //SWEET ALERT FUNCTION
                window.location.href = url + "admin/";
            }
        });
    }
};

//FUNÇÃO PARA O SELECT DA INSERÇÃO DO UTILIZADOR
$("#add_user_doc").change(function () {
    var selected_option = $('#add_user_doc').val();
    if (selected_option == 'cc') {
        $('#div_add_user_nmra').css('display', 'none');
        $('#div_add_user_nif').css('display', 'block');
    } else {
        $('#div_add_user_nmra').css('display', 'block');
        $('#div_add_user_nif').css('display', 'block');
    }
});

//FUNÇÃO PARA INSERIR NOVO UTILIZADOR
add_user = function () {
    var submit = true;
    var add_user_name = $('#add_user_name').val();
    var add_user_email = $('#add_user_email').val();
    var add_user_password = $('#add_user_password').val();
    var add_user_confirm_password = $('#add_user_confirm_password').val();
    var selected_option = $('#add_user_doc').val();
    if (selected_option == 'cc') {
        var add_user_nif = $('#add_user_nif').val();
    } else {
        var add_user_nif = $('#add_user_nif').val();
        var add_user_nmra = $('#add_user_nmra').val();
    }
    var details = {
        "name": add_user_name,
        "email": add_user_email,
        "password": add_user_password,
        "confirmed": add_user_confirm_password,
        "option": selected_option,
        "nif": add_user_nif,
        "nmra": add_user_nmra
    };
    console.log(details);
    $.ajax({
        url: 'admin.php?f=add_user',
        type: "POST",
        data: {add_user_name: add_user_name, add_user_email: add_user_email, add_user_password: add_user_password, add_user_doc: selected_option, add_user_nif: add_user_nif, add_user_nmra: add_user_nmra},
        success: function () {
            //SWEET ALERT FUNCTION
            //window.location.href = url + "admin/";
        }
    });
}

/*var user_details = {
 "admin_email": admin_email,
 "admin_password": admin_password
 };
 console.log(user_details);*/