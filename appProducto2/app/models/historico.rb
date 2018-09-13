class Historico < ApplicationRecord
	belongs_to :user
	belongs_to :estado
	belongs_to :solicitud
end
