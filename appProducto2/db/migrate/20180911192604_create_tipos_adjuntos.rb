class CreateTiposAdjuntos < ActiveRecord::Migration[5.2]
  def change
    create_table :tipos_adjuntos do |t|
      t.string :tipo_adjunto

      t.timestamps
    end
  end
end
