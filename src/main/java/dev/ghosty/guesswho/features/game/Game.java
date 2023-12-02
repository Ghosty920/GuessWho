package dev.ghosty.guesswho.features.game;

import dev.ghosty.guesswho.data.PlayerData;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.function.Consumer;

@Getter
@Setter
@ToString
public class Game {
	
	public String map;
	public int maxPlayers;
	public boolean isPublic;
	public ArrayList<PlayerData> players;
	
	/**
	 * @return null if not, else the data
	 */
	public PlayerData getPlayer(Player player) {
		for(PlayerData p : players)
			if(p.getPlayer() == player)
				return p;
		return null;
	}
	
	public void forAll(Consumer<PlayerData> func) {
		for(PlayerData p : players)
			func.accept(p);
	}
	
}
