package io.lightstudios.chat.modules.chat.inventories.actions;

import io.lightstudios.chat.util.interfaces.LightAction;
import org.bukkit.entity.Player;

public class InvCloseAction implements LightAction {

    @Override
    public void execute(Player player, String[] actionDataArray) {
        player.closeInventory();
    }
}
