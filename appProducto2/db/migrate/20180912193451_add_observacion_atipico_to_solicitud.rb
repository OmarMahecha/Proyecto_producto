class AddObservacionAtipicoToSolicitud < ActiveRecord::Migration[5.2]
  def change
    add_column :solicitudes, :observacion_atipico, :text
  end
end
