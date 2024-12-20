package io.lightstudios.chat.modules.chat.commands;

import io.lightstudios.chat.Light;
import io.lightstudios.chat.modules.chat.LightChat;
import io.lightstudios.chat.util.SubCommand;
import io.lightstudios.chat.util.constructor.InvCreator;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class DummyCommand extends SubCommand {
    @Override
    public List<String> getName() {
        return List.of("dummy");
    }

    @Override
    public String getDescription() {
        return "Dummy command opens a dummy inventory";
    }

    @Override
    public String getSyntax() {
        return "/lightdummy dummy";
    }

    @Override
    public int maxArgs() {
        return 1;
    }

    @Override
    public String getPermission() {
        return "";
    }

    @Override
    public TabCompleter registerTabCompleter() {
        return (sender, command, alias, args) -> List.of("dummy");
    }

    @Override
    public boolean performAsPlayer(Player player, String[] args) throws ExecutionException, InterruptedException {
        InvCreator invCreator = Light.instance.getInventoryManager().generateInventoryFromFileManager(
                LightChat.instance.getDummyInventory(), player);
        invCreator.openInventory();
        return false;
    }

    @Override
    public boolean performAsConsole(ConsoleCommandSender sender, String[] args) throws ExecutionException, InterruptedException {
        return false;
    }
}
