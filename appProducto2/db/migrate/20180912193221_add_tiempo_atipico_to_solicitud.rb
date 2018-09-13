class AddTiempoAtipicoToSolicitud < ActiveRecord::Migration[5.2]
  def change
    add_column :solicitudes, :tiempo_atipico, :datetime
  end
end
