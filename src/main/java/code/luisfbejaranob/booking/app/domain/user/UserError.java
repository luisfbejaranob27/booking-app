package code.luisfbejaranob.booking.app.domain.user;

import code.luisfbejaranob.booking.app.domain.shared.DomainError;

public enum UserError implements DomainError
{
	InvalidEmail("User.InvalidEmail", "The provided email is not valid"),
	UserNotFound("User.NotFound", "User not found"),
	DuplicateEmail("User.DuplicateEmail", "Email is already registered"),
	InvalidPassword("User.InvalidPassword", "Password does not meet requirements");

	private final String code;
	private final String message;

	UserError(String code, String message)
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
