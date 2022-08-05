<?php
session_start();
include "functions.php";
if ($_SESSION['employee_nmr'] || $_SESSION['admin_id']) {
    ?>


    <!-- Content Row -->
    <div class="row">

        <div class="btn_div"> <button type="button" class="btn btn-add"><i class="far fa-plus-square"></i>&nbsp;&nbsp;&nbsp;Adicionar Pedido</button>
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
    <?php
} else {
    header("Location: https://erp.jbr-projects.pt/");
}
