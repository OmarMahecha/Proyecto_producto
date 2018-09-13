class AddEstadoIdToSolicitud < ActiveRecord::Migration[5.2]
  def change
    add_reference :solicitudes, :estado, foreign_key: true
  end
end
