
var url = "https://erp.jbr-projects.pt/";
(function ($) {
    "use strict"; // Start of use strict

    // Toggle the side navigation
    $("#sidebarToggle, #sidebarToggleTop").on('click', function (e) {
        $("body").toggleClass("sidebar-toggled");
        $(".sidebar").toggleClass("toggled");
        if ($(".sidebar").hasClass("toggled")) {
            $('.sidebar .collapse').collapse('hide');
            $("#logo").width(95);
        } else {
            if ($(window).width() < 768) {
                $('.sidebar .collapse').collapse('hide');
                $("#logo").width(95);
            } else {
                $("#logo").width(150);
            }
        }
        ;
    });

    if ($(window).width() < 768) {
        $('.sidebar .collapse').collapse('hide');
        $("#logo").width(95);
    } else {
        $("#logo").width(150);
    }
    ;

    // Close any open menu accordions when window is resized below 768px
    $(window).resize(function () {

        if ($(window).width() < 768) {
            $('.sidebar .collapse').collapse('hide');
            $("#logo").width(95);
        } else {
            $("#logo").width(150);
        }
        ;

        // Toggle the side navigation when window is resized below 480px
        if ($(window).width() < 480 && !$(".sidebar").hasClass("toggled")) {
            $("body").addClass("sidebar-toggled");
            $(".sidebar").addClass("toggled");
            $('.sidebar .collapse').collapse('hide');

        }
        ;
    });

    // Prevent the content wrapper from scrolling when the fixed side navigation hovered over
    $('body.fixed-nav .sidebar').on('mousewheel DOMMouseScroll wheel', function (e) {
        if ($(window).width() > 768) {
            var e0 = e.originalEvent,
                    delta = e0.wheelDelta || -e0.detail;
            this.scrollTop += (delta < 0 ? 1 : -1) * 30;
            e.preventDefault();
        }
    });

    // Scroll to top button appear
    $(document).on('scroll', function () {
        var scrollDistance = $(this).scrollTop();
        if (scrollDistance > 100) {
            $('.scroll-to-top').fadeIn();
        } else {
            $('.scroll-to-top').fadeOut();
        }
    });

    // Smooth scrolling using jQuery easing
    $(document).on('click', 'a.scroll-to-top', function (e) {
        var $anchor = $(this);
        $('html, body').stop().animate({
            scrollTop: ($($anchor.attr('href')).offset().top)
        }, 1000, 'easeInOutExpo');
        e.preventDefault();
    });

})(jQuery); // End of use strict

employee_login = function () {
    var submit = true;
    var employee_id = $('#employee_id').val();
    var employee_pw = $('#employee_pw').val();
    if (employee_id == "") {
        $('#helper-error-employee-id').text('*O número de identificação é obrigatório!');
        submit = false;
    } else {
        $('#helper-error-employee-id').text('');
    }

    if (employee_pw == "") {
        $('#helper-error-employee-pw').text('*A password é obrigatória!');
        submit = false;
    } else {
        $('#helper-error-employee-pw').text('');
    }

    if (submit == true) {
        $.ajax({
            url: url + 'application/functions.php?function=loginColaborador',
            type: "POST",
            data: {employee_id: employee_id, employee_pw: employee_pw},
            success: function () {
                window.location.href = url + "employee/";
            }
        });
    }
};

admin_login = function () {
    var submit = true;
    var admin_email = $('#admin_email').val();
    var admin_pw = $('#admin_pw').val();
    if (admin_email == "") {
        $('#helper-error-admin-email').text('*O email é obrigatório!');
        submit = false;
    } else {
        $('#helper-error-admin-email').text('');
    }

    if (admin_pw == "") {
        $('#helper-error-admin-pw').text('*A password é obrigatória!');
        submit = false;
    } else {
        $('#helper-error-admin-pw').text('');
    }

    if (submit == true) {
        $.ajax({
            url: url + 'application/functions.php?function=loginAdministrador',
            type: "POST",
            data: {admin_email: admin_email, admin_pw: admin_pw},
            success: function () {
                window.location.href = url + "admin/";
            }
        });
    }
};

