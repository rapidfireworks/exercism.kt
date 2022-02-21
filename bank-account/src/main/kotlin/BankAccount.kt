import java.util.concurrent.atomic.AtomicReference

data class BankAccount(val state: AtomicReference<State> = AtomicReference(State(0, false))) {
  data class State(val amount: Long, val isClosed: Boolean)

  val balance: Long
    get() = getUnlessClosed().amount

  fun adjustBalance(amount: Long) = getAndUpdateUnlessClosed {
    State(it.amount + amount, it.isClosed)
  }

  fun close() = getAndUpdateUnlessClosed {
    State(it.amount, true)
  }

  fun getUnlessClosed(): State = state.get().run {
    if (isClosed) {
      throw IllegalStateException()
    } else {
      this
    }
  }

  fun getAndUpdateUnlessClosed(transform: (State) -> State) {
    state.getAndUpdate {
      if (it.isClosed) {
        throw IllegalStateException()
      } else {
        transform(it)
      }
    }
  }
}
