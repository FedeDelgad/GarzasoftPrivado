
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/DashboardCliente.css" rel="stylesheet" type="text/css"/>
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
                  <div class="lr-2 text-center text-white">${cliente.getNombrecli()}</div>
              </div>
            
            </section>
            <section class="s-menu">
              <div>
                  <a href="cli-principal.jsp">
                        <i class="las la-home"></i> 
                        <span>Inicio</span> 
                  </a> 
             </div>
              <div>
                  <a href="controladorcliente?accion=perfil&idcliente=${cliente.getIdcliente()}">
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
                  <a href="validarcliente?accion=cerrarCliente">
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
                       <img class=" mr-2 rounded-circle" style="background: #566573"  src="imagenes/icon2.png" width="43px" height="43px" />${cliente.getNombrecli()} ${cliente.getApellidocli()}
                    </a>
                    <div class="dropdown-menu dropdown-menu-right text-center submenu" aria-labelledby="navbarDropdownMenuLink ">
                        <a class="dropdown-item text-center" href="cli-perfil.jsp"><i class="las la-user" style="font-size:21px"></i> Perfil</a>
                       <div class="dropdown-divider"></div>
                       
                      <a class="dropdown-item" href="validarcliente?accion=cerrarCliente"> <i class="las la-power-off "style="font-size:20px"></i> salir</a>
                      
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
                    <h5 class="card-title">Proyectos</h5>
                    <table class="table">
                      <thead class="thead-light">
                        <tr >
                          <th  scope="col">NOMBRE</th>
                          <th scope="col">INICIO</th>
                          <th scope="col">FIN</th>
                          <th class="" scope="col">ESTADO</th>
                          <th scope="col"> VER DETALLE</th>
                        </tr>
                      </thead>
                      <tbody class="tbl-1" style="">
                        <tr>
                          <td>Sistemas de ventas</td>
                          <td>12/02/2022</td>
                          <td>03/07/2022</td>
                          <td class="m-0 p-1">
                              <div class="card  text-white bg-danger p-1 text-center" style="width: 7rem; font-weight:600; border: none">
                              PENDIENTE
                              </div>
                          </td>
                          <td class="m-0 p-2 ">
                            <button type="button" class="btn btn-primary m-0 p-0 pl-3 pr-3 pb-1 pt-1 ml-4" style="font-size: 22px"><i class="las la-eye"></i></button>
                          </td>
                        </tr>
                        <tr>
                          <td>Jacob</td>
                          <td>Thornton</td>
                          <td>Jacob</td>
                          <td>Thornton</td>
                          <td>@fat</td>
                        </tr>
                        <tr>
                           <td>Larry</td>
                          <td>the Bird</td>
                          <td>Larry</td>
                          <td>the Bird</td>
                          <td>@twitter</td>
                        </tr>
                          <tr>
                           <td>Larry</td>
                          <td>the Bird</td>
                          <td>Larry</td>
                          <td>the Bird</td>
                          <td>@twitter</td>
                        </tr>
                          <tr>
                           <td>Larry</td>
                          <td>the Bird</td>
                          <td>Larry</td>
                          <td>the Bird</td>
                          <td>@twitter</td>
                        </tr>
                        <tr>
                           <td>Larry</td>
                          <td>the Bird</td>
                          <td>Larry</td>
                          <td>the Bird</td>
                          <td>@twitter</td>
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
                       <h1>4</h1>
                       <span>Requerimientos</span>
                    </div>
                    <div class="tr-2 p-0">
                        <span class="las la-clipboard-list" ></span>
                    </div>
                   
                  </div>
             </div>
            <div class="card  " style="width: 17rem; height: 413px">
                  <div class="card-body bg-warning  " >
                    <div class=" text-center">
                    <h5 class="card-title text-white mt-2">TRABAJADOR A CARGO</h5>
                    <img  class=" bg-white mt-2 rounded-circle" src="imagenes/icon2.png" width="90px" height="90px"/>
                    <h5 class="text-white mt-3">Luis Fernando</h5>
                    <h5 class="text-white">Mechan LLontop</h5>
                    </div>
                    <div class="pl-5 pr-5">
                    <div class="mt-3 text-white"><i class="fa-solid fa-mobile-screen-button"></i>  :  951074151</div>
                    <div class="mt-2 text-white"><i class="fas fa-envelope-open-text"></i> : -------</div>
                    </div>
                  </div>
                 <div class="card-body " >
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