call_page_dashboard = function () {
    $('#mid').fadeOut('fast').load('https://erp.jbr-projects.pt/application/dashboard.php', function () {
        // Area Chart Example
        var ctx = document.getElementById("myAreaChart");
        var myLineChart = new Chart(ctx, {
            type: 'line',
            data: {
                labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
                datasets: [{
                        label: "Earnings",
                        lineTension: 0.3,
                        backgroundColor: "rgba(78, 115, 223, 0.05)",
                        borderColor: "rgba(78, 115, 223, 1)",
                        pointRadius: 3,
                        pointBackgroundColor: "rgba(78, 115, 223, 1)",
                        pointBorderColor: "rgba(78, 115, 223, 1)",
                        pointHoverRadius: 3,
                        pointHoverBackgroundColor: "rgba(78, 115, 223, 1)",
                        pointHoverBorderColor: "rgba(78, 115, 223, 1)",
                        pointHitRadius: 10,
                        pointBorderWidth: 2,
                        data: [0, 10000, 5000, 15000, 10000, 20000, 15000, 25000, 20000, 30000, 25000, 40000],
                    }],
            },
            options: {
                maintainAspectRatio: false,
                layout: {
                    padding: {
                        left: 10,
                        right: 25,
                        top: 25,
                        bottom: 0
                    }
                },
                scales: {
                    xAxes: [{
                            time: {
                                unit: 'date'
                            },
                            gridLines: {
                                display: false,
                                drawBorder: false
                            },
                            ticks: {
                                maxTicksLimit: 7
                            }
                        }],
                    yAxes: [{
                            ticks: {
                                maxTicksLimit: 5,
                                padding: 10,
                                // Include a dollar sign in the ticks
                                callback: function (value, index, values) {
                                    return '$' + number_format(value);
                                }
                            },
                            gridLines: {
                                color: "rgb(234, 236, 244)",
                                zeroLineColor: "rgb(234, 236, 244)",
                                drawBorder: false,
                                borderDash: [2],
                                zeroLineBorderDash: [2]
                            }
                        }],
                },
                legend: {
                    display: false
                },
                tooltips: {
                    backgroundColor: "rgb(255,255,255)",
                    bodyFontColor: "#858796",
                    titleMarginBottom: 10,
                    titleFontColor: '#6e707e',
                    titleFontSize: 14,
                    borderColor: '#dddfeb',
                    borderWidth: 1,
                    xPadding: 15,
                    yPadding: 15,
                    displayColors: false,
                    intersect: false,
                    mode: 'index',
                    caretPadding: 10,
                    callbacks: {
                        label: function (tooltipItem, chart) {
                            var datasetLabel = chart.datasets[tooltipItem.datasetIndex].label || '';
                            return datasetLabel + ': $' + number_format(tooltipItem.yLabel);
                        }
                    }
                }
            }
        });
        // Pie Chart Example
        var ctx = document.getElementById("myPieChart");
        var myPieChart = new Chart(ctx, {
            type: 'doughnut',
            data: {
                labels: ["Direct", "Referral", "Social"],
                datasets: [{
                        data: [55, 30, 15],
                        backgroundColor: ['#4e73df', '#1cc88a', '#36b9cc'],
                        hoverBackgroundColor: ['#2e59d9', '#17a673', '#2c9faf'],
                        hoverBorderColor: "rgba(234, 236, 244, 1)",
                    }],
            },
            options: {
                maintainAspectRatio: false,
                tooltips: {
                    backgroundColor: "rgb(255,255,255)",
                    bodyFontColor: "#858796",
                    borderColor: '#dddfeb',
                    borderWidth: 1,
                    xPadding: 15,
                    yPadding: 15,
                    displayColors: false,
                    caretPadding: 10,
                },
                legend: {
                    display: false
                },
                cutoutPercentage: 80,
            },
        });
    }).fadeIn("slow");
};

call_page_user = function () {
    $('#mid').load('https://erp.jbr-projects.pt/application/users.php');
};

