<?php require '../application/header.php' ?>

<body class="bg-dark">

    <div class="container">

        <!-- Outer Row -->
        <div class="row justify-content-center">

            <div class="col-xl-10 col-lg-12 col-md-9">

                <div class="o-hidden border-0 my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-md-12">
                                <div class="p-5">
                                    <div class="text-center div_img">
                                        <img src="/assets/img/logo.png" width="300">
                                    </div>

                                    <form class="user">
                                        <?php if ($_SESSION['no_result_admin'] == true) {
                                            ?>
                                            <div class="admin-alert d-flex justify-content-center alert-danger alert" role="alert">
                                                O administrador que inseriu não existe!
                                            </div>
                                            <?php
                                        }
                                        ?>
                                        <div class="form-group form-floating d-flex justify-content-center">
                                            <input type="email" class="form-control form-control-user inputs-login"
                                                   id="admin_email" aria-describedby="emailHelp"
                                                   placeholder="Insira o seu email">
                                            <label class="label-floating" for="admin_email">Insira o seu email</label>
                                        </div>
                                        <div class="d-flex">
                                            <span class="helper-error" id="helper-error-admin-email"></span>
                                        </div>
                                        <div class="form-group form-floating d-flex justify-content-center">
                                            <input type="password" class="form-control form-control-user inputs-login"
                                                   id="admin_pw" placeholder="Insira a sua password">
                                            <label class="label-floating" for="admin_pw">Insira a sua password</label>
                                        </div>
                                        <div class="d-flex">
                                            <span class="helper-error" id="helper-error-admin-pw"></span>
                                        </div>
                                        <div class="d-flex justify-content-center">
                                            <button  type="button" onclick="admin_login();" class="btn btn-initial">
                                                Entrar<i style="float:right;" class="fa fa-arrow-right"></i>
                                            </button>
                                        </div>

                                    </form>
                                    <hr class="label-floating" style="border-color:#fff;" width="50%">
                                    <div class="text-center">
                                        <a style="color:#0075db;" class="small" href="forgot-password.html">Esqueceu-se da Password?</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>

    </div>
    <?php require '../application/footer.php' ?>