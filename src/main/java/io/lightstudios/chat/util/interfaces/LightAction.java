package io.lightstudios.chat.util.interfaces;

import org.bukkit.entity.Player;

public interface LightAction {
    void execute(Player player, String[] actionDataArray);
}
