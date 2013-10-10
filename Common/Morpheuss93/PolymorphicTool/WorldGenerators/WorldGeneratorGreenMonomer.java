package Morpheuss93.PolymorphicTool.WorldGenerators;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import Morpheuss93.PolymorphicTool.BlockHandler;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGeneratorGreenMonomer implements IWorldGenerator{
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
		switch(world.provider.dimensionId){
		
		case 1:
			generateEnd(world,random,chunkX*16,chunkZ*16);
			
		case 0:
			generateSurface(world,random,chunkX*16,chunkZ*16);
			
		case -1:
			generateNether(world,random,chunkX*16,chunkZ*16);
		
		}
		
	}

	

	private void generateEnd(World world, Random random, int chunkX, int chunkZ) {
		
		
	}
	
	private void generateSurface(World world, Random random, int chunkX, int chunkZ) {
		//i=vene
		for(int i=0; i<30;i++)//stone 60
		{
			int cordX = random.nextInt(16)+chunkX;
			int cordY = random.nextInt(30)+34;
			int cordZ = random.nextInt(16)+chunkZ;
			
			//blocchi per vena
			(new WorldGenMinable(BlockHandler.greenMonomerOre.blockID, 8)).generate(world, random, cordX, cordY, cordZ);
			//WorldGenMinable w;
		}
			
	}

	
	private void generateNether(World world, Random random, int chunkX, int chunkZ) {
		
	}

}
