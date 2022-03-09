<%-- 
    Document   : admi-perfil
    Created on : 24/02/2022, 07:17:22 PM
    Author     : hp
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>JSP Page</title>
         <link href="css/admi-perfil.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
    </head>
    <body>
   <input type="hidden" id="msj2" value="${rpta}">
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
                  <a href="controladoradministrador?accion=perfil&idadministrador=${administrador.getIdadministrador()}" >
                        <i class="las la-user"></i>
                        <span>Perfil</span> 
                  </a> 
             </div>
             <div>
                 <a  class="dentro1" id="dentro1">
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
          <div class=" cuerpo pl-4 pr-4 pt-4 pb-2 ">
              <div class="ma-1 h4 pt-1 pb-3 ml- mr-"><i class="fas fa-user"></i> Perfil  del Usuario</div>
              <section class="d-flex cards" style="justify-content: center">
                <div class="card p-3" style="width: 47rem;">
                 <div class="card-body">
                      <h5 class="card-title mt-3 mb-4"><i class="fa-solid fa-user-pen"></i> Datos Personales</h5>
                      <form action="controladoradministrador">
                          <input type="hidden" name="idadministrador" value="${administrador.getIdadministrador()}">
                          <input  type="hidden" name="clave" id="clave" value="${administrador.getClaveadmi()}">
                          <div class="form-row">
                            <div class="form-group col-md-6">
                              <label for="idnombre" class=" pb-1 ">Nombres : </label>
                              <input type="text" class="pb-1 pt-1 pl-2 pr-2 w-100 m-1 read" id="idnombre" value="${unadministrador.getNombreadmi()}" readonly>
                            </div>
                            <div class="form-group col-md-6">
                              <label for="idapellido" class=" pb-1 ">Apellidos : </label>
                              <input type="text" class="pb-1 pt-1 pl-2 pr-2 w-100 m-1 read" id="idapellido" value="${unadministrador.getApellidosadmi()}" readonly>
                            </div>
                          </div>
                         <div class="form-row">
                            <div class="form-group col-md-6">
                              <label for="iddni" class=" pb-1 " >Dni : </label>
                              <input type="text" class="pb-1 pt-1 pl-2 pr-2 w-100 m-1 read" id="iddni" value="${unadministrador.getDniadmi()}" readonly>
                            </div>
                            <div class="form-group col-md-6">
                              <label for="idtelefono" class=" pb-1 " >Telefono : </label>
                              <input type="text" class="pb-1 pt-1 pl-2 pr-2 w-100 m-1" id="idtelefoni" name="telefono" value="${unadministrador.getTelefonoadmi()}">
                            </div>
                          </div>
                          <div class="form-group ">
                              <label for="idcorreo" class=" pb-1 ">Correo : </label>
                              <input type="text" class="pb-1 pt-1 pl-2 pr-2 w-100 m-1" id="idcorreo" name="correo" value="${unadministrador.getCorreoadmi()}">
                          </div>
                         <h5 class="card-title mb-4" style="margin-top: 33px"><i class="fa-solid fa-lock"></i> Cambiar Contraseña</h5>
                         <div class="form-row">
                          <p class="card-text pt-2 pb-3 pl-3 pr-3">Para actualizar la contraseña de esta cuenta debera ingresar la contraseña actual, una nueva y volverla a escribir. En caso que no desee actualizarla debe dejar los 3 campos vacios</p>
                            <div class="form-group col-md-4">
                              <label for="idcontraseña" class=" pb-1 " >Contraseña Actual : </label>
                              <input type="password" class="pb-1 pt-1 pl-2 pr-2 w-100 m-1" id="idcontraseña" placeholder="Nombre">
                            </div>
                             <div class="form-group col-md-4">
                              <label for="idcontraseña" class=" pb-1 ">Contraseña Nueva : </label>
                              <input type="password" class="pb-1 pt-1 pl-2 pr-2 w-100 m-1" id="idcontraseña" placeholder="Nombre">
                            </div>
                             <div class="form-group col-md-4">
                              <label for="idcontraseña" class=" pb-1 ">Repita Contraseña Nueva : </label>
                              <input type="password" class="pb-1 pt-1 pl-2 pr-2 w-100 m-1" id="idcontraseña" placeholder="Nombre">
                            </div>
                            
                          </div>
                          
                      
                       
                         <button type="submit " name="accion" value="actualizar" class="btn btn-primary float-right mt-5  mb-2 pl-5 pr-5 pb-2 pt-2 "><i class="fa-regular fa-floppy-disk mr-1 ml-1" style="font-size: 22px"></i>  ACTUALIZAR</button>
                        </form>
                  </div>
                </div>
                 <div class="card" style="width: 20rem; height:350px">
                 <div class="card-body perfil text-center" style="height: 200px ">
                    <img  class=" bg-white rounded-circle mt-4" src="imagenes/icon2.png" width="90px" height="90px"/>
                    <h5 class="pt-4 text-white">Administrador</h5>
                    <p class="text-white mb-3">${unadministrador.getCorreoadmi()}</p>
                   
                  </div>
                  <div class="card-body" >
                   
                  </div>
                </div> 
                
             
             </section>
         </div>
         </section>
    </div>    
    </body>
    <script src="https://kit.fontawesome.com/ef7654b222.js" crossorigin="anonymous"></script>   
     <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
     <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
     <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
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
