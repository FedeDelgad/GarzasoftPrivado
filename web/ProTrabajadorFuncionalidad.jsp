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
        <div class="m-4">
            <div class=" d-inline h4 ma-1 pl-2 ">Detalles del proyecto</div>
            <hr class="mt-4" style="background: #1F618D">
            <div >
                <div class="card " style="border: none ">
                    <div class="card-body">

                        <div class="form-row">
                            <div class="col-md-4 form-group">
                                <label>Nombre</label>
                                <input type="text" name="nombreproyecto" class="form-control" readonly value="${nombreproyecto}"/>
                            </div>
                            <div class="form-group col-md-4">
                                <label>Fecha de Inicio</label>
                                <input type="date" name="inicio" class="form-control" readonly value="${inicio}"/>
                            </div>
                            <div class="form-group col-md-4">
                                <label>Fecha de Finalizacion</label>
                                <input type="date" name="fin" class="form-control" readonly value="${fin}"/>
                            </div>
                        </div>
                        <div class="row" style="margin-bottom: -15px;">
                            <div class="form-group col-md-4">
                                <label >Cliente</label>
                            </div>
                            <div class="form-group col-md-8">
                                <label >Cambiar el estado/informar de finalizacion</label>
                            </div>
                        </div>
                        <div class="row" >
                            <div class="form-group col-md-4">
                                <input type="text" name="cliente" class="form-control" readonly value="${cliente}"/>
                            </div>
                            <form class="col-md-8" action="controladorproyecto?accion=cambiarEstado" method="post">
                                <input type="hidden" name="faltantes" value="${faltantes}">
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
                <div class="card mt-3">

                    <div class="card-body">

                        <h1 class=" d-inline h4 ma-1 pl-2">Lista de funcionalidades del proyecto</h1>
                        <div class="row m-2" id="tablaRequerimiento">
                            <table class="table">
                                <thead class="thead-dark">
                                    <tr>
                                        <th style="width:100px; text-align: center">#</th>
                                        <th>Nombre</th>
                                        <th style="width:150px;">Situacion</th>
                                        <th style="width:100px;">Actualizar Situacion</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="lista" items="${funcionalidad}">

                                        <tr>
                                            <td style="width:100px; text-align: center">${lista.getIdfuncionalidad()}</td>
                                            <td>${lista.getNombre()}</td>
                                            <td>
                                                <input id="estado" type="text" value="${lista.getEstado()}" class="text-white text-center btn" style="width: 120px; border: none; input:hover{border: none}; background-color: #ed0025" readonly>
                                            </td>
                                            <td style="width:300px; text-align: center">
                                                <form action="controladorRequerimiento?accion=cambiarEstadoFunci" method="post">
                                                    <input type="hidden" name="idfun" value="${lista.getIdfuncionalidad()}">
                                                    <input type="hidden" name="dni" value="${trabajador.getDni()}">
                                                    <div class="d-flex">
                                                        <select name="estado" class="form-control">
                                                            <option value="PENDIENTE">PENDIENTE</option>
                                                            <option value="EN PROCESO">EN PROCESO</option>
                                                            <option value="REALIZADO">REALIZADO</option>
                                                        </select>
                                                        <button type="submit" class="btn btn-primary ml-1" >Guardar</button>
                                                    </div>
                                                </form>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="card-footer" style="background-color: white; height: 80px">
                        <div class="row m-2 float-right">
                            <div class="form-group ">
                                <a href="controladorproyecto?accion=trabajador&dni=${trabajador.getDni()}" class="btn btn-primary" style="width:200px;">Guardar</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <input type="hidden" id="mensaje" value="${mensaje}">
    </body>
    <script src="https://kit.fontawesome.com/ef7654b222.js" crossorigin="anonymous"></script>   
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="js/datatables.min.js" type="text/javascript"></script>
    <script src="js/DataTable.js" type="text/javascript"></script>
    <script >
                                            function validacion() {
                                                var faltare = document.getElementById("refaltantes").value;
                                                if (faltare > 0) {
                                                    var mensaje = document.getElementById("mensaje").value;
                                                    if (mensaje) {
                                                        Swal.fire({
                                                            icon: 'success',
                                                            title: msj,
                                                            showConfirmButton: true,
                                                            timer: 2000,
                                                            width: '30%'
                                                        });
                                                    }
                                                }
                                            }

                                            var msj = document.getElementById("mensaje").value;
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

