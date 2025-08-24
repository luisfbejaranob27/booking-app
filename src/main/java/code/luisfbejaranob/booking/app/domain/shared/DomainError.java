package code.luisfbejaranob.booking.app.domain.shared;

public sealed interface DomainError
{
	String getCode();

	String getMessage();

	// Generic Errors
	record ValidationError(String field, String message) implements DomainError
	{
		@Override
		public String getCode()
		{
			return "Validation.Error";
		}

		@Override
		public String getMessage()
		{
			return message;
		}
	}

	record NotFound(String resource, String identifier) implements DomainError
	{
		@Override
		public String getCode()
		{
			return "Resource.NotFound";
		}

		@Override
		public String getMessage()
		{
			return resource + " not found with identifier: " + identifier;
		}
	}

	record Unauthorized(String reason) implements DomainError
	{
		@Override
		public String getCode()
		{
			return "Access.Unauthorized";
		}

		@Override
		public String getMessage()
		{
			return "Access denied: " + reason;
		}
	}

	record Forbidden(String reason) implements DomainError
	{
		@Override
		public String getCode()
		{
			return "Access.Forbidden";
		}

		@Override
		public String getMessage()
		{
			return "Access forbidden: " + reason;
		}
	}

	record InternalError(String message) implements DomainError
	{
		@Override
		public String getCode()
		{
			return "Internal.Error";
		}

		@Override
		public String getMessage()
		{
			return message;
		}
	}
}
