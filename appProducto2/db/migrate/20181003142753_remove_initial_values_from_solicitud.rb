class RemoveInitialValuesFromSolicitud < ActiveRecord::Migration[5.2]
  def change
    remove_column :solicitudes, :fecha_creacion, :datetime
  end
end
