##
# The single object of life.
#
class Cell

  ##
  # Is this cell alive?
  #
  attr_accessor :is_alive

  ##
  # The number of alive neighbors.
  #
  attr_accessor :n_neighbors

  ##
  # Create a new cell.
  #
  # is_alive:: Boolean
  # n_neighbors:: Integer of range 0 to 8
  #
  def initialize(is_alive = false, n_neighbors = 0)
    # Is alive or dead?
    @is_alive = is_alive
    # Number of alive neighbors.
    @n_neighbors = n_neighbors
  end

  ##
  # Step the cell forward a generation.
  #
  def step
    if @is_alive and (@n_neighbors < 2 or @n_neighbors > 3)
        @is_alive = false
    elsif @n_neighbors == 3
      @is_alive = true
    end
  end
end
