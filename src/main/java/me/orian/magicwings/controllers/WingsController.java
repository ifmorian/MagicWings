package me.orian.magicwings.controllers;

import me.orian.magicwings.listeners.JoinListener;
import me.orian.magicwings.listeners.QuitListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class WingsController {

    Plugin plugin;
    public Map<UUID, Boolean> movingPlayers = new HashMap<UUID, Boolean>();
    public BukkitTask runnable = null;

    public WingsController(Plugin plugin) {
        this.plugin = plugin;
    }

    public void enableController(boolean hideWingsOnMove) {
        Bukkit.getPluginManager().registerEvents(new JoinListener(), plugin);
        Bukkit.getPluginManager().registerEvents(new QuitListener(), plugin);

        if(hideWingsOnMove) {
            runnable = new BukkitRunnable() {

                public void run() {
                    for(UUID id : movingPlayers.keySet()) {

                    }
                }
            }.runTaskTimer(plugin, 0, 20);
        }
    }

    public void disableController() {
        if(!runnable.equals(null)) {
            runnable.cancel();
        }
    }

}
