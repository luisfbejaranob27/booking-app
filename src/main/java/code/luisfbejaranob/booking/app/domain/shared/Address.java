package code.luisfbejaranob.booking.app.domain.shared;

public record Address(
	String country,
	String state,
	String city,
	String value,
	String zipCode
) {}
