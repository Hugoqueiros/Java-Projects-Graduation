<?php
session_start();
if ($_SESSION['employee_nmr'] || $_SESSION['admin_id']) {
    ?>
    <!-- Sidebar -->
    <ul class="navbar-nav shadow sidebar sidebar-dark accordion bg-secondary" id="accordionSidebar">
        <!-- Sidebar - Brand -->
        <a class="sidebar-brand d-flex align-items-center justify-content-center bg-third">
            <img id="logo" src="/assets/img/logo.png" width="150">
        </a>
        <br>
        <!-- Nav Item - Dashboard -->
        <li class="nav-item">
            <button class="btn nav-link" onclick="call_page_dashboard();">
                <i class="fas fa-fw fa-tachometer-alt"></i>
                <span>Dashboard</span></button>
        </li>
        <?php if ($_SESSION['employee_nmr']) { ?>
            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                Serviços
            </div>
            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <button class="btn nav-link" onclick="call_page_requests();">
                    <i class="fas fa-utensils"></i>
                    <span>Pedidos</span></button>
            </li>
            <!-- Divider -->
            <hr class="sidebar-divider ">

            <!-- Heading -->
            <div class="sidebar-heading">
                Logout
            </div>

            <!-- Nav Item - Tables -->
            <li class="nav-item">
                <a class="nav-link" href="https://erp.jbr-projects.pt/application/functions.php?function=logout">
                    <i class="fas fas fa-sign-out-alt"></i>
                    <span>Sair da Aplicação</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>
        <?php } else { ?>
            <!-- Divider -->
            <hr class="sidebar-divider">



            <!-- Heading -->
            <div class="sidebar-heading">
                Serviços
            </div>

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <button class="btn nav-link" onclick="call_page_user();">
                    <i class="fas fa-users"></i>
                    <span>Utilizadores</span></button>
            </li>

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <button class="btn nav-link" onclick="call_page_requests();">
                    <i class="fas fa-utensils"></i>
                    <span>Pedidos</span></button>
            </li>


            <!-- Nav Item - Charts -->
            <li class="nav-item">
                <button class="btn nav-link" onclick="call_page_products();">
                    <i class="fas fa-hamburger"></i>
                    <span>Produtos</span></button>
            </li>

            <!-- Nav Item - Tables -->
            <li class="nav-item">
                <button class="btn nav-link" onclick="call_page_menus();">
                    <i class="fas fa-scroll"></i>
                    <span>Menus</span></button>
            </li>

            <!-- Nav Item - Tables -->
            <li class="nav-item">
                <button class="btn nav-link" onclick="call_page_providers();">
                    <i class="fas fa-shipping-fast"></i>
                    <span>Fornecedores</span></button>
            </li>

            <li class="nav-item">
                <button class="btn nav-link" onclick="call_page_orders();">
                    <i class="fas fa-cubes"></i>
                    <span>Encomendas</span></button>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider ">

            <!-- Heading -->
            <div class="sidebar-heading">
                Logout
            </div>

            <!-- Nav Item - Tables -->
            <li class="nav-item">
                <a class="nav-link" href="https://erp.jbr-projects.pt/application/functions.php?function=logout">
                    <i class="fas fas fa-sign-out-alt"></i>
                    <span>Sair da Aplicação</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>
        <?php } ?>




    </ul>
    <!-- End of Sidebar -->
    <?php
} else {
    header("Location: https://erp.jbr-projects.pt/");
}
?>

