# ----------- **FIRST** -----------

## DESAROLLO DE INTERFACES - MARIO MUÑOZ FUENTES

## 1. **INTRODUCCIÓN:**
Para comenzar este proyecto guiado, en primer lugar hicimos un boceto utilizando el programa *Adobe XD*.
Esto nos sirvió para comenzar a iniciarnos con el mundo del desarrollo de apps y poder partir desde ahi.

## 2. **PENSAR LA TEMÁTICA:**
Pensé que una buena temática podía ser una aplicación de gymnasio, ya que es un tema que me gusta, y podría desarrollarlo bien.

## 3. **CREACIÓN DEL PROYECTO:**
Para empezar elegimos una actividad en blanco la cual fuimos desarrollando y creando las distintas ventanas en ella.

![issue tab](img/1.png)

## 4. **DESARROLLO DEL PROYECTO:**
![issue tab](img/2.png)
#### 4.1. MANIFEST:
En el archivo ***"AndroidManifest.xml"*** es en el cual por ejemplo, podemos declarar cual va a ser la ventana en la que va a iniciar la aplicación, o cambiar el nombre de la app...

![issue tab](img/3.png)

#### 4.2. JAVA:
![issue tab](img/4.png)

######   4.2.1 LoginActivity
Aquí hemos puesto el fondo de la ventana principal *(activity_login.xml)* y también hemos puesto los enlaces de los botones.
El botón de ***"Entrar"*** al ***"MainActivity"***  y el botón de ***"Registrarse"*** nos lleva al ***"SingUp"*** .

######   4.2.1 MainActivity
Esta parte es la que más código lleva, ya que es la parte principal de la aplicación.
Aquí hemos incluido un ***"refresh"*** que cada vez que refrescamos nos muestra una imagen de una página web que crea caras de *personas que no existen* y aparece un mensaje en la parte inferior de la pantalla que dice *"Hi there!! I don`t exixt:)"*
En la parte del Status Bar hemos incluido dos iconos, uno de una lupa y otro de una tuerca, y a continuación incluimos las opciones de *"About Us"* y *"Sing Out"* los cuales estan ocultos hasta que pinchamos en los 3 puntitos.

Si pinchamos en la opción de ***"SingUp"*** nos aparece un diálogo de alerta en el cual si pinchamos en *"Other"* nos vuelve a la página en la que estábamos, en cambio si pinchamos en *"SingUp"* accedemos a la ventana *"SingUp"*.

######   4.2.1 SingUp
En esta parte únicamente llamamos al *"activity_sing_up"*.

######   4.2.1 SplashScreen
Aqui creamos la animación que aparece cuando se inicia la aplicación, insertando la imagen, el efecto, el tiempo que va a durar...


#### 4.3. RES:
Aquí encontramos los recursos necesarios para que la aplicación pueda funcionar.

######   4.3.1 Drawable y mipmap
Aquí podemos encontrar las imágenes y vectores que usamos en la aplicación, como son el logo y los diferentes iconos.

######   4.3.2 Layout
En esta carpeta encontramos una de las partes fundamentales de la aplicación, que son los archivos ***".xml"*** en los cuáles seleccionamos lo que vamos a ver en nuestra aplicación y lo que no.

######   4.3.3 Creadas por nosotros
Hemos creado alguna carpeta para dar alguna nueva funcionalidad a nuestro proyecto, estas carpetas han sido ***"font"*** en la cual hemos añadido la fuente que hemos usado en el logo *"Sigmar One Regular"*.
También hemos añadido la animación del inicio de la app.
Otra carpeta que hemos añadido nosotros ha sido la de ***"menu"*** en la cual hemos creado el *"menu_context"* en el cual hemos situado las diferentes opciones del *"appbar"* (barra superior de la aplicación), y también hemos creado *"menu_main"* el cual recoge los iconos del *"appbar"* del *main*.

## 5. **:**


## 6. **:**

