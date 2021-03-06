package xyz.olivermartin.multichat.spigotbridge;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.plugin.messaging.PluginMessageRecipient;

public class SpigotCommunicationManager {

	private static SpigotCommunicationManager instance;

	public static SpigotCommunicationManager getInstance() {
		return instance;
	}

	static {
		instance = new SpigotCommunicationManager();
	}

	/* --- END STATIC --- */

	private SpigotCommunicationManager() {
		/* Empty */
	}

	public void sendProxyExecuteMessage(String command) {

		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(stream);

		try {
			out.writeUTF(command);
		} catch (IOException e) {
			e.printStackTrace();
		}

		((PluginMessageRecipient)Bukkit.getServer().getOnlinePlayers().toArray()[0]).sendPluginMessage(Bukkit.getPluginManager().getPlugin(MultiChatSpigot.pluginName), "multichat:pxe", stream.toByteArray());

	}

	public void sendProxyExecutePlayerMessage(String command, String player) {

		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(stream);

		try {
			out.writeUTF(command);
			out.writeUTF(player);
		} catch (IOException e) {
			e.printStackTrace();
		}

		((PluginMessageRecipient)Bukkit.getServer().getOnlinePlayers().toArray()[0]).sendPluginMessage(Bukkit.getPluginManager().getPlugin(MultiChatSpigot.pluginName), "multichat:ppxe", stream.toByteArray());

	}

	public void sendPluginChannelMessage(String channel, UUID uuid, String message) {

		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(stream);

		try {
			out.writeUTF(uuid.toString());
			out.writeUTF(message);
		} catch (IOException e) {
			e.printStackTrace();
		}

		((PluginMessageRecipient)Bukkit.getServer().getOnlinePlayers().toArray()[0]).sendPluginMessage(Bukkit.getPluginManager().getPlugin(MultiChatSpigot.pluginName), channel, stream.toByteArray());

	}

	public void sendPluginChatChannelMessage(String channel, UUID uuid, String message, String format) {

		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(stream);

		try {
			out.writeUTF(uuid.toString());
			out.writeUTF(message);
			out.writeUTF(format);

		} catch (IOException e) {
			e.printStackTrace();
		}

		((PluginMessageRecipient)Bukkit.getServer().getOnlinePlayers().toArray()[0]).sendPluginMessage(Bukkit.getPluginManager().getPlugin(MultiChatSpigot.pluginName), channel, stream.toByteArray());

	}

}
