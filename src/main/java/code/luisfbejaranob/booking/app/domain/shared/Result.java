package code.luisfbejaranob.booking.app.domain.shared;

public sealed class Result<T>
{
	public record Success<T>(T value) extends Result<T>
	{}

	public record Failure<T>(Error error) extends Result<T>
	{}

	public static <T> Result<T> success(T value)
	{
		return new Success<>(value);
	}

	public static <T> Result<T> failure(Error error)
	{
		return new Failure<>(error);
	}

	public boolean isSuccess()
	{
		return this instanceof Success;
	}

	public boolean isFailure()
	{
		return this instanceof Failure;
	}

	public T getValue()
	{
		if (this instanceof Success<T> success)
		{
			return success.value();
		}
		throw new IllegalStateException("Cannot get value from a failed result");
	}

	public T getValueOrNull()
	{
		if (this instanceof Success<T> success)
		{
			return success.value();
		}
		return null;
	}

	public Error getError()
	{
		if (this instanceof Failure<T> failure)
		{
			return failure.error();
		}
		throw new IllegalStateException("Cannot get error from a successful result");
	}
}
