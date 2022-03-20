/* global Swal */

function cambioAdmin() {
    document.getElementById('loginAdmin').style.display = 'block';
    document.getElementById('loginTrabajdor').style.display = 'none';
    document.getElementById('loginCliente').style.display = 'none';
}

function cambioTrabajador() {
    document.getElementById('loginTrabajador').style.display = 'block';
    document.getElementById('loginAdmin').style.display = 'none';
    document.getElementById('loginCliente').style.display = 'none';
}

function cambioCliente() {
    document.getElementById('loginCliente').style.display = 'block';
    document.getElementById('loginAdmin').style.display = 'none';
    document.getElementById('loginTrabajdor').style.display = 'none';
}

var mensaje = document.getElementById("mensaje").value;
if (mensaje) {
    Swal.fire({
        icon: 'warning',
        title: mensaje,
        text: 'Ingrese sus datos nuevamente',
        confirmButtonColor: '#2874A6 ',
        confirmButtonText: 'Aceptar',
        width: '30%'
    });
}

