# aplicacionHelados

# Importar Aplicación:

# La aplicación requiere para su despliegue servidor GlassFish, y se realizó por medio del IDE NetBeans.
# Se debe importar el proyecto, a través de la opción "File-Open Project..." o mediante la opción "File-Import Project-From ZIP..."
# Se deberá seleccionar la ruta en la cual se descargo el proyecto a importar

# Creación Base de Datos:

# En la pestaña "Services" en la opción "Databases" expandirla y en la subopción "Java DB" darle clic derecho y seleccionar "Create Database...", en la pantalla que se abre ingresar la siguiente información:

# Database Name: db_Helados
# User Name: Dejar en blanco
# Password: Dejar en blanco

# Y dar clic en el botón "OK"

# Acto seguido dentro de la opción "Databases" al final aparecerá un nuevo item con el nombre "jdbc:derby://localhost:1527/db_Helados [root on ROOT]", darle clic derecho "Connect"

# Despliegue Tablas en Base de Datos:

# Una vez conectado darle clic derecho nuevamente y seleccionar la opción "Execute Command...", esto nos abrirá una nueva ventana en la cual podremos realizar consultas sobre la base de datos, en este caso copiaremos y pegaremos el script con las tablas y le daremos clic en la opción "Run SQL"
