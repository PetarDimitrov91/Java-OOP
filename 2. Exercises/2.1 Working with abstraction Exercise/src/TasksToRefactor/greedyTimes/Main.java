
package TasksToRefactor.greedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long bagCapacity = Long.parseLong(scanner.nextLine());
        String[] safe = scanner.nextLine().split("\\s+");

           var torba = new LinkedHashMap<String, LinkedHashMap<String, Long>>();
        Bag bag = new Bag(bagCapacity);

        for (int i = 0; i < safe.length; i += 2) {
            String name = safe[i];
            long quantity = Long.parseLong(safe[i + 1]);

            String elmentToCheck = "";

            if (name.length() == 3) {
                elmentToCheck = "Cash";
            } else if (name.toLowerCase().endsWith("gem")) {
                elmentToCheck = "Gem";
            } else if (name.toLowerCase().equals("gold")) {
                elmentToCheck = "Gold";
            }

            if (elmentToCheck.equals("")) {
                continue;
            } else if (bagCapacity < torba.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum() + quantity) {
                continue;
            }

            switch (elmentToCheck) {
                case "Gem":
                    if (!torba.containsKey(elmentToCheck)) {
                        if (torba.containsKey("Gold")) {
                            if (quantity > torba.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (torba.get(elmentToCheck).values().stream().mapToLong(e -> e).sum() + quantity > torba.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!torba.containsKey(elmentToCheck)) {
                        if (torba.containsKey("Gem")) {
                            if (quantity > torba.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (torba.get(elmentToCheck).values().stream().mapToLong(e -> e).sum() + quantity > torba.get("Gem").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
            }

            if (!torba.containsKey(elmentToCheck)) {
                torba.put((elmentToCheck), new LinkedHashMap<String, Long>());
            }

            if (!torba.get(elmentToCheck).containsKey(name)) {
                torba.get(elmentToCheck).put(name, 0L);
            }


            torba.get(elmentToCheck).put(name, torba.get(elmentToCheck).get(name) + quantity);
            if (elmentToCheck.equals("Gold")) {
            //    zlato += quantity;
            } else if (elmentToCheck.equals("Gem")) {
              //  kamuni += quantity;
            } else if (elmentToCheck.equals("Cash")) {
            //    mangizi += quantity;
            }
        }

        for (var x : torba.entrySet()) {
            Long sumValues = x.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.println(String.format("<%s> $%s", x.getKey(), sumValues));

            x.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }
}