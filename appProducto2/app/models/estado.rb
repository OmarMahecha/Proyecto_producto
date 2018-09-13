class Estado < ApplicationRecord
	has_many :solicituds
	has_many :historicos
end
