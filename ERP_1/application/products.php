<?php
include "functions.php";
include "header.php";
session_start();
if ($_SESSION['employee_nmr'] || $_SESSION['admin_id']) {
    ?>


    <!-- Content Row -->
    <div class="row">    
        <div class="btn_div">
            <h3 style="color:#fff;">Produtos</h3>&nbsp;&nbsp;
            <button type="button" class="btn-add" data-toggle="modal" data-target="#add_product_modal"> <i class="fas fa-plus"></i></button>
        </div>
    </div>

    <!-- Content Row -->
    <div class="col-sm-8">
        <div class="table-responsive">
            <table class="table table-hover" id="tb-products">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Stock</th>
                    </tr>
                </thead>
                <tbody>
                    <?php
                    $result_products = get_products();
                    while ($row = mysqli_fetch_assoc($result_products)) {
                        ?>
                        <tr>
                            <th><?php echo utf8_encode($row['product_name']); ?></th>
                            <th><?php echo utf8_encode($row['product_stock']); ?></th>
                                <th><button type="button" class="btn btn-warning" title="Editar Produto" onclick="open_modal_product('<?php echo utf8_encode($row['product_id']); ?>', '<?php echo utf8_encode($row['product_name']); ?>');"><i class="fas fa-pencil-alt"></i></button>&nbsp;&nbsp;&nbsp;<button type="button" class="btn btn-danger" title="Eliminar Produto" onclick="delete_product(<?php echo utf8_encode($row['product_id']); ?>);"><i class="fas fa-times-circle"></i></button></th>
                        </tr>
                        <?php
                    }
                    ?>
                </tbody>
                <tfoot></tfoot>
            </table>
        </div>
    </div>


    <div class="modal fade" id="add_product_modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="add_product">Adicionar Produto</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form>
                        <div class="form-group">
                            <label>Nome:</label>
                            <input type="text" class="form-control" name="product_name">
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-add" onclick="add_product();"> <i class="far fa-plus-square"></i>&nbsp;&nbsp;&nbsp;Adicionar</button>
                    <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar&nbsp;&nbsp;&nbsp;<i class="fas fa-times"></i></button>
                </div>
            </div>
        </div>
    </div>
    
    <div class="modal fade" id="edit_product_modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="edit_product">Editar Produto</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form>
                        <div class="form-group">
                            <label>Nome:</label>
                            <input type="text" class="form-control" name="edit_product_name">
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-add" onclick="edit_product();"> <i class="far fa-plus-square"></i>&nbsp;&nbsp;&nbsp;Guardar</button>
                    <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar&nbsp;&nbsp;&nbsp;<i class="fas fa-times"></i></button>
                </div>
            </div>
        </div>
    </div>

    <?php
} else {
    header("Location: https://erp.jbr-projects.pt/");
}

include "footer.php";

