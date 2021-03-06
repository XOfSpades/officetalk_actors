defmodule Stack do
  use GenServer

  def start_link(initial_state, opts \\ []) do
    GenServer.start_link(__MODULE__, initial_state, opts)
  end

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
