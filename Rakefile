# frozen_string_literal: true

require 'rake/testtask'

Rake::TestTask.new(:test) do |t|
  t.libs << 'ruby/test'
  t.libs << 'ruby/lib'
  t.test_files = FileList['ruby/test/**/*_test.rb']
end

task default: :test
