# Instalador que nos pregunta donde queremos instalar

# Nombre del instalador
Name "Instalador de ejemplo"

# The file to write
OutFile "ejercicio1.exe"

# The default installation directory
InstallDir $DESKTOP\Ejercicio1

# Pedimos permisos para Windows 7
RequestExecutionLevel user

# Pantallas que hay que mostrar del instalador

Page directory
Page instfiles

# Clave para el registro de Windows
InstallDirRegKey HKLM "Software\MiApp" "Install_Dir"

# Definimos la variable para el registro
!define UNINST_KEY \
  "Software\Microsoft\Windows\CurrentVersion\Uninstall\MiApp"

#Seccion principal
Section

	# Añadir al registro
	WriteRegStr SHCTX "${UNINST_KEY}" "DisplayName" "Mi Aplicacion"


	WriteRegStr HKLM "${UNINST_KEY}" \
                 "DisplayName" "Mi Aplicacion -- Ejercicio de prueba"

	WriteRegStr HKLM "${UNINST_KEY}" \
                 "UninstallString" "$\"$INSTDIR\uninstall.exe$\""

    DeleteRegKey HKLM "${UNINST_KEY}"

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
 
# fin de la seccion del desinstalador
sectionEnd