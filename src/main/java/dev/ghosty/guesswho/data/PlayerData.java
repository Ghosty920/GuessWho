package dev.ghosty.guesswho.data;

import lombok.Data;
import org.bukkit.entity.Player;

@Data
public class PlayerData {
	
	public final Player player;
	public boolean isSeeker, alive;
	
}
