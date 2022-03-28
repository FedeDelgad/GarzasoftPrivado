<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
        <link href="css/DashboardCliente.css" rel="stylesheet" type="text/css"/>
        <title>DashboardCliente</title>
    </head>
    <body>
        <div class="d-flex" >
            <section class="parte1 sticky-top ">
                <section  class="logo text-center  mt-2">
                    <h2 class="text-white"><i class="fab fa-glide-g m-0"></i>Garzasoft
                    </h2>
                </section>
                <section class="img  text-center">
                    <img  class=" bg-white rounded-circle" src="imagenes/icon2.png" width="60px" height="60px"/>
                    <div class="lr" >
                        <div class="lr-1 text-center text-white">Bienvenido:</div>
                        <div class="lr-2 text-center text-white">${cliente.getNombrecli()}</div>
                    </div>
                </section>
                <section class="s-menu">
                    <div>
                        <a href="controladorcliente?accion=inicio" target="myFrame"><i class="las la-home"></i> <span>Inicio</span></a> 
                    </div>
                    <div>
                        <a href="controladorcliente?accion=perfil&idcliente=${cliente.getIdcliente()}" target="myFrame"><i class="las la-user"></i><span>Perfil</span></a> 
                    </div>
                    <div>
                        <a href="controladorcliente?accion=proyecto" target="myFrame"><i class="las la-file-alt"></i><span>Proyecto</span></a> 
                    </div>
                    <div>
                        <a href="controladorLogin?accion=cerrar"><i class="las la-door-open"></i><span>Salir</span> </a> 
                    </div>
                </section>
            </section>
            <section class="parte2">
                <div class=" cabecera sticky-top">
                    <nav class="navbar navbar-expand-lg navbar-light bg-light">
                        <div class="collapse navbar-collapse" id="navbarNavDropdown">
                            <div class="navbar-nav  ml-auto mr-3   "> 
                                <li class="nav-item dropdown  " style="background:">
                                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="background:">
                                        <img class=" mr-2 rounded-circle" style="background: #566573"  src="imagenes/icon2.png" width="43px" height="43px" />${cliente.getNombrecli()} ${cliente.getApellidocli()}
                                    </a>
                                    <div class="dropdown-menu dropdown-menu-right text-center submenu" aria-labelledby="navbarDropdownMenuLink ">
                                        <a class="dropdown-item text-center" href="controladorcliente?accion=perfil&idcliente=${cliente.getIdcliente()}"><i class="las la-user" style="font-size:21px"></i> Perfil</a>
                                        <div class="dropdown-divider"></div>
                                        <a class="dropdown-item" href="controladorLogin?accion=cerrar"><i class="las la-power-off "style="font-size:20px"></i> salir</a>
                                    </div>
                                </li>
                            </div>
                        </div>
                    </nav>
                </div>
                <div style="height: 555px">
                    <iframe src="controladorproyecto?accion=listarporlcliente&idcliente=${cliente.getIdcliente()}" name="myFrame" style="height: 100%; width: 100%; border:none; margin-bottom: 15px"></iframe>
                </div>
            </section>
        </div> 
        <input type="hidden" id="msj" value="${rpta1}">
    </body>
    <script src="https://kit.fontawesome.com/ef7654b222.js" crossorigin="anonymous"></script>   
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script >
        var msj = document.getElementById("msj").value;
        if (msj) {
            Swal.fire({
                icon: 'success',
                title: msj,
                showConfirmButton: false,
                timer: 2000,
                width: '30%'
            });
        }
    </script>
</html>
