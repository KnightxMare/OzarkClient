package me.trambled.ozark.ozarkclient.module.chat;

import me.trambled.ozark.ozarkclient.event.events.EventPlayerSendChatMessage;
import me.trambled.ozark.ozarkclient.module.Category;
import me.trambled.ozark.ozarkclient.module.Module;
import me.zero.alpine.fork.listener.EventHandler;
import me.zero.alpine.fork.listener.Listener;
import net.minecraft.network.play.client.CPacketChatMessage;

//salhack
public
class RetardChat extends Module {

    @EventHandler
    private final Listener < EventPlayerSendChatMessage > OnSendChatMsg = new Listener <> ( event ->
    {
        if ( event.message.startsWith ( "/" ) )
            return;

        String l_Message = "";


        boolean l_Flag = false;

        for (char l_Char : event.message.toCharArray ( )) {
            String l_Val = String.valueOf ( l_Char );

            l_Message += l_Flag ? l_Val.toUpperCase ( ) : l_Val.toLowerCase ( );

            if ( l_Char != ' ' ) {
                l_Flag = ! l_Flag;
            }
        }

        event.cancel ( );
        mc.getConnection ( ).sendPacket ( new CPacketChatMessage ( l_Message ) );
    } );

    public
    RetardChat ( ) {
        super ( Category.CHAT );

        this.name = "Retard Chat";
        this.tag = "RetardChat";
        this.description = "makes you sound retarded";
    }
}
