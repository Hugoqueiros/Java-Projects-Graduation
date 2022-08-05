<?php
require '../application/header.php';
?>
<div id="eventos">
    <h1>Eventos</h1>
    <div>
        <label>Titulo do Evento: </label>
        <input id="add_event_title">
        <span class="helper-error" id="helper-error-add-event-title"></span>
    </div>
    <div>
        <label>Descrição do Evento: </label>
        <input id="add_event_description">
        <span class="helper-error" id="helper-error-add-event-description"></span>
    </div>
    <div>
        <label>Data inicial: </label>
        <input id="add_event_date_ini" type="date">
        <span class="helper-error" id="helper-error-add-event-date-ini"></span>
    </div>
    <div>
        <label>Data de Expiração: </label>
        <input id="add_event_date_exp" type="date">
        <span class="helper-error" id="helper-error-add-event-date-exp"></span>
    </div>
    <br>
    <button type="button" onclick="add_event();"> Adicionar Evento </button>
    <br>
    <br>
    <table style="width:100%"> 
        <tr>
            <th>ID do Evento</th>
            <th>Título</th>
            <th>Data Inicial</th>
            <th>Data de Expiração</th>
        </tr>
        <?php
        include "admin.php";
        $result_events = get_events();
        while ($row = mysqli_fetch_assoc($result_events)) {
            ?>
            <tr>
                <th><?php echo $row['event_id']; ?></th>
                <th><?php echo $row['event_title']; ?></th>
                <th><?php echo $row['event_date_ini']; ?></th>
                <th><?php echo $row['event_date_exp']; ?></th>
            </tr>
            <?php
        }
        ?>
    </table>
</div>
<?php
include '../application/footer.php';
?>

