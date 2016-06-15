package miscutil.core.handler;

import miscutil.core.container.Container_NHG;
import miscutil.core.gui.machine.GUI_NHG;
import miscutil.core.tileentities.TileEntityNHG;
import miscutil.core.util.Utils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	private static final int GUI1 = 0;      //Nuclear Helium Gen.
	private static final int GUI2 = 1;      //Energy Buffer



	@Override //ContainerModTileEntity
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);

		if (te != null){
			if (ID == GUI1){
				return new Container_NHG((TileEntityNHG)te, player);
			}
			else if (ID == GUI2){

			}



		}
		return null;
	}

	@Override //GuiModTileEntity
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		Utils.LOG_WARNING("getClientGuiElement Called by: "+player+", in world: "+player.dimension+" at x:"+x+", y:"+y+", z:"+z+".");
		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null){
		if (ID == GUI1){
			Utils.LOG_WARNING("Opening Gui with Id: "+ID+" NHG");
			return new GUI_NHG((TileEntityNHG) te, player);
		}
		else  if (ID == GUI2){
			Utils.LOG_WARNING("Opening Gui with Id: "+ID+" Energy Buffer");
			//return new GUI_Bat_Buf();
		}
		}
		return null;
	}

}