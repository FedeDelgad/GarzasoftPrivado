<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/dt-1.11.4/datatables.min.css"/>
        <link href="css/CrudProyectoDesarrollo.css" rel="stylesheet" type="text/css"/>
        <title>Garzasoft/ProjectDesarrollo</title>
    </head>
    <body>     
        <div class=" cuerpo pl-4 pr-4 pt-4 pb-2 " >
            <div class=" d-inline h4 ma-1 pl-2 "><i class="fas fa-user"></i>Lista de Proyectos de Desarrollo</div>
            <a href="controladorprotecto?accion=cargarDatos" class="btn text-white float-right btn-1" target="myFrame"><i class="fas fa-plus"></i> De Mantenimiento Perfectivo</a>
            <a href="controladorproyecto?accion=cargarDatos" class="btn text-white float-right btn-success mr-2" target="myFrame"><i class="fas fa-plus"></i> Proyecto Nuevo</a>         
            <hr class="mt-4" style="background: #1F618D">
            <div >
                <div class="card " style="border: none ">
                    <div class="card-body table-responsive">
                        <table id="datatable" class="table ">
                            <thead class="thead-light">
                                <tr>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Inicio</th>
                                    <th scope="col">Fin</th>
                                    <th scope="col">Trabajador</th>
                                    <th scope="col">Cliente</th>
                                    <th scope="col">Estado</th>
                                    <th scope="col">Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="lista" items="${listadesarrollo}">
                                    <tr>
                                        <td>${lista.getNombre()}</td>
                                        <td>${lista.getInicio()}</td>
                                        <td>${lista.getFin()}</td>
                                        <td>${lista.getNombreTrabajador()}</td>
                                        <td>${lista.getNombreCliente()}</td>
                                        <td>${lista.getEstado()}</td>
                                        <td  >
                                            <a href="controladorproyecto?accion=editar&id=${lista.getIdProyecto()}" class="btn btn-warning text-white " style="font-size: 17px"><i class="fas fa-edit"></i></a>  
                                            <a href="controladorproyecto?accion=eliminar&id=${lista.getIdProyecto()}" class="btn btn-danger text-white ml-1 "style="font-size: 17px"><i class="fas fa-trash-alt"></i></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <script src="https://kit.fontawesome.com/ef7654b222.js" crossorigin="anonymous"></script>   
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="js/datatables.min.js" type="text/javascript"></script>
    <script src="js/DataTable.js" type="text/javascript"></script>
</html>
