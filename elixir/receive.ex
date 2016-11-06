hello = fn ->
  receive do
    name -> IO.puts("Hello #{name}")
  end
end

pid = spawn hello

send(pid, "World")
