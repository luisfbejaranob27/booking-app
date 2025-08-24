package code.luisfbejaranob.booking.app.domain.booking;

import code.luisfbejaranob.booking.app.domain.shared.Money;

public record PricingDetails(
	Money priceForPeriod,
	Money cleaningFee,
	Money amenitiesUpcharge,
	Money totalPrice)
{}
