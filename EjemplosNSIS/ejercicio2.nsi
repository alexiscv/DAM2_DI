# Instalador que nos pregunta donde queremos instalar

# Nombre del instalador
Name "Instaladr App con Librerias"

# The file to write
OutFile "ejercicio2.exe"

# The default installation directory
InstallDir $DESKTOP\Ejercicio2

# Pedimos permisos para Windows 7
RequestExecutionLevel admin

# Pantallas que hay que mostrar del instalador
Page directory
Page instfiles

#Seccion principal
Section

	#Añadimos información para que salga en el menú de desinstalar de Windows
	WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\Mi Aplicacion 2" \
	                 "DisplayName" "Mi Aplicacion 2"
	WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\Mi Aplicacion 2" \
	                 "Publisher" "Alexis - Desarrollo Interfaces"
	WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\Mi Aplicacion 2" \
	                 "UninstallString" "$\"$INSTDIR\uninstall.exe$\""

	# Establecemos el directorio de salida al directorio de instalacion
	SetOutPath $INSTDIR

	# Ponemos ahi el archivo DAM2_DI_U6_InformeFacturas.jar
	File appConLibrerias\DAM2_DI_U6_InformeFacturas.jar

	# Cambiamos de directorio de escritura
	SetOutPath $INSTDIR\lib

	# Y copiamos las librerias
	File appConLibrerias\lib\commons-beanutils-1.8.2.jar
	File appConLibrerias\lib\commons-collections-3.2.1.jar
	File appConLibrerias\lib\commons-digester-2.1.jar
	File appConLibrerias\lib\commons-logging-1.1.jar
	File appConLibrerias\lib\hsqldb-1.8.0-10.jar
	File appConLibrerias\lib\iText-2.1.7.js2.jar
	File appConLibrerias\lib\jasperreports-5.6.0.jar
	File appConLibrerias\lib\servlet-api-2.4.jar

	# Cambiamos de directorio de escritura
	SetOutPath $INSTDIR\informes

	# Y copiamos los ficheros necesarios
	File appConLibrerias\informes\Factura.jasper

	# Cambiamos de directorio de escritura
	SetOutPath $INSTDIR

	# Creamos el desinstalador
	writeUninstaller "$INSTDIR\uninstall.exe"

	# Creamos un acceso directo apuntando al desinstalador
	createShortCut "$SMPROGRAMS\DesinstalarMiApp.lnk" "$INSTDIR\uninstall.exe"

# Fin de la seccion
SectionEnd

# seccion del desintalador
section "uninstall"

    # borramos el desintalador primero
    delete "$INSTDIR\uninstall.exe"

    # borramos el programa
    delete "$INSTDIR\DAM2_DI_U6_InformeFacturas.jar"
		delete "$INSTDIR\lib\commons-beanutils-1.8.2.jar"
		delete "$INSTDIR\lib\commons-collections-3.2.1.jar"
		delete "$INSTDIR\lib\commons-digester-2.1.jar"
		delete "$INSTDIR\lib\commons-logging-1.1.jar"
		delete "$INSTDIR\lib\hsqldb-1.8.0-10.jar"
		delete "$INSTDIR\lib\iText-2.1.7.js2.jar"
		delete "$INSTDIR\lib\jasperreports-5.6.0.jar"
		delete "$INSTDIR\lib\servlet-api-2.4.jar"
		delete "$INSTDIR\informes\jasper.jasper"

    # borramos el acceso directo del menu de inicio
    delete "$SMPROGRAMS\DesinstalarMiApp.lnk"

    # Borramos el directorio
		RMDir $INSTDIR

	#Borramos la entrada del registro
	DeleteRegKey HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\Mi Aplicacion 2"

# fin de la seccion del desinstalador
sectionEnd
