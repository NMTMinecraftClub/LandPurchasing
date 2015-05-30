/**
 * 
 */
package com.m0pt0pmatt.LandPurchasing;

import java.util.ArrayList;
import com.sk89q.worldedit.BlockVector2D;
import com.sk89q.worldguard.protection.regions.ProtectedCuboidRegion;

/**
 * Object for worldguard regions
 * @author Lucas Stuyvesant
 */
public class Land {

	ProtectedCuboidRegion land;
	ArrayList<BlockVector2D> chunks;
	String id;
	int costPerBlock = 5;

	public Land(){}
	
	public Land(ProtectedCuboidRegion region){
		land = region;
		id = land.getId();
		chunks = new ArrayList<BlockVector2D>();
		addChunks(region);
	}
	
	public String getID() {
		return this.id;
	}
	
	public ProtectedCuboidRegion getRegion() {
		return land;
	}
	
	/**
	 * Adds the chunks spanned by the region to the list
	 * @param region
	 */
	private void addChunks(ProtectedCuboidRegion region) {
		int xDim = 0;
		int xMin = region.getMinimumPoint().getBlockX();
		int xMax = region.getMaximumPoint().getBlockX();
		int zDim = 0;
		int zMin = region.getMinimumPoint().getBlockZ();
		int zMax = region.getMaximumPoint().getBlockZ();
		int i;

		//get number of chunks in x direction
		if(xMin % 16 != 0){
			xDim++;
		}
		i = xMin + (16 - xMin % 16);
		while(i < xMax){
			i += 16;
			xDim++;
		}
		if(xMax % 16 != 0){
			xDim++;
		}
		
		//get number of chunks in z direction
		if(zMin % 16 != 0){
			zDim++;
		}
		i = zMin + (16 - zMin % 16);
		while(i < zMax){
			i += 16;
			zDim++;
		}
		if(zMax % 16 != 0){
			zDim++;
		}
		
		//build chunks and add to list
		BlockVector2D c;
		for(int x = 0; x < xDim; x++){
			for(int z = 0; z < zDim; z++){
				if(!chunks.contains(c = new BlockVector2D(Math.floor(xMin + 16 * x),Math.floor(zMin + 16 * z)))){
					chunks.add(c);
				}
			}
		}
	}

	/**
	 * Method for generating the cost of a selection of this piece of land
	 * @return the cost of the given dimentions
	 */
	public int getCost(){
		int length = land.getMaximumPoint().getBlockX() - land.getMinimumPoint().getBlockX() + 1;
		int height = land.getMaximumPoint().getBlockY() - land.getMinimumPoint().getBlockY() + 1;
		int width = land.getMaximumPoint().getBlockZ() - land.getMinimumPoint().getBlockZ() + 1;
		return ((costPerBlock + height)*(length * width));
	}

}
