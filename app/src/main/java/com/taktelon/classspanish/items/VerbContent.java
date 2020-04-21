package com.taktelon.classspanish.items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class VerbContent {

    private static String[] verbs = {"llamar","comer","vivir"};
    private static String[] means = {"speak","eat","live"};

    /**
     * An array of sample (dummy) items.
     */
    public static final List<VerbItem> ITEMS = new ArrayList<VerbItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<Integer, VerbItem> ITEM_MAP = new HashMap<Integer, VerbItem>();

    static {
        // Add some sample items.
        for (int i = 0; i < verbs.length; i++) {
            addItem(createVerbItem(i));
        }
    }

    private static void addItem(VerbItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.getId(), item);
    }

    private static VerbItem createVerbItem(int position) {
        return new VerbItem(position, verbs[position], means[position]);
    }
}
