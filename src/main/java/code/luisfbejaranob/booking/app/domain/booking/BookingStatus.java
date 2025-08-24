package code.luisfbejaranob.booking.app.domain.booking;

import java.time.LocalDateTime;

public sealed class BookingStatus
{
	public static final class Reserved extends BookingStatus
	{
		private final LocalDateTime reservedAt;

		public Reserved(LocalDateTime reservedAt)
		{
			this.reservedAt = reservedAt;
		}

		public LocalDateTime reservedAt()
		{
			return reservedAt;
		}
	}

	public static final class Confirmed extends BookingStatus
	{
		private final LocalDateTime confirmedAt;
		private final String confirmedBy;

		public Confirmed(LocalDateTime confirmedAt, String confirmedBy)
		{
			this.confirmedAt = confirmedAt;
			this.confirmedBy = confirmedBy;
		}

		public LocalDateTime confirmedAt()
		{
			return confirmedAt;
		}

		public String confirmedBy()
		{
			return confirmedBy;
		}
	}

	public static final class Rejected extends BookingStatus
	{
		private final String reason;
		private final LocalDateTime rejectedAt;

		public Rejected(String reason, LocalDateTime rejectedAt)
		{
			this.reason = reason;
			this.rejectedAt = rejectedAt;
		}

		public String reason()
		{
			return reason;
		}

		public LocalDateTime rejectedAt()
		{
			return rejectedAt;
		}
	}

	public static final class Cancelled extends BookingStatus
	{
		private final String reason;
		private final LocalDateTime cancelledAt;

		public Cancelled(String reason, LocalDateTime cancelledAt)
		{
			this.reason = reason;
			this.cancelledAt = cancelledAt;
		}

		public String reason()
		{
			return reason;
		}

		public LocalDateTime cancelledAt()
		{
			return cancelledAt;
		}
	}

	public static final class Completed extends BookingStatus
	{
		private final LocalDateTime completedAt;

		public Completed(LocalDateTime completedAt)
		{
			this.completedAt = completedAt;
		}

		public LocalDateTime completedAt()
		{
			return completedAt;
		}
	}

	public int getValue()
	{
		return switch (this)
		{
			case Reserved r -> 1;
			case Confirmed c -> 2;
			case Rejected r -> 3;
			case Cancelled c -> 4;
			case Completed c -> 5;
			default -> throw new IllegalStateException("Unknown booking status");
		};
	}
}
