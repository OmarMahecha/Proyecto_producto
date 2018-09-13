class Solicitud < ApplicationRecord
	belongs_to :user
	belongs_to :estado
	has_many :adjuntos
	has_many :historicos
end
