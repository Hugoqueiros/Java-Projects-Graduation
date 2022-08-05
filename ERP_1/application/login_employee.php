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
                                        <?php if ($_SESSION['no_result_employee'] == true) {
                                            ?>
                                            <div class="employee-alert d-flex justify-content-center alert-danger alert" role="alert">
                                                O colaborador que inseriu não existe!
                                            </div>
                                            <?php
                                        }
                                        ?>
                                        <div class="form-group form-floating d-flex justify-content-center">                                
                                            <input type="text" class="form-control form-control-user inputs-login"
                                                   id="employee_id"
                                                   placeholder="Insira o seu número de identificação">
                                            <label class="label-floating" for="employee_id">Insira o seu número de identificação</label>
                                        </div>
                                        <div class="d-flex">
                                            <span class="helper-error" id="helper-error-employee-id"></span>
                                        </div>
                                        <div class="form-group form-floating d-flex justify-content-center">
                                            <input type="password" class="form-control form-control-user inputs-login"
                                                   id="employee_pw" placeholder="Insira a sua password">
                                            <label class="label-floating" for="employee_pw">Insira a sua password</label>
                                            <br>
                                        </div>
                                        <div class="d-flex">
                                            <span class="helper-error" id="helper-error-employee-pw"></span>
                                        </div>

                                        <div class="d-flex justify-content-center">
                                            <button  type="button" onclick="employee_login();" class="btn btn-initial">
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