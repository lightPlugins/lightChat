package io.lightstudios.chat.util;

import org.bukkit.OfflinePlayer;

public abstract class SubPlaceholder {

    public abstract String onRequest(OfflinePlayer player, String params);

}
