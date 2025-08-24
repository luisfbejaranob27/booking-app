package code.luisfbejaranob.booking.app.domain.user;

public sealed interface UserError
{
	String getCode();

	String getMessage();

	record InvalidEmail(String email) implements UserError
	{
		@Override
		public String getCode()
		{
			return "User.InvalidEmail";
		}

		@Override
		public String getMessage()
		{
			return "The provided email is not valid: " + email;
		}
	}

	record UserNotFound(String email) implements UserError
	{
		@Override
		public String getCode()
		{
			return "User.NotFound";
		}

		@Override
		public String getMessage()
		{
			return "User not found with email: " + email;
		}
	}

	record DuplicateEmail(String email) implements UserError
	{
		@Override
		public String getCode()
		{
			return "User.DuplicateEmail";
		}

		@Override
		public String getMessage()
		{
			return "Email is already registered: " + email;
		}
	}

	record InvalidPassword(String email, String reason) implements UserError
	{
		@Override
		public String getCode()
		{
			return "User.InvalidPassword";
		}

		@Override
		public String getMessage()
		{
			return "Password does not meet requirements: " + reason;
		}
	}

	record UserAlreadyExists(String email) implements UserError
	{
		@Override
		public String getCode()
		{
			return "User.AlreadyExists";
		}

		@Override
		public String getMessage()
		{
			return "User already exists with email: " + email;
		}
	}

	record InvalidUserData(String field, String reason) implements UserError
	{
		@Override
		public String getCode()
		{
			return "User.InvalidData";
		}

		@Override
		public String getMessage()
		{
			return "Invalid " + field + ": " + reason;
		}
	}
}
