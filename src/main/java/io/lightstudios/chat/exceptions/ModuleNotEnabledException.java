package io.lightstudios.chat.exceptions;

import io.lightstudios.chat.Light;
import io.lightstudios.chat.util.interfaces.LightModule;

public class ModuleNotEnabledException extends Exception {

    public ModuleNotEnabledException(LightModule module) {
        super(Light.consolePrefix + "The Module §e" + module.getName() + "§r is not enabled");
    }
}
