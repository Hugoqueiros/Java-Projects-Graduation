<?php
include "functions.php";
include "header.php";
session_start();
if ($_SESSION['employee_nmr'] || $_SESSION['admin_id']) {
    ?>
    <!-- Content Row -->
    <div class="row">    
        <div class="btn_div">
            <h3 style="color:#fff;">Utilizadores</h3>&nbsp;&nbsp;
            <button type="button" class="btn-add" data-toggle="modal" data-target="#add_user_modal"> <i class="fas fa-plus"></i></button>
        </div>
    </div>

    <!-- Content Row -->
    <div class="col-sm-12">
        <div class="table-responsive">
            <table class="table table-hover" id="tb-users">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Email</th>
                        <th>Nº Telemóvel</th>
                        <th>Função</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <?php
                    $result_users = get_users();
                    while ($row = mysqli_fetch_assoc($result_users)) {
                        ?>
                        <tr>
                            <th><?php echo utf8_encode($row['user_id']); ?></th>
                            <th><?php echo utf8_encode($row['user_name']); ?></th>
                            <th><?php echo utf8_encode($row['user_email']); ?></th>
                            <th><?php echo utf8_encode($row['user_phone']); ?></th>
                            <?php if ($row['user_admin'] == 1) { ?>
                                <th>Administrador</th>
                            <?php } else { ?>
                                <th>Colaborador</th>
                            <?php } ?>
                            <th><button type="button" class="btn btn-warning" title="Editar Utilizador" onclick="open_modal_user('<?php echo utf8_encode($row['user_id']); ?>', '<?php echo utf8_encode($row['user_name']); ?>', '<?php echo utf8_encode($row['user_email']); ?>', '<?php echo utf8_encode($row['user_phone']); ?>');"><i class="fas fa-user-edit"></i></button>&nbsp;&nbsp;&nbsp;<button type="button" class="btn btn-danger" title="Eliminar Utilizador" onclick="delete_user(<?php echo utf8_encode($row['user_id']); ?>);"><i class="fas fa-user-times"></i></button></th>
                        </tr>
                        <?php
                    }
                    ?>
                </tbody>
                <tfoot></tfoot>
            </table>
        </div>
    </div>

    </div>
    <!-- End of Main Content -->

    <div class="modal fade" id="add_user_modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="add_user">Adicionar Utilizador</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="form-user-add" class="row g-3 needs-validation" novalidate>
                        <div class="col-md-6">
                            <label for="validationName" class="form-label">Nome:</label>
                            <input type="text" class="form-control" name="user_name" required>
                            <span id="help-add-user-name" class="invalid-feedback"></span>
                        </div>
                        <div class="col-md-6">
                            <label for="validationPhone" class="form-label">Nº Telemóvel:</label>
                            <input type="text" class="form-control" name="user_phone" minlength="9" maxlength="9" required onkeypress="return only_numbers(event)">
                            <span id="help-add-user-phone" class="invalid-feedback"></span>
                        </div>
                        <div class="col-md-6">
                            <label for="validationEmail" class="form-label">Email:</label>
                            <input type="email" class="form-control" name="user_email" required>
                            <span id="help-add-user-email" class="invalid-feedback"></span>
                        </div>
                        <div class="col-md-6">
                            <label for="validationPassword" class="form-label">Password:</label>
                            <input type="password" class="form-control" name="user_pw" required>
                            <span id="help-add-user-password" class="invalid-feedback"></span>
                        </div>
                    </form>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-add" onclick="add_user();"><i class="fas fa-plus"></i>&nbsp;&nbsp;&nbsp;Adicionar</button>
                    <button type="button" class="btn btn-danger" data-dismiss="modal"><i class="fas fa-times"></i>&nbsp;&nbsp;&nbsp;Cancelar</button>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="edit_user_modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="edit_user">Editar Utilizador</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="form-user-edit" class="row g-3 needs-validation" novalidate>
                        <input hidden="" id="edit_user_id" value="">
                        <div class="col-md-6">
                            <label for="validationName" class="form-label">Nome:</label>
                            <input type="text" class="form-control" name="edit_user_name" id='edit_user_name' required>
                            <span id="help-edit-user-name" class="invalid-feedback"></span>
                        </div>
                        <div class="col-md-6">
                            <label for="validationPhone" class="form-label">Nº Telemóvel:</label>
                            <input type="text" class="form-control" name="edit_user_phone" id='edit_user_phone' minlength="9" maxlength="9" required onkeypress="return only_numbers(event)">
                            <span id="help-edit-user-phone" class="invalid-feedback"></span>
                        </div>
                        <div class="col-md-12">
                            <label for="validationEmail" class="form-label">Email:</label>
                            <input type="email" class="form-control" name="edit_user_email" id='edit_user_email' required>
                            <span id="help-edit-user-email" class="invalid-feedback"></span>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-add" onclick="edit_user();"> <i class="fas fa-plus-square"></i>&nbsp;&nbsp;&nbsp;Guardar</button>
                    <button type="button" class="btn btn-danger" data-dismiss="modal"><i class="fas fa-times"></i>&nbsp;&nbsp;&nbsp;Cancelar</button>
                </div>
            </div>
        </div>
    </div>
    <?php
} else {
    header("Location: https://erp.jbr-projects.pt/");
}

include "footer.php";
