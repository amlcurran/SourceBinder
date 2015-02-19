package uk.co.amlcurran.sourcebinder;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ListSourceTest {

    @Test
    public void testAListSourceMaintainsOrder() {
        List<String> list = listFromItems("Hello", "How", "Are", "You?");

        ListSource<String> source = new ListSource<>(list);

        for (int i = 0; i < list.size(); i++) {
            assertEquals(list.get(i), source.get(i));
        }
    }

    private static List<String> listFromItems(String... objects) {
        List<String> strings = new ArrayList<>();
        Collections.addAll(strings, objects);
        return strings;
    }

}