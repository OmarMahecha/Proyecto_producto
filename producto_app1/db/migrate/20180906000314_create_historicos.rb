class CreateHistoricos < ActiveRecord::Migration[5.2]
  def change
    create_table :historicos do |t|
      t.datetime :fecha_cambio
      t.text :observacion_historico

      t.timestamps
    end
  end
end
