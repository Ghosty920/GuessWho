package dev.ghosty.guesswho.features;

public final class ProtocolLibMissingException extends RuntimeException {
	
	public ProtocolLibMissingException() {
		super("A feature tried to load but ProtocolLib isn't present on the server. Please report this error with the full message here: https://github.com/Ghosty920/GuessWho/issues/new");
	}
	
}
