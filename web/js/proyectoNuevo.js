function formulario() {
    document.getElementById('formulario').style.display = 'block';
    document.getElementById('tabladatos').style.display = 'none';
}


function tablaDatos() {
    document.getElementById('tabladatos').style.display = 'block';
    document.getElementById('formulario').style.display = 'none';
}


function reque() {
    document.getElementById('tablaRequerimiento').style.display = 'block';
}

function capturaTrabajador() {
    var nombretra = document.getElementById("nombretra").value;
    var apellidotra = document.getElementById("apellidotra").value;
    document.getElementById('respuestatra').innerHTML = nombretra + ' ' + apellidotra;
}

function capturartrabajador(nodo){
    var nodotd = nodo.parentNode;
    var nodotr = nodotd.parentNode;
    //var nodoContenedorForm = document.getElementById('contenedorForm');
    var nodosentr = nodotr.getElementsByTagName('td');
    var idtra = nodosentr[0].textContent;
    var nombre = nodosentr[2].textContent;
    var apellido = nodosentr[3].textContent;
    var respuesta = '<input type="hidden" name="idtrabajador" id="idtra" value="'+idtra+'">';
    document.getElementById('respuestatra').innerHTML = nombre + ' ' + apellido + respuesta;
}

function capturarcliente(nodo){
    var nodotd = nodo.parentNode;
    var nodotr = nodotd.parentNode;
    //var nodoContenedorForm = document.getElementById('contenedorForm');
    var nodosentr = nodotr.getElementsByTagName('td');
    var idcli = nodosentr[0].textContent;
    var nombre = nodosentr[2].textContent;
    var apellido = nodosentr[3].textContent;
    var respuesta = '<input type="hidden" name="idcliente" id="idtra" value="'+idcli+'">';
    document.getElementById('respuestacli').innerHTML = nombre + ' ' + apellido + respuesta;
}


