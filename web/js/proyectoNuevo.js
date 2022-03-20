function formulario() {
    document.getElementById('formulario').style.display = 'block';
    document.getElementById('tabladatos').style.display = 'none';
}


function tablaDatos() {
    document.getElementById('tabladatos').style.display = 'block';
    document.getElementById('formulario').style.display = 'none';
}

$(document).on("click", "#btnmodal", function(){
    var idtrabajador=$(this).data('${lista.getIdtrabajador()}');
    var nombretrabajador=$(this).data('${lista.getNombre()}');
    var condiciontrabajador =$(this).data('${lista.getCondicion()}');
})


