package bow_health.bow_health;


import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;


public final class Bow_Health extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void Projectilehit(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Arrow) {
            Player shot = (Player) event.getEntity();
            Player shooter = (Player) ((Projectile) event.getDamager()).getShooter();
            double health = event.getFinalDamage();
            String name = shot.getDisplayName();
            shooter.sendMessage(name + " is at " + health);
        }

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
