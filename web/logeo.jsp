<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/logeo.css" rel="stylesheet" type="text/css"/>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto+Slab:wght@500&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Hind+Siliguri:wght@300&family=Mochiy+Pop+P+One&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Mukta&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>Garfasoft/login</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark navbar-light sticky-top">
            <h1><i class="fab fa-glide-g m-2"></i>Garzasoft</h1>
            <button class="navbar-toggler " type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span  style="font-size: 25px" class="  fas fa-align-justify "></span>
            </button>
            <div class="collapse navbar-collapse" style="margin-right: 160px" id="navbarNavDropdown">
                <ul class="navbar-nav ml-auto ">   
                    <li class="nav-item">
                        <a class="h5" href="index.html" style="font-size:20px; text-decoration: none"><i class="fas fa-sign-out-alt"></i>Salir</a>
                    </li>
                </ul>
            </div>
        </nav>
        <section class="padre">
            <img src="imagenes/im1.jpg" class="img-fluid" alt="Responsive image">
            <div  class="hijo">
                <div class="hijo-1">
                    <h1>SOFTWARE PARA MONITOREO DE ACTIVIDADES</h1>
                </div>
            </div>   
        </section>
        <section class="bienvenida">
            <h3>Bienvenido</h3>  
        </section>    
        <section class="logeo d-flex mb-1">
            <div class="cards" style="width: 18rem;">
                <div class="card-body " data-toggle="modal" data-target="#adminModal">  
                    <div class="icono"> <i class="fas fa-user-tie border border-white"></i> </div>
                    <div class="text mt-1">ADMINISTRADOR</div>
                </div>
            </div>
            <div class="cards" style="width: 18rem;">
                <div class="card-body " data-toggle="modal" data-target="#clienteModal">
                    <div class="icono"><i class=" border border-white fas fa-users  "></i> </div>
                    <div class="text mt-1">CLIENTES</div>    
                </div>
            </div>
            <div class="cards" style="width: 18rem;">
                <div class="card-body" data-toggle="modal" data-target="#trabajadorModal">
                    <div class="icono"><i class=" border border-white fas fa-user  "></i></div>
                    <div class="text mt-1">TRABAJADORES</div>   
                </div>
            </div>
        </section>
        <%--MODAL DE ADMINISTRADOR--%>
        <div class="modal fade" tabindex="-1" role="dialog" id="adminModal" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content p-2 col-sm-8 ml-5" >
                    <div class="modal-body">
                        <form class="form-sign" action="controladorLogin?accion=Admin" method="post">
                            <div class="form-group text-center">
                                <h3 style="font-size:20px; text-align: center ">ADMINISTRADOR</h3>
                                <i style="font-size: 100px; color: #A1A7A7" class="fas fa-user-circle nav-link" ></i> 
                                <label>Bienvenido al sistema</label>
                            </div>
                            <div class="form-group">
                                <label for="inputtext">Usuario</label>
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <span style="font-size: 20px" class="input-group-text" ><i class="fas fa-user"></i></span>
                                    </div>
                                    <input type="text" class="form-control" name="usuario" required="true">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputtext">Contraseña</label>
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <span style="font-size: 20px" class="input-group-text" ><i class="fas fa-key"></i></span>
                                    </div>
                                    <input type="password" class="form-control" name="clave" required="true">
                                </div>
                            </div>
                            <button type="submit" class="btn btn-primary btn-block mt4">Ingresar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <%--MODAL DE CLIENTE--%>
        <div class="modal fade" tabindex="-1" role="dialog" id="clienteModal" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content p-2 col-sm-8 ml-5">
                    <div class="modal-body">
                        <form class="form-sign" action="controladorLogin?accion=cliente" method="post">
                            <div class="form-group text-center">
                                <h3 style="font-size:20px; text-align: center ">CLIENTE</h3>
                                <i style="font-size: 100px;color: #A1A7A7" class="fas fa-user-circle nav-link" ></i>
                                <label>Bienvenido al sistema</label>
                            </div>
                            <div class="form-group">
                                <label for="inputtext">Usuario</label>
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <span style="font-size: 20px" class="input-group-text" ><i class="fas fa-user"></i></span>
                                    </div>
                                    <input type="text" class="form-control" name="usuario" placeholder="Usuario" required="true">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputtext">Contraseña</label>
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <span style="font-size: 20px" class="input-group-text" ><i class="fas fa-key"></i></span>
                                    </div>
                                    <input type="password" class="form-control" name="clave" placeholder="Contraseña" required="true">
                                </div>
                            </div>
                            <button type="submit" class="btn btn-primary btn-block mt4">Ingresar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <%--MODAL DE TRABAJADOR--%>
        <div class="modal fade" tabindex="-1" role="dialog" id="trabajadorModal" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content p-2 col-sm-8 ml-5">
                    <div class="modal-body">
                        <form class="form-sign" action="controladorLogin?accion=trabajador" method="post">
                            <div class="form-group text-center">
                                <h3 style="font-size:20px; text-align: center ">TRABAJADOR</h3>
                                <i style="font-size: 100px; color:#A1A7A7 " class="fas fa-user-circle nav-link" ></i>
                                <label>Bienvenido al sistema</label>
                            </div>
                            <div class="form-group">
                                <label for="inputtext">Usuario</label>
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <span style="font-size: 20px" class="input-group-text" ><i class="fas fa-user"></i></span>
                                    </div>
                                    <input type="text" class="form-control" name="usuario" placeholder="Usuario" required="true">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputtext">Contraseña</label>
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <span style="font-size: 20px" class="input-group-text" ><i class="fas fa-key"></i></span>
                                    </div>
                                    <input type="password" class="form-control" name="clave" placeholder="Contraseña" required="true">
                                </div>
                            </div>
                            <button type="submit" class="btn btn-primary btn-block mt4">Ingresar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <input type="hidden" id="mensaje" value="${respuesta}">
    </body>
    <script src="https://kit.fontawesome.com/ef7654b222.js" crossorigin="anonymous"></script>  
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="js/login.js" type="text/javascript"></script>
</html>
