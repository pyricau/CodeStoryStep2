package fr.xebia.katas.gildedrose;

import static com.google.common.base.Preconditions.checkArgument;

public class LifecycleItem extends Item {

	private static final String CONJURED = "Conjured";
	private static final int MAXIMUM_QUALITY = 50;
	private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
	private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
	private static final String AGED_BRIE = "Aged Brie";

	public LifecycleItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
		checkArgument(quality >= 0);
		checkArgument(quality <= MAXIMUM_QUALITY);
	}

	@Override
	public String toString() {
		return "<li>" + getName() + ": quality=" + getQuality() + " sell in=" + getSellIn() + "</li>";
	}

	public void update() {
		decreaseItemSellIn();
		updateItemQuality();
	}

	private void decreaseItemSellIn() {
		if (isNotSulfuras()) {
			setSellIn(getSellIn() - 1);
		}
	}

	private boolean isNotSulfuras() {
		return !getName().equals(SULFURAS);
	}

	private void updateItemQuality() {
		if (isAgedBrie() || isBackStage()) {
			increaseItemQuality();

			if (isBackStage()) {
				if (getSellIn() < 10) {
					increaseItemQuality();
				}

				if (getSellIn() < 5) {
					increaseItemQuality();
				}
			}
		} else {
			decreaseItemQuality();
		}
		updateExpiredItemQuality();
	}

	private boolean isBackStage() {
		return getName().equals(BACKSTAGE);
	}

	private boolean isAgedBrie() {
		return getName().equals(AGED_BRIE);
	}

	private void updateExpiredItemQuality() {
		if (hasExpired()) {
			if (isAgedBrie()) {
				increaseItemQuality();
			} else {
				if (isBackStage()) {
					dropQualityToZero();
				} else {
					decreaseItemQuality();
				}
			}
		}
	}

	private boolean isConjured() {
		return getName().equals(CONJURED);
	}

	private boolean hasExpired() {
		return getSellIn() < 0;
	}

	private boolean hasQualityLeft() {
		return getQuality() > 0;
	}

	private boolean hasNotReachedMaximumQuality() {
		return getQuality() < 50;
	}

	private void dropQualityToZero() {
		setQuality(0);
	}

	private void increaseItemQuality() {
		if (hasNotReachedMaximumQuality()) {
			setQuality(getQuality() + 1);
		}
	}

	private void decreaseItemQuality() {
		if (hasQualityLeft() && isNotSulfuras()) {
			if (isConjured()) {
				setQuality(getQuality() - 2);
			} else {
				setQuality(getQuality() - 1);
			}

		}
	}
}
