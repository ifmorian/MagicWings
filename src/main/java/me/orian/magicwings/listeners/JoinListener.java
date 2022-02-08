package me.orian.magicwings.listeners;

import me.orian.magicwings.controllers.WingsController;
import me.orian.magicwings.templates.BasicWings;
import me.orian.magicwings.utilities.ColoredPoint3D;
import me.orian.magicwings.utilities.WingedPlayer;
import me.orian.magicwings.wings.MulitpleColorWings;
import me.orian.magicwings.wings.SingleColorWings;
import me.orian.magicwings.wings.Wings;
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
