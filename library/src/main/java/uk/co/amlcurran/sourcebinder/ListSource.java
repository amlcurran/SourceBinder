package uk.co.amlcurran.sourcebinder;

import java.util.ArrayList;
import java.util.List;

public class ListSource<Item> {

    private final List<Item> items = new ArrayList<>();

    public ListSource(List<Item> list) {
        items.addAll(list);
    }

    public Item get(int index) {
        return items.get(index);
    }
}
