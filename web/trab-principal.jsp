<%-- 
    Document   : admi-principal
    Created on : 21/02/2022, 09:01:37 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
           <link href="css/trab-principal.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
    </head>
     <body>
        
    <div class="d-flex" >
        
        <section class="parte1 sticky-top ">
           <section  class="logo text-center  mt-2">
             <h2 class="text-white"><i class="fab fa-glide-g m-0"></i>Garzasoft
             </h2>
           </section>
            <section class="img  text-center">
              <img  class=" bg-white rounded-circle" src="imagenes/icon2.png" width="60px" height="60px"/>
              <div class="lr" >
                  <div class="lr-1 text-center text-white">Bienvenido:</div>
                  <div class="lr-2 text-center text-white">${trabajador.getNombre()} </div>
              </div>
            
            </section>
            <section class="s-menu">
              <div>
                  <a href="trab-principal.jsp">
                        <i class="las la-home"></i> 
                        <span>Inicio</span> 
                  </a> 
             </div>
              <div>
                  <a href="controladortrabajador?accion=perfil&idtrabajador=${trabajador.getIdtrabajador()}">
                        <i class="las la-user"></i>
                        <span>Perfil</span> 
                  </a> 
             </div>
             <div>
                  <a href="#">
                        <i class="las la-file-alt"></i>
                        <span>Proyecto</span> 
                  </a> 
             </div>
              <div>
                  <a href="validartrabajador?accion=cerrar">
                        <i class="las la-door-open"></i>
                        <span>Salir</span> 
                  </a> 
              </div>
            
            </section>
           
        </section>
        
        <section class="parte2">
         <div class=" cabecera sticky-top">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
              <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <div class="navbar-nav  ml-auto mr-3   "> 
                  <li class="nav-item dropdown  " style="background:">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="background:">
                       <img class=" mr-2 rounded-circle" style="background: #566573"  src="imagenes/icon2.png" width="43px" height="43px" />${trabajador.getNombre()} ${trabajador.getApellido()}
                    </a>
                    <div class="dropdown-menu dropdown-menu-right text-center submenu " aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item text-center" href="controladortrabajador?accion=perfil&idtrabajador=${trabajador.getIdtrabajador()}"><i class="las la-user" style="font-size:21px"></i> Perfil</a>
                       <div class="dropdown-divider"></div>
                       
                       <a class="dropdown-item" href="validartrabajador?accion=cerrar"> <i class="las la-power-off" style="font-size: 20px"></i> salir</a>
                    </div>
                  </li>
                </div>
              </div>
            </nav>

            
         </div>
          <div class=" cuerpo d-flex ">
            <div  class="cards" >
                 <div class="card " style="width:51rem;">
                  <div class="card-body pl-4 pr-4">
                    <h5 class="ml-2 mr-2 t-1"> <i class="las la-folder-open"></i> Nombre del Proyecto:</h5>
                    <div class=" d-flex">
                        <h3 class="mb-0 p-1 ml-5 ">SISTEMAS DE VENTAS</h3>
                        <div class="card  p-1 mb-1 text-white bg-danger ml-auto text-center" style="width: 7rem; font-weight:600; border: none">
                                      PENDIENTE
                         </div>  
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
                        <tr>
                          <td>Crud de clientes</td>
                          <td>12/02/2022</td>
                          <td>03/07/2022</td>
                          <td class="m-0 p-1">
                              <div class="card  text-white bg-danger p-1 text-center" style="width: 7rem; font-weight:600; border: none">
                              PENDIENTE
                              </div>
                          </td>
                        
                        </tr>
                        <tr>
                          <td>Jacob</td>
                          <td>Thornton</td>
                          <td>Jacob</td>
                          <td>Thornton</td>
                       
                        </tr>
                        <tr>
                           <td>Larry</td>
                          <td>the Bird</td>
                          <td>Larry</td>
                          <td>the Bird</td>
                          
                        </tr>
                          <tr>
                           <td>Larry</td>
                          <td>the Bird</td>
                          <td>Larry</td>
                          <td>the Bird</td>
                          
                        </tr>
                          <tr>
                           <td>Larry</td>
                          <td>the Bird</td>
                          <td>Larry</td>
                          <td>the Bird</td>
                          
                        </tr>
                        <tr>
                           <td>Larry</td>
                          <td>the Bird</td>
                          <td>Larry</td>
                          <td>the Bird</td>
                         
                        </tr>
                         
                         
                           
                         
                      </tbody>
                    </table>
                      
                   </div>
                </div> 
                 
             
                
                
            </div>
            <div>
             <div class="card  text-white" style="width: 17rem;background: cadetblue">
                  <div class="card-body  d-flex " >
                    <div class="pl-3 pr-3 ml-2 tr-1">
                       <h1>14</h1>
                       <span>Requerimientos</span>
                    </div>
                    <div class="tr-2 ml- pt-1">
                         <span class="las la-clipboard-list"></span>
                    </div>
                   
                  </div>
             </div>
             <div class="card  text-white bg-warning" style="width: 17rem;">
                  <div class="card-body  d-flex p-2 pl-3 " >
                    <div class="pl-3 pr-3 ml-2 pt-0 ">
                       <h1 class="p-0">4</h1>
                       <span >Requerimientos</span>
                        <span >Realizados</span>
                    </div>
                    <div class="tr-2 pt-1 pr-5 ">
                        <i class="las la-clipboard-check"></i>
                    </div>
                   
                  </div>
             </div>
              <div class="card  text-white bg-success" style="width: 17rem;">
                  <div class="card-body  d-flex p-2 pl-3 " >
                    <div class="pl-3 pr-3 ml-2 pt-0 ">
                       <h1 class="p-0">10</h1>
                       <span >Requerimientos</span>
                        <span >Faltantes</span>
                    </div>
                    <div class="tr-2 pt-1 pr-5 ">
                        <i class="las la-times-circle"></i>
                    </div>
                   
                  </div>
             </div>
            <div class="card  text-white bg-d" style="width: 17rem; ;height: 165px;background: #3498DB">
              <div class="card-body p-3 text-center  " >
                <div class="pl-3 pr-3 ml-2 tr-1 mb-1">
                   
                   <span>Fecha Limite del Proyecto</span>
                </div>
                <div class="tr-2 ml- pt-1 mb-2">
                    <span class="las la-calendar"></span>
                </div>
                <div class="pl-3 pr-3 ml-2 tr-1">  
                   <span>12/02/2022 - 24/08/2022</span>
                </div>
              </div>
             </div>
           
            </div>
         </div>
         </section>
    </div> 
     <input type="hidden" id="msj" value="${rpta1}">
                       
    </body>
   
    <script src="https://kit.fontawesome.com/ef7654b222.js" crossorigin="anonymous"></script>   
     <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
     <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
     <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
      <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
      <script >
          var msj=document.getElementById("msj").value;
          if(msj){
              Swal.fire({
                icon: 'success',
                title:msj,
               showConfirmButton: false,
               timer: 2000,
                width:'30%'
             });
          }
      </script>
</html>