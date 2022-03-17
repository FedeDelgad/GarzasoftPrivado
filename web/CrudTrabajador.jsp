<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="css/CrudTrabajador.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/dt-1.11.4/datatables.min.css"/>
        <title>Garzasoft/CrudTrabajador</title>
    </head>
    <body>     
        <div class=" cuerpo pl-4 pr-4 pt-4 pb-2 " >
            <div class=" d-inline h4 ma-1 pl-2 "><i class="fas fa-user"></i> Lista de Trabajador</div>
            <!--Modal Registrar-->
            <button type="button" class="btn text-white float-right btn-1 " data-toggle="modal" data-target="#nuevo"><i class="fas fa-plus"></i> Nuevo Trabajador</button>
            <div class="modal fade" id="nuevo" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content col-sm-11 p-0">
                        <div class="modal-header mod-h p-3 ">
                            <h4 class="modal-title  text-white" id="exampleModalLabel"><i class="fas fa-user"></i> Nuevo Trabajador</h4>
                            <div style="border: none" class="close  text-white mr-2" data-dismiss="modal" aria-label="Close">
                                &times;
                            </div>
                        </div>
                        <form  action="controladortrabajador?accion=agregar" method="post">
                            <div class="modal-body">
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="inputtext">Dni</label>
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <span style="font-size: 20px"class="input-group-text" ><i class="las la-address-card"></i></span>
                                            </div>
                                            <input type="text" class="form-control"  name="dni" autocomplete="off" required="true">
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="inputtext">Nombre</label>
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <span style="font-size: 20px"class="input-group-text"  ><i class="las la-user "></i></span>
                                            </div>
                                            <input type="text" class="form-control"  name="nombre" autocomplete="off" required="true">
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
                                            <input type="text" class="form-control"  name="apellido" autocomplete="off" required="true">
                                        </div>
                                    </div>  
                                    <div class="form-group col-md-6">
                                        <label for="inputtext">Telefono o Celular</label>
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <span style="font-size: 20px"class="input-group-text" ><i class="las la-phone-alt"></i></span>
                                            </div>
                                            <input type="text" class="form-control"  name="telefono" autocomplete="off" required="true">
                                        </div>
                                    </div> 
                                </div>
                                <div class="form-row">  
                                    <div class="form-group col-md-6">
                                        <label for="inputtext">Genero</label>
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <span style="font-size: 20px"class="input-group-text"  ><i class="las la-transgender"></i></span>
                                            </div>
                                            <select class="form-control" name="genero" >
                                                <option value="" >Seleccione...</option>
                                                <option value="hombre">Hombre</option>
                                                <option value="mujer" >Mujer</option>
                                            </select>
                                        </div>
                                    </div>                
                                    <div class="form-group col-md-6">
                                        <label for="inputtext">Contraseña</label>
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <span style="font-size: 20px"class="input-group-text"  ><i class="las la-key"></i></span>
                                            </div>
                                            <input type="password" class="form-control"  name="clave"  autocomplete="off" required="true">
                                        </div>
                                    </div> 
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-12">
                                        <label for="inputtext">Fecha de Ingreso</label>
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <span style="font-size: 20px"class="input-group-text" ><i class="las la-calendar"></i></span>
                                            </div>
                                            <input type="date" class="form-control" name="ingreso" autocomplete="off" required="true">
                                        </div>
                                    </div>
                                </div>    
                                <label for="inputtext">Correo</label>
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <span style="font-size: 20px"class="input-group-text"  ><i class="las la-at"></i></span>
                                    </div>
                                    <input type="text" class="form-control"  name="correo" autocomplete="off" required="true">
                                </div>
                                <button class="btn  btn-block mt-3 btn-1 text-white" >Registrar</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <hr class="mt-4" style="background: #1F618D">
            <div >
                <div class="card " style="border: none ">
                    <div class="card-body table-responsive">
                        <table id="datatable" class="table ">
                            <thead class="thead-light">
                                <tr>
                                    <th scope="col">DNI</th>
                                    <th scope="col">Nombres</th>
                                    <th scope="col">Apellidos</th>
                                    <th scope="col">Telefono</th>
                                    <th scope="col">Correo</th>
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
                                            <!--modal actualizar-->  
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
        </div>
    </body>
    <script src="https://kit.fontawesome.com/ef7654b222.js" crossorigin="anonymous"></script>   
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="js/datatables.min.js" type="text/javascript"></script>
    <script src="js/DataTable.js" type="text/javascript"></script>
</html>
