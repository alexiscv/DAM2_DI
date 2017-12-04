<helpset version="1.0">
	<title>Ejemplo de ayuda JavaHelp</title>
	<maps>
		<!-- Página por defecto al mostrar la ayuda -->
		<homeID>aplicacion</homeID>
		<!-- Que mapa deseamos -->
		<mapref location="map_file.jhm"/>
	</maps>

	<!-- Las vistas que deseamos mostrar en la ayuda -->
	<!-- La tabla de contenidos -->
	<view>
		<name>Tabla contenidos</name>
		<label>Tabla de contenidos</label>
		<type>javax.help.TOCView</type>
		<data>toc.xml</data>
	</view>

	<!-- El indice -->
	<view>
		<name>Indice</name>
		<label>El indice</label>
		<type>javax.help.IndexView</type>
		<data>indice.xml</data>
	</view>

	<!-- El indice -->
	<view>
		<name>Buscar</name>
		<label>Buscar</label>
		<type>javax.help.SearchView</type>
		<data engine="com.sun.java.help.search.DefaultSearchEngine">JavaHelpSearch</data>
	</view>

</helpset>