package code.luisfbejaranob.booking.app.domain.booking;

import code.luisfbejaranob.booking.app.domain.shared.DomainError;

public enum BookingError implements DomainError
{
	NotPending("Booking.NotPending", "Booking is not pending"),
	NotConfirmed("Booking.NotConfirmed", "Booking is not confirmed"),
	AlreadyStarted("Booking.AlreadyStarted", "Booking has already started");

	private final String code;
	private final String message;

	BookingError(String code, String message)
	{
		this.code = code;
		this.message = message;
	}

	@Override
	public String getCode()
	{
		return code;
	}

	@Override
	public String getMessage()
	{
		return message;
	}
}
