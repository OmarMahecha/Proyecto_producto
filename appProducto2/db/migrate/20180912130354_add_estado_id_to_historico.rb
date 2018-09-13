class AddEstadoIdToHistorico < ActiveRecord::Migration[5.2]
  def change
    add_reference :historicos, :estado, foreign_key: true
  end
end
