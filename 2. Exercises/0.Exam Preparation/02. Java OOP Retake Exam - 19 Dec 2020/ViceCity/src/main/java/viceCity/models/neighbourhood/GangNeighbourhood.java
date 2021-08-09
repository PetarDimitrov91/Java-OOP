package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;

import java.util.Collection;

public class GangNeighbourhood implements Neighbourhood {

    private int shotPeopleCount;

    public GangNeighbourhood() {
        this.shotPeopleCount = 0;
    }

    public int getShotPeopleCount() {
        return this.shotPeopleCount;
    }

    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        Collection<Gun> guns = mainPlayer.getGunRepository().getModels();
        for (Gun gun : guns) {
            out:
            for (Player civilPlayer : civilPlayers) {
                while (gun.canFire() && civilPlayer.isAlive()) {
                    civilPlayer.takeLifePoints(gun.fire());
                    if (!gun.canFire()) {
                        break out;
                    }
                }
            }
        }

        for (Player civilPlayer : civilPlayers) {
            if (civilPlayer.isAlive()) {
                Collection<Gun> guns2 = civilPlayer.getGunRepository().getModels();
                for (Gun gun : guns2) {
                    while (mainPlayer.isAlive() && gun.canFire()) {
                        mainPlayer.takeLifePoints(gun.fire());
                        if (!mainPlayer.isAlive()) {
                            return;
                        }
                    }
                }
            }
        }
        for (Player civilPlayer : civilPlayers) {
            if (!civilPlayer.isAlive()) {
                shotPeopleCount++;
            }
        }
    }
}
