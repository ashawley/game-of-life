require 'cell'

describe 'cell' do

  describe 'new' do
    it 'is not nil' do
      cell = Cell.new
      expect(cell).to_not be(nil)
    end
  end

  describe 'is_alive' do
    it 'is dead' do
      cell = Cell.new(false)
      expect(cell.is_alive).to be(false)
    end
    it 'is alive' do
      cell = Cell.new(true)
      expect(cell.is_alive).to be(true)
    end
  end

  describe 'neighbors' do
    it 'to be zero' do
      cell = Cell.new(true)
      expect(cell.n_neighbors).to be (0)
    end
    it 'to be one' do
      cell = Cell.new(true, 1)
      expect(cell.n_neighbors).to be (1)
    end
  end

  describe 'step' do
    describe 'is dead and no neighbors' do
      it 'stays dead' do
        cell = Cell.new(false, 0) # dead, no neighbors
        cell.step
        expect(cell.is_alive).to be (false)
      end
    end
    describe 'is alive and has 1 neighbor' do
      it 'becomes dead' do
        cell = Cell.new(true, 1) # alive, 1 neighbor
        cell.step
        expect(cell.is_alive).to be (false)
      end
    end
    describe 'is alive and has 2 neighbors' do
      it 'stays alive' do
        cell = Cell.new(true, 2) # alive, 2 neighbors
        cell.step
        expect(cell.is_alive).to be (true)
      end
    end
    describe 'is dead and has 3 neighbors' do
      it 'becomes alive' do
        cell = Cell.new(false, 3) # dead, 3 neighbors
        cell.step
        expect(cell.is_alive).to be (true)
      end
    end
    describe 'is alive and has 3 neighbors' do
      it 'becomes dead' do
        cell = Cell.new(true, 3) # alive, 3 neighbors
        cell.step
        expect(cell.is_alive).to be (true)
      end
    end
    describe 'is alive and has 4 neighbors' do
      it 'stay alive' do
        cell = Cell.new(true, 4) # alive, 4 neighbors
        cell.step
        expect(cell.is_alive).to be (false)
      end
    end
  end
end
