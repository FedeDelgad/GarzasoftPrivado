<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
        <link href="css/DashboardCliente.css" rel="stylesheet" type="text/css"/>
        <title>Garfasoft/InicioCliente</title>
    </head>
    <body>
        <div class=" cuerpo d-flex ">
            <div  class="cards" >
                <div class="card " style="width:51rem;">
                    <div class="card-body pl-4 pr-4">
                        <h5 class="ml-2 mr-2 t-1"><i class="las la-folder-open"></i> Nombre del Proyecto Actual:</h5>
                        <div class=" d-flex">
                            <h3 class="ml-3">${nombreproyecto}</h3>
                            <div class="card  p-1 mb-1 text-white bg-danger ml-auto text-center" style="width: 7rem; font-weight:600; border: none">PENDIENTE</div>  
                        </div>
                    </div>
                </div>
                <div class="card over" style="width:51rem">
                    <div class="card-body ">
                        <h5 class="card-title">Proyectos</h5>
                        <table class="table">
                            <thead class="thead-light">
                                <tr >
                                    <th>Nombre</th>
                                    <th>Inicio</th>
                                    <th>Fin</th>
                                    <th>Estado</th>
                                    <th>Detalles</th>
                                </tr>
                            </thead>
                            <tbody class="table">
                                <c:forEach var="lista" items="${listaproyectos}">
                                    <tr>
                                        <td>${lista.getNombre()}</td>
                                        <td>${lista.getInicio()}</td>
                                        <td>${lista.getFin()}</td>
                                        <td class="m-0 p-1">
                                            <button class="card  text-white bg-danger p-1 text-center" style="width: 7rem; font-weight:600; border: none"><span class="text-center ml-2">${lista.getEstado()}</span></button>
                                        </td>
                                        <td class="m-0 p-2 ">
                                            <a href="controladorproyecto?accion=detallecliente&idproyecto=${lista.getIdProyecto()}" class="btn btn-primary m-0 p-0 text-white" style="width: 7rem"><i class="las la-eye" style="font-size:30px"></i></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div> 
            </div>
            <div>
                
                <div class="card" style="width: 17rem; height: 350px">
                    <div class="card-body bg-warning  " >
                        <div class=" text-center">
                            <h5 class="card-title text-white mt-2">TRABAJADOR A CARGO</h5>
                            <img  class=" bg-white mt-2 rounded-circle" src="imagenes/icon2.png" width="90px" height="90px"/>
                            <h5 class="text-white mt-3">${nombretrabajador}</h5>
                            <h5 class="text-white">${apellidotrabajador}</h5>
                        </div>
                        <div class="pl-5 pr-5">
                            <div class="mt-3 text-white"><i class="fa-solid fa-mobile-screen-button"></i>  :  951074151</div>
                            <div class="mt-2 text-white"><i class="fas fa-envelope-open-text"></i> : -------</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <script src="https://kit.fontawesome.com/ef7654b222.js" crossorigin="anonymous"></script>   
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</html>
