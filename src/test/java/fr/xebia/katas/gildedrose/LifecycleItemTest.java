package fr.xebia.katas.gildedrose;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class LifecycleItemTest {

	@Test
	public void when_item_is_updated_then_sell_in_decreases() {
		LifecycleItem item = new LifecycleItem("Backstage passes to a TAFKAL80ETC concert", 10, 40);
		item.update();
		assertThat(item.getSellIn()).isEqualTo(9);
	}

	@Test
	public void when_sell_by_date_has_not_passed_then_quality_degrades_by_one() {
		LifecycleItem item = new LifecycleItem("Super test", 5, 50);
		item.update();
		assertThat(item.getQuality()).isEqualTo(49);
	}

	@Test
	public void when_sell_by_date_has_not_passed_and_product_is_conjured_then_quality_degrades_twice_as_fast() {
		LifecycleItem item = new LifecycleItem("Conjured", 5, 50);
		item.update();
		assertThat(item.getQuality()).isEqualTo(48);
	}

	@Test
	public void when_sell_by_date_has_passed_and_product_is_conjured_then_quality_degrades_four_times_as_fast() {
		LifecycleItem item = new LifecycleItem("Conjured", -5, 50);
		item.update();
		assertThat(item.getQuality()).isEqualTo(46);
	}

	@Test
	public void when_sell_by_date_has_passed_then_quality_degrades_twice_as_fast() {
		LifecycleItem item = new LifecycleItem("Super test", -5, 50);
		item.update();
		assertThat(item.getQuality()).isEqualTo(48);
	}

	@Test
	public void when_quality_is_0_then_it_does_not_degrade() {
		LifecycleItem item = new LifecycleItem("Super test", 5, 0);
		item.update();
		assertThat(item.getQuality()).isEqualTo(0);
	}

	@Test
	public void when_quality_is_0_and_sell_by_date_has_passed_then_it_does_not_degrade() {
		LifecycleItem item = new LifecycleItem("Super test", -5, 0);
		item.update();
		assertThat(item.getQuality()).isEqualTo(0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void when_quality_is_negative_then_throws_exception() {
		new LifecycleItem("Super test", 5, -42);
	}

	@Test
	public void when_product_is_aged_brie_then_quality_increases() {
		LifecycleItem item = new LifecycleItem("Aged Brie", 5, 0);
		item.update();
		assertThat(item.getQuality()).isEqualTo(1);
	}

	@Test
	public void when_product_is_aged_brie_then_quality_does_not_exceed_50() {
		LifecycleItem item = new LifecycleItem("Aged Brie", 5, 50);
		item.update();
		assertThat(item.getQuality()).isEqualTo(50);
	}

	@Test(expected = IllegalArgumentException.class)
	public void when_quality_is_larger_than_50_then_throws_exception() {
		new LifecycleItem("Super awesome cheese", 5, 70);
	}

	@Test
	public void when_product_is_sulfura_then_quality_does_not_change() {
		LifecycleItem item = new LifecycleItem("Sulfuras, Hand of Ragnaros", 5, 40);
		item.update();
		assertThat(item.getQuality()).isEqualTo(40);
	}

	@Test
	public void when_product_is_sulfura_then_sell_in_does_not_change() {
		LifecycleItem item = new LifecycleItem("Sulfuras, Hand of Ragnaros", 5, 40);
		item.update();
		assertThat(item.getSellIn()).isEqualTo(5);
	}

	@Test
	public void when_product_is_backstage_then_quality_increases() {
		LifecycleItem item = new LifecycleItem("Backstage passes to a TAFKAL80ETC concert", 15, 40);
		item.update();
		assertThat(item.getQuality()).isEqualTo(41);
	}

	@Test
	public void when_product_is_backstage_and_sell_in_is_less_than_10_then_quality_increases_by_2() {
		LifecycleItem item = new LifecycleItem("Backstage passes to a TAFKAL80ETC concert", 10, 40);
		item.update();
		assertThat(item.getQuality()).isEqualTo(42);
	}

	@Test
	public void when_product_is_backstage_and_sell_in_is_11_then_quality_increases() {
		LifecycleItem item = new LifecycleItem("Backstage passes to a TAFKAL80ETC concert", 11, 40);
		item.update();
		assertThat(item.getQuality()).isEqualTo(41);
	}

	@Test
	public void when_product_is_backstage_and_sell_in_is_less_than_5_then_quality_increases_by_2() {
		LifecycleItem item = new LifecycleItem("Backstage passes to a TAFKAL80ETC concert", 5, 40);
		item.update();
		assertThat(item.getQuality()).isEqualTo(43);
	}

	@Test
	public void when_product_is_backstage_and_sell_in_is_less_than_zero_then_quality_is_zero() {
		LifecycleItem item = new LifecycleItem("Backstage passes to a TAFKAL80ETC concert", -10, 40);
		item.update();
		assertThat(item.getQuality()).isEqualTo(0);
	}

}
