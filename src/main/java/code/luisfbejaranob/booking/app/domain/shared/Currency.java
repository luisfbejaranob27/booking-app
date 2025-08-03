package code.luisfbejaranob.booking.app.domain.shared;

public class Currency
{
	private final CurrencyCode code;

	public Currency(CurrencyCode code)
	{
		this.code = code;
	}

	public CurrencyCode getCode()
	{
		return code;
	}

	public static Currency fromCode(String code)
	{
		for (CurrencyCode currencyCode : CurrencyCode.values())
		{
			if (currencyCode.name().equalsIgnoreCase(code))
			{
				return new Currency(currencyCode);
			}
		}
		throw new IllegalArgumentException("Invalid currency code: " + code);
	}
}
