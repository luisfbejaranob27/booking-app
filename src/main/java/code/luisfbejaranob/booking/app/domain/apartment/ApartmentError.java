package code.luisfbejaranob.booking.app.domain.apartment;

import code.luisfbejaranob.booking.app.domain.shared.DomainError;

public enum ApartmentError implements DomainError
{
	ApartmentNotFound("Apartment.NotFound", "Apartment not found"),
	ApartmentNotAvailable("Apartment.NotAvailable", "The apartment is not available for the requested dates"),
	InvalidPrice("Apartment.InvalidPrice", "The apartment price is not valid"),
	InvalidAddress("Apartment.InvalidAddress", "The apartment address is not valid");

	private final String code;
	private final String message;

	ApartmentError(String code, String message)
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
