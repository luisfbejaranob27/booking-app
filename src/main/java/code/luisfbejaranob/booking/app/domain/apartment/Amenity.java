package code.luisfbejaranob.booking.app.domain.apartment;

public enum Amenity
{
	WIFI(1, 0.1),
	AIR_CONDITIONING(2, 0.1),
	PARKING(3, 0.1),
	PET_FRIENDLY(4, 0.1),
	SWIMMING_POOL(5, 0.1),
	GYM(6, 0.1),
	SPA(7, 0.1),
	TERRACE(8, 0.1),
	MOUNTAIN_VIEW(9, 0.1),
	OCEAN_VIEW(10, 0.1),
	GARDEN_VIEW(11, 0.1),
	CITY_VIEW(12, 0.1),
	BEACH_VIEW(13, 0.1),
	LAKE_VIEW(14, 0.1),
	RIVER_VIEW(15, 0.1);

	private final int value;
	private final double percentageUpcharge;

	Amenity(int value, double percentageUpcharge)
	{
		this.value = value;
		this.percentageUpcharge = percentageUpcharge;
	}

	public int getValue()
	{
		return value;
	}

	public double getPercentageUpcharge()
	{
		return percentageUpcharge;
	}
}
