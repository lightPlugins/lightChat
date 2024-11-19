package io.lightstudios.chat.modules.chat.config;

import io.lightstudios.chat.util.manager.FileManager;
import org.bukkit.configuration.file.FileConfiguration;

public class MessageParams {

    private final FileConfiguration config;

    public MessageParams(FileManager selectedLanguage) {
        this.config = selectedLanguage.getConfig();
    }

    public int version() { return config.getInt("version"); }

    public String prefix() { return config.getString("prefix"); }
    public String noPermission() { return config.getString("noPermission"); }
    public String moduleReload() { return config.getString("moduleReload"); }
    public String reloadAll() { return config.getString("reloadAll"); }
    public String wrongSyntax() { return config.getString("wrongSyntax"); }

}