call_page_requests = function () {
    $('#mid').fadeOut('fast').load('https://erp.jbr-projects.pt/application/requests.php', function () {
        // Area Chart Example
        var ctx = document.getElementById("myAreaChart");
        var myLineChart = new Chart(ctx, {
            type: 'line',
            data: {
                labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
                datasets: [{
                        label: "Earnings",
                        lineTension: 0.3,
                        backgroundColor: "rgba(78, 115, 223, 0.05)",
                        borderColor: "rgba(78, 115, 223, 1)",
                        pointRadius: 3,
                        pointBackgroundColor: "rgba(78, 115, 223, 1)",
                        pointBorderColor: "rgba(78, 115, 223, 1)",
                        pointHoverRadius: 3,
                        pointHoverBackgroundColor: "rgba(78, 115, 223, 1)",
                        pointHoverBorderColor: "rgba(78, 115, 223, 1)",
                        pointHitRadius: 10,
                        pointBorderWidth: 2,
                        data: [0, 10000, 5000, 15000, 10000, 20000, 15000, 25000, 20000, 30000, 25000, 40000],
                    }],
            },
            options: {
                maintainAspectRatio: false,
                layout: {
                    padding: {
                        left: 10,
                        right: 25,
                        top: 25,
                        bottom: 0
                    }
                },
                scales: {
                    xAxes: [{
                            time: {
                                unit: 'date'
                            },
                            gridLines: {
                                display: false,
                                drawBorder: false
                            },
                            ticks: {
                                maxTicksLimit: 7
                            }
                        }],
                    yAxes: [{
                            ticks: {
                                maxTicksLimit: 5,
                                padding: 10,
                                // Include a dollar sign in the ticks
                                callback: function (value, index, values) {
                                    return '$' + number_format(value);
                                }
                            },
                            gridLines: {
                                color: "rgb(234, 236, 244)",
                                zeroLineColor: "rgb(234, 236, 244)",
                                drawBorder: false,
                                borderDash: [2],
                                zeroLineBorderDash: [2]
                            }
                        }],
                },
                legend: {
                    display: false
                },
                tooltips: {
                    backgroundColor: "rgb(255,255,255)",
                    bodyFontColor: "#858796",
                    titleMarginBottom: 10,
                    titleFontColor: '#6e707e',
                    titleFontSize: 14,
                    borderColor: '#dddfeb',
                    borderWidth: 1,
                    xPadding: 15,
                    yPadding: 15,
                    displayColors: false,
                    intersect: false,
                    mode: 'index',
                    caretPadding: 10,
                    callbacks: {
                        label: function (tooltipItem, chart) {
                            var datasetLabel = chart.datasets[tooltipItem.datasetIndex].label || '';
                            return datasetLabel + ': $' + number_format(tooltipItem.yLabel);
                        }
                    }
                }
            }
        });
        // Pie Chart Example
        var ctx = document.getElementById("myPieChart");
        var myPieChart = new Chart(ctx, {
            type: 'doughnut',
            data: {
                labels: ["Direct", "Referral", "Social"],
                datasets: [{
                        data: [55, 30, 15],
                        backgroundColor: ['#4e73df', '#1cc88a', '#36b9cc'],
                        hoverBackgroundColor: ['#2e59d9', '#17a673', '#2c9faf'],
                        hoverBorderColor: "rgba(234, 236, 244, 1)",
                    }],
            },
            options: {
                maintainAspectRatio: false,
                tooltips: {
                    backgroundColor: "rgb(255,255,255)",
                    bodyFontColor: "#858796",
                    borderColor: '#dddfeb',
                    borderWidth: 1,
                    xPadding: 15,
                    yPadding: 15,
                    displayColors: false,
                    caretPadding: 10,
                },
                legend: {
                    display: false
                },
                cutoutPercentage: 80,
            },
        });
    }).fadeIn("slow");
};

call_page_products = function () {
    $('#mid').load('https://erp.jbr-projects.pt/application/products.php');
};

