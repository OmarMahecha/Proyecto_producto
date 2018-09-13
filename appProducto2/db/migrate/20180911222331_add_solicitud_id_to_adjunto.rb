class AddSolicitudIdToAdjunto < ActiveRecord::Migration[5.2]
  def change
    add_reference :adjuntos, :solicitud, foreign_key: true
  end
end
