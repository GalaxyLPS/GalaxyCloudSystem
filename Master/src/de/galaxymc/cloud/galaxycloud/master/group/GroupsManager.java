package de.galaxymc.cloud.galaxycloud.master.group;

import de.galaxymc.cloud.galaxycloud.library.server.minecraft.group.MinecraftGroup;
import de.galaxymc.cloud.galaxycloud.library.server.minecraft.group.MinecraftGroupRegistry;
import de.galaxymc.cloud.galaxycloud.library.server.minecraft.group.settings.MinecraftGroupSettings;

import java.util.Objects;

public class GroupsManager {

    private MinecraftGroupRegistry groupRegistry;

    private boolean end;
    private static final int sleepCheckTime = 100;

    public GroupsManager() {
        end = false;
        groupRegistry = new MinecraftGroupRegistry();
        //portRegistry = new PortRegistry();
    }

    public MinecraftGroup addGroup(MinecraftGroupSettings settings) {
        MinecraftGroup group = new MinecraftGroup(settings, 0 /* TODO: get port */);
        groupRegistry.add(group);
        return group;
    }

    public void removeGroup() {

    }

    public MinecraftGroup[] getGroups() {
        return (MinecraftGroup[]) groupRegistry.stream()
                .filter(Objects::nonNull)
                .map(MinecraftGroup.class::cast)
                .toArray();
    }


    private void check() {
        Thread t = new Thread(() -> {
            while (!end) {
                groupRegistry.stream().filter(Objects::nonNull)
                        .map(MinecraftGroup.class::cast)
                        .filter(group -> (group.playersInGroup() / 20) > group.getServersPer20PlayersInGroup())
                        .forEach(MinecraftGroup::openServer);
                try {
                    Thread.sleep(sleepCheckTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.setName("GroupManagerRefresh");
        t.start();
    }

}