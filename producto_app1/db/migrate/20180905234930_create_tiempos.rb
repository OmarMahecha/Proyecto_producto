class CreateTiempos < ActiveRecord::Migration[5.2]
  def change
    create_table :tiempos do |t|
      t.datetime :tiempo
      t.string :detalle

      t.timestamps
    end
  end
end
