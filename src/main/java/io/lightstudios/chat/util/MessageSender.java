package io.lightstudios.chat.util;
import io.lightstudios.chat.Light;
import io.lightstudios.chat.modules.chat.LightChat;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class MessageSender {

    public void sendPlayerMessage(String message, Player player) {
        Bukkit.getScheduler().runTask(Light.instance, () -> {
            Audience audience = (Audience) player;
            Component component = Light.instance.colorTranslation.universalColor(
                    LightChat.getMessageParams().prefix() + message, player);
            audience.sendMessage(component);
        });
    }
}
