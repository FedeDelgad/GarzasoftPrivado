<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/DashboardAdministrador.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>Inicio/Administrador</title>
    </head>
    <body style="background-color: #E5E7E9 ">
        <div class=" cuerpo ">
            <div class="cuerpo2 d-flex"> 
                <div class="cards1">
                    <div class="cards2 d-flex">
                        <div class="card" style="width: 16rem;">
                            <div class="card-body d-flex">
                                <div class="pl-3 pr-3 tr-1">
                                    <h1>54</h1>
                                    <span>Proyectos</span>
                                </div>
                                <div class="tr-2">
                                    <span class="las la-clipboard-list"></span>
                                </div>
                            </div>
                        </div>
                        <div class="card" style="width: 16rem;">
                            <div class="card-body d-flex">
                                <div class="pl-3 pr-3 tr-1">
                                    <h1>54</h1>
                                    <span>Trabajadores</span>
                                </div>
                                <div class="tr-2">
                                    <span class="las la-users"></span>
                                </div>
                            </div>
                        </div>
                        <div class="card" style="width: 16rem;">
                            <div class="card-body d-flex">
                                <div class="pl-3 pr-3 tr-1">
                                    <h1>54</h1>
                                    <span>Clientes</span>
                                </div>
                                <div class="tr-2">
                                    <span class="las la-users"></span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card" >
                        <div class="card-body p- tabla-p">
                            <h5 class="card-title">Proyectos</h5>
                            <table class="table">
                                <thead class="thead-light">
                                    <tr>
                                        <th scope="col">NOMBRE</th>
                                        <th scope="col">INICIO</th>
                                        <th scope="col">FIN</th>
                                        <th scope="col">ESTADO</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td >Sistema Veterinario</td>
                                        <td>19/02/2022</td>
                                        <td>04/04/2022</td>
                                        <td class="m-0 p-1">
                                            <div class="card  text-white bg-danger p-1 text-center" style="width: 7rem; font-weight:600; border: none">PENDIENTE</div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Sistema de Ventas</td>
                                        <td>26/02/2022</td>
                                        <td>16/05/2022</td>
                                        <td class="m-0 p-1">
                                            <div class="card  text-white bg-success p-1 text-center" style="width: 7rem; font-weight:600; border: none">TERMINADO</div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Sistemas de Compras</td>
                                        <td>30/02/2022</td>
                                        <td>12/08/2022</td>
                                        <td class="m-0 p-1">
                                            <div class="card  text-white bg-warning p-1 text-center" style="width: 7rem; font-weight:600; border: none">EN PROCESO</div>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="card " style="width: 305px;">
                    <div class="card-body p-0">
                        <h5 class="card-title pt-3 pb-1 mt-2 text-center">Administrador</h5>
                        <div class="d-flex  p-2 mr-3 ml-3 trabajador">
                            <img  class=" rounded-circle  ml-2 mr-2" src="imagenes/icon2.png" width="50px" height="50px" style="background: #566573" />
                            <div class="pt-1 pl-1 pr-1 pb-1" >
                                <div class=" text-center ">Luis Angel</div>
                                <div class=" ">Antiguo </div>
                            </div>
                        </div>
                        <div class="d-flex  p-2 mr-3 ml-3 trabajador">
                            <img  class=" rounded-circle  ml-2 mr-2" src="imagenes/icon1.png" width="50px" height="50px" style="background: #566573" />
                            <div class="pt-1 pl-1 pr-1 pb-1" >
                                <div class=" text-center ">Andrea</div>
                                <div class=" ">Nueva</div>
                            </div>
                        </div>    
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
