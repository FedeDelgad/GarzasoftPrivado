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
        <div class="container mt-4">
            <div class="d-inline h4 ma-1 pl-2">Proyectos de Desarrollo Nuevos</div>
            <hr class="mt-4" style="background: #1f618d" />
            <div class="card">
                <form action="controladordesarrollo?accion=agregarNuevo" method="post">
                    <div class="card-body">
                        <div class="form-row">
                            <div class="col-md-4 form-group">
                                <label>Nombre</label>
                                <input type="text" name="nombreproyecto" class="form-control" required="true"/>
                            </div>
                            <div class="form-group col-md-4">
                                <label>Fecha de Inicio</label>
                                <input type="date" name="inicio" class="form-control" required="true"/>
                            </div>
                            <div class="form-group col-md-4">
                                <label>Fecha de Finalizacion</label>
                                <input type="date" name="fin" class="form-control" required="true"/>
                            </div>
                        </div>
                        <div class="row" style="margin-bottom: -15px;">
                            <div class="form-group col-md-6">
                                <label >Asigne el trabajador</label>
                            </div>
                            <div class="form-group col-md-6">
                                <label >Seleccione el Cliente</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-md-6 d-flex">
                                <label id="respuestatra" class="form-control"style="height: 40px;"></label>
                                <button type="button" class="btn btn-primary ml-2" data-toggle="modal" data-target="#trabajador" style="height: 40px;">Selecionar</button>
                                <!--ventana modal con los datos del trabajador-->
                                <div class="modal fade" id="trabajador" tabindex="-1" aria-hidden="true">
                                    <div class="modal-dialog modal-lg">
                                        <div class="modal-content">
                                            <div class="modal-header bg-primary text-white">
                                                <h5 class="modal-title" id="staticBackdropLabel">Listar de Trabajadores</h5>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body">
                                                <table class="table">
                                                    <thead class="thead-dark">
                                                        <tr>
                                                            <th style="width: 20px">#</th>
                                                            <th>DNI</th>
                                                            <th>Nombre</th>
                                                            <th>Apellido</th>
                                                            <th>Condicion</th>
                                                            <th>Seleccionar</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach var="lista" items="${listaTrabajador}">
                                                            <tr>
                                                                <td style="width: 20px">${lista.getIdtrabajador()}</td>
                                                                <td>${lista.getDni()}</td>
                                                                <td>${lista.getNombre()}</td>
                                                                <td>${lista.getApellido()}</td>
                                                                <td>${lista.getCondicion()}</td>
                                                                <td>
                                                                    <button type="button"  class="btn btn-primary" onclick="capturartrabajador(this)">Seleccionar</button>
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group col-md-6 d-flex">
                                <label id="respuestacli" class="form-control"style="height: 40px;"></label>
                                <button type="button" class="btn btn-primary ml-2" data-toggle="modal" data-target="#cliente" style="height: 40px;">Selecionar</button>
                                <!--ventana modal con los datos del cliente-->
                                <div class="modal fade" id="cliente" tabindex="-1" aria-hidden="true">
                                    <div class="modal-dialog modal-lg">
                                        <div class="modal-content">
                                            <div class="modal-header bg-primary text-white">
                                                <h5 class="modal-title" id="staticBackdropLabel">Listar de Trabajadores</h5>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body">
                                                <table class="table">
                                                    <thead class="thead-dark">
                                                        <tr>
                                                            <th style="width: 20px">#</th>
                                                            <th>DNI</th>
                                                            <th>Nombre</th>
                                                            <th>Apellido</th>
                                                            <th>Condicion</th>
                                                            <th>Seleccionar</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach var="lista" items="${listaCliente}">
                                                            <tr>
                                                                <td style="width: 20px">${lista.getIdcliente()}</td>
                                                                <td>${lista.getDnicli()}</td>
                                                                <td>${lista.getNombrecli()}</td>
                                                                <td>${lista.getApellidocli()}</td>
                                                                <td>${lista.getCondicioncli()}</td>
                                                                <td>
                                                                    <button type="button"  class="btn btn-primary" onclick="capturarcliente(this)">Seleccionar</button>
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card-footer" style="background-color: white; ">
                        <div class="row float-right" >
                            <div class="form-group mr-2">
                                <button type="submit" class="btn btn-primary" style="width: 200px">Guardar</button>
                            </div>
                        </div>
                    </div>
                </form>
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

