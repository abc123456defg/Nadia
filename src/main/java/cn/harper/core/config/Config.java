package cn.harper.core.config;

import java.io.File;
import java.io.IOException;

public abstract class Config {
    private final File file;

    protected Config(File file) {
        this.file = file;
    }

    /**
     * 加载配置文件
     */
    public abstract void loadConfig() throws IOException;

    /**
     * 保存配置文件
     */
    public abstract void saveConfig() throws IOException;
    /**
     * 创建配置文件
     */
    public void createConfig() throws IOException {
        file.createNewFile();
    }

    /**
     * 存在配置文件，
     */
    public boolean hasConfig() {
        return file.exists();
    }

    /**
     * 返回配置文件
     */
    public File getFile() {
        return file;
    }

}
