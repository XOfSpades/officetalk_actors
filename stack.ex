defmodule Stack do
  use GenServer

  # Callbacks

  def handle_call(:pop, _from, []) do
    {:reply, nil, []}
  end
  def handle_call(:pop, _from, [h | t]) do
    {:reply, h, t}
  end

  def handle_call(:top, _from, []) do
    {:reply, nil, []}
  end
  def handle_call(:top, _from, [h | t]) do
    {:reply, h, [h | t]}
  end

  def handle_cast({:push, item}, state) do
    {:noreply, [item | state]}
  end
end
