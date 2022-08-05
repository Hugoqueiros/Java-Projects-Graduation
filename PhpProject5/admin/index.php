<?php

session_start();

if ($_SESSION['admin_name']) {
    require '../application/login.php';
} else {
    require '../application/dashboard.php';
}