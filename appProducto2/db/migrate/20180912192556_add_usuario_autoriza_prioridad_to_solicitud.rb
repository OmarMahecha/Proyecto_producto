class AddUsuarioAutorizaPrioridadToSolicitud < ActiveRecord::Migration[5.2]
  def change
    add_column :solicitudes, :usuario_autoriza_prioridad, :string
  end
end
