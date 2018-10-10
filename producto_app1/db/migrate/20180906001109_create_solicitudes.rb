class CreateSolicitudes < ActiveRecord::Migration[5.2]
  def change
    create_table :solicitudes do |t|
      t.datetime :fecha_creacion
      t.datetime :tiempo_oferta_comercial
      t.boolean :es_prioridad
      t.boolean :es_atipico

      t.timestamps
    end
  end
end
