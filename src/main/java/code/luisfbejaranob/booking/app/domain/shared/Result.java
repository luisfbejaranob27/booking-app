package code.luisfbejaranob.booking.app.domain.shared;

public class Result<T>
{
	private T value;
	private boolean isSuccess;
	private boolean isFailure;
	private Error error;

	protected Result(T value, boolean isSuccess, Error error)
	{
		if (isSuccess && error != Error.None)
		{
			throw new IllegalArgumentException("Success result cannot have an error");
		}
		if (!isSuccess && error == Error.None)
		{
			throw new IllegalArgumentException("Failure result must have an error");
		}

		this.value = value;
		this.isSuccess = isSuccess;
		this.isFailure = !isSuccess;
		this.error = error;
	}

	public static <T> Result<T> success(T value)
	{
		return new Result<T>(value, true, Error.None);
	}

	public static <T> Result<T> failure(Error error)
	{
		return new Result<T>(null, false, error);
	}

	public boolean isSuccess()
	{
		return isSuccess;
	}

	public boolean isFailure()
	{
		return isFailure;
	}

	public Error getError()
	{
		return error;
	}

	public T getValue()
	{
		if (isFailure)
		{
			throw new IllegalStateException("Cannot get value from a failed result");
		}
		return value;
	}

	public T getValueOrNull()
	{
		return value;
	}
}
