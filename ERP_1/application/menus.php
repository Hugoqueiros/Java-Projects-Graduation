<?php
session_start();
if ($_SESSION['employee_nmr'] || $_SESSION['admin_id']) {
    ?>


    <!-- Content Row -->
    <div class="row">

        <div class="btn_div"> <button type="button" class="btn btn-add" data-toggle="modal" data-target="#add_menu_modal"><i class="far fa-plus-square"></i>&nbsp;&nbsp;&nbsp;Adicionar Menu</button>
        </div>


    </div>

    <!-- Content Row -->

    <div class="row">

        <!-- Area Chart -->
        <div class="col-xl-8 col-lg-7">
            <div class="card mb-4 bg-third">
                <!-- Card Header - Dropdown -->
                <div
                    class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                    <h6 class="m-0 font-weight-bold text-primary">Visão Global dos Ganhos</h6>
                    <div class="dropdown no-arrow">
                        <a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
                        </a>
                        <div class="dropdown-menu dropdown-menu-right shadow animated--fade-in"
                             aria-labelledby="dropdownMenuLink">
                            <div class="dropdown-header">Opções:</div>
                            <a class="dropdown-item" href="#">Ação</a>
                            <a class="dropdown-item" href="#">Outra Ação</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">Outro...</a>
                        </div>
                    </div>
                </div>
                <!-- Card Body -->
                <div class="card-body">
                    <div class="chart-area">
                        <canvas id="myAreaChart"></canvas>
                    </div>
                </div>
            </div>
        </div>

        <!-- Pie Chart -->
        <div class="col-xl-4 col-lg-5">
            <div class="card mb-4 bg-third">
                <!-- Card Header - Dropdown -->
                <div
                    class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                    <h6 class="m-0 font-weight-bold text-primary">Fontes de Receita</h6>
                    <div class="dropdown no-arrow">
                        <a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
                        </a>
                        <div class="dropdown-menu dropdown-menu-right shadow animated--fade-in"
                             aria-labelledby="dropdownMenuLink">
                            <div class="dropdown-header">Opções:</div>
                            <a class="dropdown-item" href="#">Ação</a>
                            <a class="dropdown-item" href="#">Outra ação</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">Outro...</a>
                        </div>
                    </div>
                </div>
                <!-- Card Body -->
                <div class="card-body">
                    <div class="chart-pie pt-4 pb-2">
                        <canvas id="myPieChart"></canvas>
                    </div>
                    <div class="mt-4 text-center small">
                        <span class="mr-2">
                            <i class="fas fa-circle text-primary"></i> Mesa
                        </span>
                        <span class="mr-2">
                            <i class="fas fa-circle text-success"></i> Take-Away
                        </span>
                        <span class="mr-2">
                            <i class="fas fa-circle text-info"></i> UberEats
                        </span>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="add_menu_modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Adicionar Ementa</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form>
                        <div class="form-group">
                            <label for="menu_name" class="col-form-label">Nome:</label>
                            <input type="text" class="form-control" id="menu_name">
                        </div>
                        <div class="form-group">
                            <label for="menu_price" class="col-form-label">Preço(€):</label>
                            <input type="number" class="form-control" id="menu_price">
                        </div>
                        <div class="form-group">
                            <label for="product_quantity" class="col-form-label">Produtos Utilizados:</label>
                            <input type="number" class="form-control" id="product_quantity">
                        </div>
                        <!-- CONSOANTE OS PRODUTOS UTILIZADOS APARECE OS INPUTS DELES -->
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-add"> <i class="far fa-plus-square"></i>&nbsp;&nbsp;&nbsp;Adicionar</button>
                    <button type="button" class="btn btn-danger" data-dismiss="modal">Close&nbsp;&nbsp;&nbsp;<i class="fas fa-times"></i></button>
                </div>
            </div>
        </div>
    </div>
    <?php
} else {
    header("Location: https://erp.jbr-projects.pt/");
}


