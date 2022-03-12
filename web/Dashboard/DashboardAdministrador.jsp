<%-- 
    Document   : admi-principal
    Created on : 21/02/2022, 09:10:55 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>JSP Page</title>
         <link href="css/admi-principal.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
    </head>
    <body>
   
    <div class="d-flex" >
        
        <section class="parte1 sticky-top ">
           <section  class="logo text-center  mt-2">
             <h2 class="text-white"><i class="fab fa-glide-g m-0"></i>Garzasoft
             </h2>
           </section>
            <section class="d-flex img ">
              <img  class=" bg-white rounded-circle" src="imagenes/img.1.png" width="60px" height="60px"/>
              <div class="lr" >
                  <div class="lr-1 text-center text-white">Bienvenido:</div>
                  <div class="lr-2 text-white">${administrador.getNombreadmi()}</div>
              </div>
            
            </section>
            <section class="s-menu">
              <div>
                  <a href="admi-principal.jsp">
                        <i class="las la-home"></i> 
                        <span>Inicio</span> 
                  </a> 
             </div>
              <div>
                  <a href="controladoradministrador?accion=perfil&idadministrador=${administrador.getIdadministrador()}">
                        <i class="las la-user"></i>
                        <span>Perfil</span> 
                  </a> 
             </div>
             <div>
                 <a href="#" class="dentro1" id="dentro1">
                        <i class="las la-file-alt"></i>
                        <span>Proyectos</span> 
                        <i class="las la-angle-right flecha" style="font-size:15px"></i>
                  </a> 
                  <section class="dentro1-1">
                   
                     <div>
                      <a href="#" > Estoy dentro</a>   
                       
                     </div>
                 
                      <div>
                      <a  href="a"> Estoy dentro</a>   
                       
                     </div>
                 </section>    
              </div>
             <div>
                  <a href="admi-clientes.jsp">
                        <i class="las la-users"></i>
                        <span>Clientes</span> 
                  </a> 
             </div>
              <div>
                  <a href="#">
                        <i class="las la-users"></i>
                        <span>Trabajadores</span> 
                  </a> 
              </div>
              
              <div>
                  <a href="validaradministrador?accion=cerrar">
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
                       <img class=" mr-2 rounded-circle" style="background: #566573"  src="imagenes/img.1.png" width="43px" height="43px" />${administrador.getNombreadmi()} ${administrador.getApellidosadmi()}
                    </a>
                    <div class="dropdown-menu dropdown-menu-right text-center submenu" aria-labelledby="navbarDropdownMenuLink ">
                      
                        <a class="dropdown-item text-center" href="controladoradministrador?accion=perfil&idadministrador=${administrador.getIdadministrador()}"><i class="las la-user" style="font-size:21px"></i> Perfil</a>
                       <div class="dropdown-divider"></div>
                       
                      <a class="dropdown-item" href="validaradministrador?accion=cerrar"> <i class="las la-power-off" style="font-size:20px" ></i> salir</a>
                    </div>
                  </li>
                </div>
              </div>
            </nav>

            
         </div>
         <!--vistas proyectos-->
          <div class=" cuerpo ">
          <div class="cuerpo2 d-flex"> 
            <div class="cards1">
             <div class="cards2 d-flex">
              <div class="card" style="width: 16rem;">
                  <div class="card-body d-flex">
                    <div class="pl-3 pr-3 tr-1">
                       <h1>54</h1>
                       <span>Proyectos</span>
                    </div>
                    <div class="tr-2">
                        <span class="las la-clipboard-list"></span>
                    </div>
                  </div>
              </div>
              <div class="card" style="width: 16rem;">
                  <div class="card-body d-flex">
                    <div class="pl-3 pr-3 tr-1">
                       <h1>54</h1>
                       <span>Trabajadores</span>
                    </div>
                    <div class="tr-2">
                        <span class="las la-users"></span>
                    </div>
                  </div>
              </div>
              <div class="card" style="width: 16rem;">
                  <div class="card-body d-flex">
                    <div class="pl-3 pr-3 tr-1">
                       <h1>54</h1>
                       <span>Clientes</span>
                    </div>
                    <div class="tr-2">
                        <span class="las la-users"></span>
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
                              <th scope="col">NOMBRE</th>
                              <th scope="col">INICIO</th>
                              <th scope="col">FIN</th>
                              <th scope="col">ESTADO</th>
                            </tr>
                          </thead>
                          <tbody>
                            <tr>
                              <td >Sistema Veterinario</td>
                              <td>19/02/2022</td>
                              <td>04/04/2022</td>
                              <td class="m-0 p-1">
                                  <div class="card  text-white bg-danger p-1 text-center" style="width: 7rem; font-weight:600; border: none">
                                  PENDIENTE
                                  </div>
                              </td>
                            </tr>
                            <tr>
                              <td>Sistema de Ventas</td>
                              <td>26/02/2022</td>
                              <td>16/05/2022</td>
                               <td class="m-0 p-1">
                                  <div class="card  text-white bg-success p-1 text-center" style="width: 7rem; font-weight:600; border: none">
                                  TERMINADO
                                  </div>
                              </td>
                            </tr>
                            <tr>
                              <td>Sistemas de Compras</td>
                              <td>30/02/2022</td>
                              <td>12/08/2022</td>
                               <td class="m-0 p-1">
                                  <div class="card  text-white bg-warning p-1 text-center" style="width: 7rem; font-weight:600; border: none">
                                  EN PROCESO
                                  </div>
                              </td>
                            </tr>
                              <tr>
                              <td>3</td>
                              <td>Larry</td>
                              <td>the Bird</td>
                              <td>@twitter</td>
                            </tr>
                              <tr>
                              <td>4</td>
                              <td>Larry</td>
                              <td>the Bird</td>
                              <td>@twitter</td>
                            </tr>
                            
                              <tr>
                              <td>4</td>
                              <td>Larry</td>
                              <td>the Bird</td>
                              <td>@twitter</td>
                            </tr>
                            
                          </tbody>
                        </table>
                  </div>
              </div>
              
            </div>
              
              
             <div class="card " style="width: 305px;">
              <div class="card-body p-0">
                <h5 class="card-title pt-3 pb-1 mt-2 text-center">Administrador</h5>
                 <div class="d-flex  p-2 mr-3 ml-3 trabajador">
                      <img  class=" rounded-circle  ml-2 mr-2" src="imagenes/icon2.png" width="50px" height="50px" style="background: #566573" />
                      <div class="pt-1 pl-1 pr-1 pb-1" >
                          <div class=" text-center ">Luis Angel</div>
                          <div class=" ">Antiguo </div>
                      </div>
            
                  </div>
                  <div class="d-flex  p-2 mr-3 ml-3 trabajador">
                      <img  class=" rounded-circle  ml-2 mr-2" src="imagenes/icon1.png" width="50px" height="50px" style="background: #566573" />
                      <div class="pt-1 pl-1 pr-1 pb-1" >
                          <div class=" text-center ">Andrea</div>
                          <div class=" ">Nueva</div>
                      </div>
            
                  </div>    
              </div>
            </div>
         </div>
    </div>
    <!--vistas proyectos-->
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
     <script >
     var lista=document.getElementById('dentro1');
    
      var lis=function(e){
         lista.classList.toggle('listo1');/*agrega clase*/
          var height=0;
          var menu =lista.nextElementSibling;/*seleciona su hermano ayacente*/
          console.log(menu.scrollHeight);/* ve el tamaño de menu*/
          if(menu.clientHeight=="0"){
             height=menu.scrollHeight; 
          };
          
          menu.style.height=height+"px";
      };
        
     lista.addEventListener('click',lis);
    
    </script>
    
    
</html>
