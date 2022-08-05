<?php
include "functions.php";
include 'header.php';
session_start();
if ($_SESSION['employee_nmr'] || $_SESSION['admin_id']) {
    ?>


    <!-- Content Row -->
    <div class="row">    
        <div class="btn_div">
            <h3 style="color:#fff;">Fornecedores</h3>&nbsp;&nbsp;
            <button type="button" class="btn-add" data-toggle="modal" data-target="#add_provider_modal"> <i class="fas fa-plus"></i></button>
        </div>
    </div>

    <!-- Content Row -->
    <div class="col-sm-8">
        <div class="table-responsive">
            <table id="tb-providers" class="table table-hover">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Email</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <?php
                    $result_providers = get_providers();
                    while ($row = mysqli_fetch_assoc($result_providers)) {
                        ?>
                        <tr>
                            <th><?php echo utf8_encode($row['provider_id']); ?></th>
                            <th><?php echo utf8_encode($row['provider_name']); ?></th>
                            <th><?php echo utf8_encode($row['provider_email']); ?></th>
                            <th><button type="button" title="Editar Fornecedor" onclick="open_modal_provider('<?php echo utf8_encode($row['provider_id']); ?>', '<?php echo utf8_encode($row['provider_name']); ?>', '<?php echo utf8_encode($row['provider_email']);?>');"><i class="fas fa-plus"></i></button></th>
                    </tr>
                    <th></th>
                    </tr>
                    <?php
                }
                ?>
                </tbody>
                <tfoot></tfoot>
            </table>  
        </div>
    </div>
    <div class="col-md-2">

    </div>


    <div class="modal fade" id="add_provider_modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="add_provider">Adicionar Fornecedor</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form>
                        <div class="form-group">
                            <label>Nome:</label>
                            <input type="text" class="form-control" name="provider_name">
                        </div>
                        <div class="form-group">
                            <label>Email:</label>
                            <input type="email" class="form-control" name="provider_email">
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-add" onclick="add_provider();"> <i class="far fa-plus-square"></i>&nbsp;&nbsp;&nbsp;Adicionar</button>
                    <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar&nbsp;&nbsp;&nbsp;<i class="fas fa-times"></i></button>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="edit_provider_modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="edit_provider">Editar Fornecedor</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form>
                        <input hidden="" id="edit_provider_id" value="">
                        <div class="form-group">
                            <label>Nome:</label>
                            <input type="text" class="form-control" name="edit_provider_name" id='edit_provider_name' value="">
                        </div>
                        <div class="form-group">
                            <label>Email:</label>
                            <input type="email" class="form-control" name="edit_provider_email" id='edit_provider_email' value="">
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-add" onclick="edit_provider();"> <i class="far fa-plus-square"></i>&nbsp;&nbsp;&nbsp;Guardar</button>
                    <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar&nbsp;&nbsp;&nbsp;<i class="fas fa-times"></i></button>
                </div>
            </div>
        </div>
    </div>
    <?php
} else {
    header("Location: https://erp.jbr-projects.pt/");
}

include 'footer.php';

