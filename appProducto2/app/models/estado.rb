class Estado < ApplicationRecord
	has_many :solicituds
	has_many :historicos
	def to_s
  		"#{estado}"
  	end
end
