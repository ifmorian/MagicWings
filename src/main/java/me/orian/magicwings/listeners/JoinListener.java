package me.orian.magicwings.listeners;

import me.orian.magicwings.controllers.WingsController;
import me.orian.magicwings.templates.BasicWings;
import me.orian.magicwings.utilities.WingedPlayer;
import me.orian.magicwings.wings.Wings;
import org.bukkit.Color;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    WingsController controller;

    public JoinListener(WingsController controller) {
        this.controller = controller;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        Wings[] wings = {new Wings(BasicWings.ANGEL_FILL, Color.AQUA, 1, 0d, 0d, 0d, 0d),
                        new Wings(BasicWings.ANGEL_OUTLINE, Color.PURPLE, 1, 0d, 0d, 0d, 0d)};
        controller.getWingedPlayers().put(p.getUniqueId(), new WingedPlayer(p.getLocation(), wings));
    }

}
