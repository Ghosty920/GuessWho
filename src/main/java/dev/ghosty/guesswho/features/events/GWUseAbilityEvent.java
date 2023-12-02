package dev.ghosty.guesswho.features.events;

import dev.ghosty.guesswho.features.ability.Abilities;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@Getter
public class GWUseAbilityEvent extends Event implements Cancellable {
	
	private static HandlerList handlers = new HandlerList();
	@Setter
	private boolean cancelled = false;

	private final Player player;
	private final Abilities ability;
	
	public GWUseAbilityEvent(Player player, Abilities ability) {
		this.player = player;
		this.ability = ability;
	}
	
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
	
}
