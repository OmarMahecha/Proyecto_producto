class AddTipoAdjuntoIdToAdjunto < ActiveRecord::Migration[5.2]
  def change
    add_reference :adjuntos, :tipo_adjunto, foreign_key: true
  end
end
