ActiveAdmin.register Solicitud do
	 menu label: "Solicitudes"
	 #actions :all, except: [:new, :create] 

permit_params :tiempo_oferta_comercial, :es_prioridad, :es_atipico, :user_id, :estado_id, :usuario_autoriza_prioridad, :observacion_prioridad, :tiempo_atipico, :observacion_atipico


# See permitted parameters documentation:
# https://github.com/activeadmin/activeadmin/blob/master/docs/2-resource-customization.md#setting-up-strong-parameters
#
# permit_params :list, :of, :attributes, :on, :model
#
# or
#
# permit_params do
#   permitted = [:permitted, :attributes]
#   permitted << :other if params[:action] == 'create' && current_user.admin?
#   permitted
# end

end
