package onlineShop.models.products.computers;

import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.Product;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;

import static onlineShop.common.constants.ExceptionMessages.*;

public abstract class BaseComputer extends BaseProduct implements Computer {
    private List<Component> components;
    private List<Peripheral> peripherals;

    public BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    @Override
    public List<Component> getComponents() {
        return this.components;
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return this.peripherals;
    }

    @Override
    public void addComponent(Component component) {
        for (Component comp : components) {
            if (comp.getClass().getSimpleName().equals(component.getClass().getSimpleName())) {
                throw new IllegalArgumentException(String.format(EXISTING_COMPONENT, component.getClass().getSimpleName(), getClass().getSimpleName(), getId()));
            }
        }
        components.add(component);
    }

    @Override
    public Component removeComponent(String componentType) {
        if (components.size() == 0) {
            throw new IllegalArgumentException(String.format(NOT_EXISTING_COMPONENT, componentType, getClass().getSimpleName(), getId()));
        }
        Component component = null;
        for (Component comp : components) {
            if (comp.getClass().getSimpleName().equals(componentType)) {
                component = comp;
            }
        }
        if (component == null) {
            throw new IllegalArgumentException(String.format(NOT_EXISTING_COMPONENT, componentType, getClass().getSimpleName(), getId()));
        }
        components.remove(component);
        return component;
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {
        for (Peripheral peri : peripherals) {
            if (peri.getClass().getSimpleName().equals(peripheral.getClass().getSimpleName())) {
                throw new IllegalArgumentException(String.format(EXISTING_PERIPHERAL, peripheral.getClass().getSimpleName(), getClass().getSimpleName(), getId()));
            }
        }
        peripherals.add(peripheral);
    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {
        if (peripherals.size() == 0) {
            throw new IllegalArgumentException(String.format(NOT_EXISTING_PERIPHERAL, peripheralType, getClass().getSimpleName(), getId()));
        }
        Peripheral peripheral = null;
        for (Peripheral peri : peripherals) {
            if (peri.getClass().getSimpleName().equals(peripheralType)) {
                peripheral = peri;
            }
        }
        if (peripheral == null) {
            throw new IllegalArgumentException(String.format(NOT_EXISTING_PERIPHERAL, peripheralType, getClass().getSimpleName(), getId()));
        }
        peripherals.remove(peripheral);
        return peripheral;
    }

    @Override
    public double getOverallPerformance() {
        if (components.size() == 0) {
            return super.getOverallPerformance();
        }
        return components.stream()
                .mapToDouble(Product::getOverallPerformance)
                .sum() / components.size() + super.getOverallPerformance();
    }

    @Override
    public double getPrice() {
        return peripherals.stream()
                .mapToDouble(Product::getPrice)
                .sum() + components.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Overall Performance: %.2f. Price: %.2f - %s: %s %s (Id: %d)",
                getOverallPerformance(), getPrice(), getClass().getSimpleName(), getManufacturer(), getModel(), getId()));
        sb.append(System.lineSeparator());
        sb.append(String.format(" Components (%d):", components.size())).append(System.lineSeparator());
        for (Component component : components) {
            sb.append("  ");
            sb.append(component).append(System.lineSeparator());
        }
        double averagePerformance = 0;
        if (!peripherals.isEmpty()) {
            averagePerformance = peripherals.stream()
                    .mapToDouble(Product::getOverallPerformance)
                    .sum()
                    / peripherals.size();
        }

        sb.append(String.format(" Peripherals (%d); Average Overall Performance (%.2f):", peripherals.size(), averagePerformance)).append(System.lineSeparator());
        for (Peripheral peripheral : peripherals) {
            sb.append("  ");
            sb.append(peripheral).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
