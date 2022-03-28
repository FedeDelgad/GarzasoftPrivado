$(document).ready(function(){
    $('#submit').click(function(event){
        var dniVar = $('#dni').val();
        var nombreVar = $('#nombre').val();
        var apellidoVar = $('#apellido').val();
        var telefonoVar = $('#telefono').val();
        var generoVar = $('#genero').val();
        var claveVar = $('#clave').val();
        var ingresoVar = $('#ingreso').val();
        var correoVar = $('#correo').val();
        
        $.post('controladortrabajadorAlterno',{
            dni : dniVar,
            nombre : nombreVar,
            apellido : apellidoVar,
            telefono : telefonoVar,
            genero : generoVar,
            clave : claveVar,
            ingreso : ingresoVar,
            correo : correoVar
        }, function(responseText){
            $('#tabla').html(responseText);
        });
    });
});


