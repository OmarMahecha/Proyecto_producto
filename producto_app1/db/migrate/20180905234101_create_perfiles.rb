class CreatePerfiles < ActiveRecord::Migration[5.2]
  def change
    create_table :perfiles do |t|
      t.string :perfil

      t.timestamps
    end
  end
end
