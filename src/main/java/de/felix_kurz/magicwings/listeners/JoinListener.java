package de.felix_kurz.magicwings.listeners;

import de.felix_kurz.magicwings.controllers.WingsController;
import de.felix_kurz.magicwings.templates.BasicWings;
import de.felix_kurz.magicwings.utilities.ColoredPoint3D;
import de.felix_kurz.magicwings.utilities.WingedPlayer;
import de.felix_kurz.magicwings.wings.MulitpleColorWings;
import de.felix_kurz.magicwings.wings.SingleColorWings;
import de.felix_kurz.magicwings.wings.Wings;
import org.bukkit.Color;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    WingsController controller;
    ColoredPoint3D[] points;

    public JoinListener(WingsController controller) {
        this.points = ColoredPoint3D.createSetFromPicture("rainbow2.jpg", controller.plugin);
        this.controller = controller;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        Wings[] wings = {new SingleColorWings(BasicWings.FLY, 2, 1, 0d, 0d, 0d, 0d, Color.FUCHSIA)};
        Wings[] wings2 = {new MulitpleColorWings(points, 1, 1, 0, 0, 0, 0)};
        controller.getWingedPlayers().put(p.getUniqueId(), new WingedPlayer(p.getLocation(), wings2));
    }

}
