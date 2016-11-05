defmodule SupervisedStack do
  import Supervisor.Spec

  def start_link(initial_state, opts \\ [name: MyStack]) do
    children = [
      worker(Stack, [initial_state, opts])
    ]

    Supervisor.start_link(children, strategy: :one_for_one)
  end

end
