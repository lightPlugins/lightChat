package io.lightstudios.chat.modules.chat;

import io.lightstudios.chat.Light;
import io.lightstudios.chat.modules.chat.commands.DummyCommand;
import io.lightstudios.chat.modules.chat.config.MessageParams;
import io.lightstudios.chat.modules.chat.config.SettingParams;
import io.lightstudios.chat.util.SubCommand;
import io.lightstudios.chat.util.interfaces.LightModule;
import io.lightstudios.chat.util.manager.CommandManager;
import io.lightstudios.chat.util.manager.FileManager;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;

public class LightChat implements LightModule {

    public static LightChat instance;
    public boolean isModuleEnabled = false;

    public final String moduleName = "chat";
    private final ArrayList<SubCommand> subCommands = new ArrayList<>();

    @Getter
    public static SettingParams settingParams;
    @Getter
    public static MessageParams messageParams;

    private FileManager settings;
    private FileManager language;


    @Override
    public void enable() {
        Light.getDebugPrinting().print(Light.consolePrefix +
                "Starting " + getName() + " module...");
        instance = this;
        Light.getDebugPrinting().print(Light.consolePrefix +
                "Creating default files for module " + getName() + " module...");
        initFiles();
        settingParams = new SettingParams(this);
        Light.getDebugPrinting().print(Light.consolePrefix +
                "Selecting module language for module " + getName() + "...");
        selectLanguage();
        messageParams = new MessageParams(language);
        Light.getDebugPrinting().print(Light.consolePrefix +
                "Registering subcommands for module " + getName() + "...");
        initSubCommands();
        this.isModuleEnabled = true;
        Light.getDebugPrinting().print(Light.consolePrefix +
                "Successfully started module " + getName() + "!");

    }

    @Override
    public void disable() {

    }

    @Override
    public void reload() { enable(); }

    @Override
    public boolean isEnabled() {
        return this.isModuleEnabled;
    }

    @Override
    public String getName() {
        return this.moduleName;
    }

    public FileConfiguration getSettings() { return this.settings.getConfig(); }

    public FileConfiguration getLanguage() { return this.language.getConfig(); }

    private void initFiles() {
        this.settings = new FileManager(
                Light.instance, getName() + "/settings.yml", true);
    }

    private void selectLanguage() {
        this.language = Light.instance.selectLanguage(settingParams.getModuleLanguage(), getName());
    }

    private void initSubCommands() {
        PluginCommand ecoCommand = Bukkit.getPluginCommand("lightchat");
        this.subCommands.add(new DummyCommand());
        new CommandManager(ecoCommand, this.subCommands);
    }
}
