# frozen_string_literal: true

# InsertionSort, Time: O(N*N), Space: O(1)
class InsertionSort
  # The main sort method, call it to run the algorithm
  def sort(list)
    return list if list.class != Array || list.length < 2

    (1...list.length).each do |j|
      key = list[j]
      i = j - 1
      while i >= 0 && list[i] > key
        list[i + 1] = list[i]
        i -= 1
      end
      list[i + 1] = key
    end

    list
  end
end
