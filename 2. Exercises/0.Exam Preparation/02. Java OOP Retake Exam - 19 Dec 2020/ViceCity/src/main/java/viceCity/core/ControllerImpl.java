package viceCity.core;

import viceCity.core.interfaces.Controller;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.neighbourhood.Neighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;
import viceCity.repositories.GunRepository;

import java.util.*;
import java.util.stream.Collectors;

import static viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller {

    private Player mainPlayer;
    private List<Player> civilPlayers;
    private GunRepository gunRepository;

    public ControllerImpl() {
        this.mainPlayer = new MainPlayer();
        this.civilPlayers = new ArrayList<>();
        this.gunRepository = new GunRepository();
    }

    @Override
    public String addPlayer(String name) {
        Player player = new CivilPlayer(name);
        civilPlayers.add(player);
        return String.format(PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        if (type.equals(Pistol.class.getSimpleName())) {
            Gun pistol = new Pistol(name);
            gunRepository.add(pistol);
        } else if (type.equals(Rifle.class.getSimpleName())) {
            Gun rifle = new Rifle(name);
            gunRepository.add(rifle);
        } else {
            return GUN_TYPE_INVALID;
        }
        return String.format(GUN_ADDED, name, type);
    }

    @Override
    public String addGunToPlayer(String name) {
        if (gunRepository.getModels().isEmpty()) {
            return GUN_QUEUE_IS_EMPTY;
        }
        Gun gun = gunRepository.getModels().stream().findFirst().orElse(null);
        gunRepository.remove(gun);
        if (name.equals("Vercetti")) {
            mainPlayer.getGunRepository().add(gun);
            assert gun != null;
            return String.format(GUN_ADDED_TO_MAIN_PLAYER, gun.getName(), mainPlayer.getName());
        } else if (civilPlayerExist(name)) {
            Objects.requireNonNull(civilPlayers.stream()
                            .filter(e -> e.getName().equals(name))
                            .findFirst()
                            .orElse(null))
                    .getGunRepository()
                    .add(gun);
            assert gun != null;
            return String.format(GUN_ADDED_TO_CIVIL_PLAYER, gun.getName(), name);
        }
        return CIVIL_PLAYER_DOES_NOT_EXIST;
    }

    private boolean civilPlayerExist(String name) {
        return civilPlayers.stream().anyMatch(e -> e.getName().equals(name));
    }

    @Override
    public String fight() {
        int initialHealth = mainPlayer.getLifePoints();
        int civilPlayersSize = civilPlayers.size();
        Neighbourhood neighbourhood = new GangNeighbourhood();
        neighbourhood.action(mainPlayer, civilPlayers);
        List<Player> collect = civilPlayers.stream().filter(e -> e.getLifePoints() > 0)
                .collect(Collectors.toList());

        if (mainPlayer.getLifePoints() == initialHealth && collect.size() == civilPlayersSize) {
            return FIGHT_HOT_HAPPENED;
        }
        int playersShot = 0;
        int civilPLayersLeft = 0;

        for (Player civilPlayer : civilPlayers) {
            if (civilPlayer.getLifePoints() > 0) {
                civilPLayersLeft++;
            } else {
                playersShot++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(FIGHT_HAPPENED).append(System.lineSeparator());
        sb.append(String.format(MAIN_PLAYER_LIVE_POINTS_MESSAGE, mainPlayer.getLifePoints())).append(System.lineSeparator());
        sb.append(String.format(MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, playersShot)).append(System.lineSeparator());
        sb.append(String.format(CIVIL_PLAYERS_LEFT_MESSAGE, civilPLayersLeft));
        return sb.toString().trim();
    }

    public Player getMainPlayer() {
        return this.mainPlayer;
    }

    public List<Player> getCivilPlayers() {
        return civilPlayers;
    }
}
