package com.ritualsoftheold.terra.client.mesher;

import com.ritualsoftheold.terra.core.chunk.ChunkLArray;

/**
 * Creates a mesh based on Terra's voxel data.
 *
 */
public interface VoxelMesher {
    
    /**
     * Creates a mesh for chunk data that given iterator provides.
     * @param data Block buffer for data.
     * */
    void chunk(ChunkLArray data);
    
    /**
     * Creates a mesh for a simple cube, perhaps an octree node.
     * @param id
     * @param scale
     * @param textures
     */
}
