<?php
session_start();
if ($_SESSION['employee_nmr'] || $_SESSION['admin_id']) {
    ?>
    <!-- Topbar -->
    <nav class="navbar navbar-expand navbar-light bg-secondary topbar mb-4 static-top shadow">

        <!-- Sidebar Toggle (Topbar) -->
        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
            <i class="fa fa-bars"></i>
        </button>

        <!-- Topbar Navbar -->
        <ul class="navbar-nav ml-auto">


            <!-- Nav Item - User Information -->
            <li class="nav-item dropdown no-arrow">
                <a class="nav-link dropdown-toggle" id="userDropdown" role="button">
                    <?php if ($_SESSION['employee_nmr']) {
                        ?>
                        <span class="mr-2 d-none d-lg-inline text-gray-600 small"><?php echo utf8_encode($_SESSION['employee_name']); ?></span>
                    <?php } else {
                        ?>
                        <span class="mr-2 d-none d-lg-inline text-gray-600 small"><?php echo utf8_encode($_SESSION['admin_name']); ?></span>
                    <?php } ?>
                    <img class="img-profile rounded-circle"
                         src="/assets/img/undraw_profile.svg">
                </a>
            </li>
        </ul>

    </nav>
    <!-- End of Topbar -->
    <?php
} else {
    header("Location: https://erp.jbr-projects.pt/");
}
?>
