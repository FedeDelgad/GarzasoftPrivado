<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/VistaInicioTrabajador.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
        <title>Dashboard/Trabajador</title>
    </head>
    <body onload="Color()">
        <div class=" cuerpo d-flex ">
            <div  class="cards" >
                <div class="card " style="width:51rem;">
                    <div class="card-body pl-4 pr-4">
                        <h5 class="ml-2 mr-2 t-1"> <i class="las la-folder-open"></i> Nombre del Proyecto:</h5>
                        <div class=" d-flex">
                            <h3 class="mb-0 p-1 ml-1">${nombreproyecto}</h3>
                            <div class="card  p-1 mb-1 text-white bg-danger ml-auto text-center" style="width: 7rem; font-weight:600; border: none">${estadopro}</div>  
                        </div>
                    </div>
                </div>
                <div class="card over" style="width:51rem">
                    <div class="card-body ">
                        <h5 class="card-title">Requerimientos</h5>
                        <table class="table">
                            <thead class="thead-light">
                                <tr >
                                    <th  scope="col">NOMBRE</th>
                                    <th scope="col">INICIO</th>
                                    <th scope="col">FIN</th>
                                    <th class="" scope="col">ESTADO</th>
                                </tr>
                            </thead>
                            <tbody class="tbl-1" style="">
                                <c:forEach var="lista" items="${requerimientos}">
                                    <tr>
                                        <td>${lista.getNombre()}</td>
                                        <td>${inicio}</td>
                                        <td>${fin}</td>
                                        <td class="m-0 p-1">
                                            <input id="estado" type="text" value="${lista.getEstado()}" class="text-white text-center btn" style="width: 120px; border: none; input:hover{border: none}; background-color: #ed0025" readonly>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div> 
            </div>
            <div>
                <div class="card  text-white bg-warning" style="width: 16rem;">
                    <div class="card-body  d-flex " >
                        <div class="pl-3 pr-3 ml-2 tr-1">
                            <h2>${totalre}</h2>
                            <span>Requerimientos</span>
                        </div>
                        <div class="tr-2 pt-1">
                            <span class="las la-clipboard-list"></span>
                        </div>
                    </div>
                </div>
                <div class="card  text-white bg-success" style="width: 16rem;">
                    <div class="card-body  d-flex p-2 pl-3 " >
                        <div class="pl-3 pr-3 ml-2 pt-0 ">
                            <h2 class="p-0">${realizados}</h2>
                            <span >Requerimientos</span>
                            <span >Realizados</span>
                        </div>
                        <div class="tr-2 pt-1 pr-5 ">
                            <i class="las la-clipboard-check"></i>
                        </div>
                    </div>
                </div>
                <div class="card  text-white " style="width: 16rem;background-color: #ed0025">
                    <div class="card-body  d-flex p-2 pl-3 " >
                        <div class="pl-3 pr-3 ml-2 pt-0 ">
                            <h2 class="p-0">${faltantes}</h2>
                            <span >Requerimientos</span>
                            <span >Faltantes</span>
                        </div>
                        <div class="tr-2 pt-1 pr-5 ">
                            <i class="las la-times-circle"></i>
                        </div>
                    </div>
                </div>
                <div class="card  text-white bg-d" style="width: 16rem; ;height: 165px;background: #3498DB">
                    <div class="card-body p-3 text-center  " >
                        <div class="pl-3 pr-3 ml-2 tr-1 mb-1">
                            <span>Fecha Limite del Proyecto</span>
                        </div>
                        <div class="tr-2 ">
                            <span class="las la-calendar"></span>
                        </div>
                        <div class="pl-3 pr-3 ml-2 tr-1">  
                            <span>${inicio} - ${fin}</span>
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
    <script type="text/javascript">
        function Color() {
            var estadoColor = document.getElementById('estado');
            if (estadoColor.value === 'REALIZADO') {
                estadoColor.style.backgroundColor = '#44DF0A';
            }else if(estadoColor.value === 'REALIZADO'){
                estadoColor.style.backgroundColor = '#F1C40F';
            }
        }

    </script>
</html>
