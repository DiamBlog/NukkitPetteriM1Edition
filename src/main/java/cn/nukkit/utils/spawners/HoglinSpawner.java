package cn.nukkit.utils.spawners;

import cn.nukkit.Player;
import cn.nukkit.block.Block;
import cn.nukkit.entity.BaseEntity;
import cn.nukkit.entity.mob.EntityHoglin;
import cn.nukkit.level.Level;
import cn.nukkit.level.Position;
import cn.nukkit.utils.AbstractEntitySpawner;
import cn.nukkit.utils.SpawnerTask;
import cn.nukkit.utils.Utils;

public class HoglinSpawner extends AbstractEntitySpawner {

    public HoglinSpawner(SpawnerTask spawnTask) {
        super(spawnTask);
    }

    @Override
    public void spawn(Player player, Position pos, Level level) {
        if (pos.y < 128 && pos.y > 0 && level.getBlockIdAt((int) pos.x, (int) pos.y, (int) pos.z) == Block.NETHERRACK) {
            for (int i = 0; i < 4; i++) {
                BaseEntity entity = this.spawnTask.createEntity("Hoglin", pos.add(0, 1, 0));
                if (entity != null && Utils.rand(1, 20) == 1) {
                    entity.setBaby(true);
                }
            }
        }
    }

    @Override
    public final int getEntityNetworkId() {
        return EntityHoglin.NETWORK_ID;
    }
}
