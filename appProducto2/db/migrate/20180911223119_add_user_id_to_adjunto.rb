class AddUserIdToAdjunto < ActiveRecord::Migration[5.2]
  def change
    add_reference :adjuntos, :user, foreign_key: true
  end
end
