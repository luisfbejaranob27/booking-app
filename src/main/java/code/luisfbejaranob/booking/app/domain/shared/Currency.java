package code.luisfbejaranob.booking.app.domain.shared;

public sealed class Currency
{
	public static final class USD extends Currency
	{}

	public static final class COP extends Currency
	{}

	public static final class EUR extends Currency
	{}

	public CurrencyCode getCode()
	{
		return switch (this)
		{
			case USD u -> CurrencyCode.USD;
			case COP c -> CurrencyCode.COP;
			case EUR e -> CurrencyCode.EUR;
			default -> throw new IllegalStateException("Unknown currency type");
		};
	}

	public static Currency fromCode(String code)
	{
		return switch (code.toUpperCase())
		{
			case "USD" -> new USD();
			case "COP" -> new COP();
			case "EUR" -> new EUR();
			default -> throw new IllegalArgumentException("Invalid currency code: " + code);
		};
	}
}