call_page_menus = function () {
    $('#mid').fadeOut('fast').load('https://erp.jbr-projects.pt/application/menus.php', function () {
        // Area Chart Example
        var ctx = document.getElementById("myAreaChart");
        var myLineChart = new Chart(ctx, {
            type: 'line',
            data: {
                labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
                datasets: [{
                        label: "Earnings",
                        lineTension: 0.3,
                        backgroundColor: "rgba(78, 115, 223, 0.05)",
                        borderColor: "rgba(78, 115, 223, 1)",
                        pointRadius: 3,
                        pointBackgroundColor: "rgba(78, 115, 223, 1)",
                        pointBorderColor: "rgba(78, 115, 223, 1)",
                        pointHoverRadius: 3,
                        pointHoverBackgroundColor: "rgba(78, 115, 223, 1)",
                        pointHoverBorderColor: "rgba(78, 115, 223, 1)",
                        pointHitRadius: 10,
                        pointBorderWidth: 2,
                        data: [0, 10000, 5000, 15000, 10000, 20000, 15000, 25000, 20000, 30000, 25000, 40000],
                    }],
            },
            options: {
                maintainAspectRatio: false,
                layout: {
                    padding: {
                        left: 10,
                        right: 25,
                        top: 25,
                        bottom: 0
                    }
                },
                scales: {
                    xAxes: [{
                            time: {
                                unit: 'date'
                            },
                            gridLines: {
                                display: false,
                                drawBorder: false
                            },
                            ticks: {
                                maxTicksLimit: 7
                            }
                        }],
                    yAxes: [{
                            ticks: {
                                maxTicksLimit: 5,
                                padding: 10,
                                // Include a dollar sign in the ticks
                                callback: function (value, index, values) {
                                    return '$' + number_format(value);
                                }
                            },
                            gridLines: {
                                color: "rgb(234, 236, 244)",
                                zeroLineColor: "rgb(234, 236, 244)",
                                drawBorder: false,
                                borderDash: [2],
                                zeroLineBorderDash: [2]
                            }
                        }],
                },
                legend: {
                    display: false
                },
                tooltips: {
                    backgroundColor: "rgb(255,255,255)",
                    bodyFontColor: "#858796",
                    titleMarginBottom: 10,
                    titleFontColor: '#6e707e',
                    titleFontSize: 14,
                    borderColor: '#dddfeb',
                    borderWidth: 1,
                    xPadding: 15,
                    yPadding: 15,
                    displayColors: false,
                    intersect: false,
                    mode: 'index',
                    caretPadding: 10,
                    callbacks: {
                        label: function (tooltipItem, chart) {
                            var datasetLabel = chart.datasets[tooltipItem.datasetIndex].label || '';
                            return datasetLabel + ': $' + number_format(tooltipItem.yLabel);
                        }
                    }
                }
            }
        });
        // Pie Chart Example
        var ctx = document.getElementById("myPieChart");
        var myPieChart = new Chart(ctx, {
            type: 'doughnut',
            data: {
                labels: ["Direct", "Referral", "Social"],
                datasets: [{
                        data: [55, 30, 15],
                        backgroundColor: ['#4e73df', '#1cc88a', '#36b9cc'],
                        hoverBackgroundColor: ['#2e59d9', '#17a673', '#2c9faf'],
                        hoverBorderColor: "rgba(234, 236, 244, 1)",
                    }],
            },
            options: {
                maintainAspectRatio: false,
                tooltips: {
                    backgroundColor: "rgb(255,255,255)",
                    bodyFontColor: "#858796",
                    borderColor: '#dddfeb',
                    borderWidth: 1,
                    xPadding: 15,
                    yPadding: 15,
                    displayColors: false,
                    caretPadding: 10,
                },
                legend: {
                    display: false
                },
                cutoutPercentage: 80,
            },
        });
    }).fadeIn("slow");
};

call_page_providers = function () {
    $('#mid').load('https://erp.jbr-projects.pt/application/providers.php')
};

call_page_orders = function () {
    $('#mid').load('https://erp.jbr-projects.pt/application/orders.php')
};

//APENAS NÚMEROS NO INPUT DO NIF E NUMERO DO ALUNO
function only_numbers(evt) {
    var charCode = (evt.which) ? evt.which : event.keyCode
    if (charCode > 31 && (charCode < 48 || charCode > 57))
        return false;
    return true;
}

