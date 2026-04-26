<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <meta charset="UTF-8"/>
                <title>Librería - Víctor</title>
                <link rel="stylesheet" type="text/css" href="style.css"/>
                <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600&amp;display=swap" rel="stylesheet"/>
            </head>
            <body>
                <div class="container">
                    <h1>Librería Víctor</h1>
                    <div class="table-wrapper">
                        <table>
                            <thead>
                                <tr class="header-table">
                                    <th>Título</th>
                                    <th>Autor</th>
                                    <th>Editor</th>
                                    <th>ISBN</th>
                                    <th>Precio</th>
                                    <th>Novedad</th>
                                </tr>
                            </thead>
                            <tbody>
                                <xsl:for-each select="Libreria/Libro">
                                    <xsl:sort select="Precio" data-type="number" order="descending"/>
                                    
                                    <tr>
                                        <td class="bold"><xsl:value-of select="Titulo"/></td>
                                        
                                        <xsl:choose>
                                            <xsl:when test="Autor = 'Autor 3' or Autor = 'autor 3'">
                                                <td style="color: #00f;"><xsl:value-of select="Autor"/></td>
                                            </xsl:when>
                                            <xsl:otherwise>
                                                <td><xsl:value-of select="Autor"/></td>
                                            </xsl:otherwise>
                                        </xsl:choose>

                                        <td><xsl:value-of select="Editor"/></td>
                                        <td class="isbn"><xsl:value-of select="ISBN"/></td>
                                        <td class="price"><xsl:value-of select="Precio"/>€</td>
                                        <td>
                                            <xsl:choose>
                                                <xsl:when test="Novedad='Si' or Novedad='si'">
                                                    <span class="badge">Novedad</span>
                                                </xsl:when>
                                                <xsl:otherwise>-</xsl:otherwise>
                                            </xsl:choose>
                                        </td>
                                    </tr>
                                </xsl:for-each>
                            </tbody>
                        </table>
                    </div>
                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>