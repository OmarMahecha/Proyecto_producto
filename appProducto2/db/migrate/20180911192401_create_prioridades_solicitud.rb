class CreatePrioridadesSolicitud < ActiveRecord::Migration[5.2]
  def change
    create_table :prioridades_solicitud do |t|
      t.text :observacion_prioridad

      t.timestamps
    end
  end
end
