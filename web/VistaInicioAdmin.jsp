
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="css/VistaInicioAdmin.css" rel="stylesheet" type="text/css"/>
        <title>Inicio/Administrador</title>
    </head>
    <body style="background-color: #E5E7E9 ">
        <div class="container mt-4">
            <div class="cardBox">
                <div class="card">
                    <div class="card-body d-flex">
                        <div class="pl-3 pr-3 tr-1">
                            <h1>54</h1>
                            <span>Proyectos</span>
                        </div>
                        <div class="tr-2">
                            <ion-icon name="folder-open-outline"></ion-icon>
                        </div>
                    </div>
                </div>
                <div class="card">
                    <div class="card-body d-flex">
                        <div class="pl-3 pr-3 tr-1">
                            <h1>54</h1>
                            <span>Trabajadores</span>
                        </div>
                        <div class="tr-2" >
                            <ion-icon name="person-outline"></ion-icon>
                        </div>
                    </div>
                </div>
                <div class="card">
                    <div class="card-body d-flex">
                        <div class="pl-3 pr-3 tr-1">
                            <h1>54</h1>
                            <span>Clientes</span>
                        </div>
                        <div class="tr-2">
                            <ion-icon name="person-outline"></ion-icon>
                        </div>
                    </div>
                </div>
            </div>
            <div class="card" >
                <div class="card-body p- tabla-p">
                    <h5 class="card-title">Proyectos</h5>
                    <table class="table">
                        <thead class="thead-light">
                            <tr>
                                <th scope="col">Nombre</th>
                                <th scope="col">Inicio</th>
                                <th scope="col">Fin</th>
                                <th scope="col">Estado</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="lista" items="${listainicio}">
                                <tr>
                                    <td>${lista.getNombre()}</td>
                                    <td>${lista.getInicio()}</td>
                                    <td>${lista.getFin()}</td>
                                    <td class="m-0 p-1">
                                        <div class="card  text-white bg-danger p-1 text-center" style="width: 7rem; font-weight:600; border: none">${lista.getEstado()}</div>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</html>
