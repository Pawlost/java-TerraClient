package com.ritualsoftheold.terra.client;

import com.ritualsoftheold.terra.core.WorldLoadListener;
import com.ritualsoftheold.terra.core.chunk.ChunkLArray;
import com.ritualsoftheold.terra.core.markers.Marker;
import com.ritualsoftheold.terra.core.TerraWorld;
import com.ritualsoftheold.terra.core.markers.Type;
import com.ritualsoftheold.terra.core.materials.Registry;

import java.util.ArrayList;

public class TerraClient implements TerraWorld {

    private ArrayList<Marker> chunks;

    private ArrayList<Marker> entities;

    private WorldLoadListener chunkListener;

    private Registry registry;

    public TerraClient(Registry registry, WorldLoadListener chunkListener){
        chunks = new ArrayList<>();
        entities = new ArrayList<>();
        this.registry = registry;
        this.chunkListener = chunkListener;
    }

    @Override
    public void addMarker(Marker marker) {
        if(marker.getType() == Type.CHUNK){
            chunks.add(marker);
            if(marker instanceof ChunkLArray){
                chunkListener.chunkLoaded((ChunkLArray) marker);
            }
        }else if(marker.getType() == Type.ENTITY){
            entities.add(marker);
        }
    }

    @Override
    public void removeMarker(Marker marker) {
        if(marker.getType() == Type.CHUNK){
            chunks.remove(marker);
        }else if(marker.getType() == Type.ENTITY){
            entities.remove(marker);
        }
    }

    @Override
    public void updateMarker(Marker marker) {

    }

    @Override
    public boolean checkMarker(Marker marker) {
        if(marker.getType() == Type.CHUNK){
            return chunks.contains(marker);
        }else if(marker.getType() == Type.ENTITY){
            return entities.contains(marker);
        }

        return false;
    }

    @Override
    public Registry getRegistry() {
        return registry;
    }

    @Override
    public void initialWorldGeneration(Marker marker) {
    }
}
