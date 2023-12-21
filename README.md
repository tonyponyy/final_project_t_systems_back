
# DeepCodeSkill API

## Auth
### 1. Iniciar Sesión

-   **Método:** `POST`
-   **URL:** `/auth/login`
-   **Roles:** Público
-   **Descripción:** Inicia sesión y obtén un token JWT válido.

### 2. Registro de Nuevo Usuario

-   **Método:** `POST`
-   **URL:** `/auth/signup`
-   **Roles:** Público
-   **Descripción:** Registra un nuevo usuario en el sistema.

## Entrevistas
### 1. Listar Entrevistas Paginadas
- **Método:** `GET`
- **URL**  `/interviews/paginated_interviews`
-   **Roles:** Usuario, Recursos Humanos
-   **Descripción:** Obtén una lista paginada de entrevistas.

###  2. Buscar Entrevistas por Título
-   **Método:** `GET`
-  **URL**`/interviews/search_by/{title}`
-   **Roles:** Usuario, Recursos Humanos
-   **Descripción:** Busca entrevistas por título.

###  3. Agregar Nueva Entrevista
-   **Método:** `POST`
-   **URL** `/interviews/addInterview`
-   **Roles:** Recursos Humanos
-   **Descripción:** Agrega una nueva entrevista.

###  4. Editar Entrevista
-   **Método:** `PUT`
-   **URL:** `/interviews/editInterview/{id}`
-   **Roles:** Recursos Humanos
-   **Descripción:** Edita una entrevista existente.

### 5. Eliminar Entrevista
-   **Método:** `DELETE`
-   **URL:** `/interviews/deleteInterview/{id}`
-   **Roles:** Recursos Humanos
-   **Descripción:** Elimina una entrevista existente.

### 6. Mostrar Detalles de la Entrevista para RH
-   **Método:** `GET`
-   **URL:** `/interviews/show_interview_rh/{id}`
-   **Roles:** Recursos Humanos
-   **Descripción:** Obtiene detalles de una entrevista para el usuario de RH.

### 7. Mostrar Detalles de la Entrevista para Usuario
-   **Método:** `GET`
-   **URL:** `/interviews/show_interview_user/{id}`
-   **Roles:** User
-   **Descripción:** Obtiene información básica de una entrevista para el usuario autenticado.


## Skills
### 1. Listar Skills Paginadas
-   **Método:** `GET`
-   **URL:** `/skills/paginated_skills`
-   **Roles:** Recursos Humanos
-   **Descripción:** Obtiene una lista paginada de las skills.

### 2. Añadir una nueva Skills 
-   **Método:** `POST`
-   **URL:** `/skills/addSkill`
-   **Roles:** Recursos Humanos
-   **Descripción:** Añade una nueva habilidad al sistema.
    
### 3. Editar una Skill
-   **Método:** `PUT`
-   **URL:** `/skills/editSkill/{id}`
-   **Roles:** Recursos Humanos
-   **Descripción:** Edita una habilidad existente.

### 4. Borrar una Habilidad
-   **Método:** `DELETE`
-   **URL:** `/skills/deleteSkill/{id}`
-   **Roles:** Recursos Humanos
-   **Descripción:** Elimina una habilidad del sistema.
  
## Users

### 1. Listar Usuarios Paginados

-   **Método:** `GET`
-   **URL:** `/users/paginated_users`
-   **Roles:** Administrador
-   **Descripción:** Obtiene una lista paginada de usuarios

### 2. Obtener Mi Currículum

-   **Método:** `GET`
-   **URL:** `/users/my_resume`
-   **Roles:** Usuario
-   **Descripción:** Obtiene el currículum del usuario autenticado. 

### 3. Obtener Currículum por Usuario
-   **Método:** `GET`
-   **URL:** `/users/user_resume/{id}`
-   **Roles:** Administrador
-   **Descripción:** Obtiene el currículum de un usuario por ID.
    

### 4. Ver Usuario por ID
-   **Método:** `GET`
-   **URL:** `/users/{id}`
-   **Roles:** Administrador
-   **Descripción:** Obtiene detalles de un usuario por ID.

### 5. Obtener Información del Usuario Actual
-   **Método:** `GET`
-   **URL:** `/users/current_user/info`
-   **Roles:** Usuario
-   **Descripción:** Obtiene información del usuario autenticado.

### 6. Añadir Foto de Perfil
-   **Método:** `PUT`
-   **URL:** `/users/photo`
-   **Roles:** Administrador
-   **Descripción:** Añade una foto de perfil al usuario autenticado.

### 7. Añadir Currículum

-   **Método:** `PUT`
-   **URL:** `/users/resume`
-   **Roles:** Administrador
-   **Descripción:** Añade un currículum al usuario autenticado.

