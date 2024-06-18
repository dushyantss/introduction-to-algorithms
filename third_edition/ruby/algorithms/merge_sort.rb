# frozen_string_literal: true

# MergeSort, Time: O(N*logN), Space: O(N)
# This will sort in place
class MergeSort
  # main sort method
  def sort(list)
    return list if list.class != Array || list.length < 2

    do_sort(list, 0, list.length - 1)

    list
  end

  private

  def do_sort(list, p, r)
    return unless p < r

    q = (p + r) / 2
    do_sort(list, p, q)
    do_sort(list, q + 1, r)
    merge(list, p, q, r)
  end

  def merge(list, p, q, r)
    l1 = create_array(list, p, q)
    l2 = create_array(list, q + 1, r)
    i = 0
    j = 0
    (p..r).each do |k|
      if i <= (q - p) && j <= (r - q - 1)
        if l1[i] < l2[j]
          list[k] = l1[i]
          i += 1
        else
          list[k] = l2[j]
          j += 1
        end
      elsif i <= (q - p)
        list[k] = l1[i]
        i += 1
      else
        list[k] = l2[j]
        j += 1
      end
    end
  end

  def create_array(list, a, b)
    [].concat(list[a..b])
  end
end