//UTILIZADORES
//FUNÇÃO PARA INSERIR UTILZADOR
add_user = function () {
    var add_user_name = $("input[name='user_name']").val();
    var add_user_email = $("input[name='user_email']").val();
    var add_user_pw = $("input[name='user_pw']").val();
    var add_user_phone = $("input[name='user_phone']").val();
    $("#form-user-add").addClass("was-validated");
    var submit = true;
    if (add_user_name == '') {
        $('#help-add-user-name').text('Insira o nome.')
        submit = false;
    }

    if (add_user_phone == '') {
        $('#help-add-user-phone').text('Insira o Nº Telémovel.')
        submit = false;
    }

    if (add_user_email == '') {
        $('#help-add-user-email').text('Insira o email.')
        submit = false;
    }

    if (add_user_pw == '') {
        $('#help-add-user-password').text('Insira a password.')
        submit = false;
    }

    if (submit == true) {
        $.ajax({
            url: url + 'application/functions.php?function=add_user',
            type: "POST",
            data: {add_user_name: add_user_name, add_user_email: add_user_email, add_user_pw: add_user_pw, add_user_phone: add_user_phone}
        }).done(function (added) {
            if (added != true) {
                alert("Ocorreu um erro, o utilizador não foi adicionado");
                $(".modal-backdrop").remove();
                $("#add_user_modal").hide();
                call_page_user();
            } else {
                alert("Utilizador adicionado com sucesso");
                $(".modal-backdrop").remove();
                $("#add_user_modal").hide();
                call_page_user();
            }
        });
    }
}

//FUNÇÃO PARA EDITAR UTILIZADOR
open_modal_user = function (user_id, user_name, user_email, user_phone) {
    $('#edit_user_name').val(user_name);
    $('#edit_user_email').val(user_email);
    $('#edit_user_phone').val(user_phone);
    $('#edit_user_id').val(user_id);
    $('#edit_user_modal').modal('show');
}

edit_user = function () {
    var edit_user_name = $('#edit_user_name').val();
    var edit_user_email = $('#edit_user_email').val();
    var edit_user_phone = $('#edit_user_phone').val();
    var edit_user_id = $('#edit_user_id').val();
    $("#form-user-edit").addClass("was-validated");
    var submit = true;

    if (edit_user_name == '') {
        $('#help-edit-user-name').text('Insira o nome.')
        submit = false;
    }

    if (edit_user_phone == '') {
        $('#help-edit-user-phone').text('Insira o Nº Telémovel.')
        submit = false;
    }

    if (edit_user_email == '') {
        $('#help-edit-user-email').text('Insira o email.')
        submit = false;
    }

    if (submit == true) {
        $.ajax({
            url: url + 'application/functions.php?function=edit_user',
            type: "POST",
            data: {edit_user_name: edit_user_name, edit_user_email: edit_user_email, edit_user_phone: edit_user_phone, edit_user_id: edit_user_id}
        }).done(function (user_edited) {
            if (user_edited != true) {
                alert("Ocorreu um erro, o utilizador não foi editado");
                $(".modal-backdrop").remove();
                $("#edit_user_modal").hide();
                call_page_user();
            } else {
                alert("Utilizador editado com sucesso");
                $(".modal-backdrop").remove();
                $("#edit_user_modal").hide();
                call_page_user();
            }
        });
    }
}

//FUNÇÃO PARA ELIMINAR UTILIZADOR
delete_user = function (user_id) {
    $.ajax({
        url: url + 'application/functions.php?function=delete_user',
        type: "POST",
        data: {user_id: user_id}
    }).done(function (added) {
        if (added != true) {
            alert("Ocorreu um erro, o utilizador não foi eliminado");
            call_page_user();
        } else {
            alert("Utilizador eliminado com sucesso");
            call_page_user();
        }
    });
};
//PRODUTOS
//FUNÇÃO PARA INSERIR PRODUTO
add_product = function () {
    var add_product_name = $("input[name='product_name']").val();
    $("#form-product-add").addClass("was-validated");
    var submit = true;

    if (add_product_name == '') {
        $('#help-add-product-name').text('Insira o nome.')
        submit = false;
    }

    if (submit == true) {
        $.ajax({
            url: url + 'application/functions.php?function=add_product',
            type: "POST",
            data: {add_product_name: add_product_name}
        }).done(function (added) {
            if (added != true) {
                alert("Ocorreu um erro, o produto não foi adicionado");
                $(".modal-backdrop").remove();
                $("#add_product_modal").hide();
                call_page_products();
            } else {
                alert("Produto adicionado com sucesso");
                $(".modal-backdrop").remove();
                $("#add_product_modal").hide();
                call_page_products();
            }
        });
    }
};

