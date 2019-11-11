package by.senla.nikitaSergei.task6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task6 {

    private static int stuffQuantity = (int) Math.round(5 + Math.random() * 6); // stuffQuantity can be from 5 to 11 for example (can be changed)

    public static void resultMethod() {
        System.out.println("We have " + stuffQuantity + " items");
        BackPack backpack = new BackPack(30 + (int) Math.round(Math.random() * 30)); //backPack's capacity can be from 30 to 60 for example (can be changed)
        System.out.println("We have backpack with capacity: " + backpack.getCapacity());
        List<Item> listOfItems = getItems();
        ItemSet setsWithMaxCost = getSetsWithMaxCost(getSetsWithSuitableWeight(listOfItems, backpack));
        System.out.println("\n");
        System.out.println("This is ItemSet for your backpack:");
        for (int i = 0; i < setsWithMaxCost.getSet().length; i++) {
            if (setsWithMaxCost.getSet()[i] == '1') {
                System.out.println(listOfItems.get(i).toString());
            }
        }
        System.out.println("ItemSet max weight: " + setsWithMaxCost.getSumWeight());
        System.out.println("ItemSet max cost: " + setsWithMaxCost.getSumCost());
    }

    /**
     * @return list of items we have for work
     */
    private static List<Item> getItems() {
        List<Item> listOfItems = new ArrayList<>();
        for (int i = 0; i < stuffQuantity; i++) {
            listOfItems.add(createItem());
        }
        return listOfItems;
    }

    /**
     * @return new object of Item.class with random @param
     */
    private static Item createItem() {
        int weight = 5 + (int) Math.round(Math.random() * 10); //from 5 to 15
        int cost = 1 + (int) Math.round(Math.random() * 10); //from zero to 11
        System.out.println("Item: weight = " + weight + ", cost = " + cost);
        return new Item(weight, cost);
    }

    /**
     * @param itemList - list of items,
     * @param backPack
     * @return
     */
    private static List<ItemSet> getSetsWithSuitableWeight(List<Item> itemList, BackPack backPack) {
        List<ItemSet> setsWithSuitableWeight = new ArrayList<>();
        for (long i = (long) Math.pow(2, stuffQuantity); i < Math.pow(2, stuffQuantity + 1); i++) {
            ItemSet itemSet = new ItemSet();
            itemSet.setSet(Long.toString(i, 2).substring(1).toCharArray());
            for (int j = 0; j < itemSet.getSet().length; j++) {
                if (itemSet.getSet()[j] == '1') {
                    itemSet.setSumWeight(itemSet.getSumWeight() + itemList.get(j).getWeight());
                    itemSet.setSumCost(itemSet.getSumCost() + itemList.get(j).getCost());
                }
            }
            if (itemSet.getSumWeight() <= backPack.getCapacity()) {
                setsWithSuitableWeight.add(itemSet);
            }
        }
        return setsWithSuitableWeight;
    }

    /**
     *
     * @param itemList - list of ItemSet, witch have weight less than backpack's capacity
     * @return most expensive itemSet
     */
    private static ItemSet getSetsWithMaxCost(List<ItemSet> itemList) {
        return itemList.stream().max(Comparator.comparingDouble(ItemSet::getSumCost)).orElse(null);
    }

}
