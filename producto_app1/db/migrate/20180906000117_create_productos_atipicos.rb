class CreateProductosAtipicos < ActiveRecord::Migration[5.2]
  def change
    create_table :productos_atipicos do |t|
      t.datetime :tiempo_producto_atipico

      t.timestamps
    end
  end
end
