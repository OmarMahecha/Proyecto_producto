class AddSolicitudIdToHistorico < ActiveRecord::Migration[5.2]
  def change
    add_reference :historicos, :solicitud, foreign_key: true
  end
end
