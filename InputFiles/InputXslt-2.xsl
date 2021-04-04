<?xml version = "1.0" encoding = "UTF-8"?> 
<xsl:stylesheet version = "1.0" xmlns:xsl = "http://www.w3.org/1999/XSL/Transform"> 
<xsl:output version="1.0" indent="yes" encoding="UTF-8" method="xml"/> 
	<xsl:template match="/">
	  <BreakFastMenu>
	     <FoodType>
		    <xsl:for-each select="breakfast_menu/food">
			 <FoodItem>
			   <xsl:value-of select="./name"/>
			 </FoodItem>
			</xsl:for-each> 
		 </FoodType>
		 <FoodPrice>
		    <xsl:for-each select="breakfast_menu/food">
			 <FoodItemPrice>
			   <xsl:value-of select="./price"/>
			 </FoodItemPrice>
			</xsl:for-each> 
		 </FoodPrice>
	  </BreakFastMenu>
	</xsl:template>
</xsl:stylesheet>