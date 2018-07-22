<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html> 
<body>
  <h1>WiCast</h1>
  <h2>Client Channels</h2>
  <table border="1">
    <tr bgcolor="grey">
      <th>Name</th>
      <th>IP</th>
    </tr>
    <xsl:for-each select="wicast/client">
    <tr>
      <td><xsl:value-of select="source/@name"/></td>
      <td><xsl:value-of select="source/@ip"/></td>
    </tr>
    </xsl:for-each>
  </table>
  <h2>Server Channels</h2>
  <table border="1">
    <tr bgcolor="grey">
      <th>Name</th>
      <th>IP</th>
    </tr>
    <xsl:for-each select="wicast/server">
    <tr>
      <td><xsl:value-of select="channel/@name"/></td>
      <td><xsl:value-of select="channel/@ip"/></td>
    </tr>
    </xsl:for-each>
  </table>
  <h2>Relay Channels</h2>
  <table border="1">
    <tr bgcolor="grey">
      <th>Source</th>
      <th>Destination</th>
    </tr>
    <xsl:for-each select="wicast/relay">
    <tr>
      <td><xsl:value-of select="source/@ip"/></td>
      <td><xsl:value-of select="source/destination/@ip"/></td>
    </tr>
    </xsl:for-each>
  </table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>
