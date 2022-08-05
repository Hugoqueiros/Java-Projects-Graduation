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
                                        <div class="form-group d-flex justify-content-center">
                                            <input type="email" class="form-control form-control-user"
                                                   id="exampleInputEmail" aria-describedby="emailHelp"
                                                   placeholder="Insira o seu email">
                                        </div>
                                        <div class="form-group d-flex justify-content-center">
                                            <input type="password" class="form-control form-control-user"
                                                   id="exampleInputPassword" placeholder="Insira a sua password">
                                        </div>
                                        <div class="d-flex justify-content-center">
                                            <a href="#" class="btn btn-primary btn-user btn-block">
                                                Entrar
                                            </a>
                                        </div>

                                    </form>
                                    <hr style="border-color:#fff;" width="50%">
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