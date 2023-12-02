package dev.ghosty.guesswho.features.game;

import dev.ghosty.guesswho.data.PlayerData;
import dev.ghosty.guesswho.utils.Duo;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public final class GameManager {
	
	public ArrayList<Game> games;
	
	public GameManager() {
		this.games = new ArrayList<>();
	}
	
	/**
	 * @return null if not, else the stuff
	 */
	public Duo<Game, PlayerData> getPlayer(Player player) {
		for(Game game : games) {
			PlayerData data = game.getPlayer(player);
			if(data != null)
				return new Duo<>(game, data);
		}
		return null;
	}
	
}
