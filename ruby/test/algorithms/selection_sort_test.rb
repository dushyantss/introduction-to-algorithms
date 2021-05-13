# frozen_string_literal: true

require 'minitest/autorun'
require './ruby/algorithms/selection_sort'

class SelectionSortTest < Minitest::Test
  def test_selection_sort_sorts
    [
      { input: [], output: [] },
      { input: 1, output: 1 },
      { input: '1', output: '1' },
      { input: [1], output: [1] },
      { input: [1, 2], output: [1, 2] },
      { input: [1, 2, 3, 4, 5], output: [1, 2, 3, 4, 5] },
      { input: [5, 4, 3, 2, 1], output: [1, 2, 3, 4, 5] },
      { input: [3, 5, -3, 2, 1], output: [-3, 1, 2, 3, 5] }
    ].each do |args|
      assert SelectionSort.new.sort(args[:input]) == args[:output]
    end
  end
end
