package code.luisfbejaranob.booking.app.domain.booking;

public enum BookingStatus
{
	RESERVED(1),
	CONFIRMED(2),
	REJECTED(3),
	CANCELLED(4),
	COMPLETED(5);

	private final int value;

	BookingStatus(int value)
	{
		this.value = value;
	}

	public int getValue()
	{
		return value;
	}
}
