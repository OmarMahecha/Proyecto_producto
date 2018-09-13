class Adjunto < ApplicationRecord
	belongs_to :solicitud
	belongs_to :tipo_adjunto
	belongs_to :user
end
