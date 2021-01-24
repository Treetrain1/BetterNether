package paulevs.betternether.structures.plants;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ServerWorldAccess;
import paulevs.betternether.BlocksHelper;
import paulevs.betternether.blocks.BlockLumabusVine;
import paulevs.betternether.blocks.BlockProperties.TripleShape;
import paulevs.betternether.registry.BlocksRegistry;
import paulevs.betternether.structures.IStructure;

public class StructureGoldenLumabusVine implements IStructure {
	@Override
	public void generate(ServerWorldAccess world, BlockPos pos, Random random) {
		int h = random.nextInt(19) + 5;
		int h2 = BlocksHelper.downRay(world, pos, h);
		h2 -= 2;

		if (h2 < 3)
			return;

		BlockState vineState = BlocksRegistry.GOLDEN_LUMABUS_VINE.getDefaultState().with(BlockLumabusVine.SHAPE, TripleShape.MIDDLE);

		BlocksHelper.setWithUpdate(world, pos, BlocksRegistry.GOLDEN_LUMABUS_VINE.getDefaultState());

		for (int y = 1; y < h2; y++)
			BlocksHelper.setWithUpdate(world, pos.down(y), vineState);

		BlocksHelper.setWithUpdate(world, pos.down(h2), BlocksRegistry.GOLDEN_LUMABUS_VINE.getDefaultState().with(BlockLumabusVine.SHAPE, TripleShape.BOTTOM));
	}
}