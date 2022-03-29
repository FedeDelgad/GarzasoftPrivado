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
                                    <th scope="col" class="col-r text-center">Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="lista" items="${listadesarrollo}">
                                    <tr>
                                        <td>${lista.getNombreproyecto()}</td>
                                        <td>${lista.getInicio()}</td>
                                        <td>${lista.getFin()}</td>
                                        <td>${lista.getNombretrabajador()}</td>
                                        <td>${lista.getNombrecliente()}</td>
                                        <td>${lista.getEstadoproyecto()}</td>
                                        <td class="col-r">
                                            <a class="btn btn-warning text-white " style="font-size: 17px" id="actualizar" data-toggle="modal" data-target="#modificar${lista.getIddesarrollo()}"><i class="fas fa-edit"></i></a>
                                            <div class="modal fade" id="modificar${lista.getIddesarrollo()}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                <div class="modal-dialog" role="document">
                                                    <div class="modal-content col-sm-11 p-0">
                                                        <div class="modal-header mod-h p-3 ">
                                                            <h4 class="modal-title text-white">Actualizar Datos del Proyecto</h4>
                                                            <div style="border: none" class="close  text-white mr-2" data-dismiss="modal" aria-label="Close">
                                                                &times;
                                                            </div>
                                                        </div>
                                                        <form  action="controladorproyecto?accion=actualizar" method="post">
                                                            <div class="modal-body">
                                                                <input type="hidden" name="idproyecto" value="${lista.getIdproyecto()}">
                                                                <div class="form-row">
                                                                    <div class="form-group col-md-12">
                                                                        <label>Nombre</label>
                                                                        <div class="input-group">
                                                                            <div class="input-group-prepend">
                                                                                <span style="font-size: 20px"class="input-group-text" ><i class="las la-address-card"></i></span>
                                                                            </div>
                                                                            <input type="text" class="form-control"  name="nombreproyecto" value="${lista.getNombreproyecto()}" autocomplete="off" required="true">
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="form-row">
                                                                    <div class="form-group col-md-6">
                                                                        <label>Fecha Inicio</label>
                                                                        <div class="input-group">
                                                                            <input type="date" class="form-control"  name="inicio" value="${lista.getInicio()}" autocomplete="off" required="true">
                                                                        </div>
                                                                    </div>
                                                                    <div class="form-group col-md-6">
                                                                        <label for="inputtext">Fecha de finalizacion</label>
                                                                        <div class="input-group">
                                                                            <input type="date" class="form-control"  name="fin" value="${lista.getFin()}" autocomplete="off" required="true">
                                                                        </div>
                                                                    </div>  
                                                                </div>
                                                                <div class="form-row">  
                                                                    <div class="form-group col-md-6">
                                                                        <input type="hidden" name="idtrabajador" value="${lista.getIdtrabajdor()}">
                                                                        <label >Trabajador</label>
                                                                        <div class="input-group">
                                                                            <div class="input-group-prepend">
                                                                                <span style="font-size: 20px"class="input-group-text" ><i class="las la-phone-alt"></i></span>
                                                                            </div>
                                                                            <input type="text" class="form-control"  value="${lista.getNombretrabajador()}" autocomplete="off" required="true">
                                                                        </div>
                                                                    </div> 
                                                                    <div class="form-group col-md-6">
                                                                        <label for="inputtext">Cliente</label>
                                                                        <div class="input-group">
                                                                            <div class="input-group-prepend">
                                                                                <span style="font-size: 20px"class="input-group-text" ><i class="las la-transgender"></i></span>
                                                                            </div>
                                                                            <input type="text" class="form-control"  value="${lista.getNombrecliente()}" autocomplete="off" required="true">
                                                                        </div>
                                                                    </div>                

                                                                </div>
                                                                <div class="row">
                                                                    <div class="form-group col-md-12">
                                                                        <label>Estado</label>
                                                                        <div class="input-group">
                                                                            <div class="input-group-prepend">
                                                                                <span style="font-size: 20px"class="input-group-text" ><i class="las la-calendar"></i></span>
                                                                            </div>
                                                                            <input type="text" class="form-control" name="estado" value="${lista.getEstadoproyecto()}" autocomplete="off" required="true">
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <button type="submit" class="btn  btn-block mt-3 btn-1 text-white" >Actualizar</button>
                                                            </div>
                                                        </form>
                                                    </div>
                                                </div>
                                            </div>
                                            <a href="controladorproyecto?accion=eliminar&idproyecto=${lista.getIdproyecto()}" class="btn btn-danger text-white ml-1 "style="font-size: 17px"><i class="fas fa-trash-alt"></i></a>
                                            <a href="controladorRequerimiento?accion=listar&iddesarrollo=${lista.getIddesarrollo()}" class="btn btn-info text-white ml-1 "style="font-size: 17px"><i class="fa-solid fa-list-check"></i></a>
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
