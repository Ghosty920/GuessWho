package dev.ghosty.guesswho.features.ability;

import lombok.RequiredArgsConstructor;

/**
 * As declared on <a href="https://github.com/lolleko/guesswho/tree/master/gamemodes/guesswho/entities/weapons">the original gamemode</a>
 */
@RequiredArgsConstructor
public enum Abilities {
	
	BLASTING_OFF("Blast Off", 3),
	CLOAK("Cloak", 7),
	DECOY("Decoy", 14),
	DEFLECT("Deflect", 12),
	DISGUISE("Disguise", 20),
	MIND_TRANSFER("Mind Transfer", 1600),
	PROP_HUNT("Prop Hunt", 7),
	RAGDOLL("Ragdoll", 8),
	SHOCKWAVE("Shockwave", 4),
	SHRINK("Shrink", 7),
	SOLARFLARE("Solarflare", 6),
	SUDOKU("Sudoku", 10),
	SUPERHOT("SUPER HOT", 8),
	SURGE("Graviton Surge", 1.5f),
	TELEPORT("Teleport", 1.5f),
	TIMELAPSE("Timelapse", 15),
	TUMBLE("Tumble", 3),
	VAMPIRISM("Vampirism", 5);
	
	// this is actually running 4 times faster, not used much but still, looks great! :)
	public static final Abilities[] values = values();
	
	public final String name;
	public final float duration;
	
}
