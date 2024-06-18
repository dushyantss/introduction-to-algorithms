# frozen_string_literal: true

# BinarySearch, Time: O(lgN), Space: O(1)
class BinarySearch
  NOT_FOUND = -1
  # The main search method
  # returns the index of the val, or -1
  def search(list, val)
    return NOT_FOUND if list.class != Array || list.empty?

    l = 0
    h = list.length - 1
    while l >= 0 && h <= list.length - 1 && l <= h
      i = (l + h) / 2
      if list[i] == val
        return i
      elsif list[i] > val
        h = i - 1
      else
        l = i + 1
      end
    end

    NOT_FOUND
  end
end
