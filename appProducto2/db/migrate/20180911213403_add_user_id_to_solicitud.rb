class AddUserIdToSolicitud < ActiveRecord::Migration[5.2]
  def change
    add_reference :solicitudes, :user, foreign_key: true
  end
end
