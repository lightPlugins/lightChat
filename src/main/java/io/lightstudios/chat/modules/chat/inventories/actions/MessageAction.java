package io.lightstudios.chat.modules.chat.inventories.actions;

import io.lightstudios.chat.Light;
import io.lightstudios.chat.util.interfaces.LightAction;
import org.bukkit.entity.Player;

public class MessageAction implements LightAction {

    @Override
    public void execute(Player player, String[] actionDataArray) {

        if (actionDataArray.length < 2) {
            player.sendMessage("Config error: No message to send.");
            return;
        }

        Light.getMessageSender().sendPlayerMessage(actionDataArray[1], player);
    }
}
