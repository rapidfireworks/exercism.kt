import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime

class Gigasecond {
  val date: LocalDateTime

  constructor(oldDate: LocalDate) : this(oldDate.atStartOfDay())

  constructor(oldDatetime: LocalDateTime) {
    this.date = oldDatetime + Duration.ofSeconds(1_000_000_000)
  }
}
