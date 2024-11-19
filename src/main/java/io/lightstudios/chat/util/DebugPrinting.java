package io.lightstudios.chat.util;

import io.lightstudios.chat.Light;
import org.bukkit.Bukkit;

public class DebugPrinting {

    public void print(String message) {
        Bukkit.getConsoleSender().sendMessage(Light.consolePrefix + message);
    }
    public void configError(String message) {
        Bukkit.getConsoleSender().sendMessage(Light.consolePrefix + " [CONFIG-ERROR] " + message);
    }
}
