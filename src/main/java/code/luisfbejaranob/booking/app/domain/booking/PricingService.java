package code.luisfbejaranob.booking.app.domain.booking;

import code.luisfbejaranob.booking.app.domain.apartment.Amenity;
import code.luisfbejaranob.booking.app.domain.apartment.Apartment;
import code.luisfbejaranob.booking.app.domain.shared.Currency;
import code.luisfbejaranob.booking.app.domain.shared.Money;

public class PricingService
{
	public static PricingDetails calculatePrice(Apartment apartment, DateRange dateRange)
	{
		Currency currency = apartment.getPrice().currency();
		Money priceForPeriod = new Money(apartment.getPrice().amount() * dateRange.getDays(), currency);
		double percentageUpcharge = 0;

		for (Amenity amenity : apartment.getAmenities())
		{
			percentageUpcharge += amenity.getPercentageUpcharge();
		}

		Money amenitiesUpcharge = Money.ZERO;
		if (percentageUpcharge > 0)
		{
			amenitiesUpcharge = new Money(priceForPeriod.amount() * percentageUpcharge / 100, currency);
		}

		Money totalPrice = Money.ZERO;

		totalPrice = totalPrice.add(priceForPeriod);

		if (!apartment.getCleaningFee().equals(Money.ZERO))
		{
			totalPrice = totalPrice.add(apartment.getCleaningFee());
		}

		totalPrice = totalPrice.add(amenitiesUpcharge);

		return new PricingDetails(priceForPeriod, apartment.getCleaningFee(), amenitiesUpcharge, totalPrice);
	}
}
