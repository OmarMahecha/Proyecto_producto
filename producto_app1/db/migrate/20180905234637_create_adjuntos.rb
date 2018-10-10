class CreateAdjuntos < ActiveRecord::Migration[5.2]
  def change
    create_table :adjuntos do |t|
      t.datetime :fecha_adjunto
      t.text :ruta_adjunto

      t.timestamps
    end
  end
end
