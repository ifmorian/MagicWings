package me.orian.magicwings.listeners;

import me.orian.magicwings.controllers.WingsController;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {

    WingsController controller;

    public QuitListener(WingsController controller) {
        this.controller = controller;
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        controller.getWingedPlayers().remove(p.getUniqueId());
    }

}
