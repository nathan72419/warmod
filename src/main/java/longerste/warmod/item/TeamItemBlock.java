package longerste.warmod.item;

import com.feed_the_beast.ftblib.lib.data.ForgePlayer;
import com.feed_the_beast.ftblib.lib.data.Universe;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TeamItemBlock extends ItemBlock {

  public TeamItemBlock(Block block) {
    super(block);
  }

  @Override
  public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
    if(worldIn.isRemote){
      return EnumActionResult.FAIL;
    }
    ForgePlayer fPlayer = Universe.get().getPlayer(player.getUniqueID());
    if (fPlayer.hasTeam()) {
      return super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
    } else {
      return EnumActionResult.FAIL;
    }
  }
}
