# frozen_string_literal: true

# SelectionSort, Time: O(N*N), Space: O(1)
class SelectionSort
  # main sort method
  def sort(list)
    return list if list.class != Array || list.length < 2

    (0..(list.length - 2)).each do |i|
      min_i = i
      (i...list.length).each do |j|
        min_i = j if list[j] < list[min_i]
      end

      temp = list[i]
      list[i] = list[min_i]
      list[min_i] = temp
    end

    list
  end
end
