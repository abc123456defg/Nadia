package cn.harper.core.config;

import cn.harper.utils.Info;

public class ConfigManager {
    /**
     * 保存多个配置文件
     *
     * @param configs list
     */
    public void saveConfigs(final Config... configs) {
        for(final Config fileConfig : configs)
            saveConfig(fileConfig);
    }


    /**
     * 保存一个文件
     *
     * @param config
     *
     */
    private void saveConfig(final Config config) {
        try {
            if(!config.hasConfig())
                config.createConfig();

            config.saveConfig();
            Info.getLogger().info("[FileManager] Saved config: " + config.getFile().getName() + ".");
        }catch(final Throwable t) {
            Info.getLogger().error("[FileManager] Failed to save config file: " +
                    config.getFile().getName() + ".", t);
        }
    }

}
