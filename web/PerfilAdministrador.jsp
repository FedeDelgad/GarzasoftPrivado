<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>JSP Page</title>
        <link href="css/PerfilAdministrador.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
    </head>
    <body style="background-color: #E5E7E9; overflow-x: hidden ">
        <input type="hidden" id="msj2" value="${rpta}">
        <div class=" cuerpo pl-4 pr-4 pt-4 pb-2 ">
            <section class="d-flex cards" style="justify-content: center">
                <div class="card p-3 mb-3" style="width: 100%">
                    <div class="card-body">
                        <h5 class="card-title mt-3 mb-4"><i class="fa-solid fa-user-pen"></i> Datos Personales</h5>
                        <form action="controladoradministrador" id="formulario" method="post">
                            <input type="hidden" name="idadministrador" value="${administrador.getIdadministrador()}">
                            <input  type="hidden" name="clave" id="idclave" value="${administrador.getClaveadmi()}">
                            <div class="form-row">
                                <div class="form-group col-md-4">
                                    <label for="idnombre" class=" pb-1 ml-2">Nombres : </label>
                                    <input type="text" class="pb-1 pt-1 pl-2 pr-2 w-100 m-1 read" id="idnombre" value="${unadministrador.getNombreadmi()}" readonly>
                                </div>
                                <div class="form-group col-md-4">
                                    <label for="idapellido" class=" pb-1 ml-2">Apellidos : </label>
                                    <input type="text" class="pb-1 pt-1 pl-2 pr-2 w-100 m-1 read" id="idapellido" value="${unadministrador.getApellidosadmi()}" readonly>
                                </div>
                                <div class="form-group col-md-4">
                                    <label for="iddni" class=" pb-1 ml-2" >Dni : </label>
                                    <input type="text" class="pb-1 pt-1 pl-2 pr-2 w-100 m-1 read" id="iddni" value="${unadministrador.getDniadmi()}" readonly>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-4">
                                    <label for="idtelefono" class=" pb-1 ml-2" >Telefono : </label>
                                    <input type="text" class="pb-1 pt-1 pl-2 pr-2 w-100 m-1" id="idtelefoni" name="telefono" value="${unadministrador.getTelefonoadmi()}">
                                </div>
                                <div class="form-group col-md-8">
                                    <label for="idcorreo" class=" pb-1 ml-2">Correo : </label>
                                    <input type="text" class="pb-1 pt-1 pl-2 pr-2 w-100 m-1" id="idcorreo" name="correo" value="${unadministrador.getCorreoadmi()}">
                                </div>
                            </div>

                            <h5 class="card-title mb-4" style="margin-top: 33px"><i class="fa-solid fa-lock"></i> Cambiar Contrase??a</h5>
                            <div class="form-row">
                                <p class="card-text pt-2 pb-3 pl-3 pr-3">Para actualizar la contrase??a de esta cuenta debera ingresar la contrase??a actual, una nueva y volverla a escribir. En caso que no desee actualizarla debe dejar los 3 campos vacios</p>
                                <div class="form-group col-md-4">
                                    <label for="idcontrase??a" class=" pb-1 ml-2" >Contrase??a Actual : </label>
                                    <input type="password" class="pb-1 pt-1 pl-2 pr-2 w-100 m-1" id="idclaveantigua" name="claveantigua" placeholder="Ingrese Contrase??a Actual">
                                    <div class=" invalid-feedback  text-danger pl-2 mt-2" id="no_valido"><i class="fa-solid fa-circle-exclamation"></i>  Ingrese contrase??a correcta </div>
                                </div>
                                <div class="form-group col-md-4">
                                    <label for="idcontrase??a" class=" pb-1 ml-2">Contrase??a Nueva : </label>
                                    <input type="password" class="pb-1 pt-1 pl-2 pr-2 w-100 m-1" id="idclavenueva" name="clavenueva" placeholder="Ingrese Contrase??a Nueva">
                                    <div class="invalid-feedback  ml-2 text-danger pl-2 mt-2" id="no_valido1"><i class="fa-solid fa-circle-exclamation"></i> Ambas contrase??as deben ser igual </div>
                                </div>
                                <div class="form-group col-md-4">
                                    <label for="idcontrase??a" class=" pb-1 ml-2">Repita Contrase??a Nueva : </label>
                                    <input type="password" class="pb-1 pt-1 pl-2 pr-2 w-100 m-1" id="idclavenuevar" name="rclavenueva" placeholder="Repita Contrase??a Nueva">
                                    <div class="invalid-feedback  ml-2 text-danger pl-2 mt-2" id="no_valido2"><i class="fa-solid fa-circle-exclamation"></i> Ambas contrase??as deben ser igual </div>
                                </div>
                            </div>
                            <div class="form-group col-md-4 float-right">
                                <button type="submit " name="accion" value="actualizar" class="btn btn-primary" style="width: 105%"><i class="fa-regular fa-floppy-disk mr-1 ml-1" style="font-size: 22px"></i>  ACTUALIZAR</button>
                            </div>
                        </form>
                    </div>
                </div>

            </section>
        </div>
    </body>
    <script src="https://kit.fontawesome.com/ef7654b222.js" crossorigin="anonymous"></script>   
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="js/validaciondeperfil.js" type="text/javascript"></script>
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script >
        var lista = document.getElementById('dentro1');
        var lis = function (e) {
            lista.classList.toggle('listo1');/*agrega clase*/
            var height = 0;
            var menu = lista.nextElementSibling;/*seleciona su hermano ayacente*/
            console.log(menu.scrollHeight);/* ve el tama??o de menu*/
            if (menu.clientHeight == "0") {
                height = menu.scrollHeight;
            }
            ;
            menu.style.height = height + "px";
        };
        lista.addEventListener('click', lis);
        var mensaje = document.getElementById("msj2").value;
        if (mensaje == "correcto") {

            Swal.fire({
                icon: 'success',
                title: 'Actualizado Correctamente',

                confirmButtonColor: '#2874A6 ',
                confirmButtonText: 'Aceptar',
                width: '30%'
            });
        }
        if (mensaje == "incorrecto") {
            Swal.fire({
                icon: 'error',
                title: 'error',
                text: 'Ingrese sus datos nuevamente',
                confirmButtonColor: '#2874A6 ',
                confirmButtonText: 'Aceptar',
                width: '30%'
            });
        }
    </script>
</html>
