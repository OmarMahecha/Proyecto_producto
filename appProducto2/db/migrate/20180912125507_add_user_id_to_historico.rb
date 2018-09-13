class AddUserIdToHistorico < ActiveRecord::Migration[5.2]
  def change
    add_reference :historicos, :user, foreign_key: true
  end
end
