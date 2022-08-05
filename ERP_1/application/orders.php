<?php
include "functions.php";
include 'header.php';
session_start();
if ($_SESSION['employee_nmr'] || $_SESSION['admin_id']) {
    ?>


    <!-- Content Row -->
    <div class="row">    
        <div class="btn_div">
            <h3 style="color:#fff;">Encomendas</h3>&nbsp;&nbsp;
            <button type="button" class="btn-add" data-toggle="modal" data-target="#add_order_modal"> <i class="fas fa-plus"></i></button>
        </div>
    </div>
    <div class="col-sm-12">
        <div class="table-responsive">
            <table class="table table-hover" id="tb-users">
                <thead>
                    <tr>
                        <th style="text-align: center;">ID</th>
                        <th style="text-align: center;">Nome</th>
                        <th style="text-align: center;">Email</th>
                        <th style="text-align: center;">Nº Telemóvel</th>
                        <th style="text-align: center;">Função</th>
                        <th style="text-align: center;">Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <?php
                    $result_users = get_users();
                    while ($row = mysqli_fetch_assoc($result_users)) {
                        ?>
                        <tr>
                            <th style="text-align: center;"><?php echo utf8_encode($row['user_id']); ?></th>
                            <th style="text-align: center;"><?php echo utf8_encode($row['user_name']); ?></th>
                            <th style="text-align: center;"><?php echo utf8_encode($row['user_email']); ?></th>
                            <th style="text-align: center;"><?php echo utf8_encode($row['user_phone']); ?></th>
                            <?php if ($row['user_admin'] == 1) { ?>
                                <th style="text-align: center;">Administrador</th>
                            <?php } else { ?>
                                <th style="text-align: center;">Colaborador</th>
                            <?php } ?>
                            <th style="text-align: center;"><button type="button" class="btn btn-warning" title="Editar Utilizador" onclick="open_modal_user('<?php echo utf8_encode($row['user_id']); ?>', '<?php echo utf8_encode($row['user_name']); ?>', '<?php echo utf8_encode($row['user_email']); ?>', '<?php echo utf8_encode($row['user_phone']); ?>');"><i class="fas fa-user-edit"></i></button>&nbsp;&nbsp;&nbsp;<button type="button" class="btn btn-danger" title="Eliminar Utilizador" onclick="delete_user(<?php echo utf8_encode($row['user_id']); ?>);"><i class="fas fa-user-times"></i></button></th>
                        </tr>
                        <?php
                    }
                    ?>
                </tbody>
                <tfoot></tfoot>
            </table>
        </div>
    </div>
    <!-- Content Row -->
    <div class="col-sm-12">
        <div class="table-responsive">
            <table id="tb-orders" class="table table-hover">
                <thead>
                    <tr>
                        <th style="text-align: center;">ID</th>
                        <th style="text-align: center;">Valor</th>
                        <th style="text-align: center;">Status</th>
                        <th style="text-align: center;">Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <?php
                    $result_orders = get_orders();
                    while ($row = mysqli_fetch_assoc($result_orders)) {
                        ?>
                        <tr>
                            <th style="text-align: center;"><?php echo utf8_encode($row['request_id']); ?></th>
                            <th style="text-align: center;"><?php echo utf8_encode($row['request_total']); ?></th>
                            <th style="text-align: center;"><?php echo utf8_encode($row['request_status']); ?></th>
                            <th style="text-align: center;"><button type="button" class="btn btn-warning" title="Editar Encomenda" onclick="open_modal_order();"><i class="fas fa-pencil-alt"></i></button>&nbsp;&nbsp;&nbsp;<button type="button" class="btn btn-danger" title="Eliminar Encomenda" onclick="delete_order(<?php echo utf8_encode($row['request_id']); ?>);"><i class="fas fa-times-circle"></i></button></th>
                        </tr>
                        <?php
                    }
                    ?>
                </tbody>
                <tfoot></tfoot>
            </table>  
        </div>
    </div>

    <div class="modal fade" id="add_order_modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="add_request">Adicionar Encomenda</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form>
                        <div class="form-group">
                            <label for="provider_id" class="col-form-label">Fornecedor:</label>
                            <select name="type" id="provider_name">
                                <?php
                                $result_providers = get_providers();
                                while ($row = mysqli_fetch_assoc($result_providers)) {
                                    ?>
                                    <option value="prov"><?php echo utf8_encode($row['provider_name']); ?></option>
                                <?php } ?>
                            </select>
                        </div> 
                        <div class="form-group">
                            <label for="order_product_quantity" class="col-form-label">Produtos a Encomendar:</label>
                            <input type="number" class="form-control" id="product_quantity">
                        </div>
                        <div class="form-group">
                            <label for="product_id" class="col-form-label">Produto:</label>
                            <select name="type" id="product_name">
                                <?php
                                $result_products = get_products();
                                while ($row = mysqli_fetch_assoc($result_products)) {
                                    ?>
                                    <option value="prov"><?php echo utf8_encode($row['product_name']); ?></option>
                                <?php } ?>
                            </select>
                        </div> 
                        <div class="form-group">
                            <label for="product_quantity" class="col-form-label">Quantidade:</label>
                            <input type="number" class="form-control" id="product_quantity">
                        </div>
                        <div class="form-group">
                            <button type="button" class="btn btn-add"> <i class="far fa-plus-square"></i>&nbsp;&nbsp;&nbsp;Adicionar Produto</button>
                        </div>

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
