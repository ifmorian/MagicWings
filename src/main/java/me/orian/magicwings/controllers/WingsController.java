package me.orian.magicwings.controllers;

import me.orian.magicwings.listeners.JoinListener;
import me.orian.magicwings.listeners.QuitListener;
import me.orian.magicwings.utilities.WingedPlayer;
import me.orian.magicwings.wings.Wings;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class WingsController {

    private Plugin plugin;
    private Map<UUID, WingedPlayer> wingedPlayers = new HashMap<UUID, WingedPlayer>();
    private BukkitTask moveRunnable = null;
    private BukkitTask wingRunnable = null;

    public WingsController(Plugin plugin) {
        this.plugin = plugin;
    }

    public Map<UUID, WingedPlayer> getWingedPlayers() {
        return wingedPlayers;
    }

    public void enableController(boolean hideWingsOnMove) {
        Bukkit.getPluginManager().registerEvents(new JoinListener(this), plugin);
        Bukkit.getPluginManager().registerEvents(new QuitListener(this), plugin);
        if(hideWingsOnMove) {
            moveRunnable = new BukkitRunnable() {

                public void run() {
                    for(UUID id : wingedPlayers.keySet()) {
                        wingedPlayers.get(id).update(Bukkit.getPlayer(id).getLocation());
                    }
                }
            }.runTaskTimer(plugin, 0, 10);
        }
        wingRunnable = new BukkitRunnable() {

            public void run() {
                for(UUID id : wingedPlayers.keySet()) {
                    WingedPlayer p = wingedPlayers.get(id);
                    if(!p.isMoving()) {
                        Wings[] wings = p.getWings();
                        for(int i = 0; i < wings.length; i++) {
                            wings[i].spawnWings(Bukkit.getPlayer(id).getLocation());
                        }
                    }
                }
            }
        }.runTaskTimer(plugin, 0, 5);
    }

    public void disableController() {
        if(!moveRunnable.equals(null)) {
            moveRunnable.cancel();
        }
        if(!wingRunnable.equals(null)) {
            wingRunnable.cancel();
        }
    }

    public void addWingsToPlayer(Wings[] wings, Player p) {
        wingedPlayers.put(p.getUniqueId(), new WingedPlayer(p.getLocation(), wings));
    }

    public void removeWingsFromPlayer(Player p) {
        wingedPlayers.remove(p.getUniqueId());
    }

}
