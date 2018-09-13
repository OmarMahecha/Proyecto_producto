class CreateAlertas < ActiveRecord::Migration[5.2]
  def change
    create_table :alertas do |t|
      t.text :mensaje_alerta

      t.timestamps
    end
  end
end
