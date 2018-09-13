class AddObservacionPrioridadToSolicitud < ActiveRecord::Migration[5.2]
  def change
    add_column :solicitudes, :observacion_prioridad, :text
  end
end
