package de.felix_kurz.magicwings.main;

import de.felix_kurz.magicwings.controllers.WingsController;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public void onEnable() {
        new WingsController(this).enableController(true);
    }

    public void onDisable() {

    }

}