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
        <div class=" pl-4 pr-4 pt-4 pb-2 " >
            <div class=" d-inline h4 ma-1 pl-2 ">Proyectos de Desarrollo Nuevos</div>
            <button class="btn text-white float-right btn-1" onclick="formulario()"><i class="fas fa-plus"></i> Agregar Nuevo</button>

            <hr class="mt-4" style="background: #1F618D">

            <div class="card" id="formulario">
                <div class="card-body">
                    <div class="form-row">
                        <div class="col-md-4 form-group">
                            <label>Nombre</label>
                            <input type="text" name="nombreProyecto" class="form-control" placeholder="Sistema Ventas">
                        </div>
                        <div class="form-group col-md-4">
                            <label>Fecha de Inicio</label>
                            <input type="date" name="fechaInicio" class="form-control">
                        </div>
                        <div class="form-group col-md-4">
                            <label>Fecha de Finalizacion</label>
                            <input type="date" name="fechaInicio" class="form-control">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-md-4 form-group d-flex">
                            <input class="form-control" type="text" placeholder="Agrege Requerimientos">
                            <button type="button" class="btn text-white ml-1 btn-1" data-toggle="modal" data-target="#requerimientos">Agregar</button>

                            <div class="modal fade" id="requerimientos" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog modal-lg" role="document" style="width:1000px">
                                    <div class="modal-content ">
                                        <div class="modal-header mod-h p-3 ">
                                            <h4 class="modal-title  text-white" id="exampleModalLabel">Agregue los Requerimientos Funcionales</h4>
                                            <div style="border: none" class="close  text-white mr-2" data-dismiss="modal" aria-label="Close">
                                                &times;
                                            </div>
                                        </div>
                                        <div class="modal-body">
                                            <div class="form-group">
                                                <label for="inputtext">Nombre</label>
                                                <div class="d-flex">
                                                    <input type="text" class="form-control"  name="dni" autocomplete="off" required="true">
                                                    <button type="submit" class="btn btn-primary ml-2">Agregar</button>
                                                </div>
                                            </div>
                                            </form>
                                            <div class=" table-responsive">
                                                <table class="table">
                                                    <thead class="thead-light">
                                                        <tr>
                                                            <th class="col-r">Numero</th>
                                                            <th class="col-r text-center">Nombre</th>
                                                            <th class="col-r">Acciones</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr>
                                                            <td class="col-r">1</td>
                                                            <td class="col-r text-center">Agregar cliente</td>
                                                            <td class="col-r">
                                                                <a href="#" class="btn btn-warning text-white " style="font-size: 17px" id="actualizar"><i class="fas fa-edit"></i></a>
                                                                <a href="#" class="btn btn-danger text-white"style="font-size: 17px"><i class="fas fa-trash-alt"></i></a>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td class="col-r">2</td>
                                                            <td class="col-r text-center">Modificar Cliente</td>
                                                            <td class="col-r">
                                                                <a href="#" class="btn btn-warning text-white " style="font-size: 17px" id="actualizar"><i class="fas fa-edit"></i></a>
                                                                <a href="#" class="btn btn-danger text-white"style="font-size: 17px"><i class="fas fa-trash-alt"></i></a>
                                                            </td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4 form-group d-flex">
                            <input class="form-control" type="text" placeholder="Asigne el trabajador">
                            <a href="controladortrabajador?accion=agregarproyecto" class="btn text-white ml-1 btn-1" data-toggle="modal" data-target="#trabajador">Seleccionar</a>

                            <div class="modal fade" id="trabajador" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog modal-lg" role="document" style="width:1000px">
                                    <div class="modal-content ">
                                        <div class="modal-header mod-h p-3 ">
                                            <h4 class="modal-title  text-white" id="exampleModalLabel">Trabajadores Disponibles</h4>
                                            <div style="border: none" class="close  text-white mr-2" data-dismiss="modal" aria-label="Close">
                                                &times;
                                            </div>
                                        </div>
                                        <div class="modal-body">
                                            <div class=" table-responsive">
                                                <table class="table">
                                                    <thead class="thead-light">
                                                        <tr>
                                                            <th class="col-r text-center">DNI</th>
                                                            <th class="col-r text-center">Nombre</th>
                                                            <th class="col-r text-center">Condicion</th>
                                                            <th class="col-r">Seleccionar</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach var="lista" items="${listaTrabajadorpro}">
                                                            <tr>
                                                                <td class="col-r text-center">${lista.getDni()}</td>
                                                                <td class="col-r text-center">${lista.getNombre()}</td>
                                                                <td class="col-r text-center">${lista.getCondicion()}</td>
                                                                <td><button type="button" class="btn btn-primary text-center">Seleccionar</button></td>
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

                        <div class="col-md-4 form-group d-flex">
                            <input class="form-control" type="text" placeholder="Asigne el Cliente">
                            <button type="button" class="btn text-white ml-1 btn-1" data-toggle="modal" data-target="#cliente">Seleccionar</button>

                            <div class="modal fade" id="cliente" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog modal-lg" role="document" style="width:1000px">
                                    <div class="modal-content ">
                                        <div class="modal-header mod-h p-3 ">
                                            <h4 class="modal-title  text-white" id="exampleModalLabel">Trabajadores Disponibles</h4>
                                            <div style="border: none" class="close  text-white mr-2" data-dismiss="modal" aria-label="Close">
                                                &times;
                                            </div>
                                        </div>
                                        <div class="modal-body">
                                            <div class=" table-responsive">
                                                <table class="table">
                                                    <thead class="thead-light">
                                                        <tr>
                                                            <th class="col-r text-center">DNI</th>
                                                            <th class="col-r">Nombre</th>
                                                            <th class="col-r">Condicion</th>
                                                            <th class="col-r">Seleccionar</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr>
                                                            <td class="col-r text-center">12345678</td>
                                                            <td class="col-r">Maria morales</td>
                                                            <td class="col-r">Nuevo</td>
                                                            <td><button type="button" class="btn btn-primary">Seleccionar</button></td>
                                                        </tr>
                                                        <tr>
                                                            <td class="col-r text-center">55667788</td>
                                                            <td class="col-r">Juan Delgado</td>
                                                            <td class="col-r">Antiguo</td>
                                                            <td><button type="button" class="btn btn-primary">Seleccionar</button></td>                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>


                </div>
                <div class="card-footer">
                    <div class="row">
                        <div class="form-group">
                            <button type="submit" class="btn btn-1 text-white mr-1 " style="width:200px;" onclick="tablaDatos()">Guardar</button>
                        </div>
                    </div>
                </div>
            </div>



            <!--tabla de datos-->
            <div class="card mt-3" style="border: none " id="tabladatos">
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
                            <c:forEach var="lista" items="${listaTrabajador}">
                                <tr>
                                    <td>${lista.getDni()}</td>
                                    <td>${lista.getNombre()}</td>
                                    <td>${lista.getApellido()}</td>
                                    <td>${lista.getTelefono()}</td>
                                    <td>${lista.getCorreo()}</td>
                                    <td>${lista.getCondicion()}</td>
                                    <td  >
                                        <a class="btn btn-warning text-white " style="font-size: 17px" id="actualizar" data-toggle="modal" data-target="#modificar${lista.getIdtrabajador()}"><i class="fas fa-edit"></i></a>  
                                        <div class="modal fade" id="modificar${lista.getIdtrabajador()}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                            <div class="modal-dialog" role="document">
                                                <div class="modal-content col-sm-11 p-0">
                                                    <div class="modal-header mod-h p-3 ">
                                                        <h4 class="modal-title  text-white"><i class="fas fa-user"></i> Actualizar Trabajador</h4>
                                                        <div style="border: none" class="close  text-white mr-2" data-dismiss="modal" aria-label="Close">
                                                            &times;
                                                        </div>
                                                    </div>
                                                    <form  action="controladortrabajador?accion=modificar" method="post">
                                                        <div class="modal-body">
                                                            <input type="hidden" name="id" value="${lista.getIdtrabajador()}">
                                                            <div class="form-row">
                                                                <div class="form-group col-md-6">
                                                                    <label for="inputtext">Dni</label>
                                                                    <div class="input-group">
                                                                        <div class="input-group-prepend">
                                                                            <span style="font-size: 20px"class="input-group-text" ><i class="las la-address-card"></i></span>
                                                                        </div>
                                                                        <input type="text" class="form-control"  name="dni" autocomplete="off" required="true" value="${lista.getDni()}">
                                                                    </div>
                                                                </div>
                                                                <div class="form-group col-md-6">
                                                                    <label for="inputtext">Nombre</label>
                                                                    <div class="input-group">
                                                                        <div class="input-group-prepend">
                                                                            <span style="font-size: 20px"class="input-group-text"  ><i class="las la-user "></i></span>
                                                                        </div>
                                                                        <input type="text" class="form-control"  name="nombre" autocomplete="off" required="true" value="${lista.getNombre()}">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="form-row">
                                                                <div class="form-group col-md-6">
                                                                    <label for="inputtext">Apellido</label>
                                                                    <div class="input-group">
                                                                        <div class="input-group-prepend">
                                                                            <span style="font-size: 20px"class="input-group-text" ><i class="las la-user "></i></span>
                                                                        </div>
                                                                        <input type="text" class="form-control"  name="apellido" autocomplete="off" required="true" value="${lista.getApellido()}">
                                                                    </div>
                                                                </div>  
                                                                <div class="form-group col-md-6">
                                                                    <label for="inputtext">Telefono o Celular</label>
                                                                    <div class="input-group">
                                                                        <div class="input-group-prepend">
                                                                            <span style="font-size: 20px"class="input-group-text" ><i class="las la-phone-alt"></i></span>
                                                                        </div>
                                                                        <input type="text" class="form-control" name="telefono" autocomplete="off" required="true" value="${lista.getTelefono()}">
                                                                    </div>
                                                                </div> 
                                                            </div>
                                                            <div class="form-row">  
                                                                <div class="form-group col-md-6">
                                                                    <label for="inputtext">Genero</label>
                                                                    <div class="input-group">
                                                                        <div class="input-group-prepend">
                                                                            <span style="font-size: 20px"class="input-group-text" ><i class="las la-transgender"></i></span>
                                                                        </div>
                                                                        <input type="text" class="form-control" name="genero" readonly autocomplete="off" required="true" value="${lista.getSexo()}">
                                                                    </div>
                                                                </div>                
                                                                <div class="form-group col-md-6">
                                                                    <label for="inputtext">Fecha de Ingreso</label>
                                                                    <div class="input-group">
                                                                        <div class="input-group-prepend">
                                                                            <span style="font-size: 20px"class="input-group-text" ><i class="las la-calendar"></i></span>
                                                                        </div>
                                                                        <input type="text" class="form-control" name="ingreso" autocomplete="off" required="true" value="${lista.getIngreso()}">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <label for="inputtext">Correo</label>
                                                            <div class="input-group">
                                                                <div class="input-group-prepend">
                                                                    <span style="font-size: 20px"class="input-group-text"  ><i class="las la-at"></i></span>
                                                                </div>
                                                                <input type="text" class="form-control"  name="correo" autocomplete="off" required="true" value="${lista.getCorreo()}">
                                                            </div>
                                                            <button type="submit" class="btn  btn-block mt-3 btn-1 text-white" >Actualizar</button>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                        <a href="controladortrabajador?accion=eliminar&id=${lista.getIdtrabajador()}" class="btn btn-danger text-white ml-1 "style="font-size: 17px"><i class="fas fa-trash-alt"></i></a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
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

