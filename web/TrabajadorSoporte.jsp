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
        <title>Garzasoft/Trabajador/Proyecto</title>
    </head>
    <body>     
        <div class="container mt-4">
            <div class="card mb-1">
                <div class="card-body pl-4 pr-4">
                    <h5 class="ml-2 mr-2 t-1"> <i class="las la-folder-open"></i> Nombre del Proyecto de Soporte</h5>
                    <div class=" d-flex">
                        <h3 class="mb-0 p-1 ml-1">${nombreproyecto}</h3>
                        <div class="card  p-1 mb-1 text-white bg-danger ml-auto text-center" style="width: 7rem; font-weight:600; border: none">${estado}</div>  
                    </div>
                </div>
            </div>
            <div class="card " style="border: none ">
                <div class="card-body">

                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label>Fecha de Inicio</label>
                            <input type="date" name="inicio" class="form-control" readonly value="${inicio}"/>
                        </div>
                        <div class="form-group col-md-6">
                            <label>Fecha de Finalizacion</label>
                            <input type="date" name="fin" class="form-control" readonly value="${fin}"/>
                        </div>
                    </div>
                    <div class="row" style="margin-bottom: -15px;">
                        <div class="form-group col-md-6">
                            <label >Cliente</label>
                        </div>
                        <div class="form-group col-md-6">
                            <label>Informar de su finalizacion</label>
                        </div>
                    </div>
                    <div class="row" >
                        <div class="form-group col-md-6">
                            <input type="text" name="cliente" class="form-control" readonly value="${cliente}"/>
                        </div>
                        <form class="col-md-6" action="controladorproyecto?accion=cambiosoporte" method="post">
                            <input type="hidden" name="idproyecto" value="${idproyecto}">
                            <input type="hidden" name="dni2" value="${trabajador.getDni()}">
                            <input type="hidden" name="idtrabajador" value="${trabajador.getIdtrabajador()}">
                            <div class="form-group">
                                <div style="width:100%" class="d-flex">
                                    <select name="estado" class="form-control" style="width:80%">
                                        <option value="PENDIENTE">PENDIENTE</option>
                                        <option value="TERMINADO">TERMINADO</option>
                                    </select>
                                    <button class="btn bg-primary text-white ml-3" type="submit" style="width:200px">Actualizar</button>
                                </div>
                            </div>
                        </form>
                    </div>

                </div>
            </div>
            <div class="card mt-1">
                <div class="card-body">
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label>Actividad del proyecto</label>
                            <input type="text" name="actividad" class="form-control" readonly value="${actividad}">
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
    <script src="js/datatables.min.js" type="text/javascript"></script>
    <script src="js/DataTable.js" type="text/javascript"></script>

</html>

