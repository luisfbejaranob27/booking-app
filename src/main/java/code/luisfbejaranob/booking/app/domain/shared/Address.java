package code.luisfbejaranob.booking.app.domain.shared;

public record Address(
	String street,
	String city,
	String state,
	String country,
	String zipCode)
{}
