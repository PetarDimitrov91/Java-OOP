package onlineShop.core.interfaces;

import onlineShop.models.products.components.*;
import onlineShop.models.products.computers.BaseComputer;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.computers.DesktopComputer;
import onlineShop.models.products.computers.Laptop;
import onlineShop.models.products.peripherals.*;

import java.util.ArrayList;
import java.util.List;

import static onlineShop.common.constants.ExceptionMessages.*;
import static onlineShop.common.constants.OutputMessages.*;

public class ControllerImpl implements Controller {
    private List<Computer> computers;
    private List<Component> components;
    private List<Peripheral> peripherals;

    public ControllerImpl() {
        this.computers = new ArrayList<>();
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }


    @Override
    public String addComputer(String computerType, int id, String manufacturer, String model, double price) {
        Computer computer;
        switch (computerType) {
            case "Laptop":
                computer = new Laptop(id, manufacturer, model, price);
                break;
            case "DesktopComputer":
                computer = new DesktopComputer(id, manufacturer, model, price);
                break;
            default:
                throw new IllegalArgumentException(INVALID_COMPUTER_TYPE);
        }
        if (computerExist(id)) {
            throw new IllegalArgumentException(EXISTING_COMPUTER_ID);
        }
        computers.add(computer);
        return String.format(ADDED_COMPUTER, id);
    }

    private boolean computerExist(int id) {
        for (Computer computer : computers) {
            if (computer.getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String addPeripheral(int computerId, int id, String peripheralType, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
        if (!computerExist(computerId)) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }

        for (Peripheral peripheral : peripherals) {
            if (peripheral.getId() == id) {
                throw new IllegalArgumentException(EXISTING_PERIPHERAL_ID);
            }
        }
        Peripheral peripheral;
        switch (peripheralType) {
            case "Headset":
                peripheral = new Headset(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Keyboard":
                peripheral = new Keyboard(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Monitor":
                peripheral = new Monitor(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Mouse":
                peripheral = new Mouse(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            default:
                throw new IllegalArgumentException(INVALID_PERIPHERAL_TYPE);
        }
        peripherals.add(peripheral);
        for (Computer computer : computers) {
            if (computer.getId() == computerId) {
                computer.addPeripheral(peripheral);
            }
        }
        return String.format(ADDED_PERIPHERAL, peripheralType, id, computerId);
    }

    @Override
    public String removePeripheral(String peripheralType, int computerId) {
        int peripheralId = 0;
        out:
        for (var computer : computers) {
            if (computer.getId() == computerId) {
                for (Peripheral peripheral : computer.getPeripherals()) {
                    if (peripheral.getClass().getSimpleName().equals(peripheralType)) {
                        peripheralId = peripheral.getId();
                        computer.removePeripheral(peripheral.getClass().getSimpleName());
                        peripherals.remove(peripheral);
                        break out;
                    }
                }
            }
        }
        if (peripheralId == 0) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }

        return String.format(REMOVED_PERIPHERAL, peripheralType, peripheralId);
    }

    @Override
    public String addComponent(int computerId, int id, String componentType, String manufacturer, String model, double price, double overallPerformance, int generation) {
        if (!computerExist(computerId)) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }
        for (Component component : components) {
            if (component.getId() == id) {
                throw new IllegalArgumentException(EXISTING_COMPONENT_ID);
            }
        }
        Component component;
        switch (componentType) {
            case "CentralProcessingUnit":
                component = new CentralProcessingUnit(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "Motherboard":
                component = new Motherboard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "PowerSupply":
                component = new PowerSupply(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "RandomAccessMemory":
                component = new RandomAccessMemory(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "SolidStateDrive":
                component = new SolidStateDrive(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "VideoCard":
                component = new VideoCard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            default:
                throw new IllegalArgumentException(INVALID_COMPONENT_TYPE);
        }
        components.add(component);
        for (Computer computer : computers) {
            if (computer.getId() == computerId) {
                computer.addComponent(component);
            }
        }
        return String.format(ADDED_COMPONENT, componentType, id, computerId);
    }

    @Override
    public String removeComponent(String componentType, int computerId) {
        int componentId = 0;
        out:
        for (var computer : computers) {
            if (computer.getId() == computerId) {
                for (Component component : computer.getComponents()) {
                    if (component.getClass().getSimpleName().equals(componentType)) {
                        componentId = component.getId();
                        computer.removeComponent(component.getClass().getSimpleName());
                        components.remove(component);
                        break out;
                    }
                }
            }
        }
        if (componentId == 0) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }

        return String.format(REMOVED_COMPONENT, componentType, componentId);
    }

    @Override
    public String buyComputer(int id) {
        Computer computer = null;
        for (Computer comp : computers) {
            if (comp.getId() == id) {
                computer = comp;
                break;
            }
        }
        if (computer == null) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }

        computers.remove(computer);
        return computer.toString();
    }

    @Override
    public String BuyBestComputer(double budget) {
        if (computers.size() == 0) {
            throw new IllegalArgumentException(CAN_NOT_BUY_COMPUTER);
        }
        Computer computer = computers.get(0);
        for (Computer comp : computers) {
            if (computer.getOverallPerformance() < comp.getOverallPerformance()) {
                computer = comp;
            }
        }

        if (computer.getPrice() > budget) {
            throw new IllegalArgumentException(CAN_NOT_BUY_COMPUTER);
        }
        return computer.toString();
    }

    @Override
    public String getComputerData(int id) {
        for (Computer computer1 : computers) {
            if (computer1.getId() == id) {
                return computer1.toString();
            }
        }
        return null;
    }
}
