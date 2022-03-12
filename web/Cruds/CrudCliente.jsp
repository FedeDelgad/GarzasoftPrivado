
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>JSP Page</title>
        <link href="../css/CrudTrabajador.css" rel="stylesheet" type="text/css"/>

        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.2/css/jquery.dataTables.css">
        <link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
    </head>
    <body>

        <!--crudCliente-->
        <div class=" cuerpo  pl-4 pr-4 pt-4 pb-2 ">
            <div class=" d-inline h4 ma-1 pl-2 "><i class="fas fa-user"></i> Lista de Clientes</div>     
            <button type="button" class="btn text-white float-right btn-1 " data-toggle="modal" data-target="#nuevo">
                <i class="fas fa-plus"></i> Nuevo Cliente
            </button>
            <hr class="mt-4" style="background: #1F618D">

            <div class="card " style=" " >
                <div class="card-body p-3">
                    <table id="datatable" class="table ">
                        <thead class="thead-light">
                            <tr>
                                <th scope="col">DNI</th>
                                <th scope="col">NOMBRES</th>
                                <th scope="col">APELLIDOS</th>
                                <th scope="col">TELEFONO</th>
                                <th scope="col">CORREO</th>
                                <th scope="col">ESTADO</th>
                                <th scope="col">ACCIONES</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr class="pb-5">
                                <td >Mark</td>
                                <td >Mark</td>
                                <td >Otto</td>
                                <td >@mdo</td>
                                <td >Mark</td>
                                <td >Otto</td>
                                <td  >
                                    <!--boton actualizar-->
                                    <a class="btn btn-warning text-white " style="font-size: 17px" id="actualizar" data-toggle="modal" data-target="#nuevo2"><i class="fas fa-edit"></i></a>  
                                    <!--boton actualizar--> 

                                    <!--modal actualizar-->  
                                    <div class="modal fade" id="nuevo2" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                        <div class="modal-dialog" role="document">
                                            <div class="modal-content col-sm-11 p-0">
                                                <div class="modal-header mod-h p-3 ">
                                                    <h4 class="modal-title  text-white mt-4 mb-2 ml-3  " id="exampleModalLabel"><i class="fas fa-user"></i> Actualizar Cliente</h4>
                                                    <div style="border: none" class="close  text-white mr-2" data-dismiss="modal" aria-label="Close">
                                                        &times;
                                                    </div>

                                                </div>
                                                <form  action="controlador?menu=cliente" method="post" novalidate>
                                                    <div class="modal-body mr-2  mb-2 ml-2">
                                                        <div class="form-row">
                                                            <div class="form-group col-md-6">
                                                                <label for="inputtext">Dni</label>
                                                                <div class="input-group">
                                                                    <div class="input-group-prepend">
                                                                        <span style="font-size: 20px"class="input-group-text" ><i class="las la-address-card"></i></span>
                                                                    </div>
                                                                    <input type="text" class="form-control"  name="dni" placeholder="Dni" readonly>
                                                                </div>
                                                            </div>
                                                            <div class="form-group col-md-6">
                                                                <label for="inputtext">Nombre</label>
                                                                <div class="input-group">
                                                                    <div class="input-group-prepend">
                                                                        <span style="font-size: 20px"class="input-group-text"  ><i class="las la-user "></i></span>
                                                                    </div>
                                                                    <input type="text" class="form-control"  name="nombre" placeholder="Nombre" readonly>
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
                                                                    <input type="text" class="form-control"  name="apellido" placeholder="Apellido" readonly>
                                                                </div>
                                                            </div>  
                                                            <div class="form-group col-md-6">
                                                                <label for="inputtext">Telefono o Celular</label>
                                                                <div class="input-group">
                                                                    <div class="input-group-prepend">
                                                                        <span style="font-size: 20px"class="input-group-text" ><i class="las la-phone-alt"></i></span>
                                                                    </div>
                                                                    <input type="text" class="form-control"  name="telefono" placeholder="Telefono">
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
                                                                    <input type="text" class="form-control"  name="Sexo" placeholder="Sexo" readonly>
                                                                </div>
                                                            </div>                
                                                            <div class="form-group col-md-6">
                                                                <label for="inputtext">Fecha de Ingreso</label>
                                                                <div class="input-group">
                                                                    <div class="input-group-prepend">
                                                                        <span style="font-size: 20px"class="input-group-text" ><i class="las la-calendar"></i></span>
                                                                    </div>
                                                                    <input type="text" class="form-control" name="fecha" placeholder="fecha" readonly >
                                                                </div>
                                                            </div>

                                                        </div>
                                                        <div class="form-row">
                                                            <div class="form-group col-md-6">
                                                                <label for="inputtext">Contraseña</label>
                                                                <div class="input-group">
                                                                    <div class="input-group-prepend">
                                                                        <span style="font-size: 20px"class="input-group-text"  ><i class="las la-key"></i></span>
                                                                    </div>
                                                                    <input type="password" class="form-control"  name="contra" placeholder="Contraseña" readonly>
                                                                </div>
                                                            </div> 

                                                            <div class="form-group col-md-6">
                                                                <label for="inputtext">Contraseña</label>
                                                                <div class="input-group">
                                                                    <div class="input-group-prepend">
                                                                        <span style="font-size: 20px"class="input-group-text"  ><i class="las la-key"></i></span>
                                                                    </div>
                                                                    <input type="password" class="form-control"  name="contra" placeholder="Contraseña" readonly>
                                                                </div>
                                                            </div> 
                                                        </div>    
                                                        <label for="inputtext">Correo</label>
                                                        <div class="input-group">
                                                            <div class="input-group-prepend">
                                                                <span style="font-size: 20px"class="input-group-text"  ><i class="las la-at"></i></span>
                                                            </div>
                                                            <input type="text" class="form-control"  name="correo" placeholder="Correo">
                                                        </div>


                                                        <button type="submit" name="accion" value="agregar" class="btn  btn-block mt-4 mb-4 btn-1 text-white" >Actualizar</button>


                                                    </div>

                                                </form>
                                            </div>
                                        </div>
                                    </div>


                                    <!--modal  actualizar-->  


                                    <a href="#" class="btn btn-danger text-white ml-1 "style="font-size: 17px"><i class="fas fa-trash-alt"></i></a>

                                </td>
                            </tr>

                        </tbody>
                    </table>
                </div>
            </div>
            <!--Modal Registrar-->
            <div class="modal fade" id="nuevo" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content col-sm-11 p-0">
                        <div class="modal-header mod-h p-3 ">
                            <h4 class="modal-title  text-white mt-4 mb-2 ml-3  " id="exampleModalLabel"><i class="fas fa-user"></i> Nuevo Cliente</h4>
                            <div style="border: none" class="close  text-white mr-2" data-dismiss="modal" aria-label="Close">
                                &times;
                            </div>

                        </div>
                        <form  action="controlador?menu=cliente" method="post" novalidate>
                            <div class="modal-body mr-2  mb-2 ml-2">
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="inputtext">Dni</label>
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <span style="font-size: 20px"class="input-group-text" ><i class="las la-address-card"></i></span>
                                            </div>
                                            <input type="text" class="form-control"  name="dni" placeholder="Dni">
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="inputtext">Nombre</label>
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <span style="font-size: 20px"class="input-group-text"  ><i class="las la-user "></i></span>
                                            </div>
                                            <input type="text" class="form-control"  name="nombre" placeholder="Nombre">
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
                                            <input type="text" class="form-control"  name="apellido" placeholder="Apellido">
                                        </div>
                                    </div>  
                                    <div class="form-group col-md-6">
                                        <label for="inputtext">Telefono o Celular</label>
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <span style="font-size: 20px"class="input-group-text" ><i class="las la-phone-alt"></i></span>
                                            </div>
                                            <input type="text" class="form-control"  name="telefono" placeholder="Telefono">
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
                                        <label for="inputtext">Fecha de Ingreso</label>
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <span style="font-size: 20px"class="input-group-text" ><i class="las la-calendar"></i></span>
                                            </div>
                                            <input type="date" class="form-control" name="fecha" >
                                        </div>
                                    </div>

                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="inputtext">Contraseña</label>
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <span style="font-size: 20px"class="input-group-text"  ><i class="las la-key"></i></span>
                                            </div>
                                            <input type="password" class="form-control"  name="contra" placeholder="Contraseña">
                                        </div>
                                    </div> 

                                    <div class="form-group col-md-6">
                                        <label for="inputtext">Contraseña</label>
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <span style="font-size: 20px"class="input-group-text"  ><i class="las la-key"></i></span>
                                            </div>
                                            <input type="password" class="form-control"  name="contra" placeholder="Contraseña">
                                        </div>
                                    </div> 
                                </div>    
                                <label for="inputtext">Correo</label>
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <span style="font-size: 20px"class="input-group-text"  ><i class="las la-at"></i></span>
                                    </div>
                                    <input type="text" class="form-control"  name="correo" placeholder="Correo">
                                </div>


                                <button type="submit" name="accion" value="agregar" class="btn  btn-block mt-4 mb-4 btn-1 text-white" >Registrar</button>


                            </div>

                        </form>
                    </div>
                </div>
            </div>

            <!--Modal Registrar-->     
        </div>
        <!--crudCliente-->
    </body>
    <script src="https://kit.fontawesome.com/ef7654b222.js" crossorigin="anonymous"></script>   
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.2/js/jquery.dataTables.js"></script>
    <script >
        $(document).ready(function () {
            $('#datatable').DataTable({
                "language": {
                    "lengthMenu": "Mostrar _MENU_ Registros por paginas",
                    "zeroRecords": "Nada encontrado - disculpa",
                    "info": "Mostrando la pagina _PAGE_ de _PAGES_",
                    "infoEmpty": "No records available",
                    "infoFiltered": "(Filtrado de _MAX_ Registros Totales)",
                    "search": "Buscar:",
                    "paginate": {
                        "next": "Siguiente",
                        "previous": "Anterior"
                    }

                }
            });
        });
    </script>
    <script >
        var lista = document.getElementById('dentro1');

        var lis = function (e) {
            lista.classList.toggle('listo1');/*agrega clase*/
            var height = 0;
            var menu = lista.nextElementSibling;/*seleciona su hermano ayacente*/
            console.log(menu.scrollHeight);/* ve el tamaño de menu*/
            if (menu.clientHeight == "0") {
                height = menu.scrollHeight;
            }
            ;

            menu.style.height = height + "px";
        };

        lista.addEventListener('click', lis);

    </script>

</html>
