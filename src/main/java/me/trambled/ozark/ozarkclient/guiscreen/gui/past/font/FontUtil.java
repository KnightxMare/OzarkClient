package me.trambled.ozark.ozarkclient.guiscreen.gui.past.font;

import me.trambled.ozark.Ozark;
import net.minecraft.client.Minecraft;

public
class FontUtil {
    protected static Minecraft mc = Minecraft.getMinecraft ( );

    public static
    void drawString ( String text , float x , float y , int colour ) {
        if ( Ozark.get_setting_manager ( ).get_setting_with_tag ( "PastGUI" , "PastGUIFont" ).in ( "Lato" ) ) {
            Ozark.latoFont.drawString ( text , x , y , colour );
        } else if ( Ozark.get_setting_manager ( ).get_setting_with_tag ( "PastGUI" , "PastGUIFont" ).in ( "Verdana" ) ) {
            Ozark.verdanaFont.drawString ( text , x , y , colour );
        } else if ( Ozark.get_setting_manager ( ).get_setting_with_tag ( "PastGUI" , "PastGUIFont" ).in ( "Arial" ) ) {
            Ozark.arialFont.drawString ( text , x , y , colour );
        } else {
            mc.fontRenderer.drawString ( text , (int) x , (int) y , colour );
        }
    }

    public static
    void drawStringWithShadow ( String text , float x , float y , int colour ) {

        if ( Ozark.get_setting_manager ( ).get_setting_with_tag ( "PastGUI" , "PastGUIFont" ).in ( "Lato" ) ) {
            Ozark.latoFont.drawStringWithShadow ( text , x , y , colour );
        } else if ( Ozark.get_setting_manager ( ).get_setting_with_tag ( "PastGUI" , "PastGUIFont" ).in ( "Verdana" ) ) {
            Ozark.verdanaFont.drawStringWithShadow ( text , x , y , colour );
        } else if ( Ozark.get_setting_manager ( ).get_setting_with_tag ( "PastGUI" , "PastGUIFont" ).in ( "Arial" ) ) {
            Ozark.arialFont.drawStringWithShadow ( text , x , y , colour );
        } else {
            mc.fontRenderer.drawStringWithShadow ( text , (int) x , (int) y , colour );
        }
    }

    public static
    void drawText ( String text , float x , float y , int colour ) {
        if ( Ozark.get_setting_manager ( ).get_setting_with_tag ( "PastGUI" , "PastGUIFontShadow" ).get_value ( true ) ) {
            drawStringWithShadow ( text , x , y , colour );
        } else {
            drawString ( text , x , y , colour );
        }
    }

    public static
    int getFontHeight ( ) {
        if ( Ozark.get_setting_manager ( ).get_setting_with_tag ( "PastGUI" , "PastGUIFont" ).in ( "Lato" ) ) {
            return Ozark.latoFont.getHeight ( );
        } else if ( Ozark.get_setting_manager ( ).get_setting_with_tag ( "PastGUI" , "PastGUIFont" ).in ( "Verdana" ) ) {
            return Ozark.verdanaFont.getHeight ( );
        } else if ( Ozark.get_setting_manager ( ).get_setting_with_tag ( "PastGUI" , "PastGUIFont" ).in ( "Arial" ) ) {
            return Ozark.arialFont.getHeight ( );
        } else {
            return mc.fontRenderer.FONT_HEIGHT;
        }
    }

}
