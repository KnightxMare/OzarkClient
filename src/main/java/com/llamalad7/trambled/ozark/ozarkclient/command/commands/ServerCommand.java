package me.trambled.ozark.ozarkclient.command.commands;

import me.trambled.ozark.ozarkclient.command.Command;
import me.trambled.ozark.ozarkclient.util.MessageUtil;

public class ServerCommand extends Command {


        public String serverip;

	public ServerCommand() {
		super("ip", "shows server ip");
	}

	public boolean get_message(String[] message) {
		String type = "null";
                
                serverip = mc.getCurrentServerData().serverIP;

                MessageUtil.send_client_message("You are playing on " + serverip);

                return true;
	}
}