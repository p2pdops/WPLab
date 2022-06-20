<?xml  version="1.0"  encoding="UTF-8"?>
<xsl:stylesheet  version="1.0" 
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template  match="/">
<html>
  <body>
    <h1 align="center">Class</h1>
    <table border="3"  align="center">
    <tr>
      <th>name</th>
      <th>Mobno</th>
      <th>Email</th>
   </tr>
   <xsl:for-each select="class/student">
   <tr>
       <td><xsl:value-of  select="name"/></td>
       <td><xsl:value-of  select="mobno"/></td>
       <td><xsl:value-of  select="eid"/></td>
   </tr>
   </xsl:for-each>
   </table>
  </body>
</html>
</xsl:template>
</xsl:stylesheet>
