package fr.xebia.katas.gildedrose;

import java.util.ArrayList;
import java.util.List;

public class Inn {

	private final List<LifecycleItem> items;

	public Inn() {
		items = new ArrayList<LifecycleItem>();
		items.add(new LifecycleItem("+5 Dexterity Vest", 10, 20));
		items.add(new LifecycleItem("Aged Brie", 2, 0));
		items.add(new LifecycleItem("Conjured", 3, 40));
		items.add(new LifecycleItem("Elixir of the Mongoose", 5, 7));
		items.add(new LifecycleItem("Sulfuras, Hand of Ragnaros", 0, 40));
		items.add(new LifecycleItem("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		items.add(new LifecycleItem("Conjured Mana Cake", 3, 6));
	}

	public void updateQuality() {
		for (LifecycleItem item : items) {
			item.update();
		}

	}

	public static void main(String[] args) {
		System.out.println("OMGHAI!");
		new Inn().updateQuality();
	}

	public List<LifecycleItem> getItems() {
		return items;
	}

}
