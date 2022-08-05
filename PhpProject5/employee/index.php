<?php

session_start();

if (!$_SESSION['employee_name']) {
    require '../application/login.php';
} else {
    require '../application/dashboard.php';
}
    
