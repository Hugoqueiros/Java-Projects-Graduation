<?php
session_start();
require '../application/header.php';
if ($_SESSION['employee_nmr'] || $_SESSION['admin_id']) {
    ?>
    <body id = "page-top">

        <!--Page Wrapper -->
        <div id = "wrapper">

            <?php require '../application/side_bar.php'
            ?>

            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content" class="bg-dark">

                    <?php require '../application/nav_bar.php' ?>

                    <!-- Begin Page Content -->
                    <div class="container-fluid bg-dark" id="mid">

                    </div>
                    <!-- End of Main Content -->

                    <!-- Footer -->
                    <footer class="sticky-footer bg-dark">
                        <div class="container my-auto">
                            <div class="copyright text-center my-auto">
                                <span>Copyright &copy; ERP 2021</span>
                            </div>
                        </div>
                    </footer>
                    <!-- End of Footer -->

                </div>
                <!-- End of Content Wrapper -->

            </div>
            <!-- End of Page Wrapper -->

            <!-- Scroll to Top Button-->
            <a class="scroll-to-top rounded" href="#page-top">
                <i class="fas fa-angle-up"></i>
            </a>
            <?php
            require '../application/footer.php';
        } else {
            header("Location: https://erp.jbr-projects.pt/");
        }