package io.lightstudios.chat.modules.chat.config;

import io.lightstudios.chat.modules.chat.LightChat;

public class SettingParams {

    private final LightChat lightBank;

    public SettingParams(LightChat lightBank) {
        this.lightBank = lightBank;
    }

    public String getModuleLanguage() {
        return lightBank.getSettings().getString("module-language");
    }
}
