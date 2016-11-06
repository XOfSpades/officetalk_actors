defmodule Value do
  def current(x) do
    IO.puts("Current value is #{x}")
    receive do
      add -> current(x + add)
    end
  end
end

pid = spawn fn -> Value.current(0) end

send(pid, 25)
send(pid, 17)
