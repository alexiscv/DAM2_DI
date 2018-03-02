# Instalador que nos pregunta donde queremos instalar

# Nombre del instalador
Name "Instalador de ejemplo"

# The file to write
OutFile "ejercicio1.exe"

# The default installation directory
InstallDir $DESKTOP\Ejercicio1

# Pedimos permisos para Windows 7
RequestExecutionLevel admin

# Pantallas que hay que mostrar del instalador

Page directory
Page instfiles

#Seccion principal
Section

	#Añadimos información para que salga en el menú de desinstalar de Windows
	WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\Mi Aplicacion" \
	                 "DisplayName" "Mi Aplicacion"
	WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\Mi Aplicacion" \
	                 "Publisher" "Alexis - Desarrollo Interfaces"
	WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\Mi Aplicacion" \
	                 "UninstallString" "$\"$INSTDIR\uninstall.exe$\""

	# Establecemos el directorio de salida al directorio de instalacion
	SetOutPath $INSTDIR

	# Ponemos ahi el archivo DAM2_DI_PrimeraApp.jar
	File DAM2_DI_PrimeraApp.jar

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
	delete "$INSTDIR\DAM2_DI_PrimeraApp.jar"

	# borramos el acceso directo del menu de inicio
	delete "$SMPROGRAMS\DesinstalarMiApp.lnk"

	# Borramos el directorio
	RMDir $INSTDIR

	#Borramos la entrada del registro
	DeleteRegKey HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\Mi Aplicacion"

# fin de la seccion del desinstalador
sectionEnd