//FUNÇÃO PARA ELIMINAR PRODUTO
delete_product = function (product_id) {
    $.ajax({
        url: url + 'application/functions.php?function=delete_product',
        type: "POST",
        data: {product_id: product_id}
    }).done(function (added) {
        if (added != true) {
            alert("Ocorreu um erro, o produto não foi eliminado.");
            call_page_products();
        } else {
            alert("Produto eliminado com sucesso");
            call_page_products();
        }
    });
};

//FUNÇÃO PARA EDITAR PRODUTO
open_modal_product = function (product_id, product_name) {
    $('#edit_product_name').val(product_name);
    $('#edit_product_id').val(product_id);
    $('#edit_product_modal').modal('show');
};

edit_product = function () {
    var edit_product_name = $('#edit_product_name').val();
    var edit_product_id = $('#edit_product_id').val();
    $("#form-product-edit").addClass("was-validated");
    var submit = true;

    if (edit_product_name == '') {
        $('#help-edit-product-name').text('Insira o nome.')
        submit = false;
    }

    if (submit == true) {
        $.ajax({
            url: url + 'application/functions.php?function=edit_product',
            type: "POST",
            data: {edit_product_name: edit_product_name, edit_product_id: edit_product_id}
        }).done(function (product_edited) {
            if (product_edited != true) {
                alert("Ocorreu um erro, o produto não foi editado.");
                $(".modal-backdrop").remove();
                $("#edit_product_modal").hide();
                call_page_products();
            } else {
                alert("Produto editado com sucesso.");
                $(".modal-backdrop").remove();
                $("#edit_product_modal").hide();
                call_page_products();
            }
        });
    }
};

//FORNECEDORES
//FUNÇÃO PARA INSERIR FORNECEDOR
add_provider = function () {
    var add_provider_name = $("input[name='provider_name']").val();
    var add_provider_email = $("input[name='provider_email']").val();
    var testEmail = /^[A-Z0-9._%+-]+@([A-Z0-9-]+\.)+[A-Z]{2,4}$/i;
    $("#form-provider-add").addClass("was-validated");
    var submit = true;

    if (add_provider_name == '') {
        $('#help-add-provider-name').text('Insira o nome.')
        submit = false;
    }

    if (add_provider_email == '') {
        $('#help-add-provider-email').text('Insira o email.')
        submit = false;
    } else if (!testEmail.test(add_provider_email)) {
        $('#help-add-provider-email').text('*O email introduzido não é valido!');
        submit = false;
    } else {
        $('#help-add-provider-email').text('');
    }

    if (submit == true) {
        $.ajax({
            url: url + 'application/functions.php?function=add_provider',
            type: "POST",
            data: {add_provider_name: add_provider_name, add_provider_email: add_provider_email}
        }).done(function (added) {
            if (added != true) {
                alert("Ocorreu um erro, o fornecedor não foi adicionado");
                $(".modal-backdrop").remove();
                $("#add_provider_modal").hide();
                call_page_providers();
            } else {
                alert("Fornecedor adicionado com sucesso");
                $(".modal-backdrop").remove();
                $("#add_provider_modal").hide();
                call_page_providers();
            }
        });
    }
}

//FUNÇÃO PARA MODAL DE EDITAR FORNECEDOR
open_modal_provider = function (provider_id, provider_name, provider_email) {
    $('#edit_provider_name').val(provider_name);
    $('#edit_provider_email').val(provider_email);
    $('#edit_provider_id').val(provider_id);
    $('#edit_provider_modal').modal('show');
}

