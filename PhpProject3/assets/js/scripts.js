

//-------------------------------------------------------------------------- SCRIPTS USERS --------------------------------------------------------------------------


//FUNÇÃO PARA O SELECT DO LOGIN
$("#doc").change(function () {
    var selected_option = $('#doc').val();
    if (selected_option == 'cc') {
        $('#nmr_nmra').css('display', 'none');
        $('#nmr_nif').css('display', 'block');
        $('#pw').css('display', 'block');

    } else {
        $('#nmr_nmra').css('display', 'block');
        $('#nmr_nif').css('display', 'none');
        $('#pw').css('display', 'block');
    }
});

//APENAS NÚMEROS NO INPUT DO NIF E NUMERO DO ALUNO
function only_numbers(evt) {
    var charCode = (evt.which) ? evt.which : event.keyCode
    if (charCode > 31 && (charCode < 48 || charCode > 57))
        return false;
    return true;
}

//FUNÇÃO DE LOGIN DE UTILIZADOR
user_login = function () {
    var selected_option = $('#doc').val();
    var login_user_password = $('#login_user_password').val();
    if (selected_option == 'cc') {
        var login_user_nif = $('#login_user_nif').val();
        $.ajax({
            url: 'user/user.php',
            type: "POST",
            data: {user_document_type: selected_option, user_password: login_user_password, user_nif: login_user_nif},
            success: function (data) {
                //SWEET ALERT FUNCTION
                alert(data);
                console.log(data);
                window.location.href = "https://voto-eletronico.jbr-projects.pt/";
            }
        });
    } else {
        var login_user_nmra = $('#login_user_nmra').val();
        $.ajax({
            url: 'user/user.php',
            type: "POST",
            data: {user_document_type: selected_option, user_password: login_user_password, user_nmra: login_user_nmra},
            success: function () {
                //SWEET ALERT FUNCTION
                //window.location.href = "user/User.php?f=regist_user";
            }
        });
    }

};


//-------------------------------------------------------------------------- SCRIPTS ADMINS --------------------------------------------------------------------------


//FUNÇÃO DE LOGIN DE ADMIN
user_regist = function () {
    var user_regist_name = $('#user_regist_name').val();
    var user_regist_email = $('#user_regist_email').val();
    var user_regist_doc = $('#user_regist_doc').val();
    var user_regist_nif = $('#user_regist_nif').val();
    var user_regist_password = $('#user_regist_password').val();
    var user_regist_key = $('#user_regist_key').val();
    var user_details = {
        "user_name": user_regist_name,
        "user_password": user_regist_password,
        "user_email": user_regist_email,
        "user_nif": user_regist_nif,
        "user_doc": user_regist_doc,
        "user_key": user_regist_key
    };
    console.log(user_details);
    $.ajax({
        url: 'user/User.php?f=regist_user',
        type: "POST",
        data: {user_regist_name: user_regist_name, user_regist_password: user_regist_password, user_regist_email: user_regist_email, user_regist_nif: user_regist_nif, user_regist_doc: user_regist_doc, user_regist_key: user_regist_key},
        success: function () {
            //SWEET ALERT FUNCTION
            window.location.href = "user/User.php?f=regist_user";
        }
    });
};