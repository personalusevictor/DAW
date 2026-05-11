<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:template match="/">
	<html>
		<head>
            <link rel="stylesheet" type="text/css" href="style.css"/>
		</head>
		<body>
			<h1>Víctor Martín Pérez</h1>

		<table border="0">
			<tr>
				<th>Asignatura</th>
				<th>Nota</th>
			</tr>
			<xsl:for-each select="Notas/Nota">
				<tr>
					<xsl:choose>
						<xsl:when test="Calificacion &lt; 5">
							<td class="suspenso">
								<div class="text-img">
									<xsl:value-of select="Nombre"/>
									<img src="assets/img/estudia.png" alt="Alumno Suspendido"/>
								</div>
							</td>
							<td class="suspenso"><xsl:value-of select="Calificacion"/></td>
						</xsl:when>
						<xsl:otherwise>
							<td class="aprobado"><xsl:value-of select="Nombre"/></td>
							<td class="aprobado"><xsl:value-of select="Calificacion"/></td>
						</xsl:otherwise>
					</xsl:choose>
				</tr>
			</xsl:for-each>
		</table>
		</body>
	</html>
	</xsl:template>
 
</xsl:stylesheet>
