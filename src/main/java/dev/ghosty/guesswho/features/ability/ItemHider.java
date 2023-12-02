package dev.ghosty.guesswho.features.ability;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.EnumWrappers;
import dev.ghosty.guesswho.GuessWho;
import dev.ghosty.guesswho.data.PlayerData;
import dev.ghosty.guesswho.features.ProtocolLibMissingException;
import dev.ghosty.guesswho.features.game.Game;
import dev.ghosty.guesswho.features.game.GameManager;
import dev.ghosty.guesswho.utils.Duo;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/**
 * <a href="https://wiki.vg/Protocol#Set_Equipment">Protocol</a>
 */
public final class ItemHider {
	
	public ItemHider() {
		if(!GuessWho.getInstance().hasProtocolLib)
			throw new ProtocolLibMissingException();
		
		ProtocolLibrary.getProtocolManager().addPacketListener(new PacketAdapter(
				GuessWho.getInstance(),
				ListenerPriority.NORMAL,
				PacketType.Play.Server.ENTITY_EQUIPMENT
		) {
			@Override
			public void onPacketSending(PacketEvent event) {
				if(!GuessWho.getInstance().configuration.hideItem)
					return;
				
				Duo<Game, PlayerData> duo = GuessWho.getInstance().gameManager.getPlayer(event.getPlayer());
				if(duo != null) {
					if(!duo.getB().isSeeker) {
						event.setReadOnly(false);
						PacketContainer packet = ProtocolLibrary.getProtocolManager().createPacket(PacketType.Play.Server.ENTITY_EQUIPMENT);
						packet.getIntegers().write(0, event.getPlayer().getEntityId());
						packet.getItemSlots().write(0, EnumWrappers.ItemSlot.MAINHAND);
						packet.getItemModifier().write(0, new ItemStack(Material.AIR));
						event.setPacket(packet);
					}
				}
			}
		});
	}
	
}