### 8. Cambiar el Rol de un Usuario
-   **Método:** `PUT`
-   **URL:** `/users/change_role/{id_user}/{role}`   
-   **Roles:** Administrador
-   **Descripción:** Cambia el rol de un usuario por ID.

### 9. Cambiar Información del Perfil de Usuario
-   **Método:** `PUT`
-   **URL:** `/users/change_user_info/{id_user}`
-   **Roles:** Usuario
-   **Descripción:** Cambia la información del perfil del usuario autenticado.

### 10. Eliminar un Usuario por ID
-   **Método:** `DELETE`
-   **URL:** `/users/deleteUser/{id}`
-   **Roles:** Administrador
-   **Descripción:** Elimina un usuario por ID.

## Test
### 1. Añadir un Test
-   **Método:** `POST`
-   **URL:** `/tests/addTest`
-   **Roles:** Recursos Humanos
-   **Descripción:** El usuario de RH añade una prueba a una entrevista. 

### 2. Editar un Test
-   **Método:** `PUT`
-   **URL:** `/tests/editTest/{id}`
-   **Roles:** Recursos Humanos
-   **Descripción:** El usuario de RH edita una prueba existente.

### 3. Borrar un Test
-   **Método:** `DELETE`
-   **URL:** `/tests/deleteTest/{id}`
-   **Roles:** Recursos Humanos
-   **Descripción:** El usuario de RH elimina una prueba de la entrevista.
   


## Controlador de Skills en Interviews

### 1. Añadir Skill a Interview
-   **Método:** `POST`
-   **URL:** `/interviews_skills/add_by_ids/{id_interview}/{id_skill}`
-   **Roles:** Recursos Humanos
-   **Descripción:** El usuario de RH añade habilidades a las entrevistas.
    

### 2. Eliminar Skill de Interview
-   **Método:** `DELETE`
-   **URL:** `/interviews_skills/delete_by_ids/{id_interview}/{id_skill}`
-   **Roles:** Recursos Humanos
-   **Descripción:** El usuario de RH elimina habilidades de las entrevistas.
  
  
## Controlador Users en Interviews

### 1. Añadir User a una Interview
-   **Método:** `POST`
-   **URL:** `/userinterviews/user_join_interview/{id_interview}`
-   **Roles:** Recursos Humanos
-   **Descripción:** El usuario de RH añade a un usuario a una entrevista.
    

### 2. Cambiar Estado del User en una Interview
-   **Método:** `PUT`
-   **URL:** `/userinterviews/changeState/{id_interview}/{state}`
-   **Roles:** Recursos Humanos
-   **Descripción:** El usuario de RH cambia el estado de una entrevista.
    
    
### 3. Cambiar Comentario Interno en una Interview
-   **Método:** `PUT`
-   **URL:** `/userinterviews/changeComment/{id_interview}`
-   **Roles:** Recursos Humanos
-   **Descripción:** El usuario de RH cambia el comentario interno de una entrevista

### 4. Obtener las Interviews de Usuario
-   **Método:** `GET`
-   **URL:** `/userinterviews/user_interviews`
-   **Roles:** Usuario 
-   **Descripción:** Obtiene la lista de entrevistas a las que el usuario está asignado.   


## Controlador de Skills en User

### 1. Asignar Skill a un User
-   **Método:** `POST`
-   **URL:** `/userskills/add_by/{id_skill}`
-   **Roles:** Usuario
-   **Descripción:** Asigna una habilidad a un usuario.

### 2. Cualificar Skill de User
-   **Método:** `POST`
-   **URL:** `/userskills/qualificate/{id_user}/{id_skill}`
-   **Roles:** Recursos Humanos
-   **Descripción:** Cualifica y añade un comentario a una habilidad de usuario.
   

### 3. Eliminar Skill de User
-   **Método:** `DELETE`
-   **URL:** `/userskills/delete_by/{id_user}/{id_skill}`
-   **Roles:** Usuario
-   **Descripción:** Elimina una habilidad de usuario.


## Controlador Test de un User

### 1. Asignar Test a un User
-   **Método:** `POST`
-   **URL:** `/usertests/user_test/{id_test}/{id_user}`
-   **Roles:** Recursos Humanos
-   **Descripción:** Asigna una prueba a un usuario para que la realice.


### 2. Calificar Test de User
-   **Método:** `POST`
-   **URL:** `/usertests/qualificate/{id_usertest}`
-   **Roles:** Recursos Humanos
-   **Descripción:** Cualifica y establece la fecha de realización de una prueba de usuario.


### 3. Eliminar Test de User
-   **Método:** `DELETE`
-   **URL:** `/usertests/delete_user_test/{id_user_test}`
-   **Roles:** Recursos Humanos
-   **Descripción:** Elimina una prueba de usuario.


----------

### Notas Importantes:

El archivo **SQL** para generar la base de datos se encuentra en la carpeta **other/deepcodeskill.sql**
