package code.luisfbejaranob.booking.app.domain.shared;

public record Money(
	Double amount,
	Currency currency)
{
	public static final Money ZERO = new Money(0.0, null);

	public Money add(Money money)
	{
		if (currency != money.currency)
		{
			throw new IllegalArgumentException("Currencies must match");
		}

		return new Money(amount + money.amount, currency);
	}
}
