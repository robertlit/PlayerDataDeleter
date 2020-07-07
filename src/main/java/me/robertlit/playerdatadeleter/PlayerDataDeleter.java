package me.robertlit.playerdatadeleter;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class PlayerDataDeleter extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onLogin(AsyncPlayerPreLoginEvent event) {
        File playerDataFolder = new File(getDataFolder() + File.separator + ".." + File.separator + ".." + File.separator + "world" + File.separator + "playerdata");
        if (!playerDataFolder.exists()) {
            return;
        }
        String fileName = playerDataFolder + File.separator + event.getUniqueId();
        File playerData = new File(fileName + ".dat");
        if (playerData.exists()) {
            playerData.delete();
        }
        File playerDataOld = new File(fileName + ".dat_old");
        if (playerDataOld.exists()) {
            playerDataOld.delete();
        }
    }
}