//FUNÇÃO PARA EDITAR FORNECEDOR
edit_provider = function () {
    var edit_provider_name = $('#edit_provider_name').val();
    var edit_provider_email = $('#edit_provider_email').val();
    var edit_provider_id = $('#edit_provider_id').val();
    var testEmail = /^[A-Z0-9._%+-]+@([A-Z0-9-]+\.)+[A-Z]{2,4}$/i;
    $("#form-provider-edit").addClass("was-validated");
    var submit = true;

    if (edit_provider_name == '') {
        $('#help-edit-provider-name').text('Insira o nome.')
        submit = false;
    }

    if (edit_provider_email == '') {
        $('#help-edit-provider-email').text('Insira o email.')
        submit = false;
    } else if (!testEmail.test(edit_provider_email)) {
        $('#help-edit-provider-email').text('*O email introduzido não é valido!');
        submit = false;
    } else {
        $('#help-edit-provider-email').text('');
    }

    if (submit == true) {
        $.ajax({
            url: url + 'application/functions.php?function=edit_provider',
            type: "POST",
            data: {edit_provider_name: edit_provider_name, edit_provider_email: edit_provider_email, edit_provider_id: edit_provider_id}
        }).done(function (provider_edited) {
            if (provider_edited != true) {
                alert("Ocorreu um erro, o fornecedor não foi editado");
                $(".modal-backdrop").remove();
                $("#edit_provider_modal").hide();
                call_page_providers();
            } else {
                alert("Fornecedor editado com sucesso");
                $(".modal-backdrop").remove();
                $("#edit_provider_modal").hide();
                call_page_providers();
            }
        });
    }
};
//FUNÇÃO PARA ELIMINAR FORNECEDOR
delete_provider = function (provider_id) {
    $.ajax({
        url: url + 'application/functions.php?function=delete_provider',
        type: "POST",
        data: {provider_id: provider_id}
    }).done(function (added) {
        if (added != true) {
            alert("Ocorreu um erro, o fornecedor não foi eliminado");
            call_page_providers();
        } else {
            alert("Fornecedor eliminado com sucesso");
            call_page_providers();
        }
    });
};

//ENCOMENDAS
//FUNÇÃO PARA ELIMINAR UTILIZADOR
delete_request = function (request_id) {
    $.ajax({
        url: url + 'application/functions.php?function=delete_request',
        type: "POST",
        data: {request_id: request_id}
    }).done(function (request_deleted ) {
        if (request_deleted  != true) {
            alert("Ocorreu um erro, a encomenda não foi eliminado");
            call_page_user();
        } else {
            alert("Encomenda eliminada com sucesso");
            call_page_user();
        }
    });
};

//TABELA DINÂMICAS
$(document).ready(function () {
    $('#tb-providers').DataTable({
        "language": {
            "lengthMenu": "Mostrar _MENU_ resultados",
            "zeroRecords": "Não foram encontrados fornecedores",
            "info": "Página _PAGE_ de _PAGES_",
            "infoEmpty": "Não foram encontrados fornecedores",
            "infoFiltered": "(filtrado em _MAX_ resultados)",
            "search": "Pesquisa:",
            "paginate": {
                "first": "Primeira",
                "last": "Última",
                "next": "Seguinte",
                "previous": "Anterior"
            }
        }
    });
    $('#tb-users').DataTable({
        "language": {
            "lengthMenu": "Mostrar _MENU_ resultados",
            "zeroRecords": "Não foram encontrados utilizadores",
            "info": "Página _PAGE_ de _PAGES_",
            "infoEmpty": "Não foram encontrados utilizadores",
            "infoFiltered": "(filtrado em _MAX_ resultados)",
            "search": "Pesquisa:",
            "paginate": {
                "first": "Primeira",
                "last": "Última",
                "next": "Seguinte",
                "previous": "Anterior"
            }
        }
    });
    $('#tb-products').DataTable({
        "language": {
            "lengthMenu": "Mostrar _MENU_ resultados",
            "zeroRecords": "Não foram encontrados produtos",
            "info": "Página _PAGE_ de _PAGES_",
            "infoEmpty": "Não foram encontrados produtos",
            "infoFiltered": "(filtrado em _MAX_ resultados)",
            "search": "Pesquisa:",
            "paginate": {
                "first": "Primeira",
                "last": "Última",
                "next": "Seguinte",
                "previous": "Anterior"
            }
        }
    });
})

