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
        <title>Garzasoft/ProjectDesarrollo/Nuevo</title>
    </head>
    <body>
        <div class="container mt-4 mb-4">
            <div class="d-inline h4 ma-1 pl-2">Agregue los requerimientos del proyecto</div>
            <hr class="mt-4" style="background: #1f618d" />
            <!--datos de los requerimientos-->
            <div class="card mt-3">
                <div class="card-body">
                    <div class="m-2">
                        <div class="row" style="font-weight: 600">

                            <div class="from-group col-md-4">
                                <label>Nombre del proyecto</label>
                                <input type="text" name="nombreproyecto" value="${nombreproyecto}" class="form-control" autocomplete="off" required="true" readonly>
                            </div>
                            <div class="from-group col-md-4">
                                <label>Trabajador Asignado</label>
                                <input type="text" name="trabajador" value="${datostrabajador}" class="form-control" autocomplete="off" required="true" readonly>
                            </div>
                            <div class="from-group col-md-4">
                                <label>Cliente</label>
                                <input type="text" name="cliente" value="${datoscliente}" class="form-control" autocomplete="off" required="true" readonly>
                            </div>
                        </div>
                        <div class="row ml-1 mt-3">
                            <label>Descripcion del requerimiento</label>
                        </div>
                        <form action="controladorRequerimiento?accion=agregarRequerimiento" method="post">
                            <div class="row  d-flex">
                                <input type="hidden" name="iddesarrollo" value="${iddesarrollo}">
                                <div class="form-group col-md-10">
                                    <input name="nombrere" type="text" class="form-control" autocomplete="off" required="true">
                                </div>
                                <div class="form-group col-md-2">
                                    <button type="submit" class="btn btn-primary btn-block">Agregar</button>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="row m-2" id="tablaRequerimiento">
                        <table class="table">
                            <thead class="thead-dark">
                                <tr>
                                    <th style="width:100px; text-align: center">#</th>
                                    <th>Nombre</th>
                                    <th style="width:200px; text-align: center">Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="lista" items="${listare}">
                                    <tr>
                                        <td style="width:100px; text-align: center">${lista.getIdrequerimiento()}</td>
                                        <td>${lista.getNombre()}</td>
                                        <td style="width:200px; text-align: center">
                                            <a class="btn btn-warning text-white " style="font-size: 17px" id="actualizar" data-toggle="modal" data-target="#modificar${lista.getIdrequerimiento()}"><i class="fas fa-edit"></i></a>
                                            <div class="modal fade" id="modificar${lista.getIdrequerimiento()}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                <div class="modal-dialog" role="document">
                                                    <div class="modal-content col-sm-11 p-0">
                                                        <div class="modal-header mod-h p-3 ">
                                                            <h4 class="modal-title text-white">Actualizar la descripcion del requerimiento</h4>
                                                            <div style="border: none" class="close  text-white mr-2" data-dismiss="modal" aria-label="Close">
                                                                &times;
                                                            </div>
                                                        </div>
                                                        <form  action="controladorRequerimiento?accion=actualizarRequerimiento" method="post">
                                                            <div class="modal-body">
                                                                <input type="hidden" name="idre" value="${lista.getIdrequerimiento()}">
                                                                <input type="hidden" name="iddesarrollo" value="${iddesarrollo}">
                                                                <div class="form-row">
                                                                    <div class="form-group col-md-12">
                                                                        <label>Nombre</label>
                                                                        <div class="input-group">
                                                                            <div class="input-group-prepend">
                                                                                <span style="font-size: 20px"class="input-group-text" ><i class="las la-address-card"></i></span>
                                                                            </div>
                                                                            <input type="text" class="form-control"  name="nombrere" value="${lista.getNombre()}" autocomplete="off" required="true">
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <button type="submit" class="btn  btn-block mt-3 btn-1 text-white" >Actualizar</button>
                                                            </div>
                                                        </form>
                                                    </div>
                                                </div>
                                            </div>
                                            <a href="controladorRequerimiento?accion=eliminarRequerimiento&idre=${lista.getIdrequerimiento()}&iddesarrollo=${iddesarrollo}" class="btn btn-danger text-white ml-1 "style="font-size: 17px"><i class="fas fa-trash-alt"></i></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="card-footer" style="background-color: white; height: 80px">
                <div class="row m-2 float-right">
                    <div class="form-group ">
                        <form action="controladordesarrollo?accion=listaDesarrollo">
                            <button type="submit" class="btn btn-primary" style="width:200px;">Guardar</button>
                        </form>
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
    <script src="js/proyectoNuevo.js" type="text/javascript"></script>
</html>


